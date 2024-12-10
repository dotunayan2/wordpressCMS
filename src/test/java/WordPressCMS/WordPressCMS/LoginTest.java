/**
 * 
 */
package WordPressCMS.WordPressCMS;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * @author adenuga.ayannuga
 * 
 * This class contains all Login test cases for the Wordpress CMS application
 *
 */
public class LoginTest {
	
	public WebDriver driver;
	
	By errorMsg = By.xpath("//*[@id=\"primary\"]/div/main/div[2]/div/form/div[1]/div[1]/div/div[2]/span");
		
	@BeforeMethod
	public void setup() {
		BrowserSelector browser = new BrowserSelector(driver);
		driver = browser.chooseBrowser();
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
	
	@Test (priority = 0)
	public void verifyValidLogin()
	{	
		HomePageRepo homePage = new HomePageRepo(driver);
		LoginPageRepo login = new LoginPageRepo(driver);
		homePage.clickLogin();
		login.loginToWordpress("dotuntestautomation@gmail.com", "P@ssword_1A");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("My Home ‹ Test Automation's Blog on Religion — WordPress.com"));
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "My Home ‹ Test Automation's Blog on Religion — WordPress.com");
	}
	
	@Test (priority = 2)
	public void verifyValidLoginUsingGoogle()
	{	
		HomePageRepo homePage = new HomePageRepo(driver);
		LoginPageRepo login = new LoginPageRepo(driver);
		homePage.clickLogin();
		login.loginToWordpressGoogle();
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Log In — WordPress.com");
	}
	
	@Test (priority = 1)
	public void verifyInvalidLogin()
	{	
		HomePageRepo homePage = new HomePageRepo(driver);
		LoginPageRepo login = new LoginPageRepo(driver);
		homePage.clickLogin();
		login.loginToWordpress("dotuntestautomation@gmail.com", "P@ssword");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
		
		String errormsg = driver.findElement(errorMsg).getText();
		System.out.println(errormsg);
		
		Assert.assertEquals(errormsg, "It seems you entered an incorrect password. Want to get a login link via email?");
	}

}
