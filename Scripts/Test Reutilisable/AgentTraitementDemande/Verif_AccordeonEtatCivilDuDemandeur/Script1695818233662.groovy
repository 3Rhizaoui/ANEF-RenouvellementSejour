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
/** modify WebUI.* keywords which take TestObject as arg0
 * @author hhizaoui
 *so that they call Highlight.on() automatically
 */
CustomKeywords.'com.kazurayam.ksbackyard.HighlightElement.pandemic'()


/**Vérification De l'Accordéon ÉTAT CIVIL
 */
'Vérifier Existance  Du Accordeon Etat Civil'
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/span_AccordeonEtatCivil'), 3, FailureHandling.OPTIONAL)) {
TestObject AccordeonEtatCivil=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/span_AccordeonEtatCivil')
WebUI.verifyElementPresent(AccordeonEtatCivil, 1)
'Vérifier le Texte Du Accordeon Etat Civil'
String TitreAccordeonEtatCivil = WebUI.getText(AccordeonEtatCivil)
if(!TitreAccordeonEtatCivil.contains('ÉTAT CIVIL')) {
	KeywordUtil.markFailed("Vérifier le titre de L'accordéon ÉTAT CIVIL.")}
else {KeywordUtil.markPassed("Le Titre de L'accordéon est bien Affiché : ÉTAT CIVIL.")}
}

/** Vérification Des Pj 
 * Photographie
 * Signature
 * Passeport
 * Copie du titre de séjour
 */

//Photographie
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/span_Check_DocManquantPhotographie'), 3, FailureHandling.OPTIONAL)) {
'Vérifier la case à cocher du Document manquant de la Photographie '
TestObject DocManquantPhotographie=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/span_Check_DocManquantPhotographie')
WebUI.verifyElementPresent(DocManquantPhotographie, 1)
WebUI.check(DocManquantPhotographie)
'Vérifier le Titre du Texte Document manquant de la Photographie '
TestObject MsgDocumentManquant =findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/label_MsgDocumentManquantPhotographie')
WebUI.verifyElementPresent(MsgDocumentManquant, 1)
String TitreMsgDocumentManquantPhotographie = WebUI.getText(MsgDocumentManquant)
if(!TitreMsgDocumentManquantPhotographie.contains('Préciser le document manquant au demandeur * :')) {
	KeywordUtil.markFailed("Vérifier le titre de Message Préciser le document manquant Photographie au demandeur.")}
else {KeywordUtil.markPassed("Le Titre  de Message est bien Affiché : Préciser le document manquant Photographie au demandeur.")}
'Vérifier le champ Texte Document manquant de la Photographie '
TestObject TxtDocManquantPhotographie=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/TextArea_TextDocManquantPhotographie')
WebUI.verifyElementPresent(TxtDocManquantPhotographie, 1)
WebUI.setText(TxtDocManquantPhotographie, 'Préciser le document manquant Photographie au demandeur')
'Annulation Du Document Manquant'
WebUI.check(DocManquantPhotographie)

