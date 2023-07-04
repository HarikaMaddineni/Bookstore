package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	 @FindBy(xpath="//input[@id='billing_first_name']")
	 private WebElement txt_firstName;
	 @FindBy(xpath="//input[@id='billing_last_name']")
	 private WebElement txt_lastName;
	 @FindBy(xpath="//input[@id='billing_company']")
	 private WebElement txt_company;
	 @FindBy(xpath="//input[@id='billing_email']")
	 private WebElement txt_email;
	 @FindBy(xpath="//input[@id='billing_phone']")
	 private WebElement txt_phoneNo;
	 @FindBy(xpath="//div[@id='s2id_billing_country']")
	 private WebElement drpdwn_country;
	 @FindBy(xpath="//ul[@role='listbox']//div")
	 private List<WebElement> list_country;
	 @FindBy(xpath="//div[@id='s2id_billing_country']//span")
	 private WebElement txt_getCountry;
	 @FindBy(xpath="//input[@id='billing_address_1']")
	 private WebElement txt_address;
	 @FindBy(xpath="//input[@id='billing_city']")
	 private WebElement txt_city;
	 @FindBy(xpath="//div[@id='s2id_billing_state']")//div[@id='s2id_billing_state']
	 private WebElement drpdwn_state;
	 
	 @FindBy(xpath="//ul[@role='listbox']//div[@class='select2-result-label']")
	 private List<WebElement> list_state;
	 @FindBy(xpath="//input[@id='billing_postcode']")
	 private WebElement txt_postcode;
	@FindBy(xpath="//table//tr[@class='cart-subtotal']//span")
	private WebElement lbl_subTotal;
	@FindBy(xpath="//table//tr[@class='tax-rate tax-rate-in-tax-1']//span")
	private WebElement lbl_tax;
	@FindBy(xpath="//table//tr[@class='cart-discount coupon-krishnasakinala']")
	private WebElement lbl_discountCoupon;
	@FindBy(xpath="//table//tr[@class='order-total']//span")
	private WebElement lbl_Total;
	@FindBy(xpath="//input[@id='payment_method_cod']")
	private WebElement radio_cod;
	@FindBy(xpath="//input[@id='place_order']")
	private WebElement btn_placeOrder;
	
	public void setFirstname(String firstname) {
		txt_firstName.clear();
	txt_firstName.sendKeys(firstname);
		
	}
	
	public void setLastName(String lastname) {
		txt_lastName.clear();
		txt_lastName.sendKeys(lastname);
	}
	public void setCompany(String company) {
		txt_company.clear();
		txt_company.sendKeys(company);
	}
	public void setEmail(String email) {
			txt_email.clear();
			txt_email.sendKeys(email);
	}
	
	public void setPhoneNum(String pNumber) {
		txt_phoneNo.clear();
		txt_phoneNo.sendKeys(pNumber);
	}
	public void selectCountry(String country) {
		drpdwn_country.click();
	
		selectFromDropDown(list_country, country);
	}
	
	public void selectFromDropDown(List<WebElement>list,String value) {
		for(WebElement e:list ) {
			//System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase(value)) {
				e.click();
				break;
			
			}
		}
		
	}
	public void setAddress(String streetname) {
		txt_address.clear();
		txt_address.sendKeys(streetname);
		
	}
	
	public void setCity(String city) {
		txt_city.clear();
		txt_city.sendKeys(city);
	}
	
	public void selectState(String state) {
		drpdwn_state.click();
		selectFromDropDown(list_state, state);
	}
	
	public void setpostCode(String postcode) {
		txt_postcode.clear();
		txt_postcode.sendKeys(postcode);
	}
	
	public String getSubTotal() {
		return lbl_subTotal.getText();
		
	}
	
	public String getTaxAmount() {
		return lbl_tax.getText();
	}
	public String getTotalAmount() {
		return lbl_Total.getText();
	}
	
	public boolean isDiscountCouponApplied() {
		try {
			return(lbl_discountCoupon.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	public void select_payment_type() {
		radio_cod.click();
		
	}

	public void click_on_place_order() {
		btn_placeOrder.click();
	}
	public String getCountry() {
		return txt_getCountry.getText();
	}
}
