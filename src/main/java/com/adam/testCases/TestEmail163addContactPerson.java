package com.adam.testCases;

import com.adam.appModules.AddContactPersonAction;
import com.adam.util.Constant;
import com.adam.util.ExcelUtil;
import com.adam.util.Screenshot;
import com.adam.util.log;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;


public class TestEmail163addContactPerson {
	public WebDriver driver;
	String url=Constant.url;

	@DataProvider(name="testData")
	public static Object[][] data() throws IOException{
		log.info("get the data in the rows which has y in run column in the Excel");
		return ExcelUtil.getTestData(Constant.TestDataExcelFilePath,Constant.TestDataExcelFileSheet);
		
	}

	@Test(dataProvider="testData")
	public void testAddContactPerson(String CaseRow,String CaseName,String UserName,
			String PassWord,String Name,String Email,String PhoneNumber,
			String AssertName,String AssertEmail,String AssertPhoneNumber) throws  Exception{
		
			log.startTestCase(CaseName);
			driver.get(url);
			log.info("visit the url: " + url);
			
			try {
				log.info("use the execute method in AddContactPersonAction");
				AddContactPersonAction.execute(driver,UserName, PassWord,Name, Email,PhoneNumber);
			} catch (Exception e) {
				/*
				 * 执行AddContactPersonAction类的execute方法失败时，catch语句可以捕获AssertionError类型
				 * 的异常，并设置Excel中测试数据行的执行结果为“测试失败”。由于Excel中的序号格式被默认设定
				 * 为带有一位小数点，所以使用 split("[.]"[0]) 语句获取序号的整数部分，并传给setCellData函
				 * 数在对应序号的测试数据行的最后一列设定“测试失败”
				 */
				ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]),
						ExcelUtil.getLastColumnNum(),"test failed");
				log.info("add contact failed");
				Screenshot.method(driver,"add contact failed");
				log.info("use Screenshot.method to take screenshot");
				log.endTestCase(CaseName);
				Assert.fail("the execute method in AddContactPersonAction failed.");

			}
					
		Thread.sleep(3000);
		log.info("wait 3 seconds after excute() of AddContactPersonAction");
		
		try{
			log.info("if the assertion page has the name："+AssertName);
			Assert.assertTrue(driver.getPageSource().contains(AssertName));
			}catch(AssertionError error){
			log.info("if the assertion page has the name："+AssertName +" failed.");
			ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]),
					ExcelUtil.getLastColumnNum(),"test failed");
			Screenshot.method(driver, "assertion contact name "+AssertName+" failed");
			log.info("use Screenshot.method to take screenshot");
			log.endTestCase(CaseName);
			Assert.fail("assertion contact name failed");
		}
		

		try{
			log.info("断言页面是否包含联系人邮箱："+AssertEmail);
			//断言页面是否包含AssertEmail变量的关键字
			Assert.assertTrue(driver.getPageSource().contains(AssertEmail));
		}catch(AssertionError error){
			log.info("断言通讯录页面是否包含联系人邮箱地址："+AssertEmail+" 失败");		
			ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]),
					ExcelUtil.getLastColumnNum(),"测试失败");
			log.info("调用Screenshot.method方法进行截图");
			Screenshot.method(driver,"断言联系人邮箱为"+AssertEmail+"失败");
			log.endTestCase(CaseName);
			Assert.fail("断言通讯录页面是否包含联系人邮箱地址的关键字失败");
		}
		
		
		try{
			log.info("断言通讯录页面是否包含联系人手机号码："+AssertPhoneNumber);
			//断言页面是否包含AssertPhoneNumber变量的关键字
			Assert.assertTrue(driver.getPageSource().contains(AssertPhoneNumber));
		}catch(AssertionError error){
			ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]),
					ExcelUtil.getLastColumnNum(),"测试失败");
			log.info("断言通讯录页面是否包含联系人手机号码："+AssertPhoneNumber+" 失败");
			Screenshot.method(driver,"断言联系人手机号码为"+AssertPhoneNumber+"失败");
			log.info("调用Screenshot.method方法进行截图");
			log.endTestCase(CaseName);
			Assert.fail("断言通讯录页面是否包含联系人手机号码关键字失败");
		}
		ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]),
				ExcelUtil.getLastColumnNum(),"测试成功");
		log.info("新建联系人全部断言成功，在Excel的测试数据文件“测试执行结果”列中写入“测试成功”");
		log.endTestCase(CaseName);
		
	}
	
	@BeforeClass
	public void beforeClass() throws Exception{

		DOMConfigurator.configure(System.getProperty("user.dir") + "\\Log4j.xml");

		ExcelUtil.setExcelFileDataLocation(Constant.TestDataExcelFilePath,Constant.TestDataExcelFileSheet);
		log.info("use constant variable to get the data file path: " + Constant.TestDataExcelFilePath);
		log.info("use constant variable to get the sheet: " + Constant.TestDataExcelFileSheet);
	}
	
	@BeforeMethod
	public void beforeMethod(){
		System.setProperty("webdriver.chrome.driver",Constant.webDriverPath);
		driver=new ChromeDriver();
		log.info("start browser");
	}

	@AfterMethod
	public void afterMethod(){
		driver.quit();
		log.info("close browser");
		
	}

}
