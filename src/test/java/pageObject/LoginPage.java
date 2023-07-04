package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='username']")WebElement txt_login_username;
	@FindBy(xpath="//input[@id='password']")WebElement txt_login_password;
	@FindBy(xpath="//input[@type='submit'][@name='login']")WebElement btn_login;
	@FindBy(xpath="//a[normalize-space()='Dashboard']") WebElement lnk_dashboard;
	@FindBy(xpath="//a[normalize-space()='Shop']")WebElement lnk_shop;
	
	public void setUsername(String username) {
		txt_login_username.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txt_login_password.sendKeys(password);
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
	public boolean isDashboardDispalyed() {
		if(lnk_dashboard.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public void clickOnShop() {
		lnk_shop.click();
	}

}
