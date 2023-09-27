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


/** modify WebUI.* keywords which take TestObject as arg0
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()

/**Vous êtes titulaire d'un titre de séjour en tant que <&&&&&>
 * Je sollicite le renouvellement de ce titre [$RenouvellementDeTitreSéjour]
 * Ou un autre Type de Titre De Séjour :
 * 1. [$étudiant]
 * 2. [$Visiteur]
 * 3. [$PasseportTalent]
 * 4. [$bénéficiaireProtectionInternationale]
 * 5. [$SolliciteTS_salarie-HorsPasseportTalent-HorsCitoyenUE]
 * 6. [$MembreDeFamille]
 * 7. [$SituationDeVulnérabilité]
 * 8. [$SolliciteTS_CitoyenDeUnionEuropéenne]
 * 9. [$SolliciteTS_RessortissantEtrangerNeEnFrance]
 * 10.[$SolliciteTS_MotifHumanitaire]
 * 11.[$SolliciteTS_JeuneAuPair-AncienCombattant-RetraiteAyantTravailleEnFrance]
 */
WebUI.delay(10)
switch (TypeTitreDeSejour) {

	case 'RenouvellementDeTitreSéjour':
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteRenouvellementDeTitreSéjour'))
		'Valider mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
		WebUI.delay(3)
		'2 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/Btn_JeContinue'))
	break
	case 'étudiant' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteEtudiant'))
		'Valider mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
		'2 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/Btn_JeContinue'))
	break
	case 'Visiteur' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_Visiteur'))
		'Valider mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
		WebUI.delay(3)
		'2 éme Validation de mon choix'
		WebUI.doubleClick(findTestObject('Object Repository/Page_DémarcheRenouvellement/Btn_JeContinue'))

	break

//'Cas d'un Passeport Talent Salarié Qualifié'
/**********************************************/
	case 'TS-PT-SalariéQualifié' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_SalariéQualifié'))
		'Valider mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-SalariéQualifié'))
		'2 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
		'3 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/Btn_JeContinue'))
	break
	case 'TS-PT-SalariéEntrepriseInnovante ' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_SalariéQualifié'))
		'Valider mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-SalariéEntrepriseInnovante'))
		'2 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
		'3 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/Btn_JeContinue'))
	break
	case 'TS-PT-CarteBleueEuropéenne' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_SalariéQualifié'))
		'Valider mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-CarteBleueEuropéenne'))
		'2 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
		'3 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/Btn_JeContinue'))
	break
	case 'TS-PT-SalariéEnMission' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_SalariéQualifié'))
		'Valider mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_TS-PT-SalariéEnMission'))
		'2 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
		'3 éme Validation de mon choix'
		WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/Btn_JeContinue'))
	break
/***************************************************/
//'Cas d'un Passeport Talent'
	case 'ChercheurEtChercheurEnMobilité' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_ChercheurEtChercheurEnMobilité'))
	break
	case 'InvestisseurOuPorteurProjetEconomique' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_InvestisseurOuPorteurProjetEconomique'))
	break
	case 'Artiste' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_Artiste'))
	break
	case 'MembreDeFamillePasseportTalent' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_MembreDeFamillePasseportTalent'))
	break
	case 'PersonneDeRenomméeInternationale' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_PersonneDeRenomméeInternationale'))
	break

	
	case 'bénéficiaireProtectionInternationale' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_ProtectionInternationale'))
	break
	case 'SolliciteTS_salarie-HorsPasseportTalent-HorsCitoyenUE' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_salarie-HorsPasseportTalent-HorsCitoyenUE'))
	break
	case 'MembreDeFamille' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_MembreDeFamille'))
	break
	case 'SituationDeVulnérabilité' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_SituationDeVulnérabilite'))
	break
	case 'SolliciteTS_CitoyenDeUnionEuropéenne' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_CitoyenDeUnionEuropéenne'))
	break
	case 'SolliciteTS_RessortissantEtrangerNeEnFrance' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_RessortissantEtrangerNeEnFrance'))
	break
	case 'SolliciteTS_MotifHumanitaire' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_MotifHumanitaire'))
	break
	case 'SolliciteTS_JeuneAuPair-AncienCombattant-RetraiteAyantTravailleEnFrance' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_JeuneAuPair-AncienCombattant-RetraiteAyantTravailleEnFrance'))
	default :
	break
}

'Vérification s il y a un message Erreur : Il est trop tôt pour demander le renouvellement de votre titre.'
'Verify text alert is correct or not'
MsgAlertPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Accueil_Usager/Vérif_PopUpTropTôtPourDemanderLeRenouvellementDeVotreTitre'), 1, FailureHandling.OPTIONAL)
if(MsgAlertPresent){ 
	'Get text Alert on the alert when it\'s shown'
	alertText = WebUI.getText(findTestObject('Object Repository/Page_Accueil_Usager/Vérif_PopUpTropTôtPourDemanderLeRenouvellementDeVotreTitre'),FailureHandling.OPTIONAL)
	KeywordUtil.markFailedAndStop(alertText)
	}
else {
	KeywordUtil.markPassed(" C'est le bon Moment pour demander le renouvellement de votre titre.")
}


