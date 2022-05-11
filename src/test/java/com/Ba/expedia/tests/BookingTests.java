package com.Ba.expedia.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Ba.expedia.Bookingpage;
import com.Ba.expedia.Utils.Constants;
import com.Ba.expedia.Utils.ErrorsUtil;

public class BookingTests extends BaseTest{

	@BeforeClass
	public void bookingPageSetup() throws Exception {  //only precondition is used for booking page
		book = Travelpage.doTravel(prop.getProperty("location"));
		book= Travelpage.doTravelDate();
		book= Travelpage.Travellers();
		book= Travelpage.SearchBtn();
	}
	
	@Test(priority=1)
	public void selectAmount() throws Exception {
	book.checkAmount();
	}
	
	@Test(priority=2)
	public void ischeckaAmountExist() {
		Assert.assertTrue(book.ischeckAmount());
	}
	@Test(priority=3)
	public void ischeckaRatingExist() {
		Assert.assertTrue(book.ischeckRating());
	}
	@Test(priority=4)
	public void selectGuestRating() throws Exception {
		book.Ratingreview();
	}
	@Test(priority=5)
	public void isCheckLunchincluded() {
		Assert.assertTrue(book.isCheckLunchincluded());
	}
	@Test(priority=6)
	public void selectLunch() throws Exception{
		book.selectLunch();
	}
	@Test(priority=7)
	public void isCheckDinnerincluded() {
		Assert.assertTrue(book.isCheckDinnerincluded());
	}
	@Test(priority=8)
	public void selectDinner() throws Exception{
		book.selectDinner();
	}
	
	@Test(priority=9)
	public void selectDropdown() throws Exception{
		book.selectdropdownList();
	
	}
	
	@Test(priority=10)
	public void selectHotelList() throws Exception {
		book.selectCheapestHotelList();
	

	}
	@Test(priority=11)
	public void cheapesthotels() throws Exception {
		String value1=book.CheapestHotel();
		  System.out.println("-------------------------------------");
		   System.out.println("The cheapest hotel name is : "+ value1);
		   System.out.println("-------------------------------------");
		   Assert.assertEquals(value1,Constants.Cheapest_Hotel_Name,ErrorsUtil.Error_CheapestHotel_Message);
		
	}
	@Test(priority=12)
	public void clickCheapestHotel() throws Exception{
		resultpage=book.clickCheapesthotel();
//		resultpage.Reserveroom();
		resultpage.Reserve();
		resultpage.Pay();	
		String paymentPageTitle = resultpage.getPaymentPageTitle(); 
		Assert.assertEquals(paymentPageTitle, Constants.Payment_page_Title,ErrorsUtil.Error_Payment_Message_Title);
	
	}
	
	
	
}
