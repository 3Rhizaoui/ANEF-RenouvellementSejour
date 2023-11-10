package tools

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.InputEvent
import java.awt.event.KeyEvent
import org.openqa.selenium.Capabilities
import org.openqa.selenium.Dimension
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.remote.RemoteWebDriver
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.SmartWaitWebDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import groovy.transform.CompileStatic
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.*;

public class 	UploadMyFile {
	
	static int timeoutSecond = 60
	static int timeoutMilisecond = 1000

	/**
	 * Upload file using robot.
	 *
	 * @param object The object from which we can click to choose files.
	 * @param file The full path of the file that needs to upload.
	 */
	@CompileStatic
	@Keyword
	public void uploadFileUsingRobot(TestObject object, String file) {
		WebDriver driver = DriverFactory.getWebDriver()
		Capabilities caps = ((SmartWaitWebDriver) driver).getCapabilities()
		String browserName = caps.getBrowserName().capitalize()

		//if (browserName.toLowerCase().equals("firefox")){
		//	clickJS(object, driver);
		//}
//		else {
//			try {
				WebUiBuiltInKeywords.click(object)
//			}
//			catch (Exception e) {
//				clickJS(object, driver);
//			}
//		}
		Robot robot = new Robot()
		//StringSelection path = new StringSelection(file)
		//println path
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null)
		setClipboardData(file);
		robot.setAutoDelay(timeoutMilisecond)
		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_CONTROL)
		robot.keyRelease(KeyEvent.VK_V)
		robot.setAutoDelay(timeoutMilisecond)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
	}
	
	/**
	 * Upload file using robot.
	 *
	 * @param object The object from which we can click to choose files.
	 * @param file The full path of the file that needs to upload.
	 */
	@CompileStatic
	@Keyword
	//First of all declare the method setClipboardData as below:
	public void setClipboardData(String string) {
			StringSelection stringSelection = new StringSelection(string);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}

	/**
	 * Upload file.
	 *
	 * @param object The object from which we can click to choose files.
	 * @param file The full path of the file that needs to upload.
	 */
	@CompileStatic
	@Keyword
	public void uploadMyFile(TestObject object, String file) {
		WebUiBuiltInKeywords.uploadFile(object, file)
	}

	private clickJS(TestObject object, WebDriver driver) {
		WebElement element = WebUiCommonHelper.findWebElement(object, timeoutSecond)
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element)
	}
}
