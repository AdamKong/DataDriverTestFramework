package com.adam.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program : DataDrivenTestFramework
 * @ Author      ：Fanyong Kong
 * @ Date        ：Created in 12:35 2021/11/15 2021
 * @ Description ：This is to handle excel file
 * @Version : 1.0$
 */
public class ExcelUtil {

    private static XSSFSheet excelWSheet = null;
    private static XSSFWorkbook excelWBook = null;
    private static XSSFCell cell = null;
    private static XSSFRow row = null;


    /**
     * @Description: This is to set the excel data location
     * @params: [path, sheetName]
     * @return: void
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static void setExcelFileDataLocation(String path, String sheetName) throws Exception{
        FileInputStream excelFile = null;
        try {
            excelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @Description: get the content of a specific cell. only for .xlsx file.
     * @params: [rowNum, colNum]
     * @return: java.lang.String
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static String getCellData(int rowNum, int colNum) throws Exception{

        try {
            cell = excelWSheet.getRow(rowNum).getCell(colNum);
            // use getStringCellValue for string value,
            // use getNumericCellValue() for int value.
            String cellData = cell.getStringCellValue();
            return cellData;
        } catch (Exception e) {
            return "";
        }
    }

    
    /**
     * @Description: This is to set value in Excel cell
     * @params: [rowNum, colNum, Result]
     * @return: void
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static void setCellData(int rowNum, int colNum, String Result) throws Exception{
        try {
            row = excelWSheet.getRow(rowNum);
            cell = row.getCell(colNum);
            if(cell == null){
                cell=row.createCell(colNum);
            }
            cell.setCellValue(Result);
            FileOutputStream out = new FileOutputStream(Constant.TestDataExcelFilePath);
            excelWBook.write(out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * @Description: This is to get the two-dimension data from Excel
     * @params: [excelFilePath, sheetName]
     * @return: java.lang.Object[][]
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static Object[][] getTestData(String excelFilePath, String sheetName) throws IOException {
        File file = new File(excelFilePath);
        FileInputStream in = new FileInputStream(file);
        Workbook workbook = null;
        String fileExtensionName = excelFilePath.substring(excelFilePath.indexOf("."));
        if(fileExtensionName.equals(".xlsx")){
            workbook = new XSSFWorkbook(in);
        }else {
            workbook = new HSSFWorkbook(in);
        }
        
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        List<Object[]> records = new ArrayList<Object[]>();

        for(int i=1; i<rowCount+1; i++){
            Row row = sheet.getRow(i);
            String[] fields = new String[row.getLastCellNum()-2];
            if(row.getCell(row.getLastCellNum()-2).getStringCellValue().equals("y")){
                for(int j=0; j<row.getLastCellNum()-2; j++){
                    fields[j] = row.getCell(j).getCellTypeEnum() == CellType.STRING ? row.getCell(j).getStringCellValue() : ""+row.getCell(j).getNumericCellValue();
                }
                records.add(fields);
            }
        }

        Object[][] results = new Object[records.size()][];
        for(int i=0; i<records.size(); i++){
            results[i]=records.get(i);
        }
        return results;
    }


    /**
     * @Description: Get the last column number
     * @params: []
     * @return: int
     * @Author: Fanyong Kong
     * @Date: 2021/11/15
     */
    public static int getLastColumnNum(){
        return excelWSheet.getRow(0).getLastCellNum()-1;
    }
    
    
}
