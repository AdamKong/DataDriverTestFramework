package com.adam.appModules;

import com.adam.pageObjects.LoginPage;
import com.adam.pageObjects.WaitByElement;
import com.adam.util.WaitMethod;
import com.adam.util.log;
import org.openqa.selenium.WebDriver;

public class LoginAction {
	public static void execute(WebDriver driver, String userName, String passWord)
		throws Exception{
		log.info("maximize the browser");
		driver.manage().window().maximize();
		log.info("new a login object");
		LoginPage login = new LoginPage(driver);
		log.info("click the 163 login option area");
		login.intoLogin().click();
		log.info("explicitly wait " + WaitByElement.loginFrame + " element 5 seconds");
		WaitMethod.xsWait(driver,WaitByElement.loginFrame,5);
		log.info("into login UI's frame");
		driver.switchTo().frame(login.loginFrame());
		log.info("input username: " + userName);
		login.userName().sendKeys(userName);
		log.info("input password" + passWord);
		login.passWord().sendKeys(passWord);
		log.info("click login button");
		login.loginButton().click();
	}

}
