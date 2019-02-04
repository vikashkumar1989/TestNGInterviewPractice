package base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class Base {
	public static WebDriver driver;
	public static String userdir=System.getProperty("user.dir");
	
	@BeforeMethod
	@Parameters({"Browser","URL"})
	public static void Initialize(@Optional("Chrome")String browser, @Optional("https://www.airvistara.com/trip/")String url) {
		if(browser.equals("Chrome")) {
			System.out.println("Executing in Chrome");
			System.setProperty("webdriver.chrome.driver", userdir+"\\src\\test\\resources\\driverConfig\\chromedriver.exe");
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ChromeOptions options=new ChromeOptions();
			cap.merge(options);
			driver=new ChromeDriver(options);
			
		}else if(browser.equals("Executing in Firefox")) {
			System.out.println("Executing in Firefox");
			System.setProperty("webdriver.firefox.driver", userdir+"\\src\\test\\resources\\driverConfig\\geckodriver.exe");
			DesiredCapabilities cap=DesiredCapabilities.firefox();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			FirefoxOptions options=new FirefoxOptions();
			cap.merge(options);
			driver=new FirefoxDriver(options);
			
		}else if(browser.equals("IE")) {
			System.out.println("Executing in IE");
			System.setProperty("webdriver.ie.driver", userdir+"\\src\\test\\resources\\driverConfig\\IEDriverServer.exe");
			DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			InternetExplorerOptions options=new InternetExplorerOptions();
			cap.merge(options);
			driver=new InternetExplorerDriver(options);
			
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,10);
	}
	
	@AfterMethod
	public static void TearDown() {
		if(driver!=null) {
			driver.quit();
		}
		
	}

}
