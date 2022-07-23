package Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class BaseTest {

	Logger logger = LogManager.getLogger(BaseTest.class); 
	protected WebDriver driver;
	
	
	
	
	@BeforeAll
	public void setUp() {
		logger.info("TEST START");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.kitapyurdu.com/");
		driver.manage().window().maximize();
		logger.info("Entered website: "+ driver.getCurrentUrl());
				
	}
	
	
	@AfterAll
	public void tearDown() {
		logger.info("TEST FINISH");
		driver.quit();
		
	}
	
	
}
