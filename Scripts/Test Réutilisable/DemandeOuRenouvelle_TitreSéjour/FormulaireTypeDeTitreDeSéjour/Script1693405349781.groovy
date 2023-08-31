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

/*Vous êtes titulaire d'un titre de séjour en tant que <&&&&&>
 * Je sollicite le renouvellement de ce titre
 */

switch (GlobalVariable.TypeTitreDeSejour) {

	case 'RenouvellementDeTitreSéjour':
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteRenouvellementDeTitreSéjour'))
	break
	case 'Visiteur' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_Visiteur'))
		
	break
	case 'PasseportTalent' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_PasseportTalent'))
	break
	case 'ProtectionInternationale' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_ProtectionInternationale'))
	break
	case 'CheckBox_SolliciteTS_salarie-HorsPasseportTalent-HorsCitoyenUE' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_salarie-HorsPasseportTalent-HorsCitoyenUE'))
	break
	case 'MembreDeFamille' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_MembreDeFamille'))
	break
	case 'SituationDeVulnérabilité' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_SituationDeVulnérabilite'))
	break
	case 'CheckBox_SolliciteTS_CitoyenDeUnionEuropéenne' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_CitoyenDeUnionEuropéenne'))
	break
	case 'CheckBox_SolliciteTS_RessortissantEtrangerNeEnFrance' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_RessortissantEtrangerNeEnFrance'))
	break
	case 'CheckBox_SolliciteTS_MotifHumanitaire' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_MotifHumanitaire'))
	break
	case 'CheckBox_SolliciteTS_JeuneAuPair-AncienCombattant-RetraiteAyantTravailleEnFrance' :
		WebUI.check(findTestObject('Object Repository/Page_DémarcheRenouvellement/CheckBox_SolliciteTS_JeuneAuPair-AncienCombattant-RetraiteAyantTravailleEnFrance'))
	default :
	break
}
// Valider mon choix
WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/btn_JeCommence'))
// 2 éme Validation de mon choix
WebUI.click(findTestObject('Object Repository/Page_DémarcheRenouvellement/Btn_JeContinue'))
