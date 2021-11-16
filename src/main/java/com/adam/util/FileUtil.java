package com.adam.util;

import java.io.File;
import java.io.IOException;

/**
 * @program : DataDrivenTestFramework
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 12:52 2021/11/15 2021
 * @ Description ：This is to handle the folder and file
 * @Version : 1.0
 */
public class FileUtil {

    /**
     * @Description: This is to create file
     * @params: [destFileName]
     * @return: boolean
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static boolean createFile(String destFileName){
        File file = new File(destFileName);
        if(file.exists()){
            log.info("creating "+destFileName+" failed, as the file has already existed!");
            return false;
        }
        if(destFileName.endsWith(file.separator)){
            log.info("creating "+destFileName+" failed, as it can not be a directory");
            return false;
        }

        if(!file.getParentFile().exists()){
            log.info("the directory does not exist, creating it!");
            if(!file.getParentFile().mkdirs()){
                log.info("creating directory failed!");
                return false;
            }
        }

        //creating the destination file
        try{
            if(file.createNewFile()){
                log.info("creating "+destFileName+" successfully");
                return true;
            }else{
                log.info("creating "+destFileName+" failed");
                return false;
            }
        }catch(IOException e){
            e.printStackTrace();
            log.info("creating "+destFileName+" failed:"+e.getMessage());
            return false;
        }
    }



    /**
     * @Description: this is to create a directory
     * @params: [destDirName]
     * @return: boolean
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static boolean createDir(String destDirName){
        File dir=new File(destDirName);
        if(dir.exists()){
            log.info("creating directory "+destDirName+" failed, as it has already existed!");
            return false;
        }
        //creating directory
        if(dir.mkdirs()){
            log.info("creating directory "+destDirName+" successfully");
            return true;
        }else{
            log.info("creating "+destDirName+" failed");
            return false;
        }
    }


}
