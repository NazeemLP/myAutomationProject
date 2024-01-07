package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SignUp;

public class TestSignUp {

	public WebDriver driver;
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
	}

	@Test
	public void signDetails() throws InterruptedException {
		SignUp sign=new SignUp(driver);
		System.out.println("hello");
		sign.enterDetails();

	}

	
}
