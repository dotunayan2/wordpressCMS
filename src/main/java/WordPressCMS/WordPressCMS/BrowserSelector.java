/**
 * 
 */
package WordPressCMS.WordPressCMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
			String driverPath = System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",driverPath);
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
			String driverPath = System.getProperty("user.dir")+"\\drivers\\geckodriver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",driverPath);
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("IE"))
		{
			String driverPath = System.getProperty("user.dir")+"\\drivers\\IEDriver\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver",driverPath);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
	}
}
