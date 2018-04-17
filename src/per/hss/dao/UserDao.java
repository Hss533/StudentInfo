package per.hss.dao;

import per.hss.model.User;
import per.hss.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
public class UserDao {

    public User login(Connection con, User user)
    {
        User resultUser=null;
        String sql="select * from user where username=? and password=?";
        PreparedStatement ptmt=null;
        try {
            ptmt=con.prepareStatement(sql);
            ptmt.setString(1, user.getUserName());
            ptmt.setString(2, user.getPassWord());
            ResultSet res = ptmt.executeQuery();
            if (res.next()) {
                resultUser = new User();
                resultUser.setUserName(res.getString("username"));
                resultUser.setPassWord(res.getString("password"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return resultUser;
    }
    public static void main(String[] args)
    {
        DbUtil dbutil=new DbUtil();
        Connection con=dbutil.getConnection();
        UserDao userdao=new UserDao();
        User user=new User("hss","533533");

    }
}
