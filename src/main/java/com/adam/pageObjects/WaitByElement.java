package com.adam.pageObjects;

import org.openqa.selenium.By;

public class WaitByElement {

	public static By loginFrame=By.xpath("//*[@id='loginDiv']/iframe[@frameborder='0']");
	public static By weiduButton=By.id("_mail_tabitem_0_3text");
	public static By addLinMan=By.xpath("//span[text()='新建联系人']");
	public static By confirmButton=By.xpath("//div[@role='button']/span[text()='确 定']");

}
