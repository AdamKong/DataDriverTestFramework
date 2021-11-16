package com.adam.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;

/**
 * @program : DataDrivenTestFramework
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 13:21 2021/11/15 2021
 * @ Description ：This is to handle screenshot methods
 * @Version : 1.0$
 */
public class Screenshot {

    /**
     * @Description: This is to encapsulate take screenshot function
     * @params: [driver, CaseName, basePath]
     * @return: void
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static void method(WebDriver driver, String CaseName) {
        try{
            Date date=new Date();
            String picDir = System.getProperty("user.dir") + "\\" + "screenshots" + "\\" + String.valueOf(DateTimeUtil.getYear(date)) + "-"
                    + String.valueOf(DateTimeUtil.getMonth(date)) + "-" + String.valueOf(DateTimeUtil.getDay(date));
            if(!new File(picDir).exists()){
                FileUtil.createDir(picDir);
            }

            String filePath = picDir + "//" + String.valueOf(DateTimeUtil.getHour(new Date()))+"hour"+
                    String.valueOf(DateTimeUtil.getMinute(new Date()))+"minute"+
                    String.valueOf(DateTimeUtil.getSecond(new Date()))+"second"+CaseName+".png";
            File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(filePath));
        }catch(Exception e){
            log.info("taking screenshot failed!");
            e.printStackTrace();
        }
    }
    

}
