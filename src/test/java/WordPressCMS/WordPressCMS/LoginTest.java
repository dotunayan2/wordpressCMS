/**
 * 
 */
package WordPressCMS.WordPressCMS;

import org.testng.annotations.Test;
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
	
	@BeforeMethod
	public void setup() {
		BrowserSelector browser = new BrowserSelector(driver);
		/*driver = browser.startBrowser("edge", "https://wordpress.com/");*/
		driver = browser.chooseBrowser();
	}

	@AfterMethod
	public void afterTest() {
		driver.close();
	}
	
	@Test (priority = 0)
	public void verifyValidLogin()
	{	
		HomePageRepo homePage = new HomePageRepo(driver);
		LoginPageRepo login = new LoginPageRepo(driver);
		homePage.ClickLogin();
		login.loginToWordpress("dotuntestautomation@gmail.com", "P@ssword_1A");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.searchField));
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Following ‹ Reader — WordPress.com");
	}
	
	@Test (priority = 1)
	public void verifyValidLoginUsingGoogle()
	{	
		HomePageRepo homePage = new HomePageRepo(driver);
		LoginPageRepo login = new LoginPageRepo(driver);
		homePage.ClickLogin();
		login.loginToWordpressGoogle();
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Following ‹ Reader — WordPress.com");
	}
	
	@Test (priority = 2)
	public void verifyInvalidLogin()
	{	
		HomePageRepo homePage = new HomePageRepo(driver);
		LoginPageRepo login = new LoginPageRepo(driver);
		homePage.ClickLogin();
		login.loginToWordpress("dotuntestautomation@gmail.com", "P@ssword");
		
		String validationmsg = driver.findElement(By.cssSelector("div.form-input-validation.is-error")).getText();
		System.out.println(validationmsg);
		Assert.assertEquals(validationmsg, "Oops, that's not the right password. Please try again!");
	}

}
