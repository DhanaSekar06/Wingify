package com.wingify.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Base {

	public static WebElement web;
	protected static Select sel;
	public static WebDriver driver;
	protected static List<String> listed;
	protected static WebDriverWait wait;
	final static int implicitwaitTime = 10;
	final static int explicitwaitTime = 20;

	public static void selectBrowserAndUrl(String browser, String URL) {

		switch (browser) {

		case "firefox":

			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "chrome":

			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "edge":

			System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		case "opera":
			System.setProperty("webdriver.opera.driver", "Drivers/operadriver.exe");
			driver = new OperaDriver();
			break;

		default:
			throw new RuntimeException("Browser type unsupported");

		}
		driver.manage().timeouts().implicitlyWait(implicitwaitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
	}

	// Click Button
	public static void clickBtn(WebElement Click) {
		wait = new WebDriverWait(driver, explicitwaitTime);
		WebElement readyEle = wait.until(ExpectedConditions.elementToBeClickable(Click));
		readyEle.click();
	}

	// click
	public static void click(WebElement Click) {
		Click.click();
	}

	// MouseOver Action
	public static void mouseOverAction(WebElement Click) {
		Actions ac = new Actions(driver);
		ac.moveToElement(Click).build().perform();
	}

	// Drop down
	public static void Dropdown(WebElement Element, String name) {
		sel = new Select(Element);
		sel.selectByVisibleText(name);
	}

	// goto Window by number
	public static void goToWindowByNumber(int NumOFWindow) {
		listed = new ArrayList<String>(driver.getWindowHandles());
		listed.get(NumOFWindow);
		threadWait(3000);
	}

	// Radio Button
	public static void radibutton(WebElement click) {
		wait = new WebDriverWait(driver, explicitwaitTime);
		WebElement readyEle = wait.until(ExpectedConditions.elementToBeClickable(click));
		readyEle.click();
	}

	// Explicit Waits
	public static void Explicitywaits(WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, explicitwaitTime);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}

	// Thread wait
	public static void threadWait(int milsec) {
		try {
			Thread.sleep(milsec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Scroll page to Element
	public static void ScrolltoElement(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
	}

	// Scroll to bottom
	public static void ScrolltoBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.bodyscrollHeight)");
	}

	// Scroll page by pixel value
	public static void scrollbypixel(int pixelValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixelValue + ")", "");

	}

	// send values
	public static void sendData(WebElement element, String name) {
		if (element.isEnabled())
			element.sendKeys(name);

	}

	// click By java script
	public static void clickByJS(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", ele);
	}

	// Click Check Box
	public static void checkbox(List<WebElement> element, String input) throws InterruptedException {
		for (WebElement web : element) {
			if (web.getText().equals(input))
				clickByJS(web);
		}
	}

	// ScreenShot
	public static void screenshot() {
		TakesScreenshot sr = (TakesScreenshot) driver;
		File from = sr.getScreenshotAs(OutputType.FILE);
		File to = new File("C:/Users/ADMIN/Pictures/Selenium Screenshot/screensot.png");
		try {
			Files.copy(from, to);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Get number for List
	public static List<Float> getNumberFromElements(List<WebElement> elements) {
		List<Float> texts = new ArrayList<Float>();
		for (WebElement amt : elements) {
			String replace = amt.getText().replace("USD", "").replace(",", "").replace(" ", "");
			float val = Float.parseFloat(replace);
			texts.add(val);
		}
		return texts;
	}

	// clear text box
	public static void clearTextbox(WebElement ele) {
		ele.clear();
	}

	// text box validation
	public static boolean isEnabled(WebElement ele) {
		return ele.isEnabled();
	}

	// get inner text
	public static String getText(WebElement ele) {
		Explicitywaits(ele);
		return ele.getText();
	}

	// Image validation
	public static boolean isDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}

	// Check Checkbox
	public static boolean checkCheckBox(WebElement element) {
		if (element.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	// To sort out the list
	public static boolean isSorted(List<WebElement> ele) {
		List<Float> amount = getNumberFromElements(ele);

		for (int i = 0; i < amount.size() - 1; i++) {
			if (amount.get(i) > amount.get(i + 1))
				return false;
		}
		return true;
	}
}
