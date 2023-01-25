package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonUtil;
import util.ElementUtils;

public class RegAccountSuccessPage 
{
	WebDriver driver;
	ElementUtils elementUtils;
	
	public RegAccountSuccessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//div[@class='col-sm-9']/h1")
	private WebElement AccountCreated;
	
	public boolean RegisterAccountSuccessfullyCreated()
	{
		return elementUtils.displayStatusOfElement(AccountCreated, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//return AccountCreated.isDisplayed();
	}

}
