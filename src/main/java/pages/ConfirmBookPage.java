package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmBookPage extends PageBase {

	public ConfirmBookPage(WebDriver driver) {
		super(driver);
		jse =(JavascriptExecutor) driver;
	}
	
	@FindBy(css = "button.btn.btn-success.btn-lg.btn-block.completebook")
	WebElement confirmBookBtn;
	
	@FindBy(css = "div.row.align-items-center.h-100")
	public WebElement formToDiv;
	
	@FindBy(css = "tr.tr10")
	public WebElement pricerow;
	
	List<WebElement> tds = pricerow.findElements(By.tagName("td"));
	
	public WebElement priceTxt() {
		
		WebElement x [] = new WebElement[tds.size()];
		int i =0;
		for(WebElement ele : tds ) {
			WebElement h = ele.findElement(By.tagName("h5"));
			x[i] = h;
			i++;
		}
		return x[1];
	}
	
	public void clickOnConfirmBook() {
		jse.executeScript("scrollBy(0,1500)");
		clickButton(confirmBookBtn);
	}

}
