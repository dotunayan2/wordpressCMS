/**
 * 
 */
package WordPressCMS.WordPressCMS;

import java.time.Duration;
import java.util.Set;
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
	By emailOrPhone = By.xpath("//*[@id=\"identifierId\"]");	
	By nextButton = By.xpath("//*[@id=\"identifierNext\"]/div/button/span");
	By password2 = By.name("password");
	By searchField = By.id("search-component-1");
	
	public void loginToWordpress(String username, String pass)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(usernameOrEmail));
		
		driver.findElement(usernameOrEmail).sendKeys(username);
		driver.findElement(continueButton).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(password));
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
	}
	
	public void loginToWordpressGoogle()
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Store and Print the name of the First window on the console
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window handle: " + parentWindow);
				
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueWithGoogleButton));
		driver.findElement(continueWithGoogleButton).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Store and Print the name of all the windows open	              
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Display open window handles: " + windowHandles);
        // Pass a window handle to the other window
        for (String windowHandle : windowHandles) {
        System.out.println(windowHandle);

        driver.switchTo().window(windowHandle);
        }
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailOrPhone));
        driver.findElement(emailOrPhone).sendKeys("dotuntestautomation@gmail.com");
		driver.findElement(nextButton).click();
		
		driver.close();
        
        driver.switchTo().window(parentWindow);
	}


}
