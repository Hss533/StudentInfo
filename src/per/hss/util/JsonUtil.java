package per.hss.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
/**
 * 返回的格式为Jsonarray
 */
public class JsonUtil {
    DateUtil dateUtil=new DateUtil();
    public JSONArray resultSetToJsonArray(ResultSet res)
    {
        ResultSetMetaData rmd ;
        JSONArray array = null;
        try
        {
                rmd = res.getMetaData();
                int num = rmd.getColumnCount();//获取列数
                System.out.println(num);
                array=new JSONArray();
                while (res.next())
                {

                    JSONObject jsonObject = new JSONObject();
                    for (int i = 1; i <=num; i++)
                    {
                        Object object = res.getObject(i);
                        if (object instanceof Date)
                        {
                            //将date类型转换为String类型
                            jsonObject.put(rmd.getColumnClassName(i),dateUtil.formatDate((Date)object,"yyyy-MM-dd"));
                        }
                        else
                        {
                            System.out.println(rmd.getColumnName(i)+" "+res.getObject(i));
                            jsonObject.put(rmd.getColumnName(i), res.getObject(i));
                        }
                    }
                    array.add(jsonObject);
                }
        } catch (Exception e)
            {
                e.printStackTrace();
            }
        return array;
    }
}
