package Academy.Toma16012023;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Academy.PageObject.LandingPagePO;
import Academy.PageObject.PublishArticlePO;
import Academy.PageObject.SettingsPagePO;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PublishArticleAndLogoutTest1 {

	@Test
	public void E2E()
	{
		
		
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
		

		//02. Create and publish an article

		PublishArticlePO papo= new PublishArticlePO(driver);
		
		papo.clickNewPostButton();


		String articleTitle = "Title01"+System.currentTimeMillis();
		String articleAbout = "About01";
		String articleText = "Text01";
		String articleTag = "Tag01";

		papo.publishAsrticle(articleTitle, articleAbout, articleText, articleTag);

		String author =  papo.getAuthor();
		boolean deleteArticleButton = papo.deleteArticleIsDisplayed();

		Assert.assertEquals(author, userName);
		Assert.assertTrue(deleteArticleButton);

		
		
		//03. Logout from the application
		SettingsPagePO sppo = new SettingsPagePO(driver);
		
		sppo.clickSettingsButton();
		
		sppo.clickLogoutButton();
		
		boolean signinButton = sppo.signInButtonIsDisplayed();
		Assert.assertTrue(signinButton);
		
		driver.close();
		
	}

}
