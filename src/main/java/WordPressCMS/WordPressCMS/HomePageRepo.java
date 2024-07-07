/**
 * 
 */
package WordPressCMS.WordPressCMS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	By getStartedLink = By.linkText("Get started");
	
	public void ClickPlansAndPricing()
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(plansPricingLink));
		driver.findElement(plansPricingLink).click();
	}
	
	public void ClickLogin()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(loginLink));
		driver.findElement(loginLink).click();
	}
	
	public void ClickGetStarted()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(getStartedLink));
		driver.findElement(getStartedLink).click();
	}

}
