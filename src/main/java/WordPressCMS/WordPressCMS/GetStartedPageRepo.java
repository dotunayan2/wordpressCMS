package WordPressCMS.WordPressCMS;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author adenuga.ayannuga
 * 
 * This class will store all the locators and methods of Wordpress CMS Get Started Page
 *
 */

public class GetStartedPageRepo 
{	
	
	WebDriver driver;
	
	public GetStartedPageRepo(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	By email = By.id("email");
	By username = By.name("username");
	By password = By.id("password");
	By createAccountButton = By.cssSelector("button.button.signup-form__submit.form-button.is-primary");
	By blogOption = By.cssSelector("strong.site-type__option-label");
	By blogTopic = By.id("siteTopic");
	By continueButton = By.xpath("//*[@aria-label=\"Continue with the entered contact details\"]");
	By blogName = By.id("title");
	By domainName = By.xpath("//*[@aria-label=\"What would you like your domain name to be?\"]");
	By selectDomain = By.cssSelector("h3.domain-registration-suggestion__title");
	By pickPersonalPlan = By.cssSelector("button.button.plan-features__actions-button.is-personal-plan");
	By pickFreePlan = By.id("lpc-button");
	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By phone = By.name("phone");
	By country = By.id("country-code");
	By continueCheckoutButton = By.cssSelector("button.button.contact-details-form-fields__submit-button.form-button.is-primary");
	By address = By.id("address-1");
	By city = By.id("city");
	By state = By.id("state");
	By postalCode = By.id("postal-code");
	By checkoutText = By.cssSelector("span.masterbar__secure-checkout-text");
	By subscriptionTerm = By.cssSelector("div.subscription-length-picker__option-term");
	By duplicateEmailMsg = By.cssSelector("div.form-input-validation.is-error");
	
	public String memberName = UUID.randomUUID().toString().substring(0, 20);
	public String member = "User" + memberName;
	public String generateEmail = member + "@gmail.com";

	public void createWordpressAccountPersonalPlan()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(email).sendKeys(generateEmail);
		driver.findElement(username).sendKeys(memberName);
		driver.findElement(password).sendKeys("P@ssword_1A");
		driver.findElement(createAccountButton).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		driver.findElement(domainName).sendKeys(memberName);
		driver.findElement(selectDomain).click();
			
		wait.until(ExpectedConditions.elementToBeClickable(pickPersonalPlan));
		driver.findElement(pickPersonalPlan).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));	
		
		driver.findElement(firstName).sendKeys("Test");
		driver.findElement(lastName).sendKeys("Automation");
		driver.findElement(phone).sendKeys("08029075365");
		
		Select dropdown = new Select(driver.findElement(country));
		dropdown.selectByValue("NG");
		
		driver.findElement(address).sendKeys("Test");
		driver.findElement(city).sendKeys("Lagos");
		driver.findElement(state).sendKeys("Lagos");
		driver.findElement(postalCode).sendKeys("100001");
		
		driver.findElement(continueButton).click();
	}
	
	public void createWordpressAccountFreePlan()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.elementToBeClickable(pickFreePlan));
		driver.findElement(pickFreePlan).click();
		
		driver.findElement(email).sendKeys(generateEmail);
		driver.findElement(username).sendKeys(memberName);
		driver.findElement(password).sendKeys("P@ssword_1A");
		driver.findElement(createAccountButton).click();
		
		driver.findElement(domainName).sendKeys(memberName);
		driver.findElement(selectDomain).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(pickPersonalPlan));
		driver.findElement(pickPersonalPlan).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
		
		driver.findElement(firstName).sendKeys("Test");
		driver.findElement(lastName).sendKeys("Automation");
		driver.findElement(phone).sendKeys("08029075365");
		
		Select dropdown = new Select(driver.findElement(country));
		dropdown.selectByValue("NG");
		
		driver.findElement(address).sendKeys("Test");
		driver.findElement(city).sendKeys("Lagos");
		driver.findElement(state).sendKeys("Lagos");
		driver.findElement(postalCode).sendKeys("100001");
		
		driver.findElement(continueButton).click();
	}
	
	public void createDuplicateWordpressAccount()
	
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(email).sendKeys("dotuntestautomation@gmail.com");
		driver.findElement(username).sendKeys("dotuntestautomation");
		driver.findElement(password).sendKeys("P@ssword_1A");
		driver.findElement(createAccountButton).click();
	}
}