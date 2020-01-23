/**
 * 
 */
package WordPressCMS.WordPressCMS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author adenuga.ayannuga
 * 
 * 
 * This class will store all the locators and methods of Wordpress CMS Home Page
 *
 */
public class HomePageRepo {
	
	WebDriver driver;
	
	public HomePageRepo(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	By plansPricingLink = By.linkText("Plans & Pricing");
	By loginLink = By.linkText("Log In");
	By getStartedLink = By.linkText("Get Started");
	
	public void ClickPlansAndPricing()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(plansPricingLink).click();
	}
	
	public void ClickLogin()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(loginLink).click();
	}
	
	public void ClickGetStarted()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(getStartedLink).click();
	}

}
