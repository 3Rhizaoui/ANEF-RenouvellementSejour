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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.testng.Assert as Assert
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/**** Vérification de la présence de Message de Confirmation :
 * Votre demande a bien été enregistrée et vous allez recevoir un accusé de réception. 
 */

//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Confirmation_Usager/p_MessageDeConfirmationDemandeEnregistree'), 5)
//WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Confirmation_Usager/p_MessageDeConfirmationDemandeEnregistree'), 20)

WebUI.click(findTestObject('Object Repository/Page_Confirmation_Usager/Btn_OuvrirMaConfirmationDeDépôtDeDemande(PDF)'))

/*Ecouter les évennement NetWork et page
 * concatination URL création PW
 */ 
CustomKeywords.'tools.EventsNetWorkChromeConsole.RegisterListender'(true, true)
CustomKeywords.'tools.EventsNetWorkChromeConsole.ResetDataCollection'()
CustomKeywords.'tools.EventsNetWorkChromeConsole.GetRequestString'(true)
CustomKeywords.'tools.EventsNetWorkChromeConsole.ResetDataCollection'()
