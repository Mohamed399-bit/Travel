package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.HotelDetailsPage;
import pages.LoginPage;

public class HotelsTest extends TestBase{
	
	
	LoginPage loginObject;
	HomePage homeObject;
	HotelDetailsPage detailsObject;
	
	@Test
	public void selectLowPrice() {
		
		loginObject = new LoginPage(driver);
		/*loginObject.login("test3@test.com", "S@l@m@123");
		
		Assert.assertTrue(!loginObject.returnUserName().getText().substring(3).isEmpty());
		System.out.println("User name  is : " + loginObject.returnUserName().getText().substring(3));
		*/
		loginObject.clickOnHomeLink();
		
		homeObject = new HomePage(driver);
		homeObject.selectLowPriceHotel();
		
		detailsObject = new HotelDetailsPage(driver);
		
		Assert.assertTrue(detailsObject.hotelName.isDisplayed());
		Assert.assertTrue(detailsObject.hotelPrice.isDisplayed());
		System.out.println("Hotel low price name is : " + detailsObject.hotelName.getText() +
				"  And Price is : " + detailsObject.hotelPrice.getText() );
		
	
	}

}
