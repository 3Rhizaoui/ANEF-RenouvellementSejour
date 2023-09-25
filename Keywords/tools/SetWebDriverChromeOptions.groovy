package tools

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.UnexpectedAlertBehaviour as UnexpectedAlertBehaviour
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.remote.CapabilityType as CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebDriver
import internal.GlobalVariable as GlobalVariable



public class SetWebDriverChromeOptions  {
	public WebDriver setChromeOptions(){

		ChromeOptions options = new ChromeOptions();
		String downloadPath = RunConfiguration.getProjectDir() + "/Data Files/Downloads"
		//String downloadPath = folder.getAbsolutePath()
		//String downloadsPath = System.getProperty("user.home") + "/Downloads";
		println ("downloadpath "+downloadPath)

		Map<String, Object> chromePrefs = new HashMap<String, Object>()
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath)
		chromePrefs.put("download.prompt_for_download", false)
		chromePrefs.put("plugins.plugins_disabled", "Chrome PDF Viewer");
		options.addArguments("--headless")
		options.addArguments("--window-size=1920,1080")
		options.addArguments("--test-type")
		options.addArguments("--disable-gpu")
		options.addArguments("--no-sandbox")
		options.addArguments("--disable-dev-shm-usage")
		options.addArguments("--disable-software-rasterizer")
		options.addArguments("--disable-popup-blocking")
		options.addArguments("--disable-extensions")
		options.setExperimentalOption("prefs", chromePrefs)
		DesiredCapabilities cap = DesiredCapabilities.chrome()
		cap.setCapability(ChromeOptions.CAPABILITY, options)
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
		WebDriver driver = new ChromeDriver(cap);
		driver.navigate(GlobalVariable.URL_ANEFQualif)
		//WebUI.navigateToUrl(GlobalVariable.URL_ANEFQualif)
		return driver

	}
}
