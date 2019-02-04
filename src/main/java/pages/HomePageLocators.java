package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
	
	@FindBy(xpath="//input[@name='fromPlaceName']")
	public WebElement fromPlace;
	
	@FindBy(xpath="//input[@id='toPlaceName']")
	public WebElement toPlace;
	
	@FindBy(xpath="//input[@id='txtJourneyDate']")
	public WebElement depDate;
	
	@FindBy(xpath="//input[@id='txtReturnJourneyDate']")
	public WebElement retDate;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement searchButton;	

}
