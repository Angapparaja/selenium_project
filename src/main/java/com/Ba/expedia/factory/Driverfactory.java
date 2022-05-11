package com.Ba.expedia.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {

	public WebDriver driver;
//	public static ThreadLocal<WebDriver> tlDriver =new ThreadLocal<WebDriver>(); 
	
	/**
	 * this method used to initialize the driver
	 * @param browserName
	 * @return
	 */
	
	public WebDriver initDriver(Properties prop) { //initialize the browser  and property reference prop aa ean use pannurom na only browser mattum access pannurom
		
		String browserName = prop.getProperty("browser"); //hardcode panna value aa remove pannitu config properties aa insert pannurom
		System.out.println("browser name is :" + browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
			driver =new ChromeDriver();
//			tlDriver.set(new ChromeDriver());  //thread localdriver aa initilize pannurom
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
//			tlDriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("please pass the right browser name"+browserName);
		}
		
		//once initialize browser after performs
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url")); //url la hardcode pannirukom
		
		return driver;  //browser launch panna after driver ku return pannum ,webdriver aa return pannurom so public Webdriver nu mention pannnurom
	}
//	public void getDriver() {
//		return tlDriver.get();
//	}
	
	/**
	 * This method is used to initialize the properties on the basis of given env name
	 * @return
	 */
	//initialize the properties it is intract with config.property file
	public Properties intiProperties() {  
		Properties prop =null; //intially is equal to null 
		
		try {
			FileInputStream ip =new FileInputStream("./src/test/resources/config/config.properties");
			prop =new Properties(); //it is collection class this property class help to the load the config.properties
			prop.load(ip); //fileinputstream reference ip was pass it  and this prop has get property and setproperty
		} 
		
		
		catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} //its make connection with file ,filehandling use it
 catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
}
