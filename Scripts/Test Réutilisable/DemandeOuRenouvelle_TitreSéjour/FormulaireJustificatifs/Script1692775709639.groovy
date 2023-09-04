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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory


// Joindre un  justificatif ÉTAT CIVIL
WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_EtatCivil'), "${RunConfiguration.getProjectDir()}/Data Files/EtatCivil.pdf")
WebUI.delay(02)
// Joindre un  justificatif Passeport
WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_Passeport'), "${RunConfiguration.getProjectDir()}/Data Files/Passeport.pdf")
WebUI.delay(02)
// Joindre un  justificatif Photographie d'identité récente
WebUI.setText(findTestObject('Object Repository/Page_Justificatifs_Usager/Input_Numero_Ephoto'), GlobalVariable.NumEphoto)
WebUI.click(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ConfirmerNumeroEphoto'))
WebUI.delay(02)
// Joindre un  justificatif DOMICILIATION
WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_Domiciliation'), "${RunConfiguration.getProjectDir()}/Data Files/Domiciliation.pdf")
WebUI.delay(02)

//**** Joindre un  justificatif MOTIF DE SÉJOUR
//Certificat d'inscription ou justificatif de préinscription auprès de votre établissement d'enseignement supérieur

WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_CertificatDInscription'), "${RunConfiguration.getProjectDir()}/Data Files/CertificatDInscription.pdf")
WebUI.delay(02)
//Relevé de notes

WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_ReleveDeNotes'), "${RunConfiguration.getProjectDir()}/Data Files/Relevé de notes.pdf")
WebUI.delay(02)
//Diplôme obtenu en France

WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_DiplomeObtenuEnFrance'), "${RunConfiguration.getProjectDir()}/Data Files/Diplôme obtenu en France.pdf")
WebUI.delay(02)
//Attestation de réussite

WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_AttestationDeReussite'), "${RunConfiguration.getProjectDir()}/Data Files/Attestation de réussite.pdf")
WebUI.delay(02)
//****RESSOURCES*****
//En cas de ressources multiples, veuillez joindre le justificatif de chacune des ressources.
//pris en charge par un tiers
WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_PrisEnChargeParUnTiers'), "${RunConfiguration.getProjectDir()}/Data Files/pris en charge par un tiers.pdf")
WebUI.delay(02)
//Vous êtes boursier
WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_boursier'), "${RunConfiguration.getProjectDir()}/Data Files/boursier.pdf")
WebUI.delay(02)
//Vous êtes salarié
WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_salarie'), "${RunConfiguration.getProjectDir()}/Data Files/salarié.pdf")
WebUI.delay(02)
//Vous disposez de ressources suffisantes
WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_RessourcesSuffisantes'), "${RunConfiguration.getProjectDir()}/Data Files/ressources suffisantes.pdf")
WebUI.delay(02)
//Validation
WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_EnregistrerEtPoursuivre'))



