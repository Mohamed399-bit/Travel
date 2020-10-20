package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name = "username")
	WebElement usernameTxt;
	
	@FindBy(name = "password")
	WebElement passwordTxt;
	
	@FindBy(css = "button.btn.btn-primary.btn-lg.btn-block.loginbtn")
	WebElement loginBtn;
	
	@FindBy(css = "div.row.align-items-center.pl-30")
	WebElement informationDiv;
	
	/*@FindBy(linkText = "Home")
	WebElement homeLink;*/
	
	@FindBy(id = "mobileMenuMain")
	WebElement mainMenu;
	
	public void login(String userName , String Password) {
		
		setTextWebElement(usernameTxt, userName);
		setTextWebElement(passwordTxt, Password);
		clickButton(loginBtn);
		
	}
	
	public WebElement returnUserName() {
		
		WebElement x = informationDiv.findElement(By.cssSelector("div.col-md-8"));
		WebElement userNameDiv = x.findElement(By.tagName("h3"));
		return userNameDiv;
	}
	
	public void clickOnHomeLink() {
		//clickButton(homeLink);
		WebElement navDiv = mainMenu.findElement(By.cssSelector("nav.main-nav-menu.main-menu-nav.navbar-arrow"));
		WebElement ulList = navDiv.findElement(By.cssSelector("ul.main-nav"));
		WebElement homeLink = ulList.findElement(By.tagName("a"));
		clickButton(homeLink);
	}

}
