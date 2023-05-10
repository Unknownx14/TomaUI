package Academy.Toma16012023;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Academy.PageObject.LandingPagePO;
import Academy.TestComponents.BaseTest;
import Academy.TestComponents.BaseTest02;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest1 extends BaseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup(); // WebDriver manager for invoking the chromedriver that is not on our local machine
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get("https://react-redux.realworld.io/#/login");
		
		//01. Login to the application
		
		String userEmail = "jovan.kovacevic@hotmail.com";
		String userPassword = "glupavipassword";
		String userName = "JovanK";
		
		LandingPagePO lppo = new LandingPagePO(driver);
		
		lppo.goTo();
		lppo.LoginToApplication(userEmail, userPassword);
		
		
		String userNameInApplication = lppo.getUserName();
		System.out.println(userNameInApplication);
		
		Assert.assertEquals(userNameInApplication, userName);
		
		driver.close();
		

	}

}
