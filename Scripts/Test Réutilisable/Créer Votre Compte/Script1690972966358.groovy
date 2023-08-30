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

//Première visite? Créez votre compte :
WebUI.click(findTestObject('Object Repository/Connexion/Link_Créer Votre Compte'))

//Fournir Le Numéro de votre visa ou votre numéro étranger :
WebUI.setText(findTestObject('Object Repository/Connexion/Input_Numéro étranger_Visa'), GlobalVariable.NumEtrangerVisa)

// Fournir La Date de début de validité :
def DateDébut = CustomKeywords.'tools.MyStringTools.ParsedDateDébut'()
ParsedDateDébut = CustomKeywords.'tools.MyStringTools.ParsedDateDébut'()
WebUI.setText(findTestObject('Object Repository/Connexion/Date Début Validité/Input_Jour'), ParsedDateDébut[0])
WebUI.selectOptionByIndex(findTestObject('Object Repository/Connexion/Date Début Validité/Select_Mois'), ParsedDateDébut[1])
WebUI.setText(findTestObject('Object Repository/Connexion/Date Début Validité/Input_Année'), ParsedDateDébut[2])

// Fournir La Date de fin de validité :
def DateFin = CustomKeywords.'tools.MyStringTools.ParsedDateFin'()
ParsedDateFin = CustomKeywords.'tools.MyStringTools.ParsedDateFin'()
WebUI.setText(findTestObject('Object Repository/Connexion/Date Fin Validité/Input_Jour'), ParsedDateFin[0])
WebUI.selectOptionByIndex(findTestObject('Object Repository/Connexion/Date Fin Validité/Select_Mois'), ParsedDateFin[1])
WebUI.setText(findTestObject('Object Repository/Connexion/Date Fin Validité/Input_Année'), ParsedDateFin[2])

// Validation de la page pour la création du compte :
WebUI.click(findTestObject('Object Repository/Connexion/Btn_Créer Un Compte'))

// Création de Email utilisateur
def MonEmail = GlobalVariable.NumEtrangerVisa + '@yopmail.com'
println('MonEmail = ' + MonEmail)
WebUI.delay(5)
WebUI.setText(findTestObject('Object Repository/Connexion/Input_Email'), MonEmail)
WebUI.setText(findTestObject('Object Repository/Connexion/Input_ConfirmeEmail'), MonEmail)
WebUI.click(findTestObject('Object Repository/Connexion/span_btn_ValiderEmail'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Connexion/btn_span_RetourAccueil'))
WebUI.delay(5)
/*Ecouter les évennement NetWork et page
 * concatination URL création PW
 * */
CustomKeywords.'tools.EventsNetWorkChromeConsole.RegisterListender'(true, true)
CustomKeywords.'tools.EventsNetWorkChromeConsole.ResetDataCollection'()
CustomKeywords.'tools.EventsNetWorkChromeConsole.GetRequestString'(true)
CustomKeywords.'tools.EventsNetWorkChromeConsole.ResetDataCollection'()
//Navigation à URL Création MDP
String URL_CreationMDP = GlobalVariable.URLpw + GlobalVariable.Token
println('URL_CreationMDP = ' + URL_CreationMDP)
WebUI.navigateToUrl(URL_CreationMDP)

// Vérification de la conformité du nouveau MDP
WebUI.callTestCase(findTestCase('Test Réutilisable/Vérif_FormatNewPW'), [:], FailureHandling.STOP_ON_FAILURE)

// Renseigner PDM Valide
WebUI.setText(findTestObject('Object Repository/Connexion/Input_Password'), GlobalVariable.Password)
WebUI.setText(findTestObject('Object Repository/Connexion/Input_ConfirmePassword'), GlobalVariable.Password)
WebUI.click(findTestObject('Object Repository/Connexion/btn_CréerMDP'))
WebUI.click(findTestObject('Object Repository/Connexion/btn_span_RetourAccueil'))
  
