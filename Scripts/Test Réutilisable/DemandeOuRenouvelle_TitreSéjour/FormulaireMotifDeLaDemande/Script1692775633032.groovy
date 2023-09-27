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
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By
import org.openqa.selenium.WebElement as WebElement
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webui.common.WebUiCommonHelper

/** modify WebUI.* keywords which take TestObject as arg0
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()


'Option Correspondant à votre situation :Renouvellement DeTitre Séjour  Ou Visiteur'
/********************************************************************/

if(TypeTitreDeSejour == "RenouvellementDeTitreSéjour") {
	'Sélectionner Le List_TypeEtablissement'
	WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_JétaisEtudiantEnFrance_Non'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/span_DropDown_List_TypeEtablissement'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/List_TypeEtablissement'))
	
	'Renseigner Nom de L établissement'
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NomDeEtablissement'), "Nom de L'établissement")
	
	'Sélectionner  Cycle d études '
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/span_DropDown_List_CycleEtudes'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/List_CycleEtudes'))
	
	'Sélectionner Niveau d études en fin d année'
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/span_DropDown_List_NiveauEtudesEnFinDAnnee'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/List_NiveauEtudesEnFinDAnnee'))
	
	'Renseigner Diplôme visé en fin d études '
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DiplomeEnFinDEtudes'), "Mon Diplôme en Fin D'études")
	
	'Sélectionner Discipline '
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/span_DropDown_List_Discipline'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/List_Discipline'))
	
	'Répondre par Oui/Non'
	WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_ValidationDAnnee'))
	
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
	WebUI.delay(2)
}


'Option Correspondant à votre situation : Visiteur'
/********************************************************************/

if(TypeTitreDeSejour == "Visiteur") {
	'ATTESTATION SUR L’HONNEUR'
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_NePasVivreEnPolygamie'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_NExercerAucuneActivitéProfessionnelle'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_AvoirConnaissanceDesSanctionsPénalesFausseAttestation'))

	'ASSURANCE MALADIE'
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_AvoirSouscritAUneAssuranceMaladie'))

	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
	WebUI.delay(2)
}


'Option Correspondant à votre situation :Salarié Qualifié'
/********************************************************************/
if ((TypeTitreDeSejour)== "TS-PT-SalariéQualifié") {
	'INFORMATIONS RELATIVES À LA QUALIFICATION '
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_IntituléDuDiplôme'),"Intitulé du diplôme ")
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDeDélivrance_JJ'),'10')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateDeDélivrance_MM'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/click-select_DateDeDélivrance_MM'))
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDeDélivrance_AAAA'), '2010')
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_ÉtablissementDeDélivrance'), "Établissement De Délivrance")
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NatureDeVotreEmploi'), "Veuillez préciser la nature de votre emploi")
	
	'ÉLÉMENTS DU CONTRAT DE TRAVAIL :'
	'Type de contrat de travail'
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_TypeDeContratDeTravail'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeContratDeTravail'))
	'Date de début de contrat '
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDébutContrat_JJ'),'10')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_DateDébutContrat_MM'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateDébutContrat_MM'))
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDébutContrat_AAAA'),'2010')
	
	/*
	'Date de fin de contrat'
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateFinContrat_JJ'),'23')
	WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateFinContrat_MM'),3)
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateFinContrat_AAAA'),'2024')
	*/
	'Vous devez disposer d’un salaire brut minimal de 41 022,72  euros annuel.'
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_SalaireAnnuelBrut'),'42000')
	
	"INFORMATIONS RELATIVES À L'EMPLOYEUR :"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NumSiretEmployeur'),"44449577400531")
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_ConfirmerNuméroDeSiret'))
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
	WebUI.delay(2)
}



