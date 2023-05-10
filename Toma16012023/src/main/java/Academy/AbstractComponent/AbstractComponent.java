package Academy.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void waitForElementToAppear(By findby)
	{
		//Explicit wait - define the object of the class
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	
	public void scrollIntoView(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
}
