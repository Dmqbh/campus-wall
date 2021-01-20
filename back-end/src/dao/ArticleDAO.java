package dao;

import bean.Article;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ArticleDAO {
    /**
     * 查询所有的文章
     *
     * @return 返回给前端
     * @throws SQLException
     */
    public List<Article> GetAllArticle() throws SQLException {
        DBHelper db = new DBHelper();
        Connection conn = db.getConnection();
        String sql = "select article_id, article_title, article_content, userid, article_time from article";
        try {
            return new QueryRunner().query(conn, sql, new BeanListHandler<Article>(Article.class));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    ;

    /**
     * 根据文章id，获取文章
     *
     * @param articleId 文章id
     * @return 返回文章信息
     * @throws SQLException
     */
    public List<Article> GetIdArticle(int articleId) throws SQLException {
        DBHelper db = new DBHelper();
        Connection conn = db.getConnection();
        String sql = "select article_id, article_title, article_content, userid, article_time from article wehre article_id = ?";
        try {
            return new QueryRunner().query(conn, sql, new BeanListHandler<Article>(Article.class), articleId);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 添加文章
     * @param article 要标题， 内容， 账号id， 文章发布的当前时间
     * @return 返回个文章id
     * @throws SQLException
     */
    public Article addArticle(Article article) throws SQLException {
        DBHelper db = new DBHelper();
        Connection conn = db.getConnection();
        String sql = "insert into article ( article_title, article_content, userid, article_time ) values (?, ?, ?, ?) ";
        try {
            Object [] params ={
                    article.getTitle(), article.getContent(), article.getUserid(), article.getArticletime()
            };
            QueryRunner qr = new QueryRunner();
            BigDecimal bd = qr.insert(conn, sql, new ScalarHandler<BigDecimal>(),params);
            article.setId((int) bd.longValue());
            return article;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


}
