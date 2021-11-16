package com.adam.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program : DataDrivenTestFramework
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 12:20 2021/11/15 2021
 * @ Description ：This is to handle date and time
 * @Version : 1.0$
 */
public class DateTimeUtil {

    /**
     * @Description: This is to format date and return it in String
     * @params: [date, format]
     * @return: java.lang.String
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static String format(Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                DateFormat df = new SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @Description: This is to get the year
     * @params: [date]
     * @return: int
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static int getYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }


    /**
     * @Description: This is to get the month
     * @params: [date]
     * @return: int
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static int getMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH)+1;
    }


    /**
     * @Description: This is to get the day
     * @params: [date]
     * @return: int
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static int getDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * @Description: This is to get the hour
     * @params: [date]
     * @return: int
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static int getHour(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }


    /**
     * @Description: This is to get the minute
     * @params: [date]
     * @return: int
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static int getMinute(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }


    /**
     * @Description: This is to get the second
     * @params: [date]
     * @return: int
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static int getSecond(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.SECOND);
    }




}
