package web;

import com.google.gson.Gson;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserVerifyServer extends HttpServlet {
    /**
     * 注册时验证用户名是否有重复
     * @param req 要个前端的【name】
     * @param resp 返回个json，给前端判断。
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        UserDAO ud = new UserDAO();
        try {
            ud.existenceUser(name);
            resp.getWriter().write(new Gson().toJson(ud));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            resp.getWriter().write(new Gson().toJson("对不起，我卡了。"));
        }
    }
}
