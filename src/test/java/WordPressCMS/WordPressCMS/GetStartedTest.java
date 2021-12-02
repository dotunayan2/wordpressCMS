/**
 * 
 */
package WordPressCMS.WordPressCMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author adenuga.ayannuga
 * 
 * This class contains all Get Started / Account Creation test cases for the Wordpress CMS application
 *
 */
public class GetStartedTest {
	
	public WebDriver driver ;
	
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
	public void verifyCreateWordpressBlogFree()
	{	
		HomePageRepo homePage = new HomePageRepo(driver);
		GetStartedPageRepo getStarted = new GetStartedPageRepo(driver);
		homePage.ClickPlansAndPricing();
		getStarted.createWordpressAccountFreePlan();
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Checkout — WordPress.com");
	}
	
	@Test (priority = 1)
	public void verifyCreateWordpressBlogPersonal()
	{	
		HomePageRepo homePage = new HomePageRepo(driver);
		GetStartedPageRepo getStarted = new GetStartedPageRepo(driver);
		homePage.ClickGetStarted();
		getStarted.createWordpressAccountPersonalPlan();
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Checkout — WordPress.com");
	}
	
	@Test (priority = 2)
	public void verifyCreateDuplicateWordpressAccount()
	{	
		HomePageRepo homePage = new HomePageRepo(driver);
		GetStartedPageRepo getStarted = new GetStartedPageRepo(driver);
		homePage.ClickGetStarted();
		getStarted.createDuplicateWordpressAccount();
		
		String validationmsg = driver.findElement(By.cssSelector("div.form-input-validation.is-error")).getText();
		System.out.println(validationmsg);
		Assert.assertEquals(validationmsg, "Choose a different email address. This one is not available. If this is you log in now.");
	}
}
