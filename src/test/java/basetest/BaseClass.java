package basetest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public static WebDriver driver;
	public ResourceBundle rb;
	public org.apache.logging.log4j.Logger logger;
	
	
	@BeforeClass(groups = {"regression"})
	@Parameters("browser")
	public void setup(String br)
	{
		//logger=LogManager.getLogger(this.getClass());
		logger=LogManager.getLogger(this.getClass());
		//WebDriverManager.chromedriver().setup();
		if(br.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("http://www.demo.guru99.com/V4/");
		rb=ResourceBundle.getBundle("config");
		driver.get(rb.getString("pageUrl"));
	}
	
	@AfterClass(groups = {"regression"})
	public void tearDown()
	{
		driver.quit();
	}
	public String sevenWordString() {
		String genSevenString = RandomStringUtils.randomAlphabetic(7);
		return (genSevenString);
	}
	
	public String multiWordString() {
		String genMultiString = RandomStringUtils.randomAlphabetic(25);
		return (genMultiString);
	}

	public String genPhoneNum() {
		String generatedPhNo = RandomStringUtils.randomNumeric(10);
		return (generatedPhNo);
	}
	public String genPinCode() {
		String generatedPinCode = RandomStringUtils.randomNumeric(6);
		return (generatedPinCode);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
}
