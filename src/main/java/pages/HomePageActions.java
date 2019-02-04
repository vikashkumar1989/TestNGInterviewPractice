package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Base;

public class HomePageActions extends Base{
	HomePageLocators hpl;
	public HomePageActions() {
		this.hpl=new HomePageLocators();
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.hpl);		
	}
	public void SearchBus() {
		hpl.fromPlace.sendKeys("BEN");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String place = (String)js.executeScript("return document.getElementById('fromPlaceName').value");;		
		
		while(!place.equals("BENGALURU AIRPRT")) {
			hpl.fromPlace.sendKeys(Keys.ARROW_DOWN);
			place=(String)js.executeScript("return document.getElementById('fromPlaceName').value");			
		}
		hpl.fromPlace.sendKeys(Keys.ENTER);
		
		hpl.toPlace.sendKeys("MYS");
		String place2=(String)js.executeScript("return document.getElementById('toPlaceName').value");;
		while(!place.equals("MYSORE")) {
			hpl.toPlace.sendKeys(Keys.ARROW_DOWN);
			place=(String)js.executeScript("return document.getElementById('toPlaceName').value");			
		}
		hpl.fromPlace.sendKeys(Keys.ENTER);
	}

}
