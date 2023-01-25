package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonUtil;
import util.ElementUtils;

public class AccountPage 
{
	WebDriver driver;
	ElementUtils elementUtils;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement succesfullyLogin;
	
	public boolean verifySuccessfullyLogin()
	{
		return elementUtils.displayStatusOfElement(succesfullyLogin, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//return succesfullyLogin.isDisplayed();
	}

}
