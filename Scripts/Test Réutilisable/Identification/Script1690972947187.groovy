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

// Cliquer sur le lien Se Connecter :
WebUI.click(findTestObject('Object Repository/Connexion/Link_Se Connecter'))

// Appel de l'action Réutilisable pour contourner l'erreur lié à la confidentialité
WebUI.callTestCase(findTestCase('Test Réutilisable/Erreur lié à la confidentialité'), [:], FailureHandling.STOP_ON_FAILURE)

// Renseigner l'Identifiant et le mot de passe :
WebUI.setText(findTestObject('Object Repository/Connexion/Input_Identifiant'), GlobalVariable.NumEtrangerVisa)
WebUI.setText(findTestObject('Object Repository/Connexion/Input_MDP'), GlobalVariable.Password)
WebUI.click(findTestObject('Object Repository/Connexion/btn_Sidentifier'))

// Vérification position sur la page d'accueil'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Accueil/Span_MesNotifications'), 2, FailureHandling.STOP_ON_FAILURE)
