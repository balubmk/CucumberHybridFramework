package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonUtil;
import util.ElementUtils;

public class HomePage 
{
	WebDriver driver;
	ElementUtils elementUtils;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	private WebElement myAccount;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	private WebElement logIn;
	
	@FindBy(linkText="Register")
	private WebElement register;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement search;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement clickonsearchbutton;
	

	public void clickonMyAccount()
	{
		elementUtils.clickOnElement(myAccount, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//myAccount.click();
	}
	
	public LoginPage clickonLogin()
	{
		elementUtils.clickOnElement(logIn, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//logIn.click();
		return new LoginPage(driver);
	}
	public RegisterPage clickonRegister()
	{
		elementUtils.clickOnElement(register, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//register.click();
		return new RegisterPage(driver);
	}
	
	public void productFound(String productName)
	{
		elementUtils.typeTextIntoElement(search, productName, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//search.sendKeys(productName);
	}
	public void productNotFound(String productName)
	{
		elementUtils.typeTextIntoElement(search, productName, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//search.sendKeys(productName);
	}
	public SearchPage clickonsearchbutton()
	{
		elementUtils.clickOnElement(clickonsearchbutton, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//clickonsearchbutton.click();
		return new SearchPage(driver);
	}
}
