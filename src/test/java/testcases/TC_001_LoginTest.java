package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseClass;
import pageobject.HomePage;
import pageobject.LoginPage;



public class TC_001_LoginTest extends BaseClass {
	
	
	@Test
	public void verifyLogin()
	{
		logger.info("******TC_001_LoginTest started**********");
		try {
		LoginPage lp = new LoginPage(driver);
		//mngr512684
		//tUnAhEd
		lp.enterUserId(rb.getString("userName"));
		lp.enterPassword(rb.getString("password"));
		lp.clickOnLogin();
		HomePage hp = new HomePage(driver);
		boolean verifyManagerButton = hp.verifyManagerButton();
		Assert.assertEquals(verifyManagerButton, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("******TC_001_LoginTest ended**********");
	}

}
