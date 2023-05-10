package Academy.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponent.AbstractComponent;

public class MyArticlesPO extends AbstractComponent {
	
	
	WebDriver driver;
	
	public MyArticlesPO(WebDriver driver)
	{
		super(driver); //This way we connect a child to a parent (LandingPagePO extends AbstractComponent)
		this.driver = driver; //The left driver is from this PO class, the right driver is from LoginTest1
		PageFactory.initElements(driver, this); //The method for the PageFactory to knows about the driver
	}
	
	
	//WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
		//List<WebElement> allArticles = driver.findElements(By.cssSelector(".article-preview"));
		
		
		//PageFactory
			@FindBy(css="a[href*='#@']")
			WebElement usernameButton;
			
			@FindBy(css=".article-preview")
			List<WebElement> articleTitles;
			
			
			
			
			
			
			
			//By
			By userImgBy = By.cssSelector(".user-img");
			
			
			
			
			//Action Methods
			
			public void navigateToMyArticles()
			{
				usernameButton.click();
				waitForElementToAppear(userImgBy);
			}
			
			public List<WebElement> getAllArticles()
			{
				return articleTitles;
			}
			
			public boolean isArticlePresent(String articleTitle)
			{
				boolean articlePresent = getAllArticles().stream().anyMatch(oneArticle -> oneArticle.findElement(By.cssSelector("h1")).getText().equals(articleTitle));
				return articlePresent;
			}
			
			

}
