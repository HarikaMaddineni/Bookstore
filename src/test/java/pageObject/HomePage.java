package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		
	}
	
	@FindBy(xpath=" //a[normalize-space()='My Account']") WebElement lnk_MyAccount;
	
	public void clickMyAccount() {
		lnk_MyAccount.click();
	}

}
