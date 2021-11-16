package com.adam.util;

/**
 * @program : DataDrivenTestFramework
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 12:14 2021/11/15 2021
 * @ Description ：This is to define constant
 * @Version : 1.0$
 */
public class Constant {
    // test destination address
    public static final String url="https://mail.163.com";
    // chrome installation path
    public static final String browserInstallationPath="C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
    // web driver path
    public static final String webDriverPath="D:\\111\\browserdrivers\\chromedriver.exe";
    // Excel file path - save the data
    public static final String TestDataExcelFilePath=System.getProperty("user.dir") + "\\data\\data.xlsx";
    // the Excel sheet name
    public static final String TestDataExcelFileSheet="Sheet1";

}
