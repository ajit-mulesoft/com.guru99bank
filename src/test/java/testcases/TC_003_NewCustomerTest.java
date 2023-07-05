package testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseClass;
import pageobject.AdPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.NewCustomerPage;

public class TC_003_NewCustomerTest extends BaseClass {

	// String string = rb.getString("customerName");

	@Test(groups = { "regression" }, priority = 1)
	public void navigateToNewCustomer() {
		logger.info("******TC_001_LogoutTest started**********");
		LoginPage lp = new LoginPage(driver);
		// mngr512684
		// tUnAhEd
		lp.enterUserId(rb.getString("userName"));
		lp.enterPassword(rb.getString("password"));
		lp.clickOnLogin();
		HomePage hp = new HomePage(driver);
		hp.clickOnNewCustomerButton();
		/*
		AdPage ad = new AdPage(driver);
		WebElement adElementVisibility = ad.adElementVisibility();
		if(adElementVisibility.isDisplayed())
			ad.clickOnCloseButton();
			*/
		String custPageTitle = driver.getTitle();

		try {
			Assert.assertEquals(custPageTitle, rb.getString("cpt"));
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test(groups = { "regression" }, priority = 2)
	public void verifyNewCustomerFields() {
		String sevenWordString = sevenWordString();
		NewCustomerPage nc = new NewCustomerPage(driver);
		nc.enterCustName(rb.getString("customerName"));

		if (rb.getString("gender").equals("male")) {
			nc.clickOnMaleRdBt();
		} else
			nc.clickOnFemaleRdBt();

		String genEmail = sevenWordString + "@" + "gmail.com";
		nc.enterDOB(rb.getString("dob"));
		nc.enterAddressField(multiWordString());
		nc.enterCityField(rb.getString("city"));
		nc.enterStateField(rb.getString("State"));
		nc.enterPinField(genPinCode());
		nc.enterPhoneNumField(genPhoneNum());
		nc.enterEmailField(genEmail);
		nc.enterpasswordField(rb.getString("password"));
	nc.clickOnSubmitBut();
		logger.info("******TC_001_LogoutTest closed**********");

	}

}
