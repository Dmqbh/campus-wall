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
     * 注册用户
     * @param user
     * @return 账号返回给他
     * @throws SQLException
     */
    public User addUser(User user) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        Connection conn =dbHelper.getConnection();
        String sql = "insert into tser (userid, tser_password, tser_mailbox, tser_name, tser_sex, tser_birthday) values(?,?,?,?,?,?)";
        Object [] objects = {
                user.getUserid(),user.getPassword(),user.getMailbox(),user.getName(),user.getGender(),user.getBirthday()
        };
        try{
            QueryRunner runner = new QueryRunner();
            BigDecimal res = runner.insert(conn,sql,new ScalarHandler<BigDecimal>(),objects);
            user.setUserid((int) res.longValue());
            return user;
        }finally {
            DbUtils.closeQuietly(conn);
        }
    }

    /**
     * 更改密码
     * @param password 新密码
     * @param userid 账号
     * @return 成功或者失败
     * @throws SQLException
     */
    public int upUserPassword(String password,int userid) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();
        String sql = "update tser set password = ? where userid = ?";
        Object [] param ={
                password,userid
        };
        try{
            QueryRunner runner = new QueryRunner();
            return runner.update(connection,sql,param);
        }finally {
            DbUtils.closeQuietly(connection);
        }

    }
}
