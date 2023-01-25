package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.*;
import util.ConfigReader;

public class MyHooks 
{
	WebDriver driver;
	@Before
	public void setup()
	{
		//Properties prop = new ConfigReader().intializeProperties();
		driver=DriverFactory.intialisebrowser("chrome");
		driver.get("http://www.tutorialsninja.com/demo/");
	}
	
	@After
	public void teardown(Scenario scenario)
	{
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		if(scenario.isFailed())
		{
			byte[] srcScreenshots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshots, "image/png", scenarioName);
		}
		driver.quit();
	}
}
