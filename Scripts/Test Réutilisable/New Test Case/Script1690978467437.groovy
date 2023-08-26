import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.github.kklisura.cdt.protocol.commands.Fetch as Fetch
import com.github.kklisura.cdt.protocol.commands.Page as Page
import com.github.kklisura.cdt.services.ChromeDevToolsService as ChromeDevToolsService
import com.github.kklisura.cdt.launch.ChromeLauncher;
import com.github.kklisura.cdt.protocol.commands.Network;
import com.github.kklisura.cdt.protocol.commands.Page;
import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.github.kklisura.cdt.services.ChromeService;
import com.github.kklisura.cdt.services.types.ChromeTab;
import com.katalon.cdp.CdpUtils as CdpUtils
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.util.internal.Base64 as Base64
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.annotation.Keyword
import io.netty.handler.codec.http.HttpRequest
import io.netty.handler.codec.http.HttpResponse
import net.lightbody.bmp.BrowserMobProxyServer
import net.lightbody.bmp.client.ClientUtil
import net.lightbody.bmp.filters.RequestFilter as RequestFilter
import net.lightbody.bmp.filters.ResponseFilter as ResponseFilter
import net.lightbody.bmp.util.HttpMessageContents
import net.lightbody.bmp.util.HttpMessageInfo
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;

/*
ChromeOptions options = new ChromeOptions();
System.setProperty("webdriver.chrome.driver", "C:/Users/hhizaoui/Desktop/Formation Katalon/Katalon_Studio_Windows_64-8.6.5/configuration/resources/drivers/chromedriver_win32/chromedriver.exe");

options.addArguments("--remote-allow-origins=*");
WebDriver driver = new ChromeDriver(options);
driver.navigate().to('https://qualif.administration-etrangers-en-france.interieur.gouv.fr/particuliers/#/');
*/
//Lancer un navigateur avec l'URL de l'application ANEF :

WebUI.openBrowser('https://qualif.administration-etrangers-en-france.interieur.gouv.fr/particuliers/#/')
WebUI.maximizeWindow()

// Appel de l'action Réutilisable pour contourner l'erreur lié à la confidentialité
WebUI.callTestCase(findTestCase('Test Réutilisable/Erreur lié à la confidentialité'), [:], FailureHandling.STOP_ON_FAILURE)

//Vérification de l'étape :
WebUI.verifyElementVisible(findTestObject('Object Repository/Connexion/Link_Se Connecter'), FailureHandling.STOP_ON_FAILURE)


/*********************************************************/

// Cliquer sur le lien Se Connecter :
WebUI.click(findTestObject('Object Repository/Connexion/Link_Se Connecter'))

// Appel de l'action Réutilisable pour contourner l'erreur lié à la confidentialité
WebUI.callTestCase(findTestCase('Test Réutilisable/Erreur lié à la confidentialité'), [:], FailureHandling.STOP_ON_FAILURE)

// Renseigner l'Identifiant et le mot de passe :
WebUI.setText(findTestObject('Object Repository/Connexion/Input_Identifiant'), '765736576513765732')
WebUI.setText(findTestObject('Object Repository/Connexion/Input_MDP'), 'password')


/*********************************************************/


//Première visite? Créez votre compte :
WebUI.click(findTestObject('Object Repository/Connexion/Link_Créer Votre Compte'))

//Fournir Le Numéro de votre visa ou votre numéro étranger :
WebUI.setText(findTestObject('Object Repository/Connexion/Input_Numéro étranger_Visa'), GlobalVariable.NumEtrangerVisa)

// Fournir La Date de début de validité :
WebUI.setText(findTestObject('Object Repository/Connexion/Date Début Validité/Input_Jour'), '01')
WebUI.selectOptionByIndex(findTestObject('Object Repository/Connexion/Date Début Validité/Select_Mois'), 1)
WebUI.setText(findTestObject('Object Repository/Connexion/Date Début Validité/Input_Année'), '2022')

// Fournir La Date de fin de validité :
WebUI.setText(findTestObject('Object Repository/Connexion/Date Fin Validité/Input_Jour'), '31')
WebUI.selectOptionByIndex(findTestObject('Object Repository/Connexion/Date Fin Validité/Select_Mois'), 12)
WebUI.setText(findTestObject('Object Repository/Connexion/Date Fin Validité/Input_Année'), '2022')

// Validation de la page pour la création du compte :
WebUI.click(findTestObject('Object Repository/Connexion/Btn_Créer Un Compte'))
/*********************************************************/

/*listen to Network and listen to the page trigger 
 * Create URL For PW
 * */
CustomKeywords.'tools.EventsNetWorkChromeConsole.RegisterListender'(true, true)
CustomKeywords.'tools.EventsNetWorkChromeConsole.WaitForRequestData'()
CustomKeywords.'tools.EventsNetWorkChromeConsole.GetRequestString'(true)




