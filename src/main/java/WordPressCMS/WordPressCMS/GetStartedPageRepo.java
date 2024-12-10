package WordPressCMS.WordPressCMS;

import java.time.Duration;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	By continueWithGoogleButton = By.xpath("//*[@id=\"primary\"]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[1]");
	By continueWithEmailButton = By.xpath("//*[@id=\"primary\"]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/button[4]");	
	By email = By.id("signup-email");
	By username = By.name("username");
	By password = By.id("password");
	By continueBtn = By.xpath("//*[@id=\"primary\"]/div/div[2]/div/div/div/div[3]/div[1]/div/div/div/form/div/button");
	By createAccountButton = By.cssSelector("button.button.signup-form__submit.form-button.is-primary");
	By blogOption = By.cssSelector("strong.site-type__option-label");
	By blogTopic = By.id("siteTopic");
	By continueButton = By.xpath("//*[@aria-label=\"Continue with the entered contact details\"]");
	By blogName = By.id("title");
	By domainName = By.id("search-component-search-0");
	By selectDomain = By.cssSelector("button.button.domain-suggestion__action.is-primary");
	By pickPersonalPlan = By.xpath("//*[@id=\"pricing-grid\"]/div[3]/div/div[1]/div[1]/div[4]/div[2]/a/span[1]");
	By pickFreePlan = By.linkText("start with our free plan");
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(pickPersonalPlan));
		driver.findElement(pickPersonalPlan).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(continueWithEmailButton));
		driver.findElement(continueWithEmailButton).click();
		
		driver.findElement(email).sendKeys(generateEmail);
		driver.findElement(continueBtn).click();
	}
	
	public void createWordpressAccountFreePlan()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.elementToBeClickable(pickFreePlan));
		driver.findElement(pickFreePlan).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(continueWithEmailButton));
		driver.findElement(continueWithEmailButton).click();
		
		driver.findElement(email).sendKeys(generateEmail);
		driver.findElement(continueBtn).click();		
	}

	public void createWordpressAccountDataInput()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
		wait.until(ExpectedConditions.elementToBeClickable(domainName));

		driver.findElement(domainName).sendKeys(memberName);
		
		wait.until(ExpectedConditions.elementToBeClickable(selectDomain));

		driver.findElement(selectDomain).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));	
		
		driver.findElement(firstName).sendKeys("Test");
		driver.findElement(lastName).sendKeys("Automation");
		driver.findElement(phone).sendKeys("08029075365");
		
		driver.findElement(address).sendKeys("Test");
		driver.findElement(city).sendKeys("Lagos");
		driver.findElement(state).sendKeys("Lagos");
		driver.findElement(postalCode).sendKeys("100001");
		
		driver.findElement(continueButton).click();
	}

	
	public void createDuplicateWordpressAccount()
	
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.elementToBeClickable(pickFreePlan));
		driver.findElement(pickFreePlan).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(continueWithEmailButton));
		driver.findElement(continueWithEmailButton).click();
		driver.findElement(email).sendKeys("dotuntestautomation@gmail.com");
		driver.findElement(continueBtn).click();
	}
}