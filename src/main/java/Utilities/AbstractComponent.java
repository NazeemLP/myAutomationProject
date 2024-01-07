package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	@FindBy(css = ".form-control.form-select")
	public WebElement drop;
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void childWindowHandle() {

		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String window : allWindow) {

			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
			}

		}

	}

	public void elementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public static String getCellValue(String link, String sheet,int row,int col) throws IOException {

		try {
			FileInputStream fis = new FileInputStream(link);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFCell cell = wb.getSheet(sheet).getRow(row).getCell(col);
			if (cell.getCellType() == CellType.STRING) {

				return cell.getStringCellValue();
			} else {
				return cell.getRawValue();
//				double v=cell.getNumericCellValue();
//				return String.valueOf(v);
			}

		} catch (Exception e) {
			return "";
		}

	}

	public static int getRowCount(String link, String sheet) {

		try {

			FileInputStream fis = new FileInputStream(link);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			return wb.getSheet(sheet).getLastRowNum();

		} catch (Exception e) {

			return 0;

		}

	}

}
