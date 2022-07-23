package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;

public class BasePage {
	
	WebDriver driver;
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement find(By locator) { // Web elementini buluyorum		
		return driver.findElement(locator);		
	}
	
	public List<WebElement> findAll(By locator){ // Birden fazla ise web element listesi buluyorum
		return driver.findElements(locator);		
	}
	
	public void click(By locator) { // Týklama kýsayolu
		find(locator).click();
	}
	public void type(By locator, String text) { // Yazma kýsa yolu
		find(locator).sendKeys(text);
	}
	public boolean isDisplayed(By locator) { // Display durumu
		return find(locator).isDisplayed();
	}
	
	
	
	

}
