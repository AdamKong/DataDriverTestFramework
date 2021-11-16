package com.adam.pageObjects;

import com.adam.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkmanPage {
	private WebElement element;
	private WebDriver driver;

	private ObjectMap objectMap = new ObjectMap(System.getProperty("user.dir") + "\\objectProps\\objectMap.properties");
	public LinkmanPage(WebDriver driver){
		this.driver=driver;
	}

	public WebElement addressBook() throws Exception{
		element=driver.findElement(objectMap.getLocator("addressbookpage.addlinkman"));
		return element;
	}
}
