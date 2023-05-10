package Academy.Toma16012023;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Academy.PageObject.LandingPagePO;
import Academy.TestComponents.BaseTest;
import Academy.TestComponents.BaseTest02;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest02 extends BaseTest02 {

	@Test
	public void loginWithValidUser() throws IOException
	{
		
		//LandingPagePO lppo = launchApplication();  //Not needed because of the @BeforeMethod
		
		//01. Login to the application
		
		String userEmail = "jovan.kovacevic@hotmail.com";
		String userPassword = "glupavipassword";
		String userName = "JovanK";
		
		lppo.LoginToApplication(userEmail, userPassword);
		
		
		String userNameInApplication = lppo.getUserName();
		System.out.println(userNameInApplication);
		
		Assert.assertEquals(userNameInApplication, userName);
		
		

	}

}
