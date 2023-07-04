package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.BasketPage;
import pageObject.CheckOutPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ShoppingPage;
import testBase.BaseClass;

public class TC_001_End_to_End extends BaseClass {
	
	@Test()
	public void login_test() {
		try {
		
		logger.info("Login test Started *************");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		LoginPage  lp = new LoginPage(driver);
		lp.setUsername(rb.getString("email"));
		lp.setPassword(rb.getString("password"
				));
		lp.clickLogin();
		
		
		Assert.assertTrue(lp.isDashboardDispalyed());
		
		
		logger.info("shooping page started");
		lp.clickOnShop();
		Thread.sleep(1000);
		ShoppingPage sp= new ShoppingPage(driver);
		sp.selectThePriceRange();
		sp.addBookToBasket(rb.getString("bookname"));
		sp.click_viewCart();
		BasketPage bp = new BasketPage(driver);
		bp.enterCouponCode(rb.getString("coupon_code"));
		Thread.sleep(1000);
		bp.click_ApplyCoupon();
		Thread.sleep(1000);
		bp.click_checkOut();
		CheckOutPage cop= new CheckOutPage(driver);
		cop.setFirstname(generateRandomString() );
		Thread.sleep(1000);
		cop.setLastName(generateRandomString());
		cop.setCompany(generateRandomString());
		cop.setEmail(rb.getString("email"));
		Thread.sleep(1000);
		cop.setPhoneNum(generateRandomNumber());
		Thread.sleep(1000);
		cop.selectCountry("India");
		Thread.sleep(2000);
		cop.setAddress("vinayak Nagar");
		cop.setCity("Kothagudhem");
		Thread.sleep(1000);
		cop.selectState("Telangana");
		cop.setpostCode("507118");
		//Thread.sleep(1000);
		String sub_total=cop.getSubTotal().replaceAll("[^\\d.]", "");
		String act_tax_string=cop.getTaxAmount().replaceAll("[^\\d.]", "");
		String act_total_string=cop.getTotalAmount().replaceAll("[^\\d.]", "");
		double act_sub_total = Double.parseDouble(sub_total);
		double act_tax=Double.parseDouble(act_tax_string);
		double act_total=Double.parseDouble(act_total_string);
		
		System.out.println(" act_sub_total  "+ act_sub_total);
		double cal_tax;
		if(cop.isDiscountCouponApplied()) {
			act_sub_total=act_sub_total-50;
		}
				if(cop.getCountry().equals("India")) {
					
					cal_tax=(act_sub_total*2)/100;
					if(cal_tax==act_tax) {
						logger.info("Tax calaculate in india is 2%");
						//Assert.assertTrue(true);
					}
					else {
						
						logger.info("Tax calculate does not match ");
						Assert.assertFalse(false);
					}
				}
				else {
					 cal_tax=(act_sub_total*5)/100;
					if(cal_tax==act_tax) {
						logger.info("Tax calaculate in is 5%");
						//Assert.assertTrue(true);
					}
					else {
						
						logger.info("Tax calculate does not match ");
						Assert.assertFalse(false);
					}
					
				}
				
				if(act_total==(act_sub_total+cal_tax)) {
					logger.info("Actual cost calculate is sync ");
				}
				else {
					logger.info("Actual cost calculate is correct ");
					Assert.assertFalse(false);
					
				}
				
			System.out.println("total calculated "+(act_sub_total+cal_tax));
			System.out.println("total  from  table "+act_total);
			
				cop.select_payment_type();
				cop.click_on_place_order();
				
				logger.info("End-t0-End test case  finished *************");
		
		}
		catch(Exception ex) {
			logger.info(ex);
			Assert.fail();
		}
		
	}

}
