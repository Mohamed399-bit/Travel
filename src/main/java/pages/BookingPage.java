package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage extends PageBase{

	public BookingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css ="ul.catalog-panel.list_data")
	WebElement ulList;
	
	@FindBy(xpath = "//*[@id=\"LIST\"]/li[1]/div/div[1]/div[2]/form/div[2]/div/button")
	WebElement bookBtn;
	
	List<WebElement> lis = ulList.findElements(By.tagName("li"));
	
	public void selectTrip() {
		clickButton(bookBtn);
	}

}
