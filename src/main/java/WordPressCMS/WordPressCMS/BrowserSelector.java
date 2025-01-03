/**
 * 
 */
package WordPressCMS.WordPressCMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author adenuga.ayannuga
 * 
 * This class will handle browser selection details.
 *
 */
public class BrowserSelector {

	public WebDriver driver;
	
	public BrowserSelector(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public WebDriver startBrowser(String browserName, String url)
	{
		
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			options.addArguments("--window-size=1920,1080");
			
			options.addArguments("--disable-gpu");
			options.addArguments("--no-sandbox");
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("--ignore-certificate-errors");
			options.setAcceptInsecureCerts(true);
			
			driver = new ChromeDriver(options);
			
			// driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
	}
	
	public WebDriver chooseBrowser() {
		driver = startBrowser("chrome", "https://wordpress.com/");
		
		return driver;
	}
	
}
