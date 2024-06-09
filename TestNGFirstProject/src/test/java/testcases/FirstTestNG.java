package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSFile;

public class FirstTestNG extends BaseTest {

	@Test(dataProviderClass = ReadXLSFile.class, dataProvider = "userinfo")
	public static void LoginTest(String username, String password) throws InterruptedException {

		driver.findElement(By.linkText(login_locators.getProperty("signin_link"))).click();
		driver.findElement(By.id(login_locators.getProperty("email_field"))).sendKeys(username);
		Thread.sleep(500);
		driver.findElement(By.id(login_locators.getProperty("next_button"))).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(login_locators.getProperty("pwd_field"))).sendKeys(password);
		driver.findElement(By.xpath(login_locators.getProperty("login_next_button"))).click();

	}

/*	// Using testNG dataprovider annotation for data driven test	
	@DataProvider(name = "userinfo")
	public Object[][] testData() {
		return new Object[][] 
		{
			{ "sree_74@yahoo.com", "Sree0!" }, 
			{ "sreedhar@yahoo.com", "Sre28!" },
			{ "sreedharp_74@yahoo.com", "Sree2840!" } 
		};
	}
	*/
	
	
}
