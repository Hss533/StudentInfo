package per.hss.web;

import per.hss.dao.GradeDao;
import per.hss.model.Grade;
import per.hss.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

public class GradeAdd extends HttpServlet {
    GradeDao gradeDao=new GradeDao();
    DbUtil dbUtil=new DbUtil();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");/**解决ajax乱码问题*/
        Connection con=dbUtil.getConnection();
        String gradeName=request.getParameter("gradeName");
        String gradeDesc=request.getParameter("gradeDesc");
        if(gradeDesc==null)
        {
            gradeDesc="";
        }
        Grade grade=new Grade(gradeName,gradeDesc);
        int num=gradeDao.gradeAdd(con,grade);
         if(num==1)
         {
             PrintWriter out=response.getWriter();
             out.print("succeed");
             out.flush();
             out.close();
         }
         else{

         }
    }
}
