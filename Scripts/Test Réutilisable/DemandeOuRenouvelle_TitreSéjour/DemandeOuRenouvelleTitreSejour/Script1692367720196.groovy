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



WebUI.click(findTestObject('Object Repository/Page_Accueil/btn_DemandeOuRenouvelleTitreSejour'))
WebUI.check(findTestObject('Object Repository/Page_Accueil/CheckBox_Moi-même'))
WebUI.click(findTestObject('Object Repository/Page_Accueil/btn_JeContinue'))

/*Vous êtes titulaire d'un titre de séjour en tant que <&&&&&>
 * Je sollicite le renouvellement de ce titre
 */
WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteRenouvellementDeCeTitre'))
// Valider mon choix
WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
// 2 éme Validation de mon choix
WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence1'))