package com.Ba.expedia;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Ba.expedia.Utils.Constants;
import com.Ba.expedia.Utils.ElementUtil;

public class ExpediaTravelPage {
	
	private WebDriver driver; //this driver only use for ExpediaTravelPage class
	//private By locator
	private ElementUtil elementUtil; //elementUtil class reference write pannurom
	
	private By  enterlocation = By.xpath("//button[@type='button'][@aria-label='Going to']");
	private By  enterPlace =By.id("location-field-destination");
	private By  selectDate =By.xpath("//*[@id=\"d1-btn\"]");
	private By selectStartdate =By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[1]/div[2]/div/div/div[1]");
	private By selectonedate=By.xpath("//h2[text()='April 2022']//following::table[1]//following::button[@aria-label='15 Apr 2022']");
	private By selectEndDate =By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[1]/div[2]/div/div/div[2]/div/div");
	private By selectsecondDate =By.xpath("//h2[text()='April 2022']//following::table[1]//following::button[@aria-label='19 Apr 2022']");
	
	String date="12 Apr 2022";
	String monthName ="April 2022";
	String tableMonth ="1";
	private By selectFirstdate =By.xpath("//h2[text()='\"+monthName+\"']//following::table['\"+tableMonth+\"']//following::button[@aria-label='\"+date+\"']");
	
	String date2="25 Apr 2022";
	String monthName2 ="April 2022";
	String tableMonth2 ="1";
	private By enterLastdate =By.xpath("//h2[text()='\"+monthName2+\"']//following::table['\"+tableMonth2+\"']//following::button[@aria-label='\"+date2+\"']");
	
	private By selectEnddate = By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[1]/div[2]/div/div/div[2]/div/div");
	private By selectDonebtn =By.xpath("//button[@type='button'][contains(text(),'Done')]");
	
	
	//travellers
	private By selectTraveller =By.xpath("//button[text()='1 room, 2 travellers']");
	private By incrementperson =By.xpath("//*[@class=\"uitk-cell all-x-padding-one all-t-padding-half all-b-padding-twelve uitk-scroll-vertical\"]//div//div[3]//div//button[2]");
	private By dropdownage =By.id("child-age-input-0-0");
	private By doneBtn =By.xpath("//button[@data-testid=\"guests-done-button\"][text()='Done']");
	private By searchBtn=By.xpath("//button[@data-testid='submit-button'][text()='Search']");
	private By monthview =By.xpath("//div/h2[1]");
	private By forwardBtn =By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[1]/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/button[2]");
	
	
	//constructor
	public ExpediaTravelPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);//same driver will be pass
	}
	
	//page actions  ---page action always a public and it will define the behaviour of applications and stricly no assertions
	public String getTravelpageTitle() {
		return elementUtil.waitForTitleIs(Constants.Travel_Page_Title, 5);
	}
	
	public Bookingpage doTravel(String place)  {
		elementUtil.doClick(enterlocation);
		elementUtil.doSendkeys(enterPlace, place);
		elementUtil.doSendkey(enterPlace);
		return new Bookingpage(driver); 
	}
	
	public Bookingpage doTravelDate() throws Exception {
		elementUtil.doClick(selectDate);
		Thread.sleep(1000);
		elementUtil.doClick(selectonedate);
		elementUtil.doClick(selectDonebtn);
		Thread.sleep(1000);
		elementUtil.doClick(selectEndDate);
		Thread.sleep(1000);
		elementUtil.doClick(selectsecondDate);
		elementUtil.doClick(selectDonebtn);	
		return new Bookingpage(driver);
	}
//	
//	public Bookingpage doTravelLastdate() throws Exception {
//		
//		
//	}
	
	public Bookingpage Travellers() {
		elementUtil.doClick(selectTraveller);
		elementUtil.doClick(incrementperson);
		elementUtil.doClick(dropdownage);
		Select child =new Select(elementUtil.getElement(dropdownage));
		child.selectByIndex(6);
		elementUtil.doClick(doneBtn);
		
		return new Bookingpage(driver); 
	}
	
//	public Bookingpage selectChild() {
//		
//		
//	}
//	
//	public Bookingpage childAge() {
//	
//		return new Bookingpage(driver);
//	}
	
	public String Searchhotel() {
		WebElement l=elementUtil.getElement(searchBtn);
		String value1=l.getText();
		return value1;
	}
	
	public Bookingpage SearchBtn()  { //this method is return the Bookingpage class and it has created builder pattern also and in java class you can return the object of class also 
		
		try {
			elementUtil.doClick(searchBtn);
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return new Bookingpage(driver); // it dont have any default constructor  because account page class object the constructor will be call aagum but  have to give me the driver 
		//create the pageclass object and driver is already available in this class
	    //this method return the accountpage class object
		 //click panna after new landing page poogum
		//it is blank object and reference eathuvum ella
		//this object refered by the testcase la Bookingpage book nu erukum

	}
	
	
}
