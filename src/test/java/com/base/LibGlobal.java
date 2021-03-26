package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LibGlobal {

	public static WebDriver driver;

	// 1---To launch browser
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\eclipse-workspace_UptoMaven\\CucumberDay3\\Driver\\chromedriver.exe");

		driver = new ChromeDriver();
		return driver;
	}
	
	public WebDriver getDriver1() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\admin\\eclipse-workspace_UptoMaven\\CucumberDay5\\Driver\\geckodriver.exe");

		driver = new FirefoxDriver();
		return driver;
	}


	// 2---To launch URL
	public void launchUrl(String Url) {
		driver.get(Url);
	}

	// 3---To type values
	public void type(WebElement element, String data) {
		element.sendKeys(data);
	}

	// 4---To click button
	public void btnClick(WebElement element) {
		element.click();
	}

	// 5---To maximize window
	public void maxWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	// 6---to get title
	public String getTitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}

	// 7---To wait
	public void sleep(long min) throws InterruptedException {
		Thread.sleep(min);
	}

	// 8---To get current url
	public String getCurrentUrl(WebDriver driver) {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 9---To close the browser
	public void close(WebDriver driver) {
		driver.close();
	}

	// 10---To quit the browser
	public void quit(WebDriver driver) {
		driver.quit();
	}

	// 11---To get attribute
	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}

	// 12--To select by value
	public void selectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	// 13---To select by index
	public void selectByIndex(WebElement element, int num) {
		Select s = new Select(element);
		s.selectByIndex(num);
	}

	// 14---To select by visible text
	public void selectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	// 15---To get all options
	public void getOptions(WebElement element) {
		Select s = new Select(element);

		List<WebElement> options = s.getOptions();

		for (int i = 0; i < options.size(); i++) {

			WebElement op = options.get(i);

			String text = op.getText();

			System.out.println(text);
		}
	}

	// 16---To check whether it is multiple selected options or not
	public boolean isMultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;
	}

	// 17---To select all options by using value
	public void selectAllOptionsByValue(WebElement element) {
		Select s = new Select(element);

		List<WebElement> options2 = s.getOptions();

		for (int i = 0; i < options2.size(); i++) {

			WebElement op = options2.get(i);

			String attribute = op.getAttribute("value");

			System.out.println(attribute);

			s.selectByValue(attribute);
		}
	}

	// 18---To select all options by using index
	public void selectAllOptionsByIndex(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options2 = s.getOptions();

		for (int i = 0; i < options2.size(); i++) {

			s.selectByIndex(i);
		}
	}

	// 19---To select all options by using visible text
	public void selectAllOptionsByVisibleText(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options2 = s.getOptions();

		for (int i = 0; i < options2.size(); i++) {

			WebElement op = options2.get(i);

			String text = op.getText();

			System.out.println(text);

			s.selectByVisibleText(text);
		}
	}

	// 20---To deselect all options by using value
	public void deSelectAllOptionsByValue(WebElement element) {
		Select s = new Select(element);

		List<WebElement> options2 = s.getOptions();

		for (int i = 0; i < options2.size(); i++) {

			WebElement op = options2.get(i);

			String attribute = op.getAttribute("value");

			s.selectByValue(attribute);

			s.deselectByValue(attribute);
		}
	}

	// 21---To deselect all options by using index
	public void deSelectAllOptionsByIndex(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options2 = s.getOptions();

		for (int i = 0; i < options2.size(); i++) {

			s.selectByIndex(i);

			s.deselectByIndex(i);
		}
	}

	// 22---To deselect all options by using visible text
	public void deSelectAllOptionsByVisibleText(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options2 = s.getOptions();

		for (int i = 0; i < options2.size(); i++) {

			WebElement op = options2.get(i);

			String text = op.getText();

			s.selectByVisibleText(text);

			s.deselectByVisibleText(text);
		}
	}

	// 23---To deselect all
	public void deSelectAll(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options2 = s.getOptions();

		for (int i = 0; i < options2.size(); i++) {

			WebElement op = options2.get(i);

			String text = op.getText();

			s.selectByVisibleText(text);

			s.deselectAll();
		}
	}

	// 24---To get all selected options
	public void getAllSelectedOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();

		for (int i = 0; i < allSelectedOptions.size(); i++) {

			WebElement op = allSelectedOptions.get(i);

			String text = op.getText();

			System.out.println(text);
		}
	}

	// 25---To get first selected options
	public void getFirstSelectedOptions(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();

		String text = firstSelectedOption.getText();

		System.out.println("First Selected Option is: " + text);
	}

	// 26---For simple alert
	public String simpleAlert(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		a.accept();
		return text;
	}

	// 27---For accepting the confirm alert
	public String confirmAlertAccept(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		a.accept();
		return text;
	}

	// 28---For dismissing the confirm alert
	public String confirmAlertDismiss(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		a.dismiss();
		return text;
	}

	// 29---For accepting the prompt alert
	public String promptAlertAccept(WebDriver driver, String text) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);
		String text2 = a.getText();
		a.accept();
		return text2;
	}

	// 30---For dismissing the prompt alert
	public String promptAlertDismiss(WebDriver driver, String text) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);
		String text2 = a.getText();
		a.dismiss();
		return text2;
	}

	// 31---For drag and drop
	public void actionsDragAndDrop(WebDriver driver, WebElement src, WebElement des) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}

	// 32---For mouse over action
	public void actionsMoveToElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	// 33---For right click
	public void actionsRightClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	// 34---For double click
	public void actionsDoubleClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	// 35---To press enter key
	public void pressEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	// 36---To press down key
	public void pressDown() throws AWTException {
		Robot r = new Robot();
		int num = 0;
		for (int i = 0; i <= num; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
	}

	// 37---To press tab key
	public void pressTab(int num) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i <= num; i++) {
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
	}

	// 38---For cut the content
	public void cutContent() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}

	// 39---For copy the content
	public void copyContent() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	// 40---For paste the content
	public void pasteContent() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	// 41---For screenshot
	public void takeScreenShot(WebDriver driver, String loc) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(loc);
		FileUtils.copyFile(src, des);
	}

	// 42---For window handle
	public void windowHandle(WebDriver driver) {
		String pID = driver.getWindowHandle();

		Set<String> allWID = driver.getWindowHandles();

		for (String id : allWID) {
			if (pID != id) {
				driver.switchTo().window(id);
			}
		}
	}

	// 43---To get text
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 44---To click button using Js
	public void clickJavaScript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	// 45---To read excel
	public String excelRead(String fileLoc, String sheetName, int rowNo, int cellNo) throws IOException {
		File f = new File(fileLoc);

		FileInputStream fin = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fin);

		Sheet s = w.getSheet(sheetName);

		Row r = s.getRow(rowNo);

		Cell c = r.getCell(cellNo);

		int type = c.getCellType();

		if (type == 1) {
			String name = c.getStringCellValue();
			return name;
		}
		if (type == 0) {
			if (DateUtil.isCellDateFormatted(c)) {

				String name = new SimpleDateFormat("dd-MM-yyyy").format(c.getDateCellValue());
				return name;
			} else {
				String name = String.valueOf((long) c.getNumericCellValue());
				return name;
			}

		}
		return null;
	}

	public void excelWrite(String sheetName, String fileLoc, int rowNo, int cellNo, String data) throws IOException {
		File f = new File(fileLoc);
		Workbook w = new XSSFWorkbook();

		Sheet s = w.createSheet(sheetName);

		Row r = s.createRow(rowNo);

		Cell c = r.createCell(cellNo);

		c.setCellValue(data);

		FileOutputStream fout = new FileOutputStream(f);

		w.write(fout);

	}

	public void excelUpdate(String sheetName, String fileLoc, int rowNo, int cellNo, String data) throws IOException {
		File f = new File(fileLoc);

		FileInputStream fin = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fin);

		Sheet s = w.getSheet(sheetName);

		Row r = s.createRow(rowNo);

		Cell c = r.createCell(cellNo);

		c.setCellValue(data);

		FileOutputStream fout = new FileOutputStream(f);

		w.write(fout);

	}

	public void clear(WebElement element) {
		element.clear();

	}

	// Cucumber

	// 15(1)---To get all options
	public List<String> getOptions1(WebElement element) {
		List<String> l = new ArrayList<String>();

		Select s = new Select(element);

		List<WebElement> options = s.getOptions();

		for (WebElement webElement : options) {

			l.add(webElement.getText());

		}
		return l;

	}
	
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

	}

	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();

	}

	public boolean isEnabled(WebElement element) {
		return element.isEnabled();

	}

	public void type1(WebElement element, String data) {

		if (isDisplayed(element) && isEnabled(element)) {

			element.sendKeys(data);

		} else {
			System.err.println("Webelement is hidden ot Textbox is disabled");
		}

	}

	public void btnClick1(WebElement element) {

		if (isDisplayed(element) && isEnabled(element)) {

			element.click();

		} else {
			System.err.println("Webelement is hidden ot Textbox is disabled");
		}

	}

	public void typeJs(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

	public void clickJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", element);

	}

}