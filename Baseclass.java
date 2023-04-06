package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @see Baseclass
 * @author Jubi
 * Date 16-Feb-23
 */
public class Baseclass {

	public static WebDriver driver;

	// 1.Enter URL
/**
 * @see Enter Application URL
 * @param url
 */
	public void enterAppUrl(String url) {
	driver.get(url);
	 }

	// 2.Maximize Window
	/**
	 * @see maximizeWindow
	 */
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// 3.Insert value in TextBox
	/**
	 * @see elementSendkeys
	 * @param element
	 * @param data
	 */
	public void elementSendkeys(WebElement element, String data) {
		element.sendKeys(data);
	}

	// 4.Click Button
	/**
	 * @see elementClick
	 * @param element
	 */
	public void elementClick(WebElement element) {
		element.click();
	}

	// 5.Alert OK
	/**
	 * @see alertOk
	 */
	public void alertOk() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// 6.Alert Cancel
	/**
	 * @see alertCancel
	 */
	public void alertCancel() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// 7.Text from WebPage
	/**
	 * @see elementGetText
	 * @param element
	 * @return text
	 */
	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 8.Inserted value from TextBox
	/**
	 * @see elementGetAttributeValue
	 * @param element
	 * @return attribute
	 */
	public String elementGetAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	/**
	 * @see elementGetAttributeValue
	 * @param element
	 * @param attribute
	 * @return attribute1
	 */
	// 9.Inserted value from TextBox
	public String elementGetAttributeValue(WebElement element, String attribute) {
		String attribute1 = element.getAttribute(attribute);
		return attribute1;
	}

	// 10.Close All Window
	/**
	 * @see quitWindow
	 */
	public static void quitWindow() {
		driver.quit();
	}

	// 11.Close Window
	/**
	 * @see closeWindow
	 */
	public static void closeWindow() {
		driver.close();
	}

	// 12.Get the Title
	/**
	 * @see getAppInTitle
	 * @return title
	 */
	public String getAppInTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 13.Entered URL
	/**
	 * @see enteredAppUrl
	 * @param url
	 */
	public void enteredAppUrl(String url) {
		driver.getCurrentUrl();
	}

