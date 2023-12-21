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
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElements
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import org.openqa.selenium.By
import internal.GlobalVariable
import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.configuration.RunConfiguration
import groovy.json.JsonOutput as JsonOutput
import groovy.json.JsonSlurper as JsonSlurper
import java.io.File
/** modify WebUI.* keywords which take TestObject as arg0
 * 
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()

//WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Lancer URL ANEF'), ['Portail':'Agent'], FailureHandling.STOP_ON_FAILURE)
//WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Identification'), ['Portail':'Agent'], FailureHandling.STOP_ON_FAILURE)
'Ouvrir App-Header Account-Menu pour positionner la bonne Habilitation'
WebUI.click(findTestObject('Object Repository/Page_ConnexionPositionnementSiteDeTraitement_Agent/div_App-HeaderAccount-Menu'))
WebUI.click(findTestObject('Object Repository/Page_ConnexionPositionnementSiteDeTraitement_Agent/span_habilitation'))
//WebUI.click(findTestObject('Object Repository/Page_ConnexionPositionnementSiteDeTraitement_Agent/span_habilitation'))

/**Vérification De la PopUp Afficher Habilitation
 *
 */
TestObject PopUpHabilitations =findTestObject('Object Repository/Page_ConnexionPositionnementSiteDeTraitement_Agent/span_PopupHabilitations')
WebUI.verifyElementPresent(PopUpHabilitations, 1)
String TitrePopUpAfficherCommentaires = WebUI.getText(PopUpHabilitations)
if(!TitrePopUpAfficherCommentaires.contains('HABILITATIONS')) {
	KeywordUtil.markFailed("Vérifier le titre de PopUp HABILITATIONS.")}
else {KeywordUtil.markPassed("Le Titre de PopUp est bien Affiché : HABILITATIONS.")}

'Choisir le site de traitement pour les renouvellement pour Etudiants et Visiteurs'
if(((GlobalVariable.TypeTitreDeSejour)== "RenouvellementDeTitreSéjour") || ((GlobalVariable.TypeTitreDeSejour)== "Visiteur")) {
	TestObject RoleEncadreurSite7701 =findTestObject('Object Repository/Page_ConnexionPositionnementSiteDeTraitement_Agent/CheckBox_RoleEncadreurSite7701')
	WebUI.verifyElementPresent(RoleEncadreurSite7701, 1)
	TestObject ValiderHabilitations =findTestObject('Object Repository/Page_ConnexionPositionnementSiteDeTraitement_Agent/btn_Habilitations_Valider')
	WebUI.verifyElementPresent(ValiderHabilitations, 1)
	WebUI.click(RoleEncadreurSite7701)
	WebUI.delay(3)
	def boolean  Disabled= WebUI.getAttribute(ValiderHabilitations,'disabled')
	WebUI.delay(3)
	if (Disabled == false) {
		WebUI.click(RoleEncadreurSite7701)
		TestObject ValiderHabilitation = findTestObject('Object Repository/Page_ConnexionPositionnementSiteDeTraitement_Agent/ValiderHabilitation')
		WebUI.click(ValiderHabilitation)}
	else {
		TestObject AnnulerHabilitations =findTestObject('Object Repository/Page_ConnexionPositionnementSiteDeTraitement_Agent/btn_Habilitations_Annuler')
		WebUI.verifyElementPresent(AnnulerHabilitations, 1)
		WebUI.click(AnnulerHabilitations)
		WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/span_DemandeDeTitreDeSejour'))
		WebUI.delay(3)}
}


'Choisr le site de traitement pour les Passeports Talents'
if ((GlobalVariable.TypeTitreDeSejour)== "TS-PT-SalariéQualifié") {
	TestObject RoleEncadreurSite7704 =findTestObject('Object Repository/Page_ConnexionPositionnementSiteDeTraitement_Agent/CheckBox_RoleEncadrementSite7704')
	WebUI.verifyElementPresent(RoleEncadreurSite7704, 1)
	if (WebUI.verifyElementNotChecked(RoleEncadreurSite7704, 5)) {
		WebUI.click(RoleEncadreurSite7704)
		TestObject ValiderHabilitations =findTestObject('Object Repository/Page_ConnexionPositionnementSiteDeTraitement_Agent/btn_Habilitations_Valider')
		WebUI.verifyElementPresent(ValiderHabilitations, 1)
		WebUI.click(ValiderHabilitations)}
	else {
		TestObject AnnulerHabilitations =findTestObject('Object Repository/Page_ConnexionPositionnementSiteDeTraitement_Agent/btn_Habilitations_Annuler')
		WebUI.verifyElementPresent(AnnulerHabilitations, 1)
		WebUI.click(AnnulerHabilitations)}
}

	WebUI.delay(5)

