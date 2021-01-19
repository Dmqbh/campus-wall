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

public class UserLoginServer extends HttpServlet {
    /**
     * 登录验证
     * @param req 账号， 密码
     * @param resp 返回账号或密码正不正确
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String passwrod = req.getParameter("password");
        UserDAO ud = new UserDAO();
        try {
            ud.loginUser(id, passwrod);
            resp.getWriter().write(new Gson().toJson(ud));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            resp.getWriter().write(new Gson().toJson("对不起，我卡了。"));
        }
    }
}
