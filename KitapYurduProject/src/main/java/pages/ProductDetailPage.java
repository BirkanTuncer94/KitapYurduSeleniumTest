package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductDetailPage extends BasePage {
	
	By addToCartButtonLocator = new By.ByCssSelector("a#button-cart");

	Logger logger = LogManager.getLogger(ProductDetailPage.class);
	public ProductDetailPage(WebDriver driver) {
		super(driver);
		
	}

	public boolean isOnProductDetailPage() {
		
		return isDisplayed(addToCartButtonLocator);
	}
	
	public void addToCart() throws InterruptedException {
		Thread.sleep(1000);
		click(addToCartButtonLocator);
		logger.info("Clicked on the cart button.");
		Thread.sleep(2000);
		
	}

}
