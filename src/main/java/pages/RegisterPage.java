package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonUtil;
import util.ElementUtils;

public class RegisterPage 
{
	WebDriver driver;
	ElementUtils elementutils;


	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);
	}

	@FindBy(id="input-firstname")
	private WebElement firstName;

	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	private WebElement lastName;

	@FindBy(id="input-email")
	private WebElement email;

	@FindBy(id="input-telephone")
	private WebElement telephone;

	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(id="input-confirm")
	private WebElement confirmpassword;

	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privacypolicy;

	@FindBy(xpath="//div[@class='form-group']/div/label[1]/input")
	private WebElement selectYesForNewsletter; 

	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continueButton;

	@FindBy(xpath="//*[@id=\"account-register\"]/div[1]")
	private WebElement duplicateemail;

	//warning webelements when we dont provide any details

	@FindBy(xpath="(//div[@class='text-danger'])[1]")
	WebElement FirstNamemustbebetween1and32characters;

	@FindBy(xpath="(//div[@class='text-danger'])[2]")
	WebElement LastNamemustbebetween1and32characters;

	@FindBy(xpath="(//div[@class='text-danger'])[3]")
	WebElement EMailAddressdoesnotappeartobevalid;

	@FindBy(xpath="(//div[@class='text-danger'])[4]")
	WebElement Telephonemustbebetween3and32characters;

	@FindBy(xpath="(//div[@class='text-danger'])[5]")
	WebElement Passwordmustbebetween4and20characters;


	public void enterFirstName(String firstNameText)
	{
		elementutils.typeTextIntoElement(firstName, firstNameText, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//firstName.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText)
	{
		elementutils.typeTextIntoElement(lastName, lastNameText, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//lastName.sendKeys(lastNameText);
	}
	public void enterEmail(String emailText)
	{
		elementutils.typeTextIntoElement(email, emailText, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//email.sendKeys(emailText);
	}
	public void entertTelephone(String telephoneText)
	{
		elementutils.typeTextIntoElement(telephone, telephoneText, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//telephone.sendKeys(telephoneText);
	}
	public void enterPassword(String passwordText)
	{
		elementutils.typeTextIntoElement(password, passwordText, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//password.sendKeys(passwordText);
	}
	public void enterconfirmPassword(String passwordText )
	{
		elementutils.typeTextIntoElement(confirmpassword, passwordText, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//confirmpassword.sendKeys(passwordText);
	}
	public void clickPrivacyPolicy()
	{
		elementutils.clickOnElement(privacypolicy, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//privacypolicy.click();
	}
	public void clickselectYesForNewsletter()
	{
		elementutils.clickOnElement(selectYesForNewsletter, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//selectYesForNewsletter.click();
	}
	public RegAccountSuccessPage clickonContinueButton()
	{
		elementutils.clickOnElement(continueButton, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//continueButton.click();
		return new RegAccountSuccessPage(driver);
	}
	public boolean warningemailalreadyexisted()
	{
		return elementutils.displayStatusOfElement(duplicateemail, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//return duplicateemail.isDisplayed();
	}
	//warning messages without providing any details into fields
	public boolean WarningforFirstName()
	{
		return elementutils.displayStatusOfElement(FirstNamemustbebetween1and32characters, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//return FirstNamemustbebetween1and32characters.isDisplayed();
	}
	public boolean WarningforLastName()
	{
		return elementutils.displayStatusOfElement(LastNamemustbebetween1and32characters, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//return LastNamemustbebetween1and32characters.isDisplayed();
	}
	public boolean WarningforEmail()
	{
		return elementutils.displayStatusOfElement(EMailAddressdoesnotappeartobevalid, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//return EMailAddressdoesnotappeartobevalid.isDisplayed();
	}
	public boolean WarningforTelephone()
	{
		return elementutils.displayStatusOfElement(Telephonemustbebetween3and32characters, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//return Telephonemustbebetween3and32characters.isDisplayed();
	}
	public boolean Warningforpassword()
	{
		return elementutils.displayStatusOfElement(Passwordmustbebetween4and20characters, CommonUtil.EXPLICIT_WAIT_BASIC_TIME);
		//return Passwordmustbebetween4and20characters.isDisplayed();
		
	}

}
