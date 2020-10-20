package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelDetailsPage extends PageBase{

	public HotelDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[@id=\"detail-content-sticky-nav-00\"]")
	public WebElement hotelName;
	
	@FindBy(xpath ="/html/body/div[2]/div[1]/div[1]/div/div[1]/div/div/div[2]/div/span/span")
	public WebElement hotelPrice;

}
