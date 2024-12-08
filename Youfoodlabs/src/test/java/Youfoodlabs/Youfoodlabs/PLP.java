package Youfoodlabs.Youfoodlabs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PLP {

	WebDriver driver;
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	DataFormatter formate;

	@BeforeTest(description = "openbrowser")
	void Openbrowser() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://yufoodsco.com/collections");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		file = new FileInputStream("C:\\Users\\LYXELANDFLAMINGO\\Desktop\\Maintence Project\\Yufoodlabs.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("PLP Page");
		formate = new DataFormatter();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='js-popup-close newsletter__popup-container-close']")));

		popup.click();

	}

	@Test(description = "click on All Product inside EverdyFoods")
	void TC_01() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement EverdyFoods = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='product-title'])[1]")));
		EverdyFoods.click();

		for (int i = 1; i <= 9; i++) {
			WebElement Allproducts = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//body/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div["
							+ i + "]/div[1]/div[1]/a[1]/div[1]/div[1]/img[1]")));
			Allproducts.click();
			driver.navigate().back();

		}
	}

	@Test(description = "click on All Filter inside EverdyFoods")
	void TC_02() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,-1500)");

		String[] EverdyFoods = { "(//button[@class ='js-accordion-header c-accordion__header '])[1]",
				"//ul[@id='c-accordion--menu_69']//a[@class='js-accordion-link c-accordion__link']",
				"(//button[@class ='js-accordion-header c-accordion__header '])[2]",
				"//ul[@id='c-accordion--bf6d708']//a[@class='js-accordion-link c-accordion__link']",
				"(//button[@class ='js-accordion-header c-accordion__header '])[3]",
				"//ul[@id='c-accordion--1522966']//a[@class='js-accordion-link c-accordion__link']",
				"(//button[@class ='js-accordion-header c-accordion__header '])[4]",
				"//ul[@id='c-accordion--23d72a2']//a[@class='js-accordion-link c-accordion__link']",
				"(//button[@class ='js-accordion-header c-accordion__header '])[5]",
				"//ul[@id='c-accordion--2223c28']//a[@class='js-accordion-link c-accordion__link']",
				"(//button[@class ='js-accordion-header c-accordion__header '])[6]",
				"(//ul[@id='c-accordion--65f5643']//a[@class='js-accordion-link c-accordion__link'])[1]", };

		for (String EverdyFood : EverdyFoods) {
			WebElement filter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EverdyFood)));
			filter.click();

		}

	}

	@Test(description = "click on All Filter inside EverdyFoods")
	void TC_03() {

		driver.navigate().to("https://yufoodsco.com/collections");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Snackingcategory = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='product-title'])[2]")));
		Snackingcategory.click();

		WebElement product2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//img[@class='lazyload-fade first-image lazyautosizes lazyloaded'])[2]")));
		product2.click();

	}
}
