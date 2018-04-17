package per.hss.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    //将date类型转换为String类型
    public static String formatDate(Date date, String formate)
    {
        String result="";
        SimpleDateFormat sdf=new SimpleDateFormat(formate);
        if(date!=null)
        {
            result=sdf.format(date);
        }

        return result;
    }
    //将String类型转换为data类型
    public static Date formatString(String str,String format)
    {
        SimpleDateFormat sdf=null;
        Date date=null;
        try {
            sdf=new SimpleDateFormat(format);
            date=sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
