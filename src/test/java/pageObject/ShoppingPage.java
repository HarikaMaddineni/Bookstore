package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ShoppingPage extends BasePage {

	public ShoppingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="(//div[@class='price_slider_wrapper']//span)[2]")
	WebElement slider_maxPrice;
	@FindBy(xpath="//div[@id='content']//li/a[@class='woocommerce-LoopProduct-link']//h3")
	List<WebElement> list_bookNames;
	
	 private String btnAddToBasket="(//div[@id='content']//li//a[@rel='nofollow'])[%s+1]";
	 @FindBy(xpath="//i[@class='wpmenucart-icon-shopping-cart-0']")WebElement viewCart;
	
	public void selectThePriceRange() {
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider_maxPrice, -25, 0).perform();
		//slider_maxPrice.getXpath();
	}
	
	public void addBookToBasket(String bookName) {
		
		for(int i=0;i<list_bookNames.size();i++) {
			if(list_bookNames.get(i).getText().equalsIgnoreCase(bookName)) {
				
				String formattedXpath=String.format(btnAddToBasket,i);
				System.out.println("xpath genearted "+formattedXpath);
				
				driver.findElement(By.xpath(formattedXpath)).click();
				
				
			}
		}
		
	}
	
	public void click_viewCart() {
		viewCart.click();
	}
	
	

}
