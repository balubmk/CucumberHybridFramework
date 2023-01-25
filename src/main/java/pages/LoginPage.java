package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonUtil;
import util.ElementUtils;

public class LoginPage 
{
	WebDriver driver;
	ElementUtils elementutils;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"account-login\"]/div[1]")
	private WebElement warningmessage;
	
	public void validEmail(String emailText)
	{
		elementutils.typeTextIntoElement(email, emailText, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//email.sendKeys(emailText); //instead this line above line is advanced
	}
	
	public void validPassword(String passwordText)
	{
		elementutils.typeTextIntoElement(password, passwordText, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//password.sendKeys(passwordText);
	}
	
	public AccountPage clickonloginButton()
	{
		elementutils.clickOnElement(loginButton, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//loginButton.click();
		return new AccountPage(driver);
	}
	
	public boolean usergetWarnmessage()
	{
		return elementutils.displayStatusOfElement(warningmessage, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//return warningmessage.isDisplayed();
		
	}

}
