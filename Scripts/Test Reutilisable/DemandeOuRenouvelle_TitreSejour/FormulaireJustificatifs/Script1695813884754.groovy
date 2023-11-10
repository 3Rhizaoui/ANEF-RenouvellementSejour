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
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.LocalFileDetector as LocalFileDetector
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.events.EventFiringWebDriver

/** modify WebUI.* keywords which take TestObject as arg0
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()

'RunConfiguration for get Execution Properties Driver'
Map RunBrowserConfiguration = RunConfiguration.getExecutionProperties()
String DriverName = GlobalVariable.DriverName
//RunBrowserConfiguration.get("drivers").get("system").get("WebUI").get("browserType")
String  SpecificDownloadDirectory =""
'Upload file attachment'
if (DriverName =='FIREFOX_DRIVER') {
	 SpecificDownloadDirectory = (RunConfiguration.getProjectDir() + "/Data Files/").replace(/\//, '\\')
	}
else {
	 SpecificDownloadDirectory = RunConfiguration.getProjectDir() + "/Data Files/"
 }
println "SpecificDownloadDirectory : " +SpecificDownloadDirectory

//filePath = System.getProperty("user.dir") + File.separator + "myfile.txt" // finds the directory that katalon is running in and grabs myfile.txt
//println "filePath : " + filePath
//EventFiringWebDriver driver = DriverFactory.getWebDriver()  // get the event driver (aka the katalon smartwait driver)
//
//RemoteWebDriver wrappedDriver = driver.getWrappedDriver() // get the driver inside the smart wait driver (remote,chrome, firefox,etc)
//
//wrappedDriver.setFileDetector(new LocalFileDetector()) //points your remote,chrome,firefox,etc driver to the local files in the run.
//
////TestObjet fileInput  = findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_TitreSejourValide')
////WebElement fileInput = wrappedDriver. Upload // specify your selector (I'm using CSS) and create fileInput as the object that is found by your selector
//WebElement fileInput = wrappedDriver.findElement(By.xpath("//app-justificatifs/div[2]/div/p-accordion/div/p-accordiontab[1]/div[2]/div/div[1]/div/app-pieces-jointes[1]/div/span[1]/input"))

//fileInput.sendKeys(SpecificDownloadDirectory) //Send the fileInput object your filepath, which is a directory. It will begin the upload at this point.

'Documents Justificatifs Correspondant à votre situation :Renouvellement DeTitre Séjour'
/********************************************************************************************************/

