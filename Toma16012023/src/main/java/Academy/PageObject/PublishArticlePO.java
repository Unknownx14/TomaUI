package Academy.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponent.AbstractComponent;

public class PublishArticlePO extends AbstractComponent {
	
	
	WebDriver driver;
	
	public PublishArticlePO(WebDriver driver)
	{
		super(driver); //This way we connect a child to a parent (LandingPagePO extends AbstractComponent)
		this.driver = driver; //The left driver is from this PO class, the right driver is from LoginTest1
		PageFactory.initElements(driver, this); //The method for the PageFactory to knows about the driver
	}
	
	
	//WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
		//boolean deleteArticleButton = driver.findElement(By.cssSelector(".btn-outline-danger")).isDisplayed();
		
		
		//PageFactory
			@FindBy(css="a[href*='#editor']")
			WebElement newPostButton;
			
			@FindBy(css="input[placeholder='Article Title']")
			WebElement articleTitle;
			
			@FindBy(css="input[placeholder*='about']")
			WebElement articleAbout;
			
			@FindBy(css="textarea[placeholder='Write your article (in markdown)']")
			WebElement articleText;
			
			@FindBy(css="input[placeholder='Enter tags']")
			WebElement articleTag;
			
			@FindBy(css=".btn-lg")
			WebElement publishArticleButton;
			
			@FindBy(css=".author")
			WebElement author;
			
			@FindBy(css=".btn-outline-danger")
			WebElement deleteArticleButton;
			
			
			
			//By
			By rowBy = By.cssSelector(".row");
			By commentBy = By.cssSelector(".comment-form");
			
			
			//Action Methods
			
			public void clickNewPostButton()
			{
				newPostButton.click();
				waitForElementToAppear(rowBy);
			}
			
			public void publishAsrticle(String title, String about, String text, String tag)
			{
				articleTitle.sendKeys(title);
				articleAbout.sendKeys(about);
				articleText.sendKeys(text);
				articleTag.sendKeys(tag);
				publishArticleButton.click();
				waitForElementToAppear(commentBy);
			}
			
			public String getAuthor()
			{
				String authorName = author.getText();
				return authorName;
			}
			
			public boolean deleteArticleIsDisplayed()
			{
				 return deleteArticleButton.isDisplayed();
			}

}
