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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

/**
 * @author hhizaoui
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()

'Appel Brique Réutilisable pour lancer URl ANEF pour Usager ou Agent'
WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Lancer URL ANEF'), [('Profiles') : 'Usager', ('EnvExec') : EnvExec ], FailureHandling.STOP_ON_FAILURE)

'Appel Brique Réutilisable pour Créer un Compte Usager'
WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Creer Votre Compte'), [('NumEtrangerVisa') : NumEtrangerVisa, ('DateDebut') : DateDebut
        , ('DateFin') : DateFin, ('EnvExec') :EnvExec], FailureHandling.STOP_ON_FAILURE)

if (GlobalVariable.StopTestCase == false) {
    'Appel Brique Réutilisable pour Identification Usager ou Agent'
    WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Identification'), [('Profiles') : 'Usager', ('NumEtrangerVisa') : NumEtrangerVisa, ('EnvExec'): 'EnvExec'], 
        FailureHandling.STOP_ON_FAILURE)

    'Appel Brique Réutilisable pour une Demande Ou Renouvelle Titre De Sejour Usager'
    WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/DemandeOuRenouvelleTitreSejour'), 
        [('ChangementSituation'):ChangementSituation], FailureHandling.STOP_ON_FAILURE)
	if (ChangementSituation == 'Non') {
	'Appel Brique Réutilisable pour Remplir Le Formulaire Type De Titre De Séjour Usager'
	    WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireTypeDeTitreDeSejour'), 
	        [('TypeTitreDeSejour') : TypeTitreDeSejour, ('Titre') : Titre], FailureHandling.STOP_ON_FAILURE)
	}
	if (GlobalVariable.StopTestCase == false) {
	    'Appel Brique Réutilisable pour Remplir Le Formulaire Informations Personnelles Usager'
	    WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireInformationsPersonnelles'), 
	        [('AdresseUsager') : AdresseUsager, ('NumeroTelephoneUsager') : NumeroTelephoneUsager], FailureHandling.STOP_ON_FAILURE)
	
	    'Appel Brique Réutilisable pour Remplir Le Formulaire Motif De La Demande Usager'
	    WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireMotifDeLaDemande'), [('TypeTitreDeSejour') : TypeTitreDeSejour
	            , ('ChangementSituation'):ChangementSituation, ('Titre') : Titre], FailureHandling.STOP_ON_FAILURE)
	
	    if ((((TypeTitreDeSejour == 'RenouvellementDeTitreSejour') && (ChangementSituation == 'Non')) || (TypeTitreDeSejour == 'Visiteur')) && ((Titre == 'Etudiant') || 
	    (Titre == 'Visiteur'))) {
	        'Appel Brique Réutilisable pour Remplir Le Formulaire Ressources Usager'
	        WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireRessources'), [:], 
	            FailureHandling.STOP_ON_FAILURE)
	    }
	    
	    'AppelBrique Réutilisable pour Remplir Le Formulaire Justificatifs Usager'
	    WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireJustificatifs'), [('TypeTitreDeSejour') : TypeTitreDeSejour
	            , ('Titre') : Titre, ('NumEphoto') : NumEphoto , ('ChangementSituation'):ChangementSituation], FailureHandling.STOP_ON_FAILURE)
	
	    'Appel Brique Réutilisable pour Remplir Le Formulaire Récapitulatif Usager'
	    WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireRecapitulatif'), [('Titre') : Titre
	            , ('TypeTitreDeSejour') : TypeTitreDeSejour, ('ChangementSituation'):ChangementSituation], FailureHandling.STOP_ON_FAILURE)
	
	    'Appel Brique Réutilisable pour Remplir Le Formulaire Confirmation Usager'
	    WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireConfirmation'), [('NumEtrangerVisa') : NumEtrangerVisa
	            , ('TypeTitreDeSejour') : TypeTitreDeSejour , ('ChangementSituation'):ChangementSituation], FailureHandling.STOP_ON_FAILURE)
		
		if ((ChangementSituation == 'Perte') || (ChangementSituation == 'Vol') ||(ChangementSituation == 'Deterioration')) {
			'Appel Brique Réutilisable pour Remplir Le Formulaire Type De Titre De Séjour Usager'
				WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireTypeDeTitreDeSejour'),
					[('TypeTitreDeSejour') : TypeTitreDeSejour, ('Titre') : Titre], FailureHandling.STOP_ON_FAILURE)
				'Appel Brique Réutilisable pour Remplir Le Formulaire Informations Personnelles Usager'
				WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireInformationsPersonnelles'),
					[('AdresseUsager') : AdresseUsager, ('NumeroTelephoneUsager') : NumeroTelephoneUsager], FailureHandling.STOP_ON_FAILURE)
			
				'Appel Brique Réutilisable pour Remplir Le Formulaire Motif De La Demande Usager'
				WebUI.callTestCase(findTestCase('Test Cases/Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireMotifDeLaDemande_2'), [('TypeTitreDeSejour') : TypeTitreDeSejour
						, ('ChangementSituation'):ChangementSituation, ('Titre') : Titre], FailureHandling.STOP_ON_FAILURE)
				if ((((TypeTitreDeSejour == 'RenouvellementDeTitreSejour')) || (TypeTitreDeSejour == 'Visiteur')) && ((Titre == 'Etudiant') ||
					(Titre == 'Visiteur'))) {
						'Appel Brique Réutilisable pour Remplir Le Formulaire Ressources Usager'
						WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireRessources'), [:],
							FailureHandling.STOP_ON_FAILURE)
					}
					
					'AppelBrique Réutilisable pour Remplir Le Formulaire Justificatifs Usager'
					WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireJustificatifs_2'), [('TypeTitreDeSejour') : TypeTitreDeSejour
							, ('Titre') : Titre, ('NumEphoto') : NumEphoto , ('ChangementSituation'):ChangementSituation], FailureHandling.STOP_ON_FAILURE)
				
					'Appel Brique Réutilisable pour Remplir Le Formulaire Récapitulatif Usager'
					WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireRecapitulatif_2'), [('Titre') : Titre
							, ('TypeTitreDeSejour') : TypeTitreDeSejour, ('ChangementSituation'):ChangementSituation], FailureHandling.STOP_ON_FAILURE)
				
					'Appel Brique Réutilisable pour Remplir Le Formulaire Confirmation Usager'
					WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireConfirmation_2'), [('NumEtrangerVisa') : NumEtrangerVisa
							, ('TypeTitreDeSejour') : TypeTitreDeSejour , ('ChangementSituation'):ChangementSituation], FailureHandling.STOP_ON_FAILURE)
			}
}}

if (TraitemantAgent=='Oui') {
	
	'Appel Brique Réutilisable pour lancer URl ANEF pour Usager ou Agent'
	WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Lancer URL ANEF'), [('Profiles') : 'Agent', ('EnvExec') : EnvExec ], FailureHandling.STOP_ON_FAILURE)
	
	'Appel Brique Réutilisable pour Identification Usager ou Agent'
	WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Identification'), [('Profiles') : 'Agent', ('NumEtrangerVisa') : NumEtrangerVisa, ('EnvExec'): 'EnvExec'],
		FailureHandling.STOP_ON_FAILURE)
	
	//WebUI.callTestCase(findTestCase('Test Cases/Test Reutilisable/AgentTraitementDemande/ConnexionPositionnementSiteDeTraitementAgent'), [:], FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/Test Reutilisable/AgentTraitementDemande/AgentRechercheDemande'), [('NumEtrangerVisa'):NumEtrangerVisa], FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/Test Reutilisable/AgentTraitementDemande/Verif_AccordeonInformationsGeneralesDemande'), [('NumEtrangerVisa'):NumEtrangerVisa], FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/Test Reutilisable/AgentTraitementDemande/Verif_AccordeonObservationDuDemandeur'), [:], FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/Test Reutilisable/AgentTraitementDemande/Verif_AccordeonEtatCivilDuDemandeur'), [('NumEtrangerVisa'):NumEtrangerVisa], FailureHandling.STOP_ON_FAILURE)
	
	'Appel Brique Réutilisable pour lancer URl ANEF pour Usager ou Agent'
	WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Lancer URL ANEF'), [('Profiles') : 'Usager', ('EnvExec') : EnvExec ], FailureHandling.STOP_ON_FAILURE)
	'Appel Brique Réutilisable pour Identification Usager ou Agent'
	WebUI.callTestCase(findTestCase('Test Reutilisable/Main/Identification'), [('Profiles') : 'Usager', ('NumEtrangerVisa') : NumEtrangerVisa, ('EnvExec'): 'EnvExec'],
		FailureHandling.STOP_ON_FAILURE)
	"Appel Brique Réutilisable pour Vérification Formulaire De Notifications De l'Usager "
	WebUI.callTestCase(findTestCase('Test Reutilisable/DemandeOuRenouvelle_TitreSejour/FormulaireNotificationsUsager'), [:],FailureHandling.STOP_ON_FAILURE)
}
