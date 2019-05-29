import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInTest {

    WebDriver driver; 

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        driver.findElement(By.linkText("Your trips")).click();
        
        waitFor(2000);
        
        driver.findElement(By.id("SignIn")).click();
        waitFor(2000);
        driver.switchTo().frame("modal_window");
        driver.findElement(By.id("signInButton")).click();
        
        

        String errors1 = driver.findElement(By.id("errors1")).getText();
        System.out.println(errors1);
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        
    }
    
    @BeforeTest
    public void lunchTheURL() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-notifications");
    
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	driver = new ChromeDriver(options);
    	driver.get("https://www.cleartrip.com/");
    	
    	waitFor(2000);
        
    	
    }
    
    @AfterTest
    public void closeBrowser() {
    	driver.quit();
    }
    
    

   private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

  

}
