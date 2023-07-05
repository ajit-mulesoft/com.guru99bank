package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@name='uid']")
	private WebElement userId;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	//btnLogin
	@FindBy(xpath = "//input[@name='btnLogin']")
	private WebElement loginButton;
	
	public void enterUserId(String un)
	{
		userId.sendKeys(un);
	}
	
	public void enterPassword(String pw)
	{
		password.sendKeys(pw);
	}
	
	public void clickOnLogin()
	{
		loginButton.click();
	}

}
