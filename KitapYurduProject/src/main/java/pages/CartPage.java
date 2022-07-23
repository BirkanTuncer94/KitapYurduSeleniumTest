package pages;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

	Logger logger = LogManager.getLogger(CartPage.class);
	
	By productNameLocator = new By.ByCssSelector("small.muted");
	By productQuantityLocator = new By.ByCssSelector("form.js-cart-update-product input");
	By productQuantityRefreshLocator = new By.ByCssSelector("form.js-cart-update-product i");
	By popUpToast = By.id("swal-toast");
	By productRemoveLocator = new By.ByCssSelector("td.remove a.alt");
	
	public CartPage(WebDriver driver) {
		super(driver);		
	}
	
	
	public boolean checkIfProductAdded() { //eklenmiþ mi kontrolü
		if(getProducts().size() > 0) {
			logger.info("Product added SUCCESSFULLY");
		}else {
			logger.error("Couldnt add the product");
		}
		return getProducts().size() > 0;		
	}
	
	private List<WebElement> getProducts(){
		return findAll(productNameLocator);
		}

	public void IncreaseProductQuantity() throws InterruptedException  // +1 ekleme ( önce delete sonra +1 li versiyonu ekleme )
	{		
		Thread.sleep(250);
		WebElement numb = find(productQuantityLocator);		
		String number = numb.getAttribute("value");
		int increasedNumber = Integer.parseInt(number) +1;		
		find(productQuantityLocator).clear();
		Thread.sleep(250);
		type(productQuantityLocator, Integer.toString(increasedNumber));
		logger.info("Product quantity is increased");
	}

	public void ClickRefresh() throws InterruptedException { // refresh buttonu týklama
		Thread.sleep(300);
		click(productQuantityRefreshLocator);
		logger.info("Refresh button clicked");
	}

	
	public boolean isUpdateToastExist() { // güncelleme görseli var mý
		WebElement updateToast = find(popUpToast);
		 if(updateToast.isEnabled()) {
			 logger.info("Cart updated SUCCESSFULLY");
			 return true;
		 }else {
			 logger.error("Couldnt update the cart");
		 }		
		return false;
	}
	
	
	
	private List<WebElement> findAllRemovableProducts(){ 
		return findAll(productRemoveLocator);
	}
	
	public void removeProduct() throws InterruptedException { // ürün silme 
		Thread.sleep(2000);
		logger.info("Assortment of products in the cart before remove: " + String.valueOf(findAllRemovableProducts().size()));		
		findAllRemovableProducts().get(0).click();		
		logger.info("Assortment of products in the cart after remove: " + String.valueOf(findAllRemovableProducts().size()));
	}
	
	public boolean cartItemLeftControl() { // sepette ürün var mý kontrolü
		if(findAllRemovableProducts().size() > 0) {
			logger.warn("There is atleast one more item in the cart.");
			return false;
		}
		logger.info("Cart is empty");
		return true;
	}
	
	
	
	
	
	
	
}
