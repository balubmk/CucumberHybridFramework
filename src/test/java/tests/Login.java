package tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import util.CommonUtil;

public class Login  
{
	public WebDriver driver;
	LoginPage loginpage;
	AccountPage accountpage;
	CommonUtil commonutil;

	@Given("User Navigate to Login Page")
	public void user_navigate_to_login_page() 
	{
		driver=DriverFactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickonMyAccount();
		loginpage=homepage.clickonLogin();
	}

	@When("^User enters valid Email Addess (.+)$")
	public void user_enters_valid_email_addess(String email) 
	{
		loginpage.validEmail(email);
	}

	@And("^Enters valid Password (.+)$")
	public void enters_valid_password(String password) 
	{
		loginpage.validPassword(password);	    
	}


	@And("clicks on Login button")
	public void clicks_on_login_button() 
	{
		accountpage=loginpage.clickonloginButton();
	}

	@Then("User should successfully Login")
	public void user_should_successfully_login() 
	{
		Assert.assertTrue(accountpage.verifySuccessfullyLogin());
	}

	@When("User enters Invalid Email Addess")
	public void user_enters_invalid_email_addess() 
	{
		commonutil=new CommonUtil();
		loginpage.validEmail(commonutil.getemailwithTimestamp());
	}

	@And("Enters Invalid Password {string}")
	public void enters_invalid_password(String InvalidPasswordText) 
	{
		loginpage.validPassword(InvalidPasswordText);
	}
	@When("user dont provide any details")
	public void user_dont_provide_any_details()
	{
		//intentionally kept blank
	}

	@Then("User get a warning message")
	public void user_get_a_warning_message() 
	{
		Assert.assertTrue(loginpage.usergetWarnmessage());
	}

}
