package com.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase 
{
	public static Properties prop;
	public static FileInputStream fis;
	public static WebDriver driver;
	public static WebDriverWait wait;

	public TestBase() 
	{
		prop= new Properties();
		try {
			fis = new FileInputStream("C:\\workspace\\E-commerce\\src\\main\\java\\utility\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialisation()
	{
		String browserName = prop.getProperty("Browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\workspace\\E-commerce\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
		System.setProperty("webdriver.gecko.driver", "C:\\workspace\\E-commerce\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));		
	}
}
