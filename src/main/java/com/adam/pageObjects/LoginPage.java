package com.adam.pageObjects;

import com.adam.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private ObjectMap objectMap=new ObjectMap(System.getProperty("user.dir") + "\\objectProps\\objectMap.properties");
	private WebElement element;
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}

	public WebElement intoLogin() throws Exception{
		element=driver.findElement(objectMap.getLocator("loginpage.intologin"));
		return element;
	}

	public WebElement loginFrame() throws Exception{
		element=driver.findElement(objectMap.getLocator("loginpage.loginframe"));
		return element;
	}

	public WebElement userName() throws Exception{
		element=driver.findElement(objectMap.getLocator("loginpage.username"));
		return element;
	}

	public WebElement passWord() throws Exception{
		element=driver.findElement(objectMap.getLocator("loginpage.password"));
		return element;
	}

	public WebElement loginButton() throws Exception{
		element=driver.findElement(objectMap.getLocator("loginpage.loginbutton"));
		return element;
	}

}
