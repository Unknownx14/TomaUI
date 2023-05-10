package Academy.Toma16012023;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Academy.PageObject.LandingPagePO;
import Academy.PageObject.MyArticlesPO;
import Academy.PageObject.PublishArticlePO;
import Academy.PageObject.SettingsPagePO;
import Academy.TestComponents.BaseTest02;
import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E04 extends BaseTest02 {

	
	public String articleTitle;
	
	@Test(dataProvider="getData", groups= {"Publish"})
	public void E2E(HashMap<String, String> input)
	{
		
		//LandingPagePO lppo = launchApplication();  //Not needed because of the @BeforeMethod
		
		//01. Login to the application
		
/*		String userEmail = "jovan.kovacevic@hotmail.com";
		String userPassword = "glupavipassword";
		String userName = "JovanK";*/
		
		lppo.LoginToApplication(input.get("userEmailHM"), input.get("userPasswordHM"));
		
		
		String userNameInApplication = lppo.getUserName();
		System.out.println(userNameInApplication);
		
		Assert.assertEquals(userNameInApplication, input.get("userNameHM"));
		

		//02. Create and publish an article

		PublishArticlePO papo= new PublishArticlePO(driver);
		
		papo.clickNewPostButton();


		 articleTitle = "Title01"+System.currentTimeMillis();
		String articleAbout = "About01";
		String articleText = "Text01";
		String articleTag = "Tag01";

		papo.publishAsrticle(articleTitle, articleAbout, articleText, articleTag);

		String author =  papo.getAuthor();
		boolean deleteArticleButton = papo.deleteArticleIsDisplayed();

		Assert.assertEquals(author, input.get("userNameHM"));
		Assert.assertTrue(deleteArticleButton);

		
		//03. Logout from the application
		SettingsPagePO sppo = new SettingsPagePO(driver);
		
		sppo.clickSettingsButton();
		
		sppo.clickLogoutButton();
		
		boolean signinButton = sppo.signInButtonIsDisplayed();
		Assert.assertTrue(signinButton);
		
		//driver.close();  //@AfterMethod
		
	}
	

	@Test(dependsOnMethods = {"E2E"})
	public void verifyArticlePublished()
	{
		//01. Login to the application
		
				String userEmail = "jovan.kovacevic@hotmail.com";
				String userPassword = "glupavipassword";
				String userName = "JovanK";
				
				lppo.LoginToApplication(userEmail, userPassword);
				
				
				String userNameInApplication = lppo.getUserName();
				System.out.println(userNameInApplication);
				
				Assert.assertEquals(userNameInApplication, userName);
				
		//02. 
				MyArticlesPO mapo = new MyArticlesPO(driver);
				
				mapo.navigateToMyArticles();
				
				boolean articlePresent = mapo.isArticlePresent(articleTitle);

				System.out.println(articleTitle);
				System.out.println(articlePresent);
				Assert.assertTrue(articlePresent);
				
	}
	
	
	
	
	
	//Here we use a simple DataProvider for a small amount of data we want to send
	@DataProvider
	public Object[][] getData()
	{
		
		HashMap<String, String> hmap01 = new HashMap<String, String>();
		hmap01.put("userEmailHM", "jovan.kovacevic@hotmail.com");
		hmap01.put("userPasswordHM", "glupavipassword");
		hmap01.put("userNameHM", "JovanK");
		
		HashMap<String, String> hmap02 = new HashMap<String, String>();
		hmap02.put("userEmailHM", "testuser@iptiq.com");
		hmap02.put("userPasswordHM", "test1234");
		hmap02.put("userNameHM", "testuser@iptiq.com");
		
		return new Object[][]  {{hmap01}, {hmap02}};
		//return new Object[][]  {{"jovan.kovacevic@hotmail.com", "glupavipassword", "JovanK"}, {"testuser@iptiq.com", "test1234", "testuser@iptiq.com"}};
	}

}
