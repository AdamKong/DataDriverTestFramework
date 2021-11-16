package com.adam.util;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @program : DataDrivenTestFramework
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 13:10 2021/11/15 2021
 * @ Description ：This is to locate the object
 * @Version : 1.0$
 */
public class ObjectMap {
    Properties properties;

    public ObjectMap(String propFile){
        properties = new Properties();
        try {
            FileInputStream in = new FileInputStream(propFile);
            properties.load(in);
            in.close();
        } catch (FileNotFoundException e) {
            log.info("can not find file!");
            e.printStackTrace();
        } catch (IOException e) {
            log.info("reading file error!");
            e.printStackTrace();
        }
    }


    public By getLocator(String ElementNameInPropFile) throws Exception{
        /**
        * @Description: get the locator according to the element name in properties file
        * @params: [ElementNameInPropFile]
        * @return: org.openqa.selenium.By
        * @Author: Fanyong Kong
        * @Date: 2021/11/15
        */
        String locator = properties.getProperty(ElementNameInPropFile);
        String locatorType = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];

        locatorValue = new String(locatorValue.getBytes("ISO-8859-1"),"UTF-8");

        log.info("locator type："+locatorType+"\t locator expression："+locatorValue);
        if(locatorType.toLowerCase().equals("id"))
            return By.id(locatorValue);
        else if(locatorType.toLowerCase().equals("name"))
            return By.name(locatorValue);
        else if((locatorType.toLowerCase().equals("classname"))||(locatorType.
                toLowerCase().equals("class")))
            return By.className(locatorValue);
        else if((locatorType.toLowerCase().equals("tagname"))||(locatorType.
                toLowerCase().equals("tag")))
            return By.tagName(locatorValue);
        else if((locatorType.toLowerCase().equals("linktext"))||(locatorType.
                toLowerCase().equals("link")))
            return By.linkText(locatorValue);
        else if(locatorType.toLowerCase().equals("partiallinktext"))
            return By.partialLinkText(locatorValue);
        else if((locatorType.toLowerCase().equals("cssselector"))||(locatorType.
                toLowerCase().equals("css")))
            return By.cssSelector(locatorValue);
        else if(locatorType.toLowerCase().equals("xpath"))
            return By.xpath(locatorValue);
        else
            log.info("locator type is not defined: "+locatorType);
            throw new Exception("locator type is not defined: "+locatorType);

    }


}
