/**
 * 
 */
package WordPressCMS.WordPressCMS;

import java.time.Duration;

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
		driver.quit();
	}
	
	@Test (priority = 0)
	public void verifyCreateWordpressBlogFree()
	{	
		HomePageRepo homePage = new HomePageRepo(driver);
		GetStartedPageRepo getStarted = new GetStartedPageRepo(driver);
		homePage.clickPlansAndPricing();
		getStarted.createWordpressAccountFreePlan();
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Create a site — WordPress.com");
		
		getStarted.createWordpressAccountDataInput();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String pageTitle1 = driver.getTitle();
		System.out.println(pageTitle1);
		Assert.assertEquals(pageTitle1, "Checkout — WordPress.com");
		
	}
	
	@Test (priority = 1)
	public void verifyCreateWordpressBlogPersonal()
	{	
		HomePageRepo homePage = new HomePageRepo(driver);
		GetStartedPageRepo getStarted = new GetStartedPageRepo(driver);
		homePage.clickPlansAndPricing();
		getStarted.createWordpressAccountPersonalPlan();
		
		getStarted.createWordpressAccountDataInput();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
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
		homePage.clickPlansAndPricing();
		getStarted.createDuplicateWordpressAccount();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"primary\"]/div/main/div[2]/div/form/div[1]/div[1]/div[1]/span[2]")));
		
		String validationmsg = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div[2]/div/form/div[1]/div[1]/div[1]/span[2]")).getText();
		System.out.println(validationmsg);
		Assert.assertEquals(validationmsg, "This email address is already associated with an account. Please consider using another one or log in.");
	}
}