package dao;

import bean.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDAO {
    /**
     * 用户注册
     * @param user 账号、密码、头像、邮箱、昵称、性别、注册时间、生日
     * @return 返回个账号
     * 创建时间：11点24分 2021\1
     */
    public User addUser(User user) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();
        String sql = "insert into tser (userid, tser_password, tser_mailbox) values (?, ?, ?)";
        Object[] params = {
                user.getUserid(), user.getPassword(),  user.getMailbox()
        };
        try{
            QueryRunner queryRunner = new QueryRunner();
            BigDecimal bigDecimal = queryRunner.insert(connection,sql,new ScalarHandler<BigDecimal>(),params);
            user.setUserid((int) bigDecimal.longValue());
            return user;
        }finally {
            DbUtils.closeQuietly(connection);
        }
    }

    /**
     * 用户登录功能（登录验证）
     * @param userid 账号
     * @param password 密码
     * @return 成功或者失败（有或无）
     * 注释创建时间：14点43分 2021\1\7
     */
    public int loginUser(String userid,String password) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();
        String sql = "select userid,password form where userid = ? and password = ?";
        try{
            Object [] params = {
                    userid,password
            };
            return new QueryRunner().query(connection, sql, new ScalarHandler<>(),params);
        }finally {
            DbUtils.closeQuietly(connection);
        }
    }

    /**
     * 验证是否又相同用户
     * @param name 用户名
     * @return 是或否
     * 19点23分 2021、1、7
     */
    public int existenceUser(String name) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();
        String sql = "select name from tser where name = ?";
        try{
            return new QueryRunner().query(connection, sql, new ScalarHandler<>(),name);
        }finally {
            DbUtils.closeQuietly(connection);
        }
    }

}
