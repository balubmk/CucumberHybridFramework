package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonUtil;
import util.ElementUtils;

public class SearchPage 
{
	WebDriver driver;
	ElementUtils elementUtils;
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement Hp;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement notfoundproductHonda;

	public boolean hpproductstatus()
	{
		return elementUtils.displayStatusOfElement(Hp, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//return Hp.isDisplayed();

	}
	public boolean hondaproductstatus()
	{
		return elementUtils.displayStatusOfElement(notfoundproductHonda, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//return notfoundproductHonda.isDisplayed();
	}
}
