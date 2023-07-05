package pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdPage extends BasePage {

	public AdPage(WebDriver driver) {
		super(driver);
	}

@FindBy(xpath = "//div[@id='card']")
private WebElement adElement;

@FindBy(xpath = "//div[@id='dismiss-button']")
private WebElement closeButton;

public WebElement adElementVisibility()
{
	//boolean displayed = adElement.isDisplayed();
	//return displayed;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement until = wait.until(ExpectedConditions.visibilityOf(adElement));
	return until;
}

public void clickOnCloseButton()
{
	closeButton.click();
}
	

}
