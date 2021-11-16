package com.adam.testCases;

import com.adam.appModules.LoginAction;
import com.adam.pageObjects.HomePage;
import com.adam.pageObjects.WaitByElement;
import com.adam.util.Constant;
import com.adam.util.WaitMethod;
import com.adam.util.log;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestEmail163Login {
	public WebDriver driver;
	String url="https://mail.163.com/";

	@BeforeMethod
	public void beforeMEthod(){
		DOMConfigurator.configure(System.getProperty("user.dir") + "\\Log4j.xml");

		ChromeOptions option = new ChromeOptions();
		option.setBinary(Constant.browserInstallationPath);
		System.setProperty("webdriver.chrome.driver", Constant.webDriverPath);
		driver = new ChromeDriver(option);
	}
	@Test
	public void testLogin() throws Exception{
		log.startTestCase("login 163 email box");
		log.info("visit page: " + url);
		driver.get(url);
		log.info("use LoginAction.execute to login");
		LoginAction.execute(driver, "", "");
		log.info("use explicit wait to make sure it works");
		WaitMethod.xsWait(driver,WaitByElement.weiduButton,5);
		log.info("assert that if the title is: “网易邮箱6.0版”，title："+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "网易邮箱6.0版");
		log.info("sleep 5 seconds");
		Thread.sleep(5000);
		log.info("new a homepage object");
		HomePage homePage = new HomePage(driver);
		log.info("click tongxunlu button");
		homePage.tongxunId().click();
		log.info("sleep 3 seconds");
		Thread.sleep(3000);
	}
	@AfterMethod
	public void afterMethod(){
		log.info("close browser!");
		driver.quit();
		log.endTestCase("登录163邮箱");
	}

}