if((TypeTitreDeSejour == "RenouvellementDeTitreSejour") && (Titre == 'Etudiant'))  {

	//WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_TitreSejourValide'),SpecificDownloadDirectory +'EtatCivil.pdf')
	//WebUI.setText(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_TitreSejourValide'), SpecificDownloadDirectory +'EtatCivil.pdf')
	TestObject Btn_ChoisirFichier = WebUI.click(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichierTest'))
	CustomKeywords.'tools.UploadMyFile.uploadFileUsingRobot'(Btn_ChoisirFichier, SpecificDownloadDirectory +'EtatCivil.pdf')
	
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
	WebUI.waitForAngularLoad(10)
	WebUI.waitForPageLoad(15)
	WebUI.waitForJQueryLoad(15)
}

println "TypeTitreDeSejour :" + TypeTitreDeSejour

"'Option Correspondant à votre situation :'Carte Bleue Européenne', 'Salarié En Mission'"
/*********************************************************************************************************************************************/
if ((TypeTitreDeSejour == "TS-PT-CarteBleueEuropeenne") || (TypeTitreDeSejour =="TS-PT-SalarieEnMission")) {
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
	
	
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
	}


"'Option Correspondant à votre situation :Salarié Qualifié', 'Salarié Entreprise Innovante', 'ChercheurEtChercheurEnMobilite'"
/*********************************************************************************************************************************************/
if ((TypeTitreDeSejour == "TS-PT-SalarieQualifie") || (TypeTitreDeSejour == "TS-PT-SalarieEntrepriseInnovante") || (TypeTitreDeSejour == "ChercheurEtChercheurEnMobilite")) {
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
	
	"Diplôme obtenu en France"
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_DiplomeObtenuEnFrance'), SpecificDownloadDirectory +'DiplomeObtenuEnFrance.pdf')
	WebUI.delay(02)
	
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_AttestationDEmployeur'), SpecificDownloadDirectory +'AttestationEmployeur.pdf')
	WebUI.delay(02)
	
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
}
	
"'Option Correspondant à votre situation :Salarié Qualifié', 'Salarié Entreprise Innovante', 'ChercheurEtChercheurEnMobilite'"
/*********************************************************************************************************************************************/
if ((TypeTitreDeSejour == 'FrenchTechVisaForInvestors') || (TypeTitreDeSejour == 'CreateurDEntreprise')) {
		
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
	 * Justificatifs d’un investissement direct en France 
	*/
	
	"Justificatifs d’un investissement direct en France d’au moins 300 000 €"
	WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_JustificatifsInvestissement'), SpecificDownloadDirectory +'JustificatifsInvestissement.pdf')
	WebUI.delay(02)
	
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
}

'Option Correspondant à votre situation :Investisseur (French tech Visa for Investors) or Investisseur (French Tech Visa For Founders)'
/*********************************************************************************************************************************************/
	if ((TypeTitreDeSejour == 'CreateurDEntreprise') || (TypeTitreDeSejour == 'FrenchTechVisaForFounders')) {
		
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
		 * Justificatifs d’un investissement direct en France
		*/
		
		"Tout document justifiant la réalisation du projet"
		WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_ToutDocumentJustifiantLaRealisationDuProjet'), SpecificDownloadDirectory +'ToutDocumentJustifiantLaRealisationDuProjet.pdf')
		WebUI.delay(02)
		
		"Si le demandeur a le statut de salarié : fiche de salaire pour les trois derniers mois ou en l'absence, le dernier avis d'imposition"
		WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_DernierAvisDImposition'), SpecificDownloadDirectory +'DernierAvisDImposition.pdf')
		WebUI.delay(02)
		
		'Validation'
		WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
	}
	
	'Option Correspondant à votre situation :Investisseur (MandataireSocial)'
	/*********************************************************************************************************************************************/
		if ((TypeTitreDeSejour == 'MandataireSocial')) {
			
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
			 * Justificatifs d’un investissement direct en France
			*/
			
			"Justificatif établissant que l'usager occupe une fonction de mandataire social dans un établissement ou une société établie en France"
			WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_ToutDocumentJustifiantLaRealisationDuProjet'), SpecificDownloadDirectory +'ToutDocumentJustifiantLaRealisationDuProjet.pdf')
			WebUI.delay(02)
			
			"Justificatif d'une rémunération brute au moins égale à 3 fois le salaire minimum de croissance annuel"
			WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_DernierAvisDImposition'), SpecificDownloadDirectory +'DernierAvisDImposition.pdf')
			WebUI.delay(02)
			
			WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_AttestationDEmployeur'), SpecificDownloadDirectory +'AttestationEmployeur.pdf')
			WebUI.delay(02)
			
			'Validation'
			WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
		}
		
		'Option Correspondant à votre situation :Tout document pouvant justifier de la qualité d’artiste ou d’auteur'
		/*********************************************************************************************************************************************/
			if (TypeTitreDeSejour == 'Artiste')  {
				
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
				 * Justificatifs d’un Artiste  en France
				*/
				
				"Tout document pouvant justifier de la qualité d’artiste ou d’auteur"
				WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_ToutDocumentJustifiantLaRealisationDuProjet'), SpecificDownloadDirectory +'ToutDocumentJustifiantLaRealisationDuProjet.pdf')
				WebUI.delay(02)
				
				"Justificatif de ressources"
				WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_DernierAvisDImposition'), SpecificDownloadDirectory +'DernierAvisDImposition.pdf')
				WebUI.delay(02)
				
				'Validation'
				WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
			}

			'Option Correspondant à votre situation :Tout document pouvant justifier de la qualité MembreDeFamillePasseportTalent_Conjoint'
			/*********************************************************************************************************************************************/
				if (TypeTitreDeSejour == 'MembreDeFamillePasseportTalent_Conjoint')  {
					
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
					 * Justificatifs d’un Artiste  en France
					*/
					
					"Tout document pouvant justifier de la qualité MembreDeFamillePasseportTalent_Conjoint Acte de mariage"
					WebUI.uploadFile(findTestObject('Object Repository/Page_Justificatifs_Usager/Btn_ChoisirFichier_ActeDeMariage'), SpecificDownloadDirectory +'ActeDeMariage.pdf')
					WebUI.delay(02)
					'Validation'
					WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
				}



