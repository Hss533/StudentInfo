package per.hss.util;

public class StringUtil {
    public boolean isEmpty(String string){
        if("".equals(string)||string==null)
        {
            return true;
        }
        else{
            return false ;

        }
    }
    public boolean isNotEmpty(String string){

        if(!"".equals(string)&&string!=null)
        {
            return true;
        }
        else{
            return false;
        }
    }
}
