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

/** modify WebUI.* keywords which take TestObject as arg0
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
String SpecificDownloadDirectory = RunConfiguration.getProjectDir() + "/Data Files/"

CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()


'Documents Justificatifs Correspondant à votre situation :Renouvellement DeTitre Séjour'
/********************************************************************************************************/

if((TypeTitreDeSejour == "RenouvellementDeTitreSejour") && (Titre == 'Etudiant'))  {
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_TitreSejourValide'), SpecificDownloadDirectory +'EtatCivil.pdf')
	WebUI.delay(02)
	'Joindre un  justificatif Passeport'
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_Passeport'), SpecificDownloadDirectory +'Passeport.pdf')
	WebUI.delay(02)
	"Joindre un  justificatif Photographie d'identité récente"
	WebUI.setText(findTestObject('Object Repository/Page_Justificatifs_Usager/Input_Numero_Ephoto'), NumEphoto)
	WebUI.click(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ConfirmerNumeroEphoto'))
	WebUI.delay(02)
	"Joindre un  justificatif DOMICILIATION"
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_Domiciliation'), SpecificDownloadDirectory +'Domiciliation.pdf')
	WebUI.delay(02)
	/**Joindre un  justificatif MOTIF DE SÉJOUR
	 * Certificat d'inscription ou justificatif de préinscription auprès de votre établissement d'enseignement supérieur
	*/
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_CertificatDInscription'), SpecificDownloadDirectory +'CertificatDInscription.pdf')
	WebUI.delay(02)
	"Relevé de notes"
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_ReleveDeNotes'), SpecificDownloadDirectory +'ReleveDeNotes.pdf')
	WebUI.delay(02)
	"Diplôme obtenu en France"
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_DiplomeObtenuEnFrance'), SpecificDownloadDirectory +'DiplomeObtenuEnFrance.pdf')
	WebUI.delay(02)
	"Attestation de réussite"
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_AttestationDeReussite'), SpecificDownloadDirectory +'AttestationDeReussite.pdf')
	WebUI.delay(02)
	/****RESSOURCES*****
	*En cas de ressources multiples, veuillez joindre le justificatif de chacune des ressources.
	*pris en charge par un tiers
	*/
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_PrisEnChargeParUnTiers'), SpecificDownloadDirectory +'PrisEnChargeParUnTiers.pdf')
	WebUI.delay(02)
	'Vous êtes boursier'
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_boursier'), SpecificDownloadDirectory +'Boursier.pdf')
	WebUI.delay(02)
	'Vous êtes salarié'
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_3DernieresFichesDePaie'), SpecificDownloadDirectory +'Salarie.pdf')
	WebUI.delay(02)
	'Vous disposez de ressources suffisantes'
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_RessourcesSuffisantes'), SpecificDownloadDirectory +'RessourcesSuffisantes.pdf')
	WebUI.delay(02)
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
}


'Documents Justificatifs Correspondant à votre situation : Visiteur'
/********************************************************************************************************/

if(((TypeTitreDeSejour == 'RenouvellementDeTitreSejour') && (Titre == 'Visiteur')) || ((TypeTitreDeSejour == 'Visiteur') && (Titre == 'Etudiant'))) {
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_TitreSejourValide'), SpecificDownloadDirectory +'EtatCivil.pdf')
	WebUI.delay(02)
	'Joindre un  justificatif Passeport'
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_Passeport'), SpecificDownloadDirectory +'Passeport.pdf')
	WebUI.delay(02)
	"Joindre un  justificatif Photographie d'identité récente"
	WebUI.setText(findTestObject('Object Repository/Page_Justificatifs_Usager/Input_Numero_Ephoto'), GlobalVariable.NumEphoto)
	WebUI.click(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ConfirmerNumeroEphoto'))
	WebUI.delay(02)
	"Joindre un  justificatif DOMICILIATION"
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_Domiciliation'), SpecificDownloadDirectory +'Domiciliation.pdf')
	WebUI.delay(02)
	/**Joindre un  justificatif MOTIF DE SÉJOUR
	 * Le document justifiant que le demandeur ait souscrit à une assurance maladie pendant toute la durée de son séjour
	*/
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_SouscriptionAssurance'), SpecificDownloadDirectory +'SouscriptionAssurance.pdf')
	WebUI.delay(02)

	/****RESSOURCES*****
	*En cas de ressources multiples, veuillez joindre le justificatif de chacune des ressources.
	*Vous êtes pris en charge par un parent, enfant ou conjoint / partenaire
    *Veuillez fournir :
    *- Les justificatifs de ses ressources (avis d’imposition sur les revenus, fiches de paie…)
    *- Sa carte d'identité
    *- Une attestation de prise en charge financière
    *- La copie intégrale de votre acte de naissance avec filiation
	*/
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_PrisEnChargeParUnTiers'), SpecificDownloadDirectory +'PrisEnChargeParUnTiers.pdf')
	WebUI.delay(02)
	
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
}


"'Option Correspondant à votre situation :Salarié Qualifié', 'Salarié Entreprise Innovante', 'Carte Bleue Européenne', 'Salarié En Mission'"
/*********************************************************************************************************************************************/
if ((TypeTitreDeSejour)== "TS-PT-SalariéQualifié") {
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_TitreSejourValide'), SpecificDownloadDirectory +'EtatCivil.pdf')
	WebUI.delay(02)
	'Joindre un  justificatif Passeport'
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_Passeport'), SpecificDownloadDirectory +'Passeport.pdf')
	WebUI.delay(02)
	"Joindre un  justificatif Photographie d'identité récente"
	WebUI.setText(findTestObject('Object Repository/Page_Justificatifs_Usager/Input_Numero_Ephoto'), GlobalVariable.NumEphoto)
	WebUI.click(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ConfirmerNumeroEphoto'))
	WebUI.delay(02)
	"Joindre un  justificatif DOMICILIATION"
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_Domiciliation'), SpecificDownloadDirectory +'Domiciliation.pdf')
	WebUI.delay(02)
	/**Joindre un  justificatif MOTIF DE SÉJOUR
	 * Attestation de l'employeur  et Diplôme obtenu en France
	*/
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_AttestationDEmployeur'), SpecificDownloadDirectory +'AttestationEmployeur.pdf')
	WebUI.delay(02)
	"Diplôme obtenu en France"
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_DiplomeObtenuEnFrance'), SpecificDownloadDirectory +'DiplomeObtenuEnFrance.pdf')
	WebUI.delay(02)
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
	}
	