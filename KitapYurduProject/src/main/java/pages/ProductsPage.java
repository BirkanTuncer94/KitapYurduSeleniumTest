package pages;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ProductsPage extends BasePage {
	
	Logger logger = LogManager.getLogger(ProductsPage.class);
	By categoryLocator = By.id("faceted-search-group-0");
	By productNameLocator = new By.ByCssSelector("div.grid_7.omega div.name a span");

	public ProductsPage(WebDriver driver) {
		super(driver);
		
	}

	public boolean isOnProductPage() {
		
		return isDisplayed(categoryLocator);
	}

	public void selectProduct() throws InterruptedException {
		Random rnd = new Random();		
		int max = getAllProducts().size();		
		int rndNumber = rnd.nextInt(max-1);
		logger.info("Selected book: " + getAllProducts().get(rndNumber).getText());
		Thread.sleep(3000);
		getAllProducts().get(rndNumber).click();
		
		
				
	}
	
	private List<WebElement> getAllProducts(){
		return findAll(productNameLocator);
	}


	
	
	
	
}
