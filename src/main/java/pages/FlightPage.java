package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FlightPage extends PageBase{

	public FlightPage(WebDriver driver) {
		super(driver);
		actions = new Actions(driver); 
		jse = (JavascriptExecutor) driver;
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "s2id_location_from")
	WebElement s2id_location_from;

	@FindBy(id ="s2id_location_to")
	WebElement s2id_location_to;

	@FindBy(id = "location_from")
	WebElement locationFromTxt;

	@FindBy(id = "location_to")
	WebElement locationToTxt;
	
	@FindBy(id ="FlightsDateStart")
	WebElement FlightsDateStartBtn;
	
	@FindBy(id = "flights")
	WebElement flightsDiv;
	
	@FindBy(css ="div.datepicker.-bottom-left-.-from-bottom-.active")
	public WebElement calender;

	public void enterFromAndToLocation(String from , String to) throws InterruptedException {

		jse.executeScript("scrollBy(0,500)");
		clickButton(s2id_location_from);
		setTextWebElement(locationFromTxt, from);
		Thread.sleep(1500);
		actions.sendKeys(Keys.ENTER).build().perform();

		clickButton(s2id_location_to);
		setTextWebElement(locationToTxt, to);
		Thread.sleep(1500);
		actions.sendKeys(Keys.ENTER).build().perform();

	}
	
	public void clickonFlightData(String day) {
		clickButton(FlightsDateStartBtn);
		
		WebElement datePicker = calender.findElement(By.cssSelector("div.datepicker--content"));
		WebElement daysDatePicker= datePicker.findElement(By.cssSelector("div.datepicker--days.datepicker--body.active"));
		WebElement cellDay = daysDatePicker.findElement(By.cssSelector("div.datepicker--cells.datepicker--cells-days"));
		List<WebElement> days = cellDay.findElements(By.tagName("div"));
		
		for(WebElement ele : days) {
			if(ele.getText().contains(day)) {
				clickButton(ele);
				break;
			}
			
		}
	}
	
	public void clickOnSearchButton() {
		
		WebElement searchBtn = flightsDiv.findElement(By.cssSelector("button.btn-primary.btn.btn-block"));
		clickButton(searchBtn);
	}

}
