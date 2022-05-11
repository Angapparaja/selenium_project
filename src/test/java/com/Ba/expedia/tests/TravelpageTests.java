package com.Ba.expedia.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ba.expedia.Bookingpage;
import com.Ba.expedia.Utils.Constants;
import com.Ba.expedia.Utils.ErrorsUtil;

//test class la thaa assertion aa use pannum
public class TravelpageTests extends BaseTest {  
	
	@Test(priority = 1)
	public void TravelpageTitleTests() { //never use driver code in the testng and testclass 
		                                     //baseTest already use the drivertest so dont use 
		                                     //thetitle method returns inside the travel page class call the method getTitle is object login page and
		
		String travelTitle = Travelpage.getTravelpageTitle(); // travelpage method is already created the Basetest class so basetest la  Travelpage aa inherits pannurom
		                                                      //base test la erukura travelpage la nullpointer exception varathu because travelpage la driver object class is created  so it is not point to null   
	    System.out.println("the travelpageTile"+travelTitle);	
	    
	    //using assertion
	    Assert.assertEquals(travelTitle,Constants.Travel_Page_Title,ErrorsUtil.Error_Title_Message);  //Constants class la travel page title crt aa nu mention pannurom and also error
	    
	    //login page class aa enga again again use panna theva ella one time base class aa mention panna poothum
	}
	
	//priority is a alphabatical order
	@Test(priority = 1)
	public void TravlePageTest() throws Exception {
		
		Bookingpage book=Travelpage.doTravel(prop.getProperty("location").trim());
		
		
	 //hardcode value ku assertion use pannna koodathu 
		                                                   //basetest la eruthu property aa inherits pannurom so basetest la thaa property reference eruku athu config file trigger pannuthu
	}
	
	
	
	@Test(priority = 2)
	public void SelectFirstDate() throws Exception {
		Bookingpage book=Travelpage.doTravelDate();
	
		
	}
	

	
	@Test(priority = 3)
	public void selectTraveller() throws Exception  {
		Bookingpage book=Travelpage.Travellers();
		
	}
	

	
	@Test(priority = 4)
	public void searchbtn() {
		String search=Travelpage.Searchhotel();
		System.out.println("the button name was :"+search);
		Assert.assertEquals(search,Constants.Search_btn,ErrorsUtil.Error_Title_Message);
	}
	
	@Test(priority = 5)
	public void searchClick() throws Exception {
		Bookingpage book=Travelpage.SearchBtn();//this searchbtn return the Bookingpage class and store inside the bookingpage class references
	// so book reference point out Bookingpage class object
		
//		Assert.assertTrue(book.ischeckAmount());
		
	
	}	

}
