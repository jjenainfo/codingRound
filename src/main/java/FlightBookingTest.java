import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest {

    WebDriver driver;

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        
        
        
        driver.findElement(By.id("OneWay")).click();

        driver.findElement(By.id("FromTag")).clear();
        driver.findElement(By.id("FromTag")).sendKeys("Ban");
        waitFor(3000);
        List<WebElement> element=driver.findElements(By.tagName("li"));
        for(WebElement suggestion:element) {
        	System.out.println(suggestion.getText());
        	if(suggestion.getText().equalsIgnoreCase("Bangalore, IN - Kempegowda International Airport (BLR)")) {
        		
        		suggestion.click();
        	}
        		
        	}

               
        driver.findElement(By.id("ToTag")).clear();
        driver.findElement(By.id("ToTag")).sendKeys("Del");
        waitFor(3000);
        List<WebElement> element2=driver.findElements(By.tagName("li"));
        for(WebElement suggestion2:element2) {
        	System.out.println(suggestion2.getText());
        	if(suggestion2.getText().equalsIgnoreCase("New Delhi, IN - Indira Gandhi Airport (DEL)")) {
        		
        		suggestion2.click();
        	}
        		
        	}

        

        

       driver.findElement(By.id("DepartDate")).click();
       List<WebElement> element1=driver.findElements(By.tagName("td"));
       for(WebElement suggestion1:element1) {
       	System.out.println(suggestion1.getText());
       	if(suggestion1.getText().equalsIgnoreCase("31")) {
       
       		suggestion1.click();
       		

       }
       }

        //all fields filled in. Now click on search
      driver.findElement(By.id("SearchBtn")).click();

        //verify that result appears for the provided journey search
       Assert.assertTrue(isElementPresent(By.className("searchSummary")));

        

    }
    
    @BeforeTest
    public void openURL() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-notifications");
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	driver = new ChromeDriver(options);
        driver.get("https://www.cleartrip.com/");
    }
    
    @AfterTest
    public void quitBrowser() {
    	
    	driver.quit();
    	
    }
    
    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }



  

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

   
}

