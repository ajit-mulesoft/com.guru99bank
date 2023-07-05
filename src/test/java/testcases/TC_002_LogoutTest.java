package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseClass;
import pageobject.HomePage;
import pageobject.LoginPage;

public class TC_002_LogoutTest extends BaseClass {
	
	@Test
	public void verifyLogout()
	{
		logger.info("******TC_001_LogoutTest started**********");
		try {
		LoginPage lp = new LoginPage(driver);
		
		lp.enterUserId(rb.getString("userName"));
		lp.enterPassword(rb.getString("password"));
		lp.clickOnLogin();
		HomePage hp = new HomePage(driver);
		hp.clickOnLogout();
	}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("******TC_001_LogoutTest ended**********");
}
	
}
