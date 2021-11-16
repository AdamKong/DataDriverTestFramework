package com.adam.pageObjects;

import com.adam.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private ObjectMap objectMap = new ObjectMap(System.getProperty("user.dir") + "\\objectProps\\objectMap.properties");
	private WebElement element;
	private WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver=driver;
	}

	public WebElement homePageText() throws Exception{
		element=driver.findElement(objectMap.getLocator("homepage.shouyetext"));
		return element;
	}

	public WebElement tongxunId() throws Exception{
		element=driver.findElement(objectMap.getLocator("homepage.addressbook"));
		return element;
	}
	
}
