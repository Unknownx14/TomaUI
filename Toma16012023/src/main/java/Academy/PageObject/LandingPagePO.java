package Academy.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Academy.AbstractComponent.AbstractComponent;

public class LandingPagePO extends AbstractComponent {
	
	
	WebDriver driver;
	
	public LandingPagePO(WebDriver driver)
	{
		super(driver); //This way we connect a child to a parent (LandingPagePO extends AbstractComponent)
		this.driver = driver; //The left driver is from this PO class, the right driver is from LoginTest1
		PageFactory.initElements(driver, this); //The method for the PageFactory to knows about the driver
	}
	
	
	//WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
		//String errorMessage = driver.findElement(By.cssSelector("ul[class='error-messages'] li")).getText();
		
		
		//PageFactory
			@FindBy(css="input[placeholder='Email']")
			WebElement userEmail;
			
			@FindBy(css="input[placeholder='Password']")
			WebElement userPassword;
			
			@FindBy(css=".btn-lg")
			WebElement signInButton;
			
			@FindBy(css="a[href*='#@']")
			WebElement loggedInUserName;
			
			@FindBy(css="ul[class='error-messages'] li")
			WebElement errorMessage;
			
			
			//By
			By userPicBy = By.cssSelector("a[href*='#@']");
			
			
			//Action Methods
			
			public void LoginToApplication(String email, String password)
			{
				userEmail.sendKeys(email);
				userPassword.sendKeys(password);
				signInButton.click();
				waitForElementToAppear(userPicBy);
				
			}
			
			public String getUserName()
			{
				String userNameInApplication = loggedInUserName.getText();
				return userNameInApplication;
			}
			
			public void goTo()
			{
				driver.get("https://react-redux.realworld.io/#/login");
			}
			
			public void LoginToApplicationWrongCredentials(String email, String password)
			{
				userEmail.sendKeys(email);
				userPassword.sendKeys(password);
				signInButton.click();
				
			}
			
			public String getErrorMessageText()
			{
				String errorMessageText = errorMessage.getText();
				return errorMessageText;
			}

}
