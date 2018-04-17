package per.hss.dao;
import java.sql.*;
import per.hss.util.*;
import per.hss.model.*;
public class GradeDao {
    StringUtil stringUtil=new StringUtil();
    public ResultSet gradelist(Connection con,Grade grade)
    {
         StringBuffer sb=new StringBuffer("select * from grade");
        if(grade!=null&&stringUtil.isNotEmpty(grade.getGradename())) {
            sb.append(" and gradename like '%" + grade.getGradename() + "%' ");
        }
        PreparedStatement ptmt;
        ResultSet resultSet=null;
        try {
            ptmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
            resultSet=ptmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    //获取总记录数
    public int gradeCount(Connection con,Grade grade)throws Exception
    {
        StringBuffer sb=new StringBuffer("select  count(*) as total from grade");
        if(stringUtil.isNotEmpty(grade.getGradename()))
        {
            sb.append(" and gradename like '%"+grade.getGradename()+"%'");
        }
        String sql=sb.toString().replaceFirst("and", "where");
        PreparedStatement ptmt=con.prepareStatement(sql);
        ResultSet res=ptmt.executeQuery();

        if(res.next())
        {
            return res.getInt("total");
        }else {
            return 0;
        }
    }

    /**
     * 执行删除操作
     * @param
     * @param delIds
     * @return
     */
    public int gradeDelete(Connection con,String delIds) {

        String sql="delete from grade where id in ("+delIds+")";
        int resultnum=0;
        try {
            PreparedStatement ptmt=con.prepareStatement(sql);
            resultnum=ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultnum;
    }
    /**
     * 添加班级信息
     * @param con
     * @param grade
     * @return
     */
    public int gradeAdd(Connection con,Grade grade)
    {
        String sql="insert into grade (gradename,gradedesc) values (?,?)";
        PreparedStatement ptmt;
        int num=0;
        try {
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, grade.getGradename());
            ptmt.setString(2, grade.getGradedesc());
            num=ptmt.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return num;
    }

    /**
     * 修改班级信息
     * @param con
     * @param grade
     * @return
     */
    public int gradeModify(Connection con,Grade grade)
    {
        String sql="update grade set gradename=? ,gradedesc=? where id=?";
        PreparedStatement ptmt=null;
        int num=0;
        try {
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, grade.getGradename());
            ptmt.setString(2, grade.getGradedesc());;
            ptmt.setInt(3, grade.getId());
            num=ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  num;
    }

    /**
     * 判断班级之下有没有学生 如果有的话 就不能进行删除操作
     * @param con
     * @param gradeId
     * @return
     */
    public boolean getStudentGradeIs(Connection con,String gradeId)
    {

        String sql="select * from student where gradeId=?";
        PreparedStatement ptmt=null;
        Boolean judge=true;
        try {
            ptmt=con.prepareStatement(sql);
            ptmt.setString(1, gradeId);
            ResultSet res=ptmt.executeQuery();
            if(res.next())
            {
            }else {
                judge=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return judge;
    }
    public static void main(String[] args) throws Exception
    {
        DbUtil dbUtil=new DbUtil();
        Connection con=dbUtil.getConnection();
        GradeDao grade=new GradeDao();
        ResultSet res=grade.gradelist(con,null);


    }
}
