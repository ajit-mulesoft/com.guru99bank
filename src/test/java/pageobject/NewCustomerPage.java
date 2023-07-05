package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomerPage extends BasePage {

	public NewCustomerPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='name']")
	private WebElement customerName;

	@FindBy(xpath = "//input[@name='rad1' and @value='m']")
	private WebElement maleRdBt;

	@FindBy(xpath = "//input[@name='rad1' and @value='f']")
	private WebElement femaleRdBt;

	@FindBy(id = "dob")
	private WebElement calenderDOB;

	@FindBy(name = "addr")
	private WebElement addressField;

	@FindBy(name = "city")
	private WebElement cityField;

	@FindBy(name = "state")
	private WebElement stateField;
	
	@FindBy(name = "pinno")
	private WebElement pinField;
	
	@FindBy(name = "telephoneno")
	private WebElement phoneNumField;
	
	@FindBy(name = "emailid")
	private WebElement emailField;
	
	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(name = "sub")
	private WebElement submitBut;

	public void enterCustName(String cn) {
		customerName.sendKeys(cn);
	}

	public void clickOnMaleRdBt() {
		maleRdBt.click();
	}

	public void clickOnFemaleRdBt() {
		femaleRdBt.click();
	}

	public void enterDOB(String dob) {
		calenderDOB.sendKeys(dob);
	}

	public void enterAddressField(String adr) {
		addressField.sendKeys(adr);
	}

	public void enterCityField(String cty) {
		cityField.sendKeys(cty);
	}

	public void enterStateField(String st) {
		stateField.sendKeys(st);
	}
	public void enterPinField(String pn) {
		pinField.sendKeys(pn);
	}
	
	public void enterPhoneNumField(String phn) {
		phoneNumField.sendKeys(phn);
	}
	
	public void enterEmailField(String eml) {
		emailField.sendKeys(eml);
	}
	
	public void enterpasswordField(String pwd) {
		passwordField.sendKeys(pwd);
	}
	public void clickOnSubmitBut() {
		
		submitBut.click();
	}
	
}
