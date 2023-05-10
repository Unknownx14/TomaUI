package Academy.Toma16012023;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PublishArticleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup(); // WebDriver manager for invoking the chromedriver that is not on our local machine
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://react-redux.realworld.io/#/login");
		
		//01. Login to the application
		
		String userEmail = "jovan.kovacevic@hotmail.com";
		String userPassword = "glupavipassword";
		String userName = "JovanK";
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys(userEmail);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(userPassword);
		driver.findElement(By.cssSelector(".btn-lg")).click();
		
		//Explicit wait - define the object of the class
				WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
				w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='#@']")));
		
		String loggedInUserName = driver.findElement(By.cssSelector("a[href*='#@']")).getText();
		System.out.println(loggedInUserName);
		
		Assert.assertEquals(loggedInUserName, userName);
		
		//02. Create and publish an article
		
		driver.findElement(By.cssSelector("a[href*='#editor']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".row")));
		
		String articleTitle = "Title01"+System.currentTimeMillis();
		String articleAbout = "About01";
		String articleText = "Text01";
		String articleTag = "Tag01";
		
		driver.findElement(By.cssSelector("input[placeholder='Article Title']")).sendKeys(articleTitle);
		driver.findElement(By.cssSelector("input[placeholder*='about']")).sendKeys(articleAbout);
		driver.findElement(By.cssSelector("textarea[placeholder='Write your article (in markdown)']")).sendKeys(articleText);
		driver.findElement(By.cssSelector("input[placeholder='Enter tags']")).sendKeys(articleTag);
		driver.findElement(By.cssSelector(".btn-lg")).click();
		

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".comment-form")));
		String author =  driver.findElement(By.cssSelector(".author")).getText();
		boolean deleteArticleButton = driver.findElement(By.cssSelector(".btn-outline-danger")).isDisplayed();
		Assert.assertEquals(author, userName);
		Assert.assertTrue(deleteArticleButton);
		
	}

}
