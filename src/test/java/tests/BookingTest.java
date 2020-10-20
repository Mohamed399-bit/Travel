package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BookingPage;
import pages.ConfirmBookPage;
import pages.FlightPage;
import pages.HomePage;
import pages.LoginPage;

public class BookingTest extends TestBase{
	
	LoginPage loginObject;
	HomePage homeObject;
	FlightPage flightObject;
	BookingPage bookingObject;
	ConfirmBookPage confirmBookObject;
	
	@Test
	public void bookFlight() throws InterruptedException {
		
		loginObject = new LoginPage(driver);
		loginObject.login("test3@test.com", "S@l@m@123");
		
		Assert.assertTrue(!loginObject.returnUserName().getText().substring(3).isEmpty());
		System.out.println("User name  is : " + loginObject.returnUserName().getText().substring(3));
		
		loginObject.clickOnHomeLink();
		
		homeObject = new HomePage(driver);
		homeObject.clickOnTabNameWith("Flights");
		
		flightObject = new FlightPage(driver);
		flightObject.enterFromAndToLocation("Zurich", "Paris");
		flightObject.clickonFlightData("22");
		flightObject.clickOnSearchButton();
		
		bookingObject = new BookingPage(driver);
		bookingObject.selectTrip();
		
		confirmBookObject = new ConfirmBookPage(driver);
		Assert.assertTrue(confirmBookObject.formToDiv.isDisplayed());
		System.out.println("From and to location : " + confirmBookObject.formToDiv.getText());
		Assert.assertTrue(confirmBookObject.priceTxt().isDisplayed());
		System.out.println("price of trip : " + confirmBookObject.priceTxt().getText());
		
		confirmBookObject.clickOnConfirmBook();
		
		Thread.sleep(10000);
	}

}
