package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.FlightBookingPage;

public class FlightBookingTest {
	WebDriver driver ;
	@Test
	public void fligtBooking() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		FlightBookingPage fbp=new FlightBookingPage(driver);
		fbp.login();
		Thread.sleep(2000);
		fbp.bookFlight();
		Thread.sleep(2000);
		fbp.dateHandle();
		fbp.addPassangers(5);
		
	}
	

	
	
	
	
	

}
