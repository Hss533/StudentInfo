package per.hss.web;

import per.hss.dao.GradeDao;
import per.hss.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

public class GradeDelete extends HttpServlet{

    DbUtil dbUtil=new DbUtil();
    GradeDao gradedao=new GradeDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String num=request.getParameter("num");
        System.out.println(num);
        Connection con=dbUtil.getConnection();
        int result=gradedao.gradeDelete(con,num);
        PrintWriter out=response.getWriter();
        if(result==1)
        out.print("succeed");
        else
            out.print("fail");
        out.flush();
        out.close();
    }
}
