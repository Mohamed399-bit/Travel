package pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "ul.nav.row-reverse ")
	WebElement ulList;

	@FindBy(xpath ="/html/body/div[2]/div[1]/div[3]/div[1]")
	WebElement hotelsContainer;


	List<WebElement> headerTabs = ulList.findElements(By.tagName("Li"));

	WebElement hotelsDiv = hotelsContainer.findElement(By.id("MenuHorizon28_01"));
	WebElement hotelsDiv2 = hotelsDiv.findElement(By.cssSelector("div.tab-inner"));
	WebElement hotelsDiv3 = hotelsDiv2.findElement(By.cssSelector("div.row.equal-height.cols-1.cols-sm-2.cols-lg-3.gap-10.gap-md-20.gap-xl-30"));
	List<WebElement> hotelsList = hotelsDiv3.findElements(By.cssSelector("div.col-lg-3.col-sm-4.col-xs-12"));
	String prices [] = new String [hotelsList.size()];
	WebElement hotle[] = new WebElement [hotelsList.size()];

	public void clickOnTabNameWith(String NameOfTab) {
		//System.out.println("Number of tabs is : " + headerTabs.size());

		for(WebElement ele : headerTabs) {
			WebElement tab = ele.findElement(By.tagName("a"));
			if(tab.getText().contains(NameOfTab)) {
				clickButton(tab);
				break;
			}
		}
	}



	public void selectLowPriceHotel() {

		jse.executeScript("scrollBy(0,1000)");
		int i = 0;
		for(WebElement ele : hotelsList) {
			WebElement priceDiv = ele.findElement(By.cssSelector("div.price"));
			WebElement priceSpan = priceDiv.findElement(By.cssSelector("span.text-secondary"));
			//System.out.println("price is : " + priceSpan.getText().substring(1));
			prices[i] = priceSpan.getText().substring(1);
			hotle[i] = ele;
			i++;
		}

		int smallprice = convertPricetoInt();
		String smallprice2 = String.valueOf(smallprice);
		for(int k = 0 ; k < hotelsList.size() ; k++) {
			if(prices[k].contains(smallprice2)) {
				clickButton(hotle[k]);
			}
		}
	}

	public int convertPricetoInt() {
		int  priceInteger[] = new int [hotelsList.size()];
		for(int i=0; i<hotelsList.size(); i++) {
			priceInteger[i] = Integer.parseInt(prices[i]);
		}
		Arrays.sort(priceInteger);
		/*for(int j = 0 ; j < hotelsList.size() ; j++) {
			System.out.println(priceInteger[j]);
		}*/

		return priceInteger[0];
	}



}