	// 14.Select dropdown option by Text
	/**
	 * @see selectOptionByText
	 * @param element
	 * @param text
	 */
	public void selectOptionByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// 15.Select dropdown option by Attribute
	/**
	 * @see selectOptionByAttribute
	 * @param element
	 * @param value
	 */
	public void selectOptionByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 16.Select dropdown option by Index
	/**
	 * @see selectOptionByIndex
	 * @param element
	 * @param index
	 */
	public void selectOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// 17.Insert value in TextBox by JS
	/**
	 * @see elementSendkeysJs
	 * @param element
	 * @param data
	 * @return executeScript
	 */
	public JavascriptExecutor elementSendkeysJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("arguments[0].setAttribute('value'," + data + ")", element);
		return (JavascriptExecutor) executeScript;
	}

	// 18.Click Button by JS
	/**
	 * @see clickJs
	 * @param element
	 */
	public void clickJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}
	// 19.Lanch Chrome Browser

	// 20.Switc to Child Window
	/**
	 * @see childWindow
	 */
	public void childWindow() {
		String windowHandle = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String x : allWindow) {
			if (!windowHandle.equals(allWindow))
				;
			driver.switchTo().window(x);
		}
	}

	// 21.Switch to Frame by Index
	/**
	 * @see switchToIndex
	 * @param index
	 */
	public void switchToIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 22.Switch to Frame by FrameId
	/**
	 * @see switchToFrameId
	 * @param name
	 */
	public void switchToFrameId(String name) {
		driver.switchTo().frame(name);
	}

	// 23.Find Loctor By Id
	/**
	 * @see findElementId
	 * @param id
	 * @return element
	 */
	public WebElement findElementId(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	// 24.Find Locator By Name
	/**
	 * @see findElementByName
	 * @param name
	 * @return element
	 */
	private WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	// 25.Find Locator By ClassName
	/**
	 * @see findElementByClassName
	 * @param Value
	 * @return element
	 */
	public WebElement findElementByClassName(String Value) {
		WebElement element = driver.findElement(By.className(Value));
		return element;
	}

	// 26.Find Locator By xpath
	/**
	 * @see findElementByXpath
	 * @param xpathExpression
	 * @return element
	 */
	public WebElement findElementByXpath(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;
	}

	// 27.get All option from dropdown as Text
	/**
	 * @see getText
	 * @param element
	 */
	public void getText(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			webElement.getText();
		}
	}

	// 28.get All option from dropdown as Attribute Value
	/**
	 * @see getAttribute
	 * @param element
	 * @param value
	 * @return attribute
	 */
	public String getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;
	}

	// 29.get All option from dropdown as FirstSelectOption
	/**
	 * @see firstSelectoption
	 * @param element
	 */
	public void firstSelectoption(WebElement element) {
		Select select = new Select(element);
		select.getFirstSelectedOption();
	}

	// 30.dropdown isMultiple select option
	/**
	 * @see isMultiple
	 * @param element
	 * @return multiple
	 */
	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	// 31.Implicity Wait
	/**
	 * @see implicityWait
	 * @param duration
	 */
	public void implicityWait(Duration duration) {
		driver.manage().timeouts().implicitlyWait(duration);
	}

	// 32.Explicit Wait
	/**
	 * @see explicitWait
	 * @param timeout
	 * @return wait
	 */
	public WebDriverWait explicitWait(Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait;
	}

	// 33.Fulent Wait
	/**
	 * @see fulentwait
	 * @param input
	 */
	public void fulentwait(String input) {
		WebDriver wait = (WebDriver) new FluentWait(input);
	}

	// 34.Verify isDisplayed
	/**
	 * @see elementisDisplyed
	 * @param element
	 * @return displayed
	 */
	public boolean elementisDisplyed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	// 35.verify isEnabled
	/**
	 * @see elementisEnabled
	 * @param element
	 * @return enabled
	 */
	public boolean elementisEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	// 36.verify isSelected
	/**
	 * @see elementisSelected
	 * @param element
	 * @return selected
	 */
	public boolean elementisSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	// 37.Deselect by Index
	/**
	 * @see deselectByIndex
	 * @param element
	 * @param index
	 */
	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	// 38.Deselect by Attribute
	/**
	 * @see deselectByAttribute
	 * @param element
	 * @param value
	 */
	public void deselectByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	// 39.Deselect by Text
	/**
	 * @see deselectByVisibleText
	 * @param element
	 * @param text
	 */
	public void deselectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// 40.Deselect by All
	/**
	 * @see deselectByAll
	 * @param element
	 */
	public void deselectByAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	// 41.get the Parent Window
	/**
	 * @see parentWindow
	 * @return windowHandle
	 */
	public String parentWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	// 42.get All Window
	/**
	 * @see allWindow
	 * @return windowHandles
	 */
	public Set<String> allWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	// 43.Clear Textbox
	/**
	 * @see clear
	 * @param element
	 */
	public void clear(WebElement element) {
		element.click();
	}

	// 44.Take Screenshot
	/**
	 * @see takeScreenshot
	 * @return screenshotAs
	 */
	public File takeScreenshot() {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File screenshotAs = ss.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	// 45.Take Screenshot for Element
	/**
	 * @see takeScreenshotElement
	 * @param element
	 * @return screenshotAs
	 */
	public File takeScreenshotElement(WebElement element) {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		return screenshotAs;
	}

	// 46.Mouseover action for Single Option
	/**
	 * @see mouseoverActionSingleOption
	 * @param element
	 * @return moveToElement
	 */
	public Actions mouseoverActionSingleOption(WebElement element) {
		Actions actions = new Actions(driver);
		Actions moveToElement = actions.moveToElement(element);
		return moveToElement;
	}

	// 47.DragAndDrop
	/**
	 * @see dragAndDrop
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target);
	}

	// 48.Right Click
	/**
	 * @see rightClick
	 * @return contextClick
	 */
	public Actions rightClick() {
		Actions actions = new Actions(driver);
		Actions contextClick = actions.contextClick();
		return contextClick;
	}

	// 49.Double Click
	/**
	 * @see doubleClick
	 * @return doubleClick
	 */
	public Actions doubleClick() {
		Actions actions = new Actions(driver);
		Actions doubleClick = actions.doubleClick();
		return doubleClick;
	}

	// 50.Insert value in Textbox and Enter
	/**
	 * @see sendkeysAndEnter
	 * @param element
	 * @param data
	 */
	public void sendkeysAndEnter(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);
	}

	// 51.Refresh Page
	/**
	 * @see refreshPage
	 */
	public void refreshPage() {
		driver.navigate().refresh();
	}

	// 52.Forward to Webpage
	/**
	 * @see forward
	 */
	public void forward() {
		driver.navigate().forward();
	}

	// 53.Back to Webpage
	/**
	 * @see back
	 */
	public void back() {
		driver.navigate().back();
	}

	// 54.Robot using Down
	/**
	 * @see robotKeyEnter
	 * @throws AWTException
	 */
	public void robotKeyEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	// 55.ScrollDown Using JS
	/**
	 * @see scrollDownJs
	 * @param element
	 */
	public void scrollDownJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	// 56.ScrollUp Using JS
	/**
	 * @see scrollUpJs
	 * @param element
	 */
	public void scrollUpJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	// 57.Thread Sleep
	/**
	 * @see threadSleep
	 * @param seconds
	 * @throws InterruptedException
	 */
	public void threadSleep(long seconds) throws InterruptedException {
		Thread.sleep(seconds);
	}

	// 58.Text from Alert
	/**
	 * @see alertText
	 * @return text
	 */
	public String alertText() {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	// 59.Dropdown All Select Option
	/**
	 * @see allSelect
	 * @param element
	 * @return allSelectedOptions
	 */
	public List<WebElement> allSelect(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	// 60.get Webpage Source
	/**
	 * @see webpageSource
	 * @return pageSource
	 */
	public Object webpageSource() {
		String pageSource = driver.getPageSource();
		return pageSource;
	}

	// 61.getProjectPath
	/**
	 * @see getProjectPath
	 * @return path
	 */
	public static String getProjectPath() {

		String path = System.getProperty("user.dir");
		return path;
	}

	// 62.getPropertyFileValue
	/**
	 * @see getPropertyFileValue
	 * @param key
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	public static String getPropertyFileValue(String key) throws Exception, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}

	// 63.getDrivers
	/**
	 * @see getDrivers
	 * @param browserType
	 */
	public void getDrivers(String browserType) {

		WebDriver driver;

		switch (browserType) {

		case "chrome":

			driver = new ChromeDriver();
			break;
		case "firefox":

			driver = new FirefoxDriver();
			break;
		case "ie":

			driver = new InternetExplorerDriver();
			break;

		case "edge":

			driver = new EdgeDriver();
			break;

		default:
			break;
		}

	}

	// 64 Robot
	/**
	 * @see roboyKeyEnter
	 * @throws AWTException
	 */
	private void roboyKeyEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}