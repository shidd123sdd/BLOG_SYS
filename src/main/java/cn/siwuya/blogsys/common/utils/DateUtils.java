package cn.siwuya.blogsys.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author shi_dd
 * @date 2020/7/22 14:14
 */
public class DateUtils {

    public static String getCurrDatePath(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        return year+"/"+month+"/"+day+"/";
    }

    public static String getCurrDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       return  sdf.format(date);
    }
    public static String getCurrDateTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        return  sdf.format(date);
    }

}
