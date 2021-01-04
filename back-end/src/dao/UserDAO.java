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
     * @return
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
            return user;
        }finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public int upUser(){
        return 1;
    }
}
