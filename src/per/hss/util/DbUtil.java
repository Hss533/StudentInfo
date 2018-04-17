package per.hss.util;
import java.sql.*;
public class DbUtil {
    private String url="jdbc:mysql://localhost:3306/studentinfo?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private String username="root";
    private String password="533533";
    private  String jdbcname="com.mysql.jdbc.Driver";

    public Connection getConnection()
    {
        Connection connection = null;
        try {
            Class.forName(jdbcname);
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭数据库
     * @param con
     */
    public void closeCon(Connection con)
    {
        if(con!=null)
        {
            try
            {
                con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}
