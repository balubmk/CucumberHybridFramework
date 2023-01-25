package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader
{
	
	public Properties intializeProperties()
	{
		Properties prop=new Properties();
		File propfile=new File(System.getProperty("user.dir")+"src\\main\\java\\config\\config.properties");
		try
		{
		FileInputStream fis=new FileInputStream(propfile);
		prop.load(fis);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		return prop;
	}

}
