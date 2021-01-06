package dao;

import bean.Post;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class PostDAO {
    /**
     * 添加博客
     * @param post 发博客要的信息
     * @return 把“博客文章账号”给他
     * @throws SQLException
     */
    public Post addPost(Post post) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        Connection conn =dbHelper.getConnection();
        String sql = "insert into article (article_title, article_content, userid, article_time) values(?, ?, ?, ?)";
        Object [] objects = {
                post.getTitle(),post.getContent(),post.getUserid(),post.getUptime()
        };
        try{
            QueryRunner runner = new QueryRunner();
            BigDecimal res = runner.insert(conn,sql,new ScalarHandler<BigDecimal>(),objects);
            post.setId((int) res.longValue());
            return post;
        }finally {
            DbUtils.closeQuietly(conn);
        }
    }


}
