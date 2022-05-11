package com.Ba.expedia.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Ba.expedia.Bookingpage;
import com.Ba.expedia.ExpediaTravelPage;
import com.Ba.expedia.Resultpage;
import com.Ba.expedia.factory.Driverfactory;
//base test is parent of all test classes
public class BaseTest { //basetest are linked with driverfactory
WebDriver driver;
	Driverfactory df; //driverfactory references 
	//driverfactory is different Util class and Basetest is a different test class 
	
	Properties prop;
	ExpediaTravelPage Travelpage; //its page layer references 
	Bookingpage book;
	Resultpage resultpage;

	@BeforeTest
	public void setUp() { //setUp will maintain not all object its maintain the references
		df = new Driverfactory();
		prop = df.intiProperties(); //this return properties class ref
		
		driver = df.initDriver(prop); //this line go to the driverfactory and initdriver are initialize the driver
		
		Travelpage = new ExpediaTravelPage(driver); //Expediatravelpage is not defalut construtor  because already one webdriver driver Expediatravelpage la aa use pannurom
		                                           //next initDriver la initialize panna driver aa travelpage la pass pannurom
		
	}
	@AfterTest
	public void tearDown() {
		//driver.quit(); //already initialize panna driver aa quit pannurom
	}
	
}