package pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{
	
	Logger logger = LogManager.getLogger(SearchBox.class);
	By searchBoxLocator = By.id("search-input");
	
	public SearchBox(WebDriver driver) {
		super(driver);		
	}
	
	public void search(String text) {
		type(searchBoxLocator, text);		
		find(searchBoxLocator).sendKeys(Keys.ENTER);
		logger.info("Pressed Enter button.");
	}
	
}
