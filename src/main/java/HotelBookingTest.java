import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import codingUtility.BrowserFactory;

public class HotelBookingTest {
	
	@Test
	public void hotelBooking() throws InterruptedException {
		WebDriver driver=BrowserFactory.openBrowser();
		HotelBookingPage hotel_book=PageFactory.initElements(driver, HotelBookingPage.class);
		hotel_book.shouldBeAbleToSearchForHotels();
		
		
		
	}

}
