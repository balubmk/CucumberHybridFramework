package tests;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.RegAccountSuccessPage;
import pages.RegisterPage;
import util.CommonUtil;

public class Registration  
{
	public WebDriver driver;
	RegisterPage registerpage;
	RegAccountSuccessPage regaccountsuccesspage;
	CommonUtil commonutil;

	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() 
	{
		driver=DriverFactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickonMyAccount();
		registerpage=homepage.clickonRegister();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) 
	{
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		 commonutil=new CommonUtil();
		registerpage.enterEmail(commonutil.getemailwithTimestamp());
		registerpage.entertTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterconfirmPassword(dataMap.get("password"));
	}

	@And("User selects privacy policy Filed")
	public void user_selects_privacy_policy_filed() 
	{
	   registerpage.clickPrivacyPolicy();
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() 
	{
	regaccountsuccesspage=registerpage.clickonContinueButton();
	}

	@Then("User Account should get Successfully created")
	public void user_account_should_get_successfully_created() 
	{	
		Assert.assertTrue(regaccountsuccesspage.RegisterAccountSuccessfullyCreated());
		//note;VERY IMPORTant Import Assert from Junit.Assert NOT from Framework.assert
	}

	@And("Selects Yes for Newsletter")
	public void selects_yes_for_newsletter() 
	{
	registerpage.clickselectYesForNewsletter();
	}
	
	@When("User enters the details into below fields duplicate Field")
	public void User_enters_the_details_into_below_fields_duplicate_Field(DataTable dataTable)
	{
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enterEmail(dataMap.get("email"));
		registerpage.entertTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterconfirmPassword(dataMap.get("password"));
	}

	@When("User dont enter details any fields")
	public void user_dont_enter_details_any_fields() 
	{
		//intentionally kept blank
	}

	@Then("Warning message Should be displayed for all fields")
	public void warning_message_should_be_displayed_for_all_fields() 
	{
		Assert.assertTrue(registerpage.WarningforFirstName());
		Assert.assertTrue(registerpage.WarningforLastName());
		Assert.assertTrue(registerpage.WarningforEmail());
		Assert.assertTrue(registerpage.WarningforTelephone());
		Assert.assertTrue(registerpage.Warningforpassword());

	}

	@Then("Warning message informating the user about duplicate email should be dislpayed")
	public void warning_message_informating_the_user_about_duplicate_email_should_be_dislpayed() 
	{
		Assert.assertTrue(registerpage.warningemailalreadyexisted());
	}
	
	
}
