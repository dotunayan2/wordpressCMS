/**
 * 
 */
package WordPressCMS.WordPressCMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		Assert.assertEquals(pageTitle, "WordPress.com");
		
		
		String pageHeader = driver.findElement(By.xpath("//*[@id=\"free-setup-header\"]/div/h1")).getText();
		System.out.println(pageHeader);
		Assert.assertEquals(pageHeader, "Personalize your Site");
		
	}
	
	@Test (priority = 1)
	public void verifyCreateWordpressBlogPersonal()
	{	
		HomePageRepo homePage = new HomePageRepo(driver);
		GetStartedPageRepo getStarted = new GetStartedPageRepo(driver);
		homePage.ClickPlansAndPricing();
		getStarted.createWordpressAccountPersonalPlan();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"primary\"]/div/main/div[2]/div/form/div[1]/div[1]/div[1]/span[2]")));
		
		String validationmsg = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div[2]/div/form/div[1]/div[1]/div[1]/span[2]")).getText();
		System.out.println(validationmsg);
		Assert.assertEquals(validationmsg, "This email address is already associated with an account. Please consider using another one or log in.");
	}
}
