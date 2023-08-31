import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select




//Sélectionner Le List_TypeEtablissement
WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_JétaisEtudiantEnFrance_Non'))
WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/span_DropDown_List_TypeEtablissement'))
WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/List_TypeEtablissement'))

//Renseigner Nom de L'établissement
WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NomDeEtablissement'), "Nom de L'établissement")

//Sélectionner  Cycle d'études 
WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/span_DropDown_List_CycleEtudes'))
WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/List_CycleEtudes'))

//Sélectionner Niveau d'études en fin d'année
WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/span_DropDown_List_NiveauEtudesEnFinDAnnee'))
WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/List_NiveauEtudesEnFinDAnnee'))

//Renseigner Diplôme visé en fin d'études 
WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DiplomeEnFinDEtudes'), "Mon Diplôme en Fin D'études")

//Sélectionner Discipline 
WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/span_DropDown_List_Discipline'))
WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/List_Discipline'))

//Répondre par Oui/Non
WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_ValidationDAnnee'))

//Validation 
WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_EnregistrerEtPoursuivre'))




	 
	 





