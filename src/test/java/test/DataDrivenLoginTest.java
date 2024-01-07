package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utilities.AbstractComponent;
import pages.SpiceJetLoginPage;

public class DataDrivenLoginTest {
	WebDriver driver;

	@Test
	public void loginDataDiven() throws IOException, InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		SpiceJetLoginPage spice = new SpiceJetLoginPage(driver);
		String link = "C:\\Users\\ASUS\\OneDrive\\Pictures\\spicejet.xlsx";
		String sheet = "Sheet1";
		int rowCount = AbstractComponent.getRowCount(link, sheet);
		for (int i = 1; i <= rowCount; i++) {
			String userName = AbstractComponent.getCellValue(link, sheet, i, 0);
			System.out.println(userName);
			String userPassword = AbstractComponent.getCellValue(link, sheet, i, 1);
			System.out.println(userPassword);
			spice.loginApplication(userName, userPassword);
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(3000);

		}

	}

}
