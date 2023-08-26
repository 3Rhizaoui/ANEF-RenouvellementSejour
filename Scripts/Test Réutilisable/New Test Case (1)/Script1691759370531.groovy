import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.github.kklisura.cdt.protocol.commands.Fetch as Fetch
import com.github.kklisura.cdt.protocol.commands.Page as Page
import com.github.kklisura.cdt.services.ChromeDevToolsService as ChromeDevToolsService
import com.katalon.cdp.CdpUtils as CdpUtils
import com.kms.katalon.core.util.internal.Base64 as Base64
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.github.kklisura.cdt.launch.ChromeLauncher as ChromeLauncher
import com.github.kklisura.cdt.protocol.commands.Network as Network
import com.github.kklisura.cdt.services.ChromeService as ChromeService
import com.github.kklisura.cdt.services.types.ChromeTab as ChromeTab
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities as DesiredCapabilities
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.remote.CapabilityType as CapabilityType
import com.kms.katalon.core.annotation.Keyword as Keyword
import io.netty.handler.codec.http.HttpRequest as HttpRequest
import io.netty.handler.codec.http.HttpResponse as HttpResponse
import net.lightbody.bmp.BrowserMobProxyServer as BrowserMobProxyServer
import net.lightbody.bmp.client.ClientUtil as ClientUtil
import net.lightbody.bmp.filters.RequestFilter as RequestFilter
import net.lightbody.bmp.filters.ResponseFilter as ResponseFilter
import net.lightbody.bmp.util.HttpMessageContents as HttpMessageContents
import net.lightbody.bmp.util.HttpMessageInfo as HttpMessageInfo
import net.lightbody.bmp.proxy.CaptureType as CaptureType
import com.github.kklisura.cdt.protocol.types.network.RequestPattern as RequestPattern
import java.util.Collections as Collections
import java.util.HashMap as HashMap
import java.util.Map as Map
import com.github.kklisura.cdt.protocol.events.fetch.AuthRequired as AuthRequired
import com.github.kklisura.cdt.protocol.events.fetch.RequestPaused as RequestPaused
import com.github.kklisura.cdt.protocol.support.annotations.EventName as EventName
import com.github.kklisura.cdt.protocol.support.annotations.Optional as Optional
import com.github.kklisura.cdt.protocol.support.annotations.ParamName as ParamName
import com.github.kklisura.cdt.protocol.support.annotations.Returns as Returns
import com.github.kklisura.cdt.protocol.support.types.EventHandler as EventHandler
import com.github.kklisura.cdt.protocol.support.types.EventListener as EventListener
import com.github.kklisura.cdt.protocol.types.fetch.AuthChallengeResponse as AuthChallengeResponse
import com.github.kklisura.cdt.protocol.types.fetch.HeaderEntry as HeaderEntry
import com.github.kklisura.cdt.protocol.types.fetch.RequestPattern as RequestPattern
import com.github.kklisura.cdt.protocol.types.fetch.ResponseBody as ResponseBody
import com.github.kklisura.cdt.protocol.types.network.ErrorReason as ErrorReason
import java.util.List as List

/*
ChromeOptions options = new ChromeOptions();
System.setProperty("webdriver.chrome.driver", "C:/Users/hhizaoui/Desktop/Formation Katalon/Katalon_Studio_Windows_64-8.6.5/configuration/resources/drivers/chromedriver_win32/chromedriver.exe");

options.addArguments("--remote-allow-origins=*");
WebDriver driver = new ChromeDriver(options);
driver.navigate().to('https://qualif.administration-etrangers-en-france.interieur.gouv.fr/particuliers/#/');
*/
//Lancer un navigateur avec l'URL de l'application ANEF :
WebUI.openBrowser('')

WebUI.closeBrowser()

WebUI.openBrowser('')

WebUI.navigateToUrl('https://qualif.administration-etrangers-en-france.interieur.gouv.fr/particuliers/#/')

WebUI.click(findTestObject('Object Repository/Page_trangers en France  Accueil/a_SE CONNECTER'))

WebUI.click(findTestObject('Object Repository/Page_Se connecter  trangers en France/a_Premire visite  Crer votre compte'))

WebUI.setText(findTestObject('Object Repository/Page_trangers en France  Se connecter ou cr_191992/input_Exemple  9999999999_900a94e4-a0b9-c7a_dc1c0d'), 
    '7703039392')

WebUI.setText(findTestObject('Object Repository/Page_trangers en France  Se connecter ou cr_191992/input_Jour_ng-untouched ng-pristine ng-valid'), 
    '1')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_trangers en France  Se connecter ou cr_191992/select_Mois Janvier  Fvrier  Mars  Avril  M_d1607b'), 
    'Mois', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_trangers en France  Se connecter ou cr_191992/select_Mois Janvier  Fvrier  Mars  Avril  M_d1607b'), 
    '1', true)

WebUI.setText(findTestObject('Object Repository/Page_trangers en France  Se connecter ou cr_191992/input_Anne_ng-untouched ng-pristine ng-valid'), 
    '2022')

WebUI.setText(findTestObject('Object Repository/Page_trangers en France  Se connecter ou cr_191992/input_Jour_ng-untouched ng-pristine ng-valid'), 
    '31')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_trangers en France  Se connecter ou cr_191992/select_Mois Janvier  Fvrier  Mars  Avril  M_d1607b'), 
    'Mois', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_trangers en France  Se connecter ou cr_191992/select_Mois Janvier  Fvrier  Mars  Avril  M_d1607b'), 
    '12', true)

WebUI.setText(findTestObject('Object Repository/Page_trangers en France  Se connecter ou cr_191992/input_Anne_ng-untouched ng-pristine ng-valid'), 
    '2022')

WebUI.click(findTestObject('Object Repository/Page_trangers en France  Se connecter ou cr_191992/span_Crer un compte'))

WebUI.setText(findTestObject('Object Repository/Page_trangers en France  Se connecter/input_Exemple  9999999999_ef8f9cb9-8c23-1bc_d05766'), 
    'hafedh.hizaoui@gmail.com')

WebUI.setText(findTestObject('Object Repository/Page_trangers en France  Se connecter/input__5a4bdcee-dc2b-281a-d620-0208f5939b31'), 
    'hafedh.hizaoui@gmail.com')

WebUI.click(findTestObject('Object Repository/Page_trangers en France  Se connecter/span_Valider'))

WebUI.click(findTestObject('Object Repository/Page_trangers en France  Se connecter/p-header_CRATION DE COMPTE'))

WebUI.click(findTestObject('Object Repository/Page_trangers en France  Se connecter/span_Retour  laccueil'))

