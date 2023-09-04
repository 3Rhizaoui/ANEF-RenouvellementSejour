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

WebUI.callTestCase(findTestCase('Test Réutilisable/Lancer URL ANEF'), ['Portail':'Usager'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Réutilisable/Créer Votre Compte'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Test Réutilisable/Identification'), ['Portail':'Usager'], FailureHandling.STOP_ON_FAILURE)



WebUI.callTestCase(findTestCase('Test Réutilisable/DemandeOuRenouvelle_TitreSéjour/DemandeOuRenouvelleTitreSejour'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Réutilisable/DemandeOuRenouvelle_TitreSéjour/FormulaireTypeDeTitreDeSéjour'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Réutilisable/DemandeOuRenouvelle_TitreSéjour/FormulaireInformationsPersonnelles'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Réutilisable/DemandeOuRenouvelle_TitreSéjour/FormulaireMotifDeLaDemande'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Réutilisable/DemandeOuRenouvelle_TitreSéjour/FormulaireRessources'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Réutilisable/DemandeOuRenouvelle_TitreSéjour/FormulaireJustificatifs'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Réutilisable/DemandeOuRenouvelle_TitreSéjour/FormulaireRécapitulatif'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Réutilisable/DemandeOuRenouvelle_TitreSéjour/FormulaireConfirmation'), [:], FailureHandling.STOP_ON_FAILURE)

