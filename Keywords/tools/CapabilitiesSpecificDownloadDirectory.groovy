package tools

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.Files
import java.io.File
import internal.GlobalVariable


public class CapabilitiesSpecificDownloadDirectory {
	/**
	 * Executes before every test case starts.
	 */
	@Keyword
	def SetSpecificDownloadDirectoryIfNeeded() {

		GlobalVariable.downloadPath =RunConfiguration.getProjectDir()+ "/Data Files/Downloads/"
		Map desiredCapabilities = RunConfiguration.getDriverPreferencesProperties("WebUI")
		String projectDir = RunConfiguration.getProjectDir()+ "/Data Files/Downloads/"
		Path projectPath = Paths.get(projectDir)
		Path downloadPath = projectPath.resolve(GlobalVariable.downloadPath)
		def customizedDownloadDirectory = downloadPath.toString()

		Map prefs = desiredCapabilities.get("prefs")
		if (prefs == null) {
			prefs = [:]
		}
		KeywordUtil.logInfo("BeforeTc3SetSpecificDownloadDirectoryIfNeeded: We detected test name contains \"download\" so we get current desiredCapabilities prefs =" + prefs.toString())
		KeywordUtil.logInfo("BeforeTc3SetSpecificDownloadDirectoryIfNeeded: ...and set desiredCapabilities to work with a customized download directory = RunConfiguration.getProjectDir() + / + GlobalVariable.downloadPath = : $customizedDownloadDirectory")
		prefs.put("download.default_directory", customizedDownloadDirectory)
		prefs.put("download_dir", customizedDownloadDirectory)
		prefs.put("download.prompt_for_download", false)
		prefs.put("profile.default_content_settings.popups", "0")

		RunConfiguration.setWebDriverPreferencesProperty("prefs", prefs)
		RunConfiguration.setWebDriverPreferencesProperty("args", [
			"--no-sandbox",
			"--start-maximized",
			"--incognito",
			"--disable-popup-blocking",
			"--disable-extensions",
			"--disable-gpu",
			"--remote-allow-origins=*",
			"--test-type",
			"--disable-dev-shm-usage"
		])
		RunConfiguration.setWebDriverPreferencesProperty("useAutomationExtension", "false")
	}
}


