package test;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;

public class Testing02 extends Base{
	
	@Test(dataProvider="getData")
	public void FlightLogin(String username, String password) {
		driver.findElement(By.xpath("//button[@class='btn-lg sign-in-btn']")).click();
		driver.findElement(By.xpath("//input[@id='sign-in-FFid']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='sign-in-pin']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id='login-btn-md']")).click();
		
	}
	@DataProvider(parallel=false)
	public synchronized Object[][] getData(){
		Object[][] obj=new Object[2][2];
		obj[0][0]="smartyvik35@gmail.com";
		obj[0][1]="181285";
		
		obj[1][0]="vikashkumar@gmail.com";
		obj[1][1]="060185";
		return obj;
	}

}
