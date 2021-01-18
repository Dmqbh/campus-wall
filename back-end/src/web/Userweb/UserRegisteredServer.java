package web.Userweb;

import bean.User;
import com.google.gson.Gson;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserRegisteredServer extends HttpServlet {
    /**
     * 注册用户
     *
     * @param req  前端获取 账号， 密码， 邮箱
     * @param resp 注册成功的话，返回个账号
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        UserDAO ud = new UserDAO();
        try {
            ud.addUser(new User(id, password, email));
            resp.getWriter().write(new Gson().toJson(ud));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            resp.getWriter().write(new Gson().toJson("对不起，我卡了。"));
        }

    }
}
