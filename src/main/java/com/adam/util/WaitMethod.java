package com.adam.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @program : DataDrivenTestFramework
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 13:39 2021/11/15 2021
 * @ Description ：This is to encapsulate wait method
 * @Version : 1.0$
 */
public class WaitMethod {

    public static void xsWait(WebDriver driver, By by, int time){
        try{
            WebDriverWait wait = new WebDriverWait(driver,time);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        }catch(NoSuchElementException e){
            log.info("wait: "+time+" seconds, but can not find the "+ by +" element");
            Screenshot.method(driver,"explicit wait "+ by + "element "+ time + "seconds timed out!");
            log.info("invoke Screenshot.method to take screenshot!");
        }
    }

}
