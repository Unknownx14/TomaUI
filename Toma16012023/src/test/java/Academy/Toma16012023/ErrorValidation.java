package Academy.Toma16012023;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Academy.PageObject.LandingPagePO;
import Academy.PageObject.MyArticlesPO;
import Academy.PageObject.PublishArticlePO;
import Academy.PageObject.SettingsPagePO;
import Academy.TestComponents.BaseTest02;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidation extends BaseTest02 {

	
	
	@Test(groups= {"ErrorValidations"})
	public void WrongCredentials()
	{
		
		//LandingPagePO lppo = launchApplication();  //Not needed because of the @BeforeMethod
		
		//01. Login to the application
		
		String userEmail = "jovan.kovacevic@hotmail.com";
		String userPassword = "wrongpassword";
		String userName = "JovanK";
		
		lppo.LoginToApplicationWrongCredentials(userEmail, userPassword);
		
		String expectedErrorMessage = "email or password is invalid";
		String errorMessage = lppo.getErrorMessageText();
		System.out.println(errorMessage);
		Assert.assertEquals(errorMessage, expectedErrorMessage);


		
		//driver.close();  //@AfterMethod
		
	}
	
	
	
}
