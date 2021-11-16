package com.adam.pageObjects;

import com.adam.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressBookPage {
	private WebElement element;
	private WebDriver driver;

	private ObjectMap objectMap = new ObjectMap(System.getProperty("user.dir") + "\\objectProps\\objectMap.properties");

	public AddressBookPage(WebDriver driver){
		this.driver = driver;
	}

	public WebElement inputName() throws Exception{
		element = driver.findElement(objectMap.getLocator("addressbookpage.name"));
		return element;
	}

	public WebElement inputEmail() throws Exception{
		element = driver.findElement(objectMap.getLocator("addressbookpage.email"));
		return element;
	}

	public WebElement inputPhonenumber() throws Exception{
		element = driver.findElement(objectMap.getLocator("addressbookpage.phonenumber"));
		return element;
	}

	public WebElement inputConfirmbutton() throws Exception{
		element = driver.findElement(objectMap.getLocator("addressbookpage.confirmbutton"));
		return element;
	}

}
