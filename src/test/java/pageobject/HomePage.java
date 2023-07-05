package pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(linkText = "Manager")
	private WebElement ManagerButton;
	
	@FindBy(linkText = "New Customer")
	private WebElement newCustomerButton;
	
	@FindBy(linkText = "Edit Customer")
	private WebElement editCustomerButton;
	
	@FindBy(linkText = "Delete Customer")
	private WebElement deleteCustomerButton;
	
	@FindBy(linkText = "Log out")
	private WebElement logoutButton;
	
	public void clickOnNewCustomerButton()
	{
		newCustomerButton.click();
	}
	
	public void clickOnEditCustomerButton()
	{
		editCustomerButton.click();
	}
	
	public void clickOnDeleteCustomerButton()
	{
		deleteCustomerButton.click();
	}
	public void clickOnLogout()
	{
		logoutButton.click();
		try
		{
		driver.switchTo().alert().accept();
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public boolean verifyManagerButton()
	{
		try
		{
		boolean displayed = ManagerButton.isDisplayed();
		return displayed;
		}
		catch (Exception e) {
			return false;
		}
	}


}