'Option Correspondant à votre situation :Salarié Entreprise Innovante'
/********************************************************************/
if ((TypeTitreDeSejour)== "TS-PT-SalariéEntrepriseInnovante") {
	"INFORMATIONS RELATIVES À L'ACTIVITÉ PROFESSIONNELLE :"
	
	WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_EntrepriseInnovanteReconnuePublic'))
	WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_EntrepriseInnovanteReconnueOganismePublic'))
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_AttestationMinistèreEconomie'),"Entreprise innovante reconnue par un organisme public")
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NatureEmploiEtLienNatureInnovanteEntreprise'),"Veuillez préciser la nature de votre emploi et son lien avec la nature innovante de l’entreprise")
	
	'ÉLÉMENTS DU CONTRAT DE TRAVAIL :'
	'Type de contrat de travail'
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_TypeDeContratDeTravail'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeContratDeTravail'))
	
	'Date de début de contrat '
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDébutContrat_JJ'),'10')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_DateDébutContrat_MM'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateDébutContrat_MM'))
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDébutContrat_AAAA'),'2010')
	
	'Vous devez disposer d’un salaire brut minimal de 41 022,72  euros annuel.'
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_SalaireAnnuelBrut'),'42000')
	
	"INFORMATIONS RELATIVES À L'EMPLOYEUR :"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NumSiretEmployeur'),"44449577400531")
	
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_ConfirmerNuméroDeSiret'))
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
	WebUI.delay(2)
}



'Option Correspondant à votre situation :Carte Bleue Européenne'
/********************************************************************/
if ((TypeTitreDeSejour)== "TS-PT-CarteBleueEuropéenne") {
		
	WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-CarteBleueEuropéenne'))
	"INFORMATIONS RELATIVES À LA QUALIFICATION :"
	WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_DiplomeSanctionnantAuMoins3AnneesEtudesSupérieures_NON'))
	
	"INFORMATIONS RELATIVES À L’EXPÉRIENCE PROFESSIONNELLE :"
	WebUI.check(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/CheckBox_InformationsRelativesAMonExpérienceProfessionnelle_NON'))
	
	'ÉLÉMENTS DU CONTRAT DE TRAVAIL :'
	'Type de contrat de travail'
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_TypeDeContratDeTravail'))
	WebUI.doubleClick(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeContratDeTravail'))
	
	'Date de début de contrat '
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDébutContrat_JJ'),'10')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_DateDébutContrat_MM'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateDébutContrat_MM'))
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDébutContrat_AAAA'),'2010')
	
	'Vous devez disposer d’un salaire brut minimal de 41 022,72  euros annuel.'
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_SalaireAnnuelBrut'),'42000')
	
	"INFORMATIONS RELATIVES À L'EMPLOYEUR :"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NumSiretEmployeur'),"44449577400531")
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_ConfirmerNuméroDeSiret'))
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
	WebUI.delay(2)
}



'Option Correspondant à votre situation :Salarié En Mission'
/********************************************************************/
if ((TypeTitreDeSejour)== "TS-PT-SalariéEnMission") {
	"INFORMATIONS RELATIVES À L'ACTIVITÉ PROFESSIONNELLE :"
	
	WebUI.check(findTestObject('Object Repository/Page_DemarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-SalariéEnMission'))
	'INFORMATIONS RELATIVES AU GROUPE :'
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NomDuGroupe'), 'INFORMATIONS RELATIVES AU GROUPE ')
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_SiteInternetEmployeur'), "https://www.capgemini.com/fr-fr/")
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DuréeDeAncienneté'), "15")
	
	"INFORMATIONS RELATIVES À L'EMPLOYEUR EN FRANCE "
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_TypeDeSociété'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeSociété'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_TypeDeSociété'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeSociété'))
	"INFORMATIONS RELATIVES À L'EMPLOYEUR :"
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NumSiretEmployeurEnFrance'),"44449577400531")
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_NumSiretEmployeur'),"44449577400531")
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/btn_ConfirmerNuméroDeSiret'))
	
	'ÉLÉMENTS DU CONTRAT DE TRAVAIL :'
	'Type de contrat de travail'
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_TypeDeContratDeTravail'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_TypeDeContratDeTravail'))
	
	'Date de début de contrat '
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDébutContrat_JJ'),'10')
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Click-select_DateDébutContrat_MM'))
	WebUI.click(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/select_DateDébutContrat_MM'))
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_DateDébutContrat_AAAA'),'2010')
	
	'Vous devez disposer d’un salaire brut minimal de 41 022,72  euros annuel.'
	WebUI.setText(findTestObject('Object Repository/Page_MotifDeLaDemande_Usager/Input_SalaireAnnuelBrut'),'42000')
	'Validation'
	WebUI.click(findTestObject('Object Repository/Page_DemarcheRenouvellement/btn_EnregistrerEtPoursuivre'))
	WebUI.delay(2)
}
