package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	
	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is "+ browserName) ; 
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver() ; 
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver() ; 
		}else if (browserName.equalsIgnoreCase("safari")) {
		driver = new SafariDriver() ; 
		} else {
			System.out.println("Please pass the right Browser name "+ browserName) ; 

		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(prop.getProperty("url").trim()) ; 
		return driver ;
	}
	
	public Properties init_prop() {
		Properties prop = new Properties() ; 
		FileInputStream ip;
		try {
			ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
}
