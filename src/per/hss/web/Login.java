package per.hss.web;

import per.hss.dao.UserDao;
import per.hss.model.User;
import per.hss.util.DbUtil;
import per.hss.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

public class Login extends HttpServlet{

    UserDao userDao=new UserDao();
    DbUtil dbUtil=new DbUtil();
    StringUtil stringUtil=new StringUtil();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        request.setAttribute("username",username);
        request.setAttribute("password",password);
        System.out.println("asd"+username+password+"asd");
        if(stringUtil.isEmpty(username)||stringUtil.isEmpty(password))
        {
            //不能进入这个
            request.setAttribute("error","用户名和密码不能为空");
            request.getRequestDispatcher("index.jsp").forward(request,response);
            return;
        }
        User user=new User(username,password);
        Connection con=null;
        try{
            con=dbUtil.getConnection();
            User currentUser=userDao.login(con,user);
            System.out.println("currentUser"+currentUser);
            if(currentUser==null)
            {
                request.setAttribute("error","用户名或者密码错误");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
            else{
                HttpSession session=request.getSession();
                session.setAttribute("currentUser",currentUser);
                response.sendRedirect("main.jsp");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {

            try{
                dbUtil.closeCon(con);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}