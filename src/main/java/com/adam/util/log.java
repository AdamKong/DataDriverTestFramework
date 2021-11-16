package com.adam.util;

import org.apache.log4j.Logger;

/**
 * @program : DataDrivenTestFramework
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 12:54 2021/11/15 2021
 * @ Description ：This is to add logging
 * @Version : 1.0$
 */
public class log {

    private static Logger log=Logger.getLogger(log.class.getName());

    public static void startTestCase(String CaseName){
        log.info("======================================================================");
        log.info("*************     "+CaseName+" Starting"+"     *************");
    }
    public static void endTestCase(String CaseName){
        log.info("*************     "+CaseName+" ending"+"     *************");
        log.info("======================================================================");
    }

    public static void info(String message){
        log.info(message);
    }
    public static void warn(String message){
        log.warn(message);
    }
    public static void error(String message){
        log.error(message);
    }
    public static void fatal(String message){
        log.fatal(message);
    }
    public static void debug(String message){
        log.debug(message);
    }

}
