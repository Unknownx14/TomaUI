package Academy.StepDefinitions;

import org.testng.Assert;

import Academy.PageObject.LandingPagePO;
import Academy.PageObject.PublishArticlePO;
import Academy.PageObject.SettingsPagePO;
import Academy.TestComponents.BaseTest02;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BaseTest02 {

	public LandingPagePO lppo;
	public PublishArticlePO papo;
	public String articleTitle;
	public SettingsPagePO sppo;
	
	
	@Given("^A user has landed on the Conduit landing page$")
    public void a_user_has_landed_on_the_conduit_landing_page() throws Throwable {
        
		 lppo = launchApplication();
    }
	
	@Given("^A user has logged in with a username (.+) and a password (.+)$")
    public void a_user_has_logged_in_with_a_username_and_a_password(String email, String password) throws Throwable {
        
		lppo.LoginToApplication(email, password);
    }
	
	@And("^Verify that the (.+) is correct for the logged-in user$")
    public void verify_that_the_is_correct_for_the_loggedin_user(String username) throws Throwable {
        
		String userNameInApplication = lppo.getUserName();
		System.out.println(userNameInApplication);
		
		Assert.assertEquals(userNameInApplication, username);
    }
	
	@When("^A user populates all the fields (.+), (.+), (.+) and (.+) and publishes the article$")
    public void a_user_populates_all_the_fields_and_and_publishes_the_article(String title, String about, String text, String tag) throws Throwable {
        
		 papo= new PublishArticlePO(driver);
		
		papo.clickNewPostButton();
		 articleTitle = title+System.currentTimeMillis();

		papo.publishAsrticle(articleTitle, about, text, tag);
    }
	
	@And("^Verify that the article is published for this user (.+)$")
    public void verify_that_the_article_is_published_for_this_user(String username) throws Throwable {
        
		String author =  papo.getAuthor();
		boolean deleteArticleButton = papo.deleteArticleIsDisplayed();

		Assert.assertEquals(author, username);
		Assert.assertTrue(deleteArticleButton);
    }
	
	@Then("^Log out from the application$")
    public void log_out_from_the_application() throws Throwable {
        
		 sppo = new SettingsPagePO(driver);
		
		sppo.clickSettingsButton();
		
		sppo.clickLogoutButton();
		
		boolean signinButton = sppo.signInButtonIsDisplayed();
		Assert.assertTrue(signinButton);
    }
	
	@And("^A browser is closed$")
    public void a_browser_is_closed() throws Throwable {
        
		closeBrowser();
    }
	
	@Given("^A user has tried to login with a wrong Email (.+) and/or a wrong password (.+)$")
    public void a_user_has_tried_to_login_with_a_wrong_email_andor_a_wrong_password(String wrongemail, String validpassword) throws Throwable {
        
		lppo.LoginToApplicationWrongCredentials(wrongemail, validpassword);
    }
	
	@Then("^Verify that the user has not logged in successfully and the message \"([^\"]*)\" is displayed$")
    public void verify_that_the_user_has_not_logged_in_successfully_and_the_message_something_is_displayed(String expectedErrorMessage) throws Throwable {
        
		String errorMessage = lppo.getErrorMessageText();
		System.out.println(errorMessage);
		Assert.assertEquals(errorMessage, expectedErrorMessage);
    }
	
}
