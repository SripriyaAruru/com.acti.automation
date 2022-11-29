package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Class :DriverScript
 * Desciption:This class is responsible for loading the properties file and the application
 * Developed By : Sukumar (Like tester who writes this code for testing and runs)
 * Date: 11/26/2022
 * Reviewed By: Sripriya (Manager who reveiws it)
 */

public class DriverScript {

	public static WebDriver driver;
	static Properties prop;

	public DriverScript()

	{
		try {
			File file = new File("./atConfig/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}

		catch (Exception e)

		{
			e.printStackTrace();
			System.out.println("unable to load the properties file pls check: " + e.getMessage());
		}

	}

	public  void  initApplication()
	{
		 String browser = prop.getProperty("browser");
		 if (browser.equalsIgnoreCase("Chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", "./atbrowser/chromedriver.exe");
			 driver = new ChromeDriver();
		 }
		 
		 else if (browser.equalsIgnoreCase("Firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", "./atbrowser/geckodriver.exe");
			 driver = new FirefoxDriver();
		 }
		 else if (browser.equalsIgnoreCase("Edge"))
		 {
			 System.setProperty("webdriver.edge.driver", "./atbrowser/msedgedriver.exe");
			 driver = new EdgeDriver();
		 }
		 else
		 {
			 System.err.println("The browser parameter in not supported pls check config file");
		 }
		 
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 geturl();
		
	}
	
	public static void geturl()
	{
		 String url = prop.getProperty("url");
		 driver.get(url);
	}
	public void quitdriver()
	{
		driver.close();
	}

	
	}


