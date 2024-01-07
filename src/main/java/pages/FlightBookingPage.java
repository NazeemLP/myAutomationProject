package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightBookingPage {
	WebDriver driver;
	@FindBy(xpath = "//div[text()=\"Login\"]")
	WebElement ele;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[4]/div[2]/input")
	WebElement phoneNumber;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[5]/div[1]/div[2]/input")
	WebElement password;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[5]/div[3]")
	WebElement buttonClick;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[3]/div[2]/div/div[1]/div/div[3]")
	List<WebElement> Ldates;
	@FindBy(css = "input[class*='css-1cwyjr8']")
	WebElement forClick;
	@FindBy(xpath = "//div[text()='BLR']")
	WebElement forClick3;
	@FindBy(xpath = "//div[text()='IXB']")
	WebElement forClick2;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[1]/div[2]")
	WebElement forClick4;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]")
	WebElement forClick5;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[7]/div[2]/div")
	WebElement forClick6;

	public FlightBookingPage(WebDriver driver) {

		this.driver = driver;

	}

	public void login() {
		ele.click();

		phoneNumber.sendKeys("8590111964");
		password.sendKeys("*#Huebryt001*#");
		buttonClick.click();
	}

	public void bookFlight() throws InterruptedException {
		Thread.sleep(2000);
		forClick.click();
		Thread.sleep(2000);
		forClick2.click();
		Thread.sleep(2000);
		forClick3.click();

	}

	public void dateHandle() {
		List<WebElement> dates = Ldates;

		for (WebElement e : dates) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains("5")) {
				System.out.println("entereddddd");
				e.click();
				break;
			}
		}

	}

	public void addPassangers(int count) {
		forClick4.click();
		for (int i = 0; i < count; i++) {
			forClick5.click();
			forClick6.click();

		}

	}
}
