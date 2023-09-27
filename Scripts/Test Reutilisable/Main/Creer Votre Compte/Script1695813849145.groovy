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
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.exception.StepErrorException;
import com.kms.katalon.core.exception.StepFailedException;
import com.kms.katalon.core.logging.ErrorCollector;
import com.kms.katalon.core.logging.KeywordLogger;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;


/** modify WebUI.* keywords which take TestObject as arg0
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()

' Cliquer sur le lien Se Connecter :'
 WebUI.click(findTestObject('Object Repository/Connexion Usager/Link_Se Connecter'))

" Appel de l'action Réutilisable pour contourner l'erreur lié à la confidentialité"
WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Erreur lie a la confidentialite'), [:], FailureHandling.STOP_ON_FAILURE)

"Première visite? Créez votre compte :"
WebUI.click(findTestObject('Object Repository/Connexion Usager/Link_Creer Votre Compte'))
println ("NumEtrangerVisa = "+ NumEtrangerVisa)
"Fournir Le Numéro de votre visa ou votre numéro étranger :"
WebUI.setText(findTestObject('Object Repository/Connexion Usager/Input_Numero étranger_Visa'), NumEtrangerVisa)

" Fournir La Date de début de validité :"
GlobalVariable.DateDebut=  DateDebut
def DateDébut = CustomKeywords.'tools.MyStringTools.ParsedDateDébut'()
ParsedDateDébut = CustomKeywords.'tools.MyStringTools.ParsedDateDébut'()
WebUI.setText(findTestObject('Object Repository/Connexion Usager/Date Debut Validite/Input_Jour'), ParsedDateDébut[0])
WebUI.selectOptionByIndex(findTestObject('Object Repository/Connexion Usager/Date Debut Validite/Select_Mois'), ParsedDateDébut[1])
WebUI.setText(findTestObject('Object Repository/Connexion Usager/Date Debut Validite/Input_Annee'), ParsedDateDébut[2])

" Fournir La Date de fin de validité :"
GlobalVariable.DateFin=  DateFin
def DateFin = CustomKeywords.'tools.MyStringTools.ParsedDateFin'()
ParsedDateFin = CustomKeywords.'tools.MyStringTools.ParsedDateFin'()
WebUI.setText(findTestObject('Object Repository/Connexion Usager/Date Fin Validite/Input_Jour'), ParsedDateFin[0])
WebUI.selectOptionByIndex(findTestObject('Object Repository/Connexion Usager/Date Fin Validite/Select_Mois'), ParsedDateFin[1])
WebUI.setText(findTestObject('Object Repository/Connexion Usager/Date Fin Validite/Input_Annee'), ParsedDateFin[2])

"Validation de la page pour la création du compte :"
WebUI.click(findTestObject('Object Repository/Connexion Usager/Btn_Creer Un Compte'))

/*************************************************************************************/
'Vérification si le compte existe déjà(message Erreur : Il semblerait que vos informations soient déjà associées à un compte.)'
' Exit Action ou on passe à la création'

MsgAlertPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/Connexion Usager/Verif_PopUpCompteExisteDeja'), 1, FailureHandling.OPTIONAL)
if(MsgAlertPresent){
	
	alertText = WebUI.getText(findTestObject('Object Repository/Connexion Usager/Verif_PopUpCompteExisteDeja'),FailureHandling.OPTIONAL)
	//KeywordUtil.markFailed(alertText)
	KeywordUtil.markFailedAndStop(alertText)
	}
else {
	KeywordUtil.markPassed("Vos informations ne sont pas associées à un compte ==>> Création d'un nouveau Compte avec ces Informations.")
}

/*************************************************************************************/

	
" Création de Email utilisateur"
def MonEmail = NumEtrangerVisa + '@yopmail.com'
WebUI.delay(2)
WebUI.setText(findTestObject('Object Repository/Connexion Usager/Input_Email'), MonEmail)
WebUI.setText(findTestObject('Object Repository/Connexion Usager/Input_ConfirmeEmail'), MonEmail)
WebUI.click(findTestObject('Object Repository/Connexion Usager/span_btn_ValiderEmail'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Connexion Usager/btn_span_RetourAccueil'))
WebUI.delay(2)

/**Ecouter les évennement NetWork et page
 * concatination URL création PW
 * */
'Delete all cookies after browser is opened'
// wait for socket connection to close
CustomKeywords.'tools.EventsNetWorkChromeConsole.RegisterListender'(true, true)
CustomKeywords.'tools.EventsNetWorkChromeConsole.ResetDataCollection'()
CustomKeywords.'tools.EventsNetWorkChromeConsole.GetRequestString'(true)


'Navigation à URL Création MDP'
String URL_CreationMDP = GlobalVariable.URLpw + GlobalVariable.Token
WebUI.navigateToUrl(URL_CreationMDP)

'Vérification de la conformité du nouveau MDP'
WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Verif_FormatNewPW'), [:], FailureHandling.STOP_ON_FAILURE)

'Renseigner PDM Valide'
WebUI.setEncryptedText(findTestObject('Object Repository/Connexion Usager/Input_Password'), GlobalVariable.Password)
WebUI.setEncryptedText(findTestObject('Object Repository/Connexion Usager/Input_ConfirmePassword'), GlobalVariable.Password)
WebUI.click(findTestObject('Object Repository/Connexion Usager/btn_CreerMDP'))
WebUI.click(findTestObject('Object Repository/Connexion Usager/btn_span_RetourAccueil'))
//WebUI.deleteAllCookies()
CustomKeywords.'tools.EventsNetWorkChromeConsole.InitializeWebDriveDeleteAllCookies'()
