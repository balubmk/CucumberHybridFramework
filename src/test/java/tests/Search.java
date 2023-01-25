package tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchPage;

public class Search 
{
	public WebDriver driver;
	HomePage homepage;
	SearchPage searchpage;

	@Given("user opens the application")
	public void user_opens_the_application() 
	{
		driver=DriverFactory.getDriver();
	}

	@When("^user enters valid product into search field (.+)$")
	public void user_enters_valid_product_into_search_field(String productname) 
	{
		homepage=new HomePage(driver);
		homepage.productFound(productname); 
	}

	@And("user clicks on search button")
	public void user_clicks_on_search_button() 
	{
		searchpage=homepage.clickonsearchbutton();
	}

	@Then("valid product should be displayed in search results")
	public void valid_product_should_be_displayed_in_search_results() 
	{
		Assert.assertTrue(searchpage.hpproductstatus());
	}

	@When("^user enters Invalid product into search field (.+)$")
	public void user_enters_invalid_product_into_search_field(String productname) {
		homepage=new HomePage(driver);
		homepage.productNotFound(productname);
	}

	@Then("proper text informing the user about no product matching should be displayed")
	public void proper_text_informing_the_user_about_no_product_matching_should_be_displayed() 
	{
		Assert.assertTrue(searchpage.hondaproductstatus());
	}

	@When("user dont enters any product into search field")
	public void user_dont_enters_any_product_into_search_field() 
	{
		homepage=new HomePage(driver);
	}

}
