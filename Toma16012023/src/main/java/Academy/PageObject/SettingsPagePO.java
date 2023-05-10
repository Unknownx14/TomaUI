package Academy.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponent.AbstractComponent;

public class SettingsPagePO extends AbstractComponent {
	
	
	WebDriver driver;
	
	public SettingsPagePO(WebDriver driver)
	{
		super(driver); //This way we connect a child to a parent (LandingPagePO extends AbstractComponent)
		this.driver = driver; //The left driver is from this PO class, the right driver is from LoginTest1
		PageFactory.initElements(driver, this); //The method for the PageFactory to knows about the driver
	}
	
	
	//WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
		//boolean signinButton = driver.findElement(By.cssSelector("a[href='#login']")).isDisplayed();
		
		
		//PageFactory
			@FindBy(css="a[href*='#settings']")
			WebElement settingsButton;
			
			@FindBy(css="input[placeholder='Article Title']")
			WebElement articleTitle;
			
			@FindBy(css=".btn-outline-danger")
			WebElement logoutButton;
			
			@FindBy(css="a[href='#login']")
			WebElement signinButton;
			
			
			
			
			
			//By
			By updateSettingsBy = By.cssSelector(".btn-primary");
			By signupButtonBy = By.cssSelector("a[href='#register']");
			
			
			
			//Action Methods
			
			public void clickSettingsButton()
			{
				settingsButton.click();
				waitForElementToAppear(updateSettingsBy);
			}
			
			public void clickLogoutButton()
			{
				scrollIntoView(logoutButton);
				logoutButton.click();
				waitForElementToAppear(signupButtonBy);
			}
			
			public boolean signInButtonIsDisplayed()
			{
				return signinButton.isDisplayed();
			}

}
