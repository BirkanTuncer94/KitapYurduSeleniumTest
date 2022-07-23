package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage{
	
	Logger logger = LogManager.getLogger(HomePage.class);
	public SearchBox searchBox;
	By cartCountLocator = new By.ByCssSelector("div#sprite-cart-icon");
	By cartInsideLocator = new By.ByCssSelector("a#js-cart");
	By bannerLocator = new By.ById("desktop-banners");
	
	public HomePage(WebDriver driver) {
		super(driver);
		searchBox = new SearchBox(driver);
		
	}
	
	public boolean homePageLoaded() {
		if(find(bannerLocator).isEnabled()) {
			logger.info("Home page loaded SUCCESSFULLY");
			return true;
		}
		logger.error("Home page couldnt loaded");
		return false;
	}
	
	public SearchBox searchBox() {
		return this.searchBox;
	}

	public boolean isProductCountUp() {
		
		return getCartCount()>0 ;
	}

	public void goToCart() throws InterruptedException {
		
		click(cartCountLocator);
		logger.info("Clicked cart button.");
		Thread.sleep(500);
	}
	
	public void goToInsideCart() {
		click(cartInsideLocator);
		logger.info("Clicked to cart for inside of the cart page");
	}
	
	
	private int getCartCount() {
		String count = find(cartCountLocator).getText();
		int countItem = Integer.parseInt(count);
		logger.info("Card count checked");
		return countItem;
	}
	

}
