package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SeleniumGridPractice {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String NodeUrl="http://10.0.0.4:28958/wd/hub";
		URL url=new URL(NodeUrl);
		DesiredCapabilities capability=DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN10);
		WebDriver driver=new RemoteWebDriver(url,capability);
		Thread.sleep(10000);
		driver.get("https://www.google.com");
	}

}
