package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.parser.Element;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BC {
	public static WebDriver driver;

	public static void getDriver(String data, String url) {
		if (data.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--disable-notifications");
			driver = new ChromeDriver(op);

		}
		else if (data.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions f=new FirefoxOptions();
			f.addArguments("--disable-notifications");
			driver = new FirefoxDriver(f);
		}

		else if (data.equals("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		
	}
  
	
	

	public static void getBrowser(String url) {

		WebDriverManager.chromedriver().setup();

	    driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

	}

	public static void loadUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void getcurrentUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void type(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static String getAttribut(WebElement element, String data) {
		String attribute = element.getAttribute(data);
		System.out.println(attribute);
		return attribute;
	}

	public static void getTxt(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public static WebElement byId(String data) {
		WebElement findElement = driver.findElement(By.id(data));
		return findElement;

	}

	public static WebElement byName(String data) {
		WebElement findElement = driver.findElement(By.name(data));
		return findElement;
	}

	public static WebElement byClassName(String data) {
		WebElement findElement = driver.findElement(By.className(data));
		return findElement;
	}

	public static WebElement byXpath(String data) {
		WebElement findElement = driver.findElement(By.xpath(data));
		return findElement;
	}

	public static List<WebElement> byTagName(String data) {
		List<WebElement> findElements = driver.findElements(By.tagName(data));
		return findElements;
	}

	public static WebElement byLinkText(String data) {
		WebElement findElement = driver.findElement(By.linkText(data));
		return findElement;
	}

	public static WebElement byPartiallyLinkText(String data) {
		WebElement findElement = driver.findElement(By.partialLinkText(data));
		return findElement;
	}

	public static WebElement bycssSelector(String data) {
		WebElement findElement = driver.findElement(By.cssSelector(data));
		return findElement;
	}

	public static void btnClick(WebElement element) {
		element.click();
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public static void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public static void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public static void dragandDrop(WebElement drog, WebElement drop) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drog, drop).perform();
	}

	public static void robotCut() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_X);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_X);
	}

	public static void robotCopy() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
	}

	public static void robotPaste() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
	}

	public static void robotDownAndEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void robotEsc() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public static void robotEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void robotTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public static void robotDowns(int num) throws AWTException {
		Robot robot = new Robot();

		for (int i = 0; i < num; i++) {
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
		}

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void simple(WebElement element) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void confirm(WebElement element) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public static void prompt(WebElement element, String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
		alert.accept();
	}

	public static void textJs(WebElement element, String data) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public static void attributeJs(WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("return arguments[0].getAttribute('value')", element);
	}

	public static void clickJs(WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click()", element);

	}

	public static void scrollDown(WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arugments[0].ScrollIntoView(true)", element);
	}

	public static void scrollUp(WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arugments[0].ScrollIntoView(false)", element);
	}

	public static void frameId(String data) {
		driver.switchTo().frame(data);
	}

	public static void frameName(String data) {
		driver.switchTo().frame(data);
	}

	public static void frameIndex(int num) {
		driver.switchTo().frame(num);
	}

	public static void frameElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static Select selectByIndex(WebElement element, int num) {
		Select select = new Select(element);
		select.selectByIndex(num);
		return select;
	}

	public static void selectByValue(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByValue(data);
	}

	public static void selectByText(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}

	public static void deSelectByIndex(WebElement element, int num) {
		Select select = new Select(element);
		select.deselectByIndex(num);
	}

	public static void deSelectByValue(WebElement element, String data) {
		Select select = new Select(element);
		select.deselectByValue(data);
	}

	public static void deSelectByText(WebElement element, String data) {
		Select select = new Select(element);
		select.deselectByValue(data);
	}

	public static void getOptions(WebElement element) {
		Select select = new Select(element);
		select.getOptions();
	}

	public static void getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		select.getAllSelectedOptions();
	}

	public static void getFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		select.getFirstSelectedOption();
	}

	public static void isMultple(WebElement element) {
		Select select = new Select(element);
		select.isMultiple();
	}

	public static String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public static Set<String> windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public static void windowUrl(String data) {
		driver.switchTo().window(data);
	}

	public static void windowTitle(String data) {
		driver.switchTo().window(data);
	}

	public static void windowId(String data) {
		driver.switchTo().window(data);
	}

	public static void isEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}

	public static void isDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}

	public static void isSelected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println(selected);
	}

	public static void navigateTo(String data) {
		driver.navigate().to(data);
		driver.manage().window().maximize();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateBackward() {
		driver.navigate().back();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void sleep(int num) throws InterruptedException {
		Thread.sleep(num);
	}
	
	public static void dynamicWait1(int num) {
		driver.manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);
	}

	public static void fileLocation(File file, String data) {
		File f = new File(data);
	}

	public static void readFile(FileInputStream file, String data) throws FileNotFoundException {
		FileInputStream f = new FileInputStream(data);
	}

	public static void readFile(WebElement element) throws IOException {
		File file = new File("E:\\code\\Maven\\Excel\\HotelData1.xlsx");

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Sheet1");

		Row row = sheet.createRow(2);
		Cell cell = row.createCell(0);
		cell.setCellValue(element.getAttribute("value"));

		FileOutputStream outputstream = new FileOutputStream(file);
		workbook.write(outputstream);
	}

	public static void createWorkbook(Workbook workbook, String data) {
		Workbook book = new XSSFWorkbook();
	}

	public static void getSheet(Workbook workbook, String data) {
		Sheet sheet = workbook.getSheet(data);
	}

	public static void getRow(Sheet sheet, int num) {
		Row row = sheet.getRow(num);
	}

	public static void getCell(Row row, int num) {
		Cell cell = row.getCell(num);
	}

	public static void getNumOfRow(Sheet sheet, int num) {
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(numberOfRows);
	}

	public static void getNumOfCell(Row row, int num) {
		int numberOfCells = row.getPhysicalNumberOfCells();
		System.out.println(numberOfCells);
	}

	public static void getCellType(Cell cell) {
		int type = cell.getCellType();
	}

	public static void getStringcellValue(Cell cell) {
		String value = cell.getStringCellValue();
		System.out.println(value);
	}

	public static void getDatecellValue(Cell cell) {
		Date date = cell.getDateCellValue();
		System.out.println(date);
	}

	public static void getNumericalcellValue(Cell cell) {
		double cellValue = cell.getNumericCellValue();
		System.out.println(cellValue);
	}

	public static void valueOf(String data) {
		String valueOf = String.valueOf(data);
		System.out.println(valueOf);
	}

	public static void simpleDateFormate(String data) {
		SimpleDateFormat date = new SimpleDateFormat();
		String format = date.format(data);
		System.out.println(data);
	}

	public static void screenshot(String data, String path) throws IOException {

		driver.get(data);
		TakesScreenshot screen = (TakesScreenshot) driver;
		File screenshotAs = screen.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshotAs, new File(path));
	}

	public static String getData(int rowNo, int cellNo) throws IOException {
		File file = new File("E:\\code\\Maven\\Excel\\HotelData.xlsx");

		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		// 1-text, 0-number
		int type = cell.getCellType();
		String value = "";
		if (type == 1) {
			value = cell.getStringCellValue();

		}
		if (type == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				// Date date = cell.getDateCellValue();
				SimpleDateFormat form = new SimpleDateFormat("dd-MM-YYYY");
				value = form.format(cell.getDateCellValue());

			} else {
				double cellValue = cell.getNumericCellValue();
				// newdatatype var=(new datatype) oldvar
				// long l=(long)cellValue;
				value = String.valueOf((long) cellValue);
				// System.out.println(value);
			}
		}
		return value;

	}

	public static void getAllData(String data) throws IOException {
		File file = new File(data);

		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Sheet1");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int type = cell.getCellType();
				if (type == 1) {
					String name = cell.getStringCellValue();
					System.out.println(name);
				}
				if (type == 0) {
					if (DateUtil.isCellDateFormatted(cell)) {
						Date date = cell.getDateCellValue();
						SimpleDateFormat form = new SimpleDateFormat("dd-MM-YYYY");
						String name = form.format(date);
						System.out.println(name);

					} else {
						double cellValue = cell.getNumericCellValue();
						long l = (long) cellValue;
						String name = String.valueOf(l);
						System.out.println(name);
					}
				}
			}
		}
	}
}
