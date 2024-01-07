package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.AbstractComponent;

public class SignUp extends AbstractComponent {
	public WebDriver driver;
	@FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[1]/select")
	WebElement drop;
	@FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select")
	WebElement drop2;
	@FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")
	WebElement drop2Year;
	@FindBy(xpath = "//div[text()='Signup']")
	WebElement signUP;
	@FindBy(css = ".form-control.form-select ")
	WebElement gender;
	@FindBy(id = "first_name")
	WebElement fName;
	@FindBy(id ="last_name")
	WebElement lName;
	@FindBy(css =".d-inline-block.datepicker")
	WebElement forClick;
	@FindBy(xpath ="//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[4]/div[1]/div/div[1]/input")
	WebElement wEle;
	@FindBy(xpath ="//*[@id=\"email_id\"]")
	WebElement gmail;
	@FindBy(id ="new-password")
	WebElement passWord;
	@FindBy(id ="c-password")
	WebElement cpassWord;
	@FindBy(id ="defaultCheck1")
	WebElement forClick2;
	@FindBy(css =".btn.btn-red")
	WebElement forClick3;
	@FindBy(xpath ="//div[@class='react-datepicker__month-container']/div[2]")
	List<WebElement> elements;


	public SignUp(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterDetails() throws InterruptedException {
		elementToAppear(driver.findElement(By.xpath("//div[text()='Signup']")));
		signUP.click();
		childWindowHandle();
		WebElement gen = gender;
		staticDropDown(gen, "Mr");
		fName.sendKeys("Hue");
		lName.sendKeys("Bryt");
		staticDropDown(drop, "India");
		forClick.click();
		staticDropDown(drop2, "March");
		staticDropDown(drop2Year, "1998");
		Thread.sleep(3000);
		dates();
		WebElement mobile = wEle;
		mobile.sendKeys("8281230087");
		gmail.sendKeys("Huebryt001@gmail.com");
		scroll();
		Thread.sleep(3000);
		passWord.sendKeys("*#Huebryt001*#");
		cpassWord.sendKeys("*#Huebryt001*#");
		forClick2.click();
		forClick3.click();
	}
	public void staticDropDown(WebElement ele, String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}
	public void dates() {
		List<WebElement> dates = elements;
		for (WebElement date : dates) {
			String da = date.getText();
			System.out.println(da);
			if (da.contains("18")) {
				date.click();
				break;
			}
		}
	}
	public void scroll() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
}
