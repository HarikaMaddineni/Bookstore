package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {

	public BasketPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='coupon_code']")
	private WebElement txt_couponCode;
	@FindBy(xpath="//input[@name='apply_coupon']")
	private WebElement btn_ApplyCoupon;
	@FindBy(xpath="//div[@class='wc-proceed-to-checkout']/child::a")
	private WebElement btn_checkOut;
	
	public void enterCouponCode(String coupon) {
		txt_couponCode.sendKeys(coupon);
	}
	
	public void click_ApplyCoupon() {
		btn_ApplyCoupon.click();
	}
	
	public void click_checkOut() {
		btn_checkOut.click();
	}

}
