/**
 * 
 */
package WordPressCMS.WordPressCMS;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author adenuga.ayannuga
 * 
 * This class will store all the locators and methods of Wordpress CMS Login Page
 *
 */
public class LoginPageRepo {
	
	WebDriver driver;
	
	public LoginPageRepo(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	By usernameOrEmail = By.id("usernameOrEmail");
	By password = By.id("password");
	By continueButton = By.cssSelector("button.button.form-button.is-primary");
	By loginButton = By.cssSelector("button.button.form-button.is-primary");
	By continueWithGoogleButton = By.cssSelector("span.social-buttons__service-name");
	By emailOrPhone = By.name("identifier");
	By nextButton = By.cssSelector("span.RveJvd.snByac");
	By password2 = By.name("password");
	By searchField = By.id("search-component-1");
	
	public void loginToWordpress(String username, String pass)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(usernameOrEmail).sendKeys(username);
		driver.findElement(continueButton).click();
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
	}
	
	public void loginToWordpressGoogle()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Store and Print the name of the First window on the console
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window handle: " + parentWindow);
		
        WebDriverWait wait = new WebDriverWait(driver, 20);
		/*wait.until(ExpectedConditions.elementToBeClickable(continueWithGoogleButton));
		driver.findElement(continueWithGoogleButton).click();*/
        
		try {
			Thread.sleep(10000);
			driver.findElement(continueWithGoogleButton).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Store and Print the name of all the windows open	              
        Set<String> handles = driver.getWindowHandles();
        System.out.println("Display open window handles: " + handles);
        // Pass a window handle to the other window
        for (String windowHandle : driver.getWindowHandles()) {
        System.out.println(windowHandle);

        driver.switchTo().window(windowHandle);
        }
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailOrPhone));
        driver.findElement(emailOrPhone).sendKeys("dotuntestautomation@gmail.com");
		driver.findElement(nextButton).click();
		driver.findElement(password2).sendKeys("P@ssword_1A");
		
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		driver.findElement(nextButton).click();
        
        driver.switchTo().window(parentWindow);
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
	}


}
