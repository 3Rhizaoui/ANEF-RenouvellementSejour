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
import com.github.kklisura.cdt.launch.ChromeLauncher;
import com.github.kklisura.cdt.protocol.commands.Page;
import com.github.kklisura.cdt.protocol.types.page.PrintToPDF;
import com.github.kklisura.cdt.protocol.types.page.PrintToPDFTransferMode;
import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.github.kklisura.cdt.services.ChromeService;
import com.github.kklisura.cdt.services.factory.impl.DefaultWebSocketContainerFactory;
import com.github.kklisura.cdt.services.types.ChromeTab;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.net.URI
import org.eclipse.jetty.websocket.client.WebSocketClient
import org.eclipse.jetty.websocket.client.WebSocketUpgradeRequest
import java.util.concurrent.TimeUnit
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import internal.GlobalVariable


public class CapabilitiesSpecificDownloadDirectory {
	/**
	 * Executes before every test case starts.
	 * --remote-allow-origins=*
	 *  * "--no-sandbox",
	 "--start-maximized",
	 "--incognito",
	 "--disable-popup-blocking",
	 "--disable-extensions",
	 "--disable-gpu",
	 "--remote-allow-origins=*",
	 "--test-type",
	 "--disable-dev-shm-usage"
	 */
	@Keyword
	def SetSpecificDownloadDirectoryIfNeeded() {
		// Init standard WebDrive Chrome session Capabilities Specific for Download Directory
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
		//prefs.put("profile.default_content_settings.popups", "0")

		RunConfiguration.setWebDriverPreferencesProperty("prefs", prefs)
		RunConfiguration.setWebDriverPreferencesProperty("args", ["--start-maximized", "--remote-debugging-port=9222", "--incognito", "--remote-allow-origins=*", "--no-sandbox", "--start-maximized"])
		RunConfiguration.setWebDriverPreferencesProperty("useAutomationExtension", "true")

		// Set the incoming buffer to 24MB For hromeDevtools client
		System.setProperty(DefaultWebSocketContainerFactory.WEBSOCKET_INCOMING_BUFFER_PROPERTY,Long.toString((long) DefaultWebSocketContainerFactory.MB * 100));
		// Utilisation de l'adresse IP à la place de localhost
		java.net.InetAddress i = java.net.InetAddress.getLocalHost();
		System.out.println(i.getHostAddress());

		// Init ChromeDevtools client
		// WebSocketService webSocketService = WebSocketServiceImpl.create(new URI(String.format("ws://"+ i.getHostAddress() + ":4444/devtools/%s/page", driver.getSessionId())));
		//CommandInvocationHandler commandInvocationHandler = new CommandInvocationHandler();
		//Map<Method, Object> commandsCache = new ConcurrentHashMap<>();
		//devtools = ProxyUtils.createProxyFromAbstract( (ChromeDevToolsServiceImpl.class), (new Class[] {WebSocketService.class), (ChromeDevToolsServiceConfiguration.class}), (new Object[] {webSocketService, new ChromeDevToolsServiceConfiguration()}), ((unused, method, args) -> commandsCache.computeIfAbsent(method, key ->{Class<?> returnType = method.getReturnType(); return ProxyUtils.createProxy(returnType, commandInvocationHandler)})))
		//commandInvocationHandler.setChromeDevToolsService(devtools);// JavaScript Document
	}
}


