package Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;


import pages.CSV_Read;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;




public class Tests extends BaseTest{
	
	
	Logger logger = LogManager.getLogger(BaseTest.class);
	HomePage homePage;
	ProductsPage productsPage;
	ProductDetailPage productDetailPage;
	CartPage cartPage;
	CSV_Read csv_Read;
	
	
	@Test
	@Order(1)
	public void test_home_page_control() {
		homePage = new HomePage(driver);
		Assertions.assertTrue(homePage.homePageLoaded(),"Yüklenmemiþ");
		
		
	}
	
	
	@Test
	@Order(2)
	public void test_add_book_to_cart_and_control_the_value() throws InterruptedException, CsvValidationException, IOException {
	
		csv_Read = new CSV_Read(driver);
		productDetailPage = new ProductDetailPage(driver);
		productsPage = new ProductsPage(driver);
		homePage.searchBox.search(csv_Read.reading());
		productsPage.selectProduct();
		productDetailPage.addToCart();
		Assertions.assertTrue(homePage.isProductCountUp(),"product count did not increase");

		
	}
	

	@Test
	@Order(3)
	public void test_go_to_cart_then_increase_quantity_of_the_product_and_click_refresh() throws InterruptedException {
		cartPage = new CartPage(driver);
		homePage.goToCart();
		homePage.goToInsideCart();
		cartPage.IncreaseProductQuantity();
		cartPage.ClickRefresh();
		Assertions.assertTrue(cartPage.isUpdateToastExist(),"Update toast doesnt show up");
	}
	
	
	@Test
	@Order(4)
	public void delete_and_control_the_cart() throws InterruptedException {
		cartPage.removeProduct();
		Assertions.assertTrue(cartPage.cartItemLeftControl(),"Cart is empty");
	}
	
	
	
	
	
	}


