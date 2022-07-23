package pages;

import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class CSV_Read extends BasePage {
	public CSV_Read(WebDriver driver) {
		super(driver);
		
	}

	WebDriver driver;
	String CSV_FilePath = "C:\\Users\\Birkan\\Desktop\\Selenium_Test_Project\\TestData.csv";
		
	
	
	public String reading() throws CsvValidationException, IOException 
	{
		Logger logger = LogManager.getLogger(CSV_Read.class);
		CSVReader reader = new CSVReader(new FileReader(CSV_FilePath));
		String cell[];
		String word = null;
		
		while((cell = reader.readNext()) != null ) {
			for(int i = 0; i<cell.length; i++) 
			{
				word = cell[i];			
			}
		}
		
		if(word.isEmpty()) {
			logger.error("csv file empty or couldnt read.");
		}else {
			logger.info("The word read from csv file is: " + word);
		}				
		return word;		
	}
		
}


