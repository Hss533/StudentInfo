package per.hss.web;

import net.sf.json.JSONArray;
import per.hss.dao.GradeDao;
import per.hss.model.Grade;
import per.hss.util.DbUtil;
import per.hss.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

public class GradeList extends HttpServlet{
    Grade grade=null;
    GradeDao gradeDao=new GradeDao();
    JsonUtil jsonUtil=new JsonUtil();
    DbUtil dbUtil=new DbUtil();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection con=null;
        //request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String gradeName=request.getParameter("gradename");
        try
        {
            Grade grade=new Grade();
            con=dbUtil.getConnection();
            if(gradeName==null)
            {
                //没有执行搜索操作
                gradeName="";
            }
            grade.setGradename(gradeName);
            JSONArray jsonArray=jsonUtil.resultSetToJsonArray(gradeDao.gradelist(con,grade));


            /*
            System.out.println("jsonArray"+jsonArray);
            request.setAttribute("result",jsonArray);
            request.getRequestDispatcher("gradeInfoManager.jsp").forward(request,response);
            */

            PrintWriter out=response.getWriter();
            out.print(jsonArray);
            out.flush();
            out.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }finally
            {
                dbUtil.closeCon(con);
            }
        }

}