'Vérifier Photographie et voir Document '
TestObject objVoirDocPhotographie=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/span_VoirDocPhotographie')
CustomKeywords.'tools.OpenPopupInTab.OpenBrowserTab'(objVoirDocPhotographie)
CustomKeywords.'tools.OpenPopupInTab.CloseBrowserTab'()
WebUI.delay(2)
'Rejeter le document'
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/label_RejeterLeDocumentPhotographie'))
WebUI.doubleClick(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/List_MotifDuRejetPhotographie'))
WebUI.setText(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/Txt_ObservationPourDemandeurPhotographie'), 'Observations Photographie pour le demandeur')
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/div_AccepterLeDocumentPhotographie'))
}

//Signature
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/span_Check_DocManquantSignature'), 3, FailureHandling.OPTIONAL)) {
'Vérifier la case à cocher du Document manquant de la Signature '
TestObject DocManquantSignature=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/span_Check_DocManquantSignature')
WebUI.verifyElementPresent(DocManquantSignature, 1)
WebUI.check(DocManquantSignature)
'Vérifier le Titre du Texte Document manquant de la Signature '
TestObject MsgDocumentManquantSignature =findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/label_MsgDocumentManquantSignature')
WebUI.verifyElementPresent(MsgDocumentManquantSignature, 1)
String TitreMsgDocumentManquantSignature = WebUI.getText(MsgDocumentManquantSignature)
if(!TitreMsgDocumentManquantSignature.contains('Préciser le document manquant au demandeur * :')) {
	KeywordUtil.markFailed("Vérifier le titre de Message Préciser le document manquant Signature au demandeur.")}
else {KeywordUtil.markPassed("Le Titre  de Message est bien Affiché : Préciser le document manquant Signature au demandeur.")}
'Vérifier le champ Texte Document manquant de la Signature '
TestObject TxtDocManquantSignature=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/TextArea_TextDocManquantSignature')
WebUI.verifyElementPresent(TxtDocManquantSignature, 1)
WebUI.setText(TxtDocManquantSignature, 'Préciser le document manquant Signature au demandeur')
'Annulation Du Document Manquant'
WebUI.check(DocManquantSignature)

'Vérifier Signature et voir Document '
TestObject objVoirDocSignature=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/span_VoirDocSignature')
CustomKeywords.'tools.OpenPopupInTab.OpenBrowserTab'(objVoirDocSignature)
CustomKeywords.'tools.OpenPopupInTab.CloseBrowserTab'()
WebUI.delay(2)
'Rejeter le document'
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/label_RejeterLeDocumentSignature'))
WebUI.doubleClick(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/List_MotifDuRejetSignature'))
WebUI.setText(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/Txt_ObservationPourDemandeurSignature'), 'Observations Signature pour le demandeur')
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/div_AccepterLeDocumentSignature'))
}

//Passeport
'Vérifier la case à cocher du Document manquant du Passeport '

TestObject DocManquantPasseport=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/span_Check_DocManquantPasseport')
WebUI.verifyElementPresent(DocManquantPasseport, 1)
WebUI.check(DocManquantPasseport)
'Vérifier le Titre du Texte Document manquant du Passeport '
TestObject MsgDocumentManquantPasseport =findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/label_MsgDocumentManquantPasseport')
WebUI.verifyElementPresent(MsgDocumentManquantPasseport, 1)
String TitreMsgDocumentManquantPasseport = WebUI.getText(MsgDocumentManquantPasseport)
if(!TitreMsgDocumentManquantPasseport.contains('Préciser le document manquant au demandeur * :')) {
	KeywordUtil.markFailed("Vérifier le titre de Message Préciser le document manquant Passeport au demandeur.")}
else {KeywordUtil.markPassed("Le Titre  de Message est bien Affiché : Préciser le document manquant Passeport au demandeur.")}
'Vérifier le champ Texte Document manquant du Passeport '
TestObject TxtDocManquantPasseport=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/TextArea_TextDocManquantPasseport')
WebUI.verifyElementPresent(TxtDocManquantPasseport, 1)
WebUI.setText(TxtDocManquantPasseport, 'Préciser le document manquant Passeport au demandeur')
'Annulation Du Document Manquant'
WebUI.check(DocManquantPasseport)

'Vérifier Passeport et voir Document '
TestObject objVoirDocPasseport=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/span_VoirDocPasseport')
CustomKeywords.'tools.OpenPopupInTab.OpenBrowserTab'(objVoirDocPasseport)
CustomKeywords.'tools.OpenPopupInTab.CloseBrowserTab'()
WebUI.delay(2)
'Rejeter le document'
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/label_RejeterLeDocumentPasseport'))
WebUI.doubleClick(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/List_MotifDuRejetPasseport'))
WebUI.setText(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/Txt_ObservationPourDemandeurPasseport'), 'Observations Passeport pour le demandeur')
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/div_AccepterLeDocumentPasseport'))

//Copie du titre de séjour

'Vérifier la case à cocher du Document manquant de la Copie du titre de séjour '
TestObject DocManquantCopieTitreSejour=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/span_Check_DocManquantCopieTitreSejour')
WebUI.verifyElementPresent(DocManquantCopieTitreSejour, 1)
WebUI.check(DocManquantCopieTitreSejour)
'Vérifier le Titre du Texte Document manquant du Passeport '
TestObject MsgDocumentManquantCopieTitreSejour =findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/label_MsgDocumentManquantCopieTitreSejour')
WebUI.verifyElementPresent(MsgDocumentManquantCopieTitreSejour, 1)
String TitreMsgDocumentManquantCopieTitreSejour = WebUI.getText(MsgDocumentManquantCopieTitreSejour)
if(!TitreMsgDocumentManquantCopieTitreSejour.contains('Préciser le document manquant au demandeur * :')) {
	KeywordUtil.markFailed("Vérifier le titre de Message Préciser le document manquant la Copie du titre de séjour au demandeur.")}
else {KeywordUtil.markPassed("Le Titre  de Message est bien Affiché : Préciser le document manquant la Copie du titre de séjour au demandeur.")}
'Vérifier le champ Texte Document manquant de la Copie du titre de séjour '
TestObject TxtDocManquantCopieTitreSejour=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/TextArea_TextDocManquantCopieTitreSejour')
WebUI.verifyElementPresent(TxtDocManquantPasseport, 1)
WebUI.setText(TxtDocManquantCopieTitreSejour, 'Préciser le document manquant la Copie du titre de séjour au demandeur')
'Annulation Du Document Manquant'
WebUI.check(DocManquantCopieTitreSejour)

'Vérifier la Copie du titre de séjour et voir Document '
TestObject objVoirDocCopieTitreSejour=findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/span_VoirDocCopieTitreSejour')
CustomKeywords.'tools.OpenPopupInTab.OpenBrowserTab'(objVoirDocCopieTitreSejour)
CustomKeywords.'tools.OpenPopupInTab.CloseBrowserTab'()
WebUI.delay(2)
'Rejeter le document'
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/label_RejeterLeDocumentCopieTitreSejour'))
WebUI.doubleClick(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/List_MotifDuRejetCopieTitreSejour'))
WebUI.setText(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/Txt_ObservationPourDemandeurCopieTitreSejour'), 'Observations de la Copie du titre de séjour pour le demandeur')
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonEtatCivilDuDemandeur_Agent/div_AccepterLeDocumentCopieTitreSejour'))

'MOTIF DE SÉJOUR'
"ATTESTATION SUR L'HONNEUR"
'Vérifier Le document justifiant que le demandeur a souscrit à une assurance maladie pendant toute la durée de son séjour'
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/objVoirDocCopieSouscriptionAssurance'), 3, FailureHandling.OPTIONAL)) {
TestObject objVoirDocCopieSouscriptionAssurance =findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/objVoirDocCopieSouscriptionAssurance')
CustomKeywords.'tools.OpenPopupInTab.OpenBrowserTab'(objVoirDocCopieSouscriptionAssurance)
CustomKeywords.'tools.OpenPopupInTab.CloseBrowserTab'()
WebUI.delay(2)
'Accepter le document'
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/div_AccepterLeDocumentCopieMotifDeSejour'))
}

'RESSOURCES'
'Vérifier Le document justifiant que le demandeur a des RESSOURCES'
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/objVoirDocCopieRESSOURCES'), 3, FailureHandling.OPTIONAL)) {
TestObject objVoirDocCopieRESSOURCES =findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/objVoirDocCopieRESSOURCES')
CustomKeywords.'tools.OpenPopupInTab.OpenBrowserTab'(objVoirDocCopieRESSOURCES)
CustomKeywords.'tools.OpenPopupInTab.CloseBrowserTab'()
WebUI.delay(2)
'Accepter le document'
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/div_AccepterLeDocumentCopieRESSOURCES'))
}

'ADRESSE'
'Vérifier Le document justifiant que le demandeur a une ADRESSE'
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/objVoirDocCopieADRESSE'), 3, FailureHandling.OPTIONAL)) {
TestObject objVoirDocCopieADRESSE =findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/objVoirDocCopieADRESSE')
CustomKeywords.'tools.OpenPopupInTab.OpenBrowserTab'(objVoirDocCopieADRESSE)
CustomKeywords.'tools.OpenPopupInTab.CloseBrowserTab'()
WebUI.delay(2)
'Accepter le document'
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/div_AccepterLeDocumentCopieADRESSE'))
}
'CASIER JUDICIAIRE'
'Vérifier Le document justifiant que le demandeur a Extrait de casier judiciaire transmis par courrier'
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/Select_EtatDuCasierJudiciaire'), 3, FailureHandling.OPTIONAL)) {
TestObject Select_EtatDuCasierJudiciaire =findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/Select_EtatDuCasierJudiciaire')
WebUI.click(Select_EtatDuCasierJudiciaire)
TestObject Select_Value_EtatDuCasierJudiciaire =findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/Select_Value_EtatDuCasierJudiciaire')
WebUI.click(Select_Value_EtatDuCasierJudiciaire)
WebUI.delay(2)}

'BIOMÉTRIE'
'Acquisition des empreintes faite le'
TestObject DemandeurContacte =findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/check_DemandeurContacte')
WebUI.click(DemandeurContacte)
TestObject ImpossibiliteDePriseDEmpreintes =findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/checkBox_ImpossibiliteDePriseDEmpreintes')
WebUI.click(ImpossibiliteDePriseDEmpreintes)

WebUI.setText(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/Imput_JourPriseEmpreinte'), '10')
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/Select_MoisPriseEmpreinte'))
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/Select_Value_MoisPriseEmpreinte'))
WebUI.setText(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/Imput_AnneePriseEmpreinte'), '2024')

'Valider Adresse Et Rapatrier Le Dossier'
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/ValiderAdresseRapatrierLeDossier'), FailureHandling.OPTIONAL)
WebUI.delay(5)
/*******************************************************************************************************/
'recherche de la demande En cours'
//WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/span_DemandeDeTitreDeSejour'))
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/span_Liste_MesDemandes'))
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/a_link_TitreDeSejour'))
WebUI.setText(findTestObject('Object Repository/Page_Accueil_Agent/Input_RechercherUneDemande'), NumEtrangerVisa)
WebUI.delay(3)
/** S'affecter et Ouvrir la demande
 *
 */
TestObject ActuelleAffectation = findTestObject('Object Repository/Page_Accueil_Agent/Lib_ActuelleAffectation')
def TitreActuelleAffectation = WebUI.getText(ActuelleAffectation, FailureHandling.OPTIONAL)
//def boolean TitreActuelleAffectation = WebUI.verifyMatch(WebUI.getAttribute(ActuelleAffectation,"title"),'.*AUTOMATISATION AGENT SEJOUR.*', true)
def boolean  ExistActuelleAffectation = TitreActuelleAffectation.contains('AGENT SEJOUR')

println 'ExistActuelleAffectation='+ ExistActuelleAffectation

if (ExistActuelleAffectation == false) {
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/div_Tab_tr1NumDemande'))
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/span_AffecterLaDemande'))
WebUI.delay(3)
'Vérification de la Popup Reaffecter La Demande'
TestObject PopUpReaffecter =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/PopUp_ReaffecterLaDemande')
WebUI.verifyElementPresent(PopUpReaffecter, 1)
String TitrePopUpReaffecter = WebUI.getText(PopUpReaffecter)
if(!TitrePopUpReaffecter.contains('RÉAFFECTER LA DEMANDE')) {
	KeywordUtil.markFailed("Vérifier le titre de PopUp RÉAFFECTER LA DEMANDE.")}
else {KeywordUtil.markPassed("Le Titre de PopUp est bien Affiché : RÉAFFECTER LA DEMANDE.")}

TestObject ReaffecterA =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/List_ReaffecterA')
WebUI.verifyElementPresent(ReaffecterA, 1)
WebUI.click(ReaffecterA)
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/select_ElementList_ReaffecterA'))
TestObject PopUpReaffecterBtnConfirmer =findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_PopUpReaffecterConfirmer')
WebUI.verifyElementPresent(PopUpReaffecterBtnConfirmer, 1)
WebUI.click(PopUpReaffecterBtnConfirmer)

'retrouver la demande'
WebUI.setText(findTestObject('Object Repository/Page_Accueil_Agent/Input_RechercherUneDemande'), NumEtrangerVisa)
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/btn_LoopRecherche'))

'Sélectionner et Ouvrir La Demande'
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/div_Tab_tr1NumDemande'))
WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/span_VoirLaDemande'))

//"Retour à l'accueil"
//WebUI.click(findTestObject('Object Repository/Page_Accueil_Agent/btn_Retour_Accueil_Agent'))
//WebUI.setText(findTestObject('Object Repository/Page_Accueil_Agent/Input_RechercherUneDemande'), NumEtrangerVisa)
}
/*******************************************************************************************************/


'Clôturer la demande'
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/Btn_CloturerLaDemande'), FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/Select_MotifCloturerLaDemande'), FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/Select_Value_MotifCloturerLaDemande'), FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/Btn_ConfirmerCloturerLaDemande'), FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/Btn_ConfirmerEtNotifierAuDemandeur'), FailureHandling.OPTIONAL)

WebUI.delay(5)

//'Demander un complément'
//WebUI.click(findTestObject('Object Repository/Page_Verif_AccordeonMotifDeSejour_Agent/ValiderDemanderComplement'), FailureHandling.OPTIONAL)

// Valider et Enregistrer
//
//TestObject EnregistrerQuitter = findTestObject('Object Repository/Page_Verif_AccordeonInformationsGeneralesDemande_Agent/btn_EnregistrerQuitter')
//WebUI.click(EnregistrerQuitter)