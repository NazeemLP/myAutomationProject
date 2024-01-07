package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.AbstractComponent;

public class SpiceJetLoginPage extends AbstractComponent {
	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[3]/div[1]/div/div")
	WebElement mainContainer;
	@FindBy(xpath = "(//*[name()='circle'])[13]")
	WebElement phoneNum;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[4]/div[2]/input")
	WebElement sendName;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[5]/div[1]/div[2]/input")
	WebElement sendPass;
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[3]/div[2]/div[2]/div/div/div/div[5]/div[3]")
	WebElement clickButon;

	public SpiceJetLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	public void loginApplication(String userName, String passWord) throws InterruptedException {
		mainContainer.click();
		WebElement phoneNumField = phoneNum;
		elementToAppear(phoneNumField);
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//div[text()='Email']")).click();
		sendName.sendKeys(userName);

		sendPass.sendKeys(passWord);
		Thread.sleep(3000);
		clickButon.click();
	}

}
