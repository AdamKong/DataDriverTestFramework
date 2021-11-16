package com.adam.appModules;

import com.adam.pageObjects.AddressBookPage;
import com.adam.pageObjects.HomePage;
import com.adam.pageObjects.LinkmanPage;
import com.adam.pageObjects.WaitByElement;
import com.adam.util.Screenshot;
import com.adam.util.WaitMethod;
import com.adam.util.log;
import org.openqa.selenium.WebDriver;

public class AddContactPersonAction {

	public static void execute(WebDriver driver,
							   String userName,
							   String passWord,
							   String Name,
							   String Email,
							   String Phonenumber) throws Exception {

		log.info("invoke the login method");
		try {
			LoginAction.execute(driver,userName, passWord);
		} catch (Exception e) {
			log.info("login 163 email failed!");
			Screenshot.method(driver,"login 163 email failed!");
		}
		log.info("explicitly wait "+WaitByElement.weiduButton + " element");
		WaitMethod.xsWait(driver,WaitByElement.weiduButton,10);
		log.info("new a homePage object");
		HomePage homePage = new HomePage(driver);
		log.info("click contact");
		homePage.tongxunId().click();
		log.info("explicitly wait " + WaitByElement.addLinMan + " element");
		WaitMethod.xsWait(driver, WaitByElement.addLinMan, 5);
		log.info("new a linkmanPage object");
		LinkmanPage linkmanPage = new LinkmanPage(driver);
		log.info("click create a contact");
		linkmanPage.addressBook().click();
		log.info("explicitly wait " + WaitByElement.confirmButton + " element");
		WaitMethod.xsWait(driver, WaitByElement.confirmButton, 5);
		log.info("new a addressbookPage object");
		AddressBookPage addressbookPage = new AddressBookPage(driver);
		log.info("input contact name: " + Name);
		addressbookPage.inputName().sendKeys(Name);
		log.info("input contact email address: " + Email);
		addressbookPage.inputEmail().sendKeys(Email);
		log.info("input contact phone number: " + Phonenumber);
		addressbookPage.inputPhonenumber().sendKeys(Phonenumber);
		log.info("click the confirm button on add new contact UI.");
		addressbookPage.inputConfirmbutton().click();
	}

}
