package com.uhc.utulities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {


public static  WebDriver getDriver(String browserType){
	WebDriver driver=null;
	switch (browserType){
		case "chrome":
			System.setProperty("webdriver.chrome.driver", 
					"/Users/musaates/Desktop/Documents/Libraries/drivers/chromedriver");
	driver=new ChromeDriver();
	break;
	
		case "firefox":
			System.setProperty("webdriver.gecko.driver", 	
					"/Users/musaates/Documents/Libraries/drivers/chromedriver");
			driver=new FirefoxDriver();
			break;
			
		case "ie":
			System.setProperty("webdriver.ie.driver", 	
					"/the/location/of/ie/driver");	
			driver = new InternetExplorerDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		}
		return driver;
	}


}
