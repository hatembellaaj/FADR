/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author hatem
 */
@Entity
@Table(name = "fiche")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fiche.findAll", query = "SELECT f FROM Fiche f"),
    @NamedQuery(name = "Fiche.findByNDossier", query = "SELECT f FROM Fiche f WHERE f.nDossier = :nDossier"),
    @NamedQuery(name = "Fiche.findByDateDiagnostic", query = "SELECT f FROM Fiche f WHERE f.dateDiagnostic = :dateDiagnostic"),
    @NamedQuery(name = "Fiche.findByDateMAJ", query = "SELECT f FROM Fiche f WHERE f.dateMAJ = :dateMAJ"),
    @NamedQuery(name = "Fiche.findByDateEnregistrement", query = "SELECT f FROM Fiche f WHERE f.dateEnregistrement = :dateEnregistrement"),
    @NamedQuery(name = "Fiche.findByMedecin", query = "SELECT f FROM Fiche f WHERE f.medecin = :medecin"),
    @NamedQuery(name = "Fiche.findByHopital", query = "SELECT f FROM Fiche f WHERE f.hopital = :hopital"),
    @NamedQuery(name = "Fiche.findByService", query = "SELECT f FROM Fiche f WHERE f.service = :service"),
    @NamedQuery(name = "Fiche.findByDegConsang", query = "SELECT f FROM Fiche f WHERE f.degConsang = :degConsang"),
    @NamedQuery(name = "Fiche.findByPlaceEnfant", query = "SELECT f FROM Fiche f WHERE f.placeEnfant = :placeEnfant"),
    @NamedQuery(name = "Fiche.findByNbVivant", query = "SELECT f FROM Fiche f WHERE f.nbVivant = :nbVivant"),
    @NamedQuery(name = "Fiche.findByNbMort", query = "SELECT f FROM Fiche f WHERE f.nbMort = :nbMort"),
    @NamedQuery(name = "Fiche.findByMortNe", query = "SELECT f FROM Fiche f WHERE f.mortNe = :mortNe"),
    @NamedQuery(name = "Fiche.findByAvortement", query = "SELECT f FROM Fiche f WHERE f.avortement = :avortement"),
    @NamedQuery(name = "Fiche.findByCousin", query = "SELECT f FROM Fiche f WHERE f.cousin = :cousin"),
    @NamedQuery(name = "Fiche.findByMembre", query = "SELECT f FROM Fiche f WHERE f.membre = :membre"),
    @NamedQuery(name = "Fiche.findBySyndromeAnemique", query = "SELECT f FROM Fiche f WHERE f.syndromeAnemique = :syndromeAnemique"),
    @NamedQuery(name = "Fiche.findBySyndromeHem", query = "SELECT f FROM Fiche f WHERE f.syndromeHem = :syndromeHem"),
    @NamedQuery(name = "Fiche.findBySyndromeInf", query = "SELECT f FROM Fiche f WHERE f.syndromeInf = :syndromeInf"),
    @NamedQuery(name = "Fiche.findByDecouverteFort", query = "SELECT f FROM Fiche f WHERE f.decouverteFort = :decouverteFort"),
    @NamedQuery(name = "Fiche.findByEnqueteFam", query = "SELECT f FROM Fiche f WHERE f.enqueteFam = :enqueteFam"),
    @NamedQuery(name = "Fiche.findByTypeCancer", query = "SELECT f FROM Fiche f WHERE f.typeCancer = :typeCancer"),
    @NamedQuery(name = "Fiche.findByCancer", query = "SELECT f FROM Fiche f WHERE f.cancer = :cancer"),
    @NamedQuery(name = "Fiche.findByTailleNaiss", query = "SELECT f FROM Fiche f WHERE f.tailleNaiss = :tailleNaiss"),
    @NamedQuery(name = "Fiche.findByPoidsNaiss", query = "SELECT f FROM Fiche f WHERE f.poidsNaiss = :poidsNaiss"),
    @NamedQuery(name = "Fiche.findByHypotrophie", query = "SELECT f FROM Fiche f WHERE f.hypotrophie = :hypotrophie"),
    @NamedQuery(name = "Fiche.findByTroubleCroi", query = "SELECT f FROM Fiche f WHERE f.troubleCroi = :troubleCroi"),
    @NamedQuery(name = "Fiche.findByAAgeChDiag", query = "SELECT f FROM Fiche f WHERE f.aAgeChDiag = :aAgeChDiag"),
    @NamedQuery(name = "Fiche.findByMAgeChDiag", query = "SELECT f FROM Fiche f WHERE f.mAgeChDiag = :mAgeChDiag"),
    @NamedQuery(name = "Fiche.findByAAgeOssDiag", query = "SELECT f FROM Fiche f WHERE f.aAgeOssDiag = :aAgeOssDiag"),
    @NamedQuery(name = "Fiche.findByMAgeOssDiag", query = "SELECT f FROM Fiche f WHERE f.mAgeOssDiag = :mAgeOssDiag"),
    @NamedQuery(name = "Fiche.findByAgeRetard", query = "SELECT f FROM Fiche f WHERE f.ageRetard = :ageRetard"),
    @NamedQuery(name = "Fiche.findByPoids", query = "SELECT f FROM Fiche f WHERE f.poids = :poids"),
    @NamedQuery(name = "Fiche.findByPoidsDS", query = "SELECT f FROM Fiche f WHERE f.poidsDS = :poidsDS"),
    @NamedQuery(name = "Fiche.findByTaille", query = "SELECT f FROM Fiche f WHERE f.taille = :taille"),
    @NamedQuery(name = "Fiche.findByTailleDS", query = "SELECT f FROM Fiche f WHERE f.tailleDS = :tailleDS"),
    @NamedQuery(name = "Fiche.findByAtteinteCut", query = "SELECT f FROM Fiche f WHERE f.atteinteCut = :atteinteCut"),
    @NamedQuery(name = "Fiche.findByTacheCaf", query = "SELECT f FROM Fiche f WHERE f.tacheCaf = :tacheCaf"),
    @NamedQuery(name = "Fiche.findByVentre", query = "SELECT f FROM Fiche f WHERE f.ventre = :ventre"),
    @NamedQuery(name = "Fiche.findByMembreSup", query = "SELECT f FROM Fiche f WHERE f.membreSup = :membreSup"),
    @NamedQuery(name = "Fiche.findByMembreInf", query = "SELECT f FROM Fiche f WHERE f.membreInf = :membreInf"),
    @NamedQuery(name = "Fiche.findByVisage", query = "SELECT f FROM Fiche f WHERE f.visage = :visage"),
    @NamedQuery(name = "Fiche.findByThorax", query = "SELECT f FROM Fiche f WHERE f.thorax = :thorax"),
    @NamedQuery(name = "Fiche.findByDos", query = "SELECT f FROM Fiche f WHERE f.dos = :dos"),
    @NamedQuery(name = "Fiche.findByHyperPig", query = "SELECT f FROM Fiche f WHERE f.hyperPig = :hyperPig"),
    @NamedQuery(name = "Fiche.findByHypochromique", query = "SELECT f FROM Fiche f WHERE f.hypochromique = :hypochromique"),
    @NamedQuery(name = "Fiche.findByCouleurPeau", query = "SELECT f FROM Fiche f WHERE f.couleurPeau = :couleurPeau"),
    @NamedQuery(name = "Fiche.findByAutreAtCut", query = "SELECT f FROM Fiche f WHERE f.autreAtCut = :autreAtCut"),
    @NamedQuery(name = "Fiche.findByAtteinteTete", query = "SELECT f FROM Fiche f WHERE f.atteinteTete = :atteinteTete"),
    @NamedQuery(name = "Fiche.findByMicrocephalie", query = "SELECT f FROM Fiche f WHERE f.microcephalie = :microcephalie"),
    @NamedQuery(name = "Fiche.findByMicrophtalmie", query = "SELECT f FROM Fiche f WHERE f.microphtalmie = :microphtalmie"),
    @NamedQuery(name = "Fiche.findByFacieTrig", query = "SELECT f FROM Fiche f WHERE f.facieTrig = :facieTrig"),
    @NamedQuery(name = "Fiche.findByTraitsFin", query = "SELECT f FROM Fiche f WHERE f.traitsFin = :traitsFin"),
    @NamedQuery(name = "Fiche.findByAutreAtTete", query = "SELECT f FROM Fiche f WHERE f.autreAtTete = :autreAtTete"),
    @NamedQuery(name = "Fiche.findByEmpreintedigitiforme", query = "SELECT f FROM Fiche f WHERE f.empreintedigitiforme = :empreintedigitiforme"),
    @NamedQuery(name = "Fiche.findByMalUro", query = "SELECT f FROM Fiche f WHERE f.malUro = :malUro"),
    @NamedQuery(name = "Fiche.findByUiv", query = "SELECT f FROM Fiche f WHERE f.uiv = :uiv"),
    @NamedQuery(name = "Fiche.findByEcho", query = "SELECT f FROM Fiche f WHERE f.echo = :echo"),
    @NamedQuery(name = "Fiche.findByReinEctop", query = "SELECT f FROM Fiche f WHERE f.reinEctop = :reinEctop"),
    @NamedQuery(name = "Fiche.findBySiegeEctopie", query = "SELECT f FROM Fiche f WHERE f.siegeEctopie = :siegeEctopie"),
    @NamedQuery(name = "Fiche.findByReinFerChev", query = "SELECT f FROM Fiche f WHERE f.reinFerChev = :reinFerChev"),
    @NamedQuery(name = "Fiche.findByPetitRein", query = "SELECT f FROM Fiche f WHERE f.petitRein = :petitRein"),
    @NamedQuery(name = "Fiche.findByReinUnique", query = "SELECT f FROM Fiche f WHERE f.reinUnique = :reinUnique"),
    @NamedQuery(name = "Fiche.findByEctopTest", query = "SELECT f FROM Fiche f WHERE f.ectopTest = :ectopTest"),
    @NamedQuery(name = "Fiche.findByVergeInsuf", query = "SELECT f FROM Fiche f WHERE f.vergeInsuf = :vergeInsuf"),
    @NamedQuery(name = "Fiche.findByAutreAnomVerge", query = "SELECT f FROM Fiche f WHERE f.autreAnomVerge = :autreAnomVerge"),
    @NamedQuery(name = "Fiche.findByRetardPubertaire", query = "SELECT f FROM Fiche f WHERE f.retardPubertaire = :retardPubertaire"),
    @NamedQuery(name = "Fiche.findByMTanner", query = "SELECT f FROM Fiche f WHERE f.mTanner = :mTanner"),
    @NamedQuery(name = "Fiche.findByPTanner", query = "SELECT f FROM Fiche f WHERE f.pTanner = :pTanner"),
    @NamedQuery(name = "Fiche.findByTTanner", query = "SELECT f FROM Fiche f WHERE f.tTanner = :tTanner"),
    @NamedQuery(name = "Fiche.findByAnomUrin", query = "SELECT f FROM Fiche f WHERE f.anomUrin = :anomUrin"),
    @NamedQuery(name = "Fiche.findByTypeAnomUrin", query = "SELECT f FROM Fiche f WHERE f.typeAnomUrin = :typeAnomUrin"),
    @NamedQuery(name = "Fiche.findByAtteinteOss", query = "SELECT f FROM Fiche f WHERE f.atteinteOss = :atteinteOss"),
    @NamedQuery(name = "Fiche.findByRadiosfaites", query = "SELECT f FROM Fiche f WHERE f.radiosfaites = :radiosfaites"),
    @NamedQuery(name = "Fiche.findByAnomPouce", query = "SELECT f FROM Fiche f WHERE f.anomPouce = :anomPouce"),
    @NamedQuery(name = "Fiche.findBySurnumerarie", query = "SELECT f FROM Fiche f WHERE f.surnumerarie = :surnumerarie"),
    @NamedQuery(name = "Fiche.findByAgenesiePouce", query = "SELECT f FROM Fiche f WHERE f.agenesiePouce = :agenesiePouce"),
    @NamedQuery(name = "Fiche.findByBifide", query = "SELECT f FROM Fiche f WHERE f.bifide = :bifide"),
    @NamedQuery(name = "Fiche.findByHypoPouce", query = "SELECT f FROM Fiche f WHERE f.hypoPouce = :hypoPouce"),
    @NamedQuery(name = "Fiche.findByAspectPouce", query = "SELECT f FROM Fiche f WHERE f.aspectPouce = :aspectPouce"),
    @NamedQuery(name = "Fiche.findByHypoEminence", query = "SELECT f FROM Fiche f WHERE f.hypoEminence = :hypoEminence"),
    @NamedQuery(name = "Fiche.findByAbsenceRadial", query = "SELECT f FROM Fiche f WHERE f.absenceRadial = :absenceRadial"),
    @NamedQuery(name = "Fiche.findByPouceBas", query = "SELECT f FROM Fiche f WHERE f.pouceBas = :pouceBas"),
    @NamedQuery(name = "Fiche.findByAutreAnomPouce", query = "SELECT f FROM Fiche f WHERE f.autreAnomPouce = :autreAnomPouce"),
    @NamedQuery(name = "Fiche.findByAnomAutDoigts", query = "SELECT f FROM Fiche f WHERE f.anomAutDoigts = :anomAutDoigts"),
    @NamedQuery(name = "Fiche.findByCourtstrapus", query = "SELECT f FROM Fiche f WHERE f.courtstrapus = :courtstrapus"),
    @NamedQuery(name = "Fiche.findBySyndactylie", query = "SELECT f FROM Fiche f WHERE f.syndactylie = :syndactylie"),
    @NamedQuery(name = "Fiche.findByAutreAnomDoigts", query = "SELECT f FROM Fiche f WHERE f.autreAnomDoigts = :autreAnomDoigts"),
    @NamedQuery(name = "Fiche.findByAnomalieos", query = "SELECT f FROM Fiche f WHERE f.anomalieos = :anomalieos"),
    @NamedQuery(name = "Fiche.findByAgenesieRadius", query = "SELECT f FROM Fiche f WHERE f.agenesieRadius = :agenesieRadius"),
    @NamedQuery(name = "Fiche.findByAutreanomaliemembresup", query = "SELECT f FROM Fiche f WHERE f.autreanomaliemembresup = :autreanomaliemembresup"),
    @NamedQuery(name = "Fiche.findByAnomOrteil", query = "SELECT f FROM Fiche f WHERE f.anomOrteil = :anomOrteil"),
    @NamedQuery(name = "Fiche.findByPreciseAnomOrt", query = "SELECT f FROM Fiche f WHERE f.preciseAnomOrt = :preciseAnomOrt"),
    @NamedQuery(name = "Fiche.findByLch", query = "SELECT f FROM Fiche f WHERE f.lch = :lch"),
    @NamedQuery(name = "Fiche.findByAutreanomaliemembreinf", query = "SELECT f FROM Fiche f WHERE f.autreanomaliemembreinf = :autreanomaliemembreinf"),
    @NamedQuery(name = "Fiche.findByAnomRachis", query = "SELECT f FROM Fiche f WHERE f.anomRachis = :anomRachis"),
    @NamedQuery(name = "Fiche.findByPreciseAnomRac", query = "SELECT f FROM Fiche f WHERE f.preciseAnomRac = :preciseAnomRac"),
    @NamedQuery(name = "Fiche.findByAutreAnomOss", query = "SELECT f FROM Fiche f WHERE f.autreAnomOss = :autreAnomOss"),
    @NamedQuery(name = "Fiche.findByAnomNeuro", query = "SELECT f FROM Fiche f WHERE f.anomNeuro = :anomNeuro"),
    @NamedQuery(name = "Fiche.findByRetardMent", query = "SELECT f FROM Fiche f WHERE f.retardMent = :retardMent"),
    @NamedQuery(name = "Fiche.findByHypoacousie", query = "SELECT f FROM Fiche f WHERE f.hypoacousie = :hypoacousie"),
    @NamedQuery(name = "Fiche.findByStrabisme", query = "SELECT f FROM Fiche f WHERE f.strabisme = :strabisme"),
    @NamedQuery(name = "Fiche.findByPerformanceScolaire", query = "SELECT f FROM Fiche f WHERE f.performanceScolaire = :performanceScolaire"),
    @NamedQuery(name = "Fiche.findByAutreanomalieneurologique", query = "SELECT f FROM Fiche f WHERE f.autreanomalieneurologique = :autreanomalieneurologique"),
    @NamedQuery(name = "Fiche.findByAnomCardVas", query = "SELECT f FROM Fiche f WHERE f.anomCardVas = :anomCardVas"),
    @NamedQuery(name = "Fiche.findByEchoCoeur", query = "SELECT f FROM Fiche f WHERE f.echoCoeur = :echoCoeur"),
    @NamedQuery(name = "Fiche.findByPreciseAnomCardio", query = "SELECT f FROM Fiche f WHERE f.preciseAnomCardio = :preciseAnomCardio"),
    @NamedQuery(name = "Fiche.findByAnomDig", query = "SELECT f FROM Fiche f WHERE f.anomDig = :anomDig"),
    @NamedQuery(name = "Fiche.findByPreciseAnomDig", query = "SELECT f FROM Fiche f WHERE f.preciseAnomDig = :preciseAnomDig"),
    @NamedQuery(name = "Fiche.findByEndocrinopathie", query = "SELECT f FROM Fiche f WHERE f.endocrinopathie = :endocrinopathie"),
    @NamedQuery(name = "Fiche.findByDiabete", query = "SELECT f FROM Fiche f WHERE f.diabete = :diabete"),
    @NamedQuery(name = "Fiche.findByInsulinoDep", query = "SELECT f FROM Fiche f WHERE f.insulinoDep = :insulinoDep"),
    @NamedQuery(name = "Fiche.findByHypothyroidie", query = "SELECT f FROM Fiche f WHERE f.hypothyroidie = :hypothyroidie"),
    @NamedQuery(name = "Fiche.findByAgeDecouverte", query = "SELECT f FROM Fiche f WHERE f.ageDecouverte = :ageDecouverte"),
    @NamedQuery(name = "Fiche.findByAutreEndocrinopathie", query = "SELECT f FROM Fiche f WHERE f.autreEndocrinopathie = :autreEndocrinopathie"),
    @NamedQuery(name = "Fiche.findByAutreAnomCong", query = "SELECT f FROM Fiche f WHERE f.autreAnomCong = :autreAnomCong"),
    @NamedQuery(name = "Fiche.findByDateNumSanguine", query = "SELECT f FROM Fiche f WHERE f.dateNumSanguine = :dateNumSanguine"),
    @NamedQuery(name = "Fiche.findByAge", query = "SELECT f FROM Fiche f WHERE f.age = :age"),
    @NamedQuery(name = "Fiche.findByHb", query = "SELECT f FROM Fiche f WHERE f.hb = :hb"),
    @NamedQuery(name = "Fiche.findByVgm", query = "SELECT f FROM Fiche f WHERE f.vgm = :vgm"),
    @NamedQuery(name = "Fiche.findByRetic", query = "SELECT f FROM Fiche f WHERE f.retic = :retic"),
    @NamedQuery(name = "Fiche.findByLeuco", query = "SELECT f FROM Fiche f WHERE f.leuco = :leuco"),
    @NamedQuery(name = "Fiche.findByPnn", query = "SELECT f FROM Fiche f WHERE f.pnn = :pnn"),
    @NamedQuery(name = "Fiche.findByPlq", query = "SELECT f FROM Fiche f WHERE f.plq = :plq"),
    @NamedQuery(name = "Fiche.findByHbInf", query = "SELECT f FROM Fiche f WHERE f.hbInf = :hbInf"),
    @NamedQuery(name = "Fiche.findByPlqInf", query = "SELECT f FROM Fiche f WHERE f.plqInf = :plqInf"),
    @NamedQuery(name = "Fiche.findByPNNInf", query = "SELECT f FROM Fiche f WHERE f.pNNInf = :pNNInf"),
    @NamedQuery(name = "Fiche.findByElectrophoreseHb", query = "SELECT f FROM Fiche f WHERE f.electrophoreseHb = :electrophoreseHb"),
    @NamedQuery(name = "Fiche.findByHbf", query = "SELECT f FROM Fiche f WHERE f.hbf = :hbf"),
    @NamedQuery(name = "Fiche.findByMyelogramme", query = "SELECT f FROM Fiche f WHERE f.myelogramme = :myelogramme"),
    @NamedQuery(name = "Fiche.findByCellularite", query = "SELECT f FROM Fiche f WHERE f.cellularite = :cellularite"),
    @NamedQuery(name = "Fiche.findByErythroblaste", query = "SELECT f FROM Fiche f WHERE f.erythroblaste = :erythroblaste"),
    @NamedQuery(name = "Fiche.findByMorphologieEryth", query = "SELECT f FROM Fiche f WHERE f.morphologieEryth = :morphologieEryth"),
    @NamedQuery(name = "Fiche.findByMorphologieGran", query = "SELECT f FROM Fiche f WHERE f.morphologieGran = :morphologieGran"),
    @NamedQuery(name = "Fiche.findByMorphologieMega", query = "SELECT f FROM Fiche f WHERE f.morphologieMega = :morphologieMega"),
    @NamedQuery(name = "Fiche.findByGranuleux", query = "SELECT f FROM Fiche f WHERE f.granuleux = :granuleux"),
    @NamedQuery(name = "Fiche.findByDysmyelopoiese", query = "SELECT f FROM Fiche f WHERE f.dysmyelopoiese = :dysmyelopoiese"),
    @NamedQuery(name = "Fiche.findByMegacaryocytes", query = "SELECT f FROM Fiche f WHERE f.megacaryocytes = :megacaryocytes"),
    @NamedQuery(name = "Fiche.findByBlaste", query = "SELECT f FROM Fiche f WHERE f.blaste = :blaste"),
    @NamedQuery(name = "Fiche.findByExcesblastes", query = "SELECT f FROM Fiche f WHERE f.excesblastes = :excesblastes"),
    @NamedQuery(name = "Fiche.findByBom", query = "SELECT f FROM Fiche f WHERE f.bom = :bom"),
    @NamedQuery(name = "Fiche.findByAdipocytes", query = "SELECT f FROM Fiche f WHERE f.adipocytes = :adipocytes"),
    @NamedQuery(name = "Fiche.findByUbiquitination", query = "SELECT f FROM Fiche f WHERE f.ubiquitination = :ubiquitination"),
    @NamedQuery(name = "Fiche.findByResUbiquitination", query = "SELECT f FROM Fiche f WHERE f.resUbiquitination = :resUbiquitination"),
    @NamedQuery(name = "Fiche.findByGroupComp", query = "SELECT f FROM Fiche f WHERE f.groupComp = :groupComp"),
    @NamedQuery(name = "Fiche.findByMutationFANC", query = "SELECT f FROM Fiche f WHERE f.mutationFANC = :mutationFANC"),
    @NamedQuery(name = "Fiche.findByCongelationCellule", query = "SELECT f FROM Fiche f WHERE f.congelationCellule = :congelationCellule"),
    @NamedQuery(name = "Fiche.findByLabo", query = "SELECT f FROM Fiche f WHERE f.labo = :labo"),
    @NamedQuery(name = "Fiche.findByTypePrelevement", query = "SELECT f FROM Fiche f WHERE f.typePrelevement = :typePrelevement"),
    @NamedQuery(name = "Fiche.findByScoreClinique", query = "SELECT f FROM Fiche f WHERE f.scoreClinique = :scoreClinique"),
    @NamedQuery(name = "Fiche.findByScoreEBMT", query = "SELECT f FROM Fiche f WHERE f.scoreEBMT = :scoreEBMT"),
    @NamedQuery(name = "Fiche.findByScore", query = "SELECT f FROM Fiche f WHERE f.score = :score"),
    @NamedQuery(name = "Fiche.findByTransfusion", query = "SELECT f FROM Fiche f WHERE f.transfusion = :transfusion"),
    @NamedQuery(name = "Fiche.findByAgeTransf", query = "SELECT f FROM Fiche f WHERE f.ageTransf = :ageTransf"),
    @NamedQuery(name = "Fiche.findByDelaiDiag", query = "SELECT f FROM Fiche f WHERE f.delaiDiag = :delaiDiag"),
    @NamedQuery(name = "Fiche.findByNbCG", query = "SELECT f FROM Fiche f WHERE f.nbCG = :nbCG"),
    @NamedQuery(name = "Fiche.findByNbCP", query = "SELECT f FROM Fiche f WHERE f.nbCP = :nbCP"),
    @NamedQuery(name = "Fiche.findByChelationFer", query = "SELECT f FROM Fiche f WHERE f.chelationFer = :chelationFer"),
    @NamedQuery(name = "Fiche.findByChelateur", query = "SELECT f FROM Fiche f WHERE f.chelateur = :chelateur"),
    @NamedQuery(name = "Fiche.findByNilevar", query = "SELECT f FROM Fiche f WHERE f.nilevar = :nilevar"),
    @NamedQuery(name = "Fiche.findByOxynethadone", query = "SELECT f FROM Fiche f WHERE f.oxynethadone = :oxynethadone"),
    @NamedQuery(name = "Fiche.findByAndrotordyl", query = "SELECT f FROM Fiche f WHERE f.androtordyl = :androtordyl"),
    @NamedQuery(name = "Fiche.findByAutreAndrogene", query = "SELECT f FROM Fiche f WHERE f.autreAndrogene = :autreAndrogene"),
    @NamedQuery(name = "Fiche.findByAndroDebut", query = "SELECT f FROM Fiche f WHERE f.androDebut = :androDebut"),
    @NamedQuery(name = "Fiche.findByAndroFin", query = "SELECT f FROM Fiche f WHERE f.androFin = :androFin"),
    @NamedQuery(name = "Fiche.findByObservance", query = "SELECT f FROM Fiche f WHERE f.observance = :observance"),
    @NamedQuery(name = "Fiche.findByToxicite", query = "SELECT f FROM Fiche f WHERE f.toxicite = :toxicite"),
    @NamedQuery(name = "Fiche.findByAutreToxicite", query = "SELECT f FROM Fiche f WHERE f.autreToxicite = :autreToxicite"),
    @NamedQuery(name = "Fiche.findByEnqueteHLA", query = "SELECT f FROM Fiche f WHERE f.enqueteHLA = :enqueteHLA"),
    @NamedQuery(name = "Fiche.findByPourquoiEnqHLA", query = "SELECT f FROM Fiche f WHERE f.pourquoiEnqHLA = :pourquoiEnqHLA"),
    @NamedQuery(name = "Fiche.findByNbFratTyp", query = "SELECT f FROM Fiche f WHERE f.nbFratTyp = :nbFratTyp"),
    @NamedQuery(name = "Fiche.findByNbFratNTyp", query = "SELECT f FROM Fiche f WHERE f.nbFratNTyp = :nbFratNTyp"),
    @NamedQuery(name = "Fiche.findByDonneurComp", query = "SELECT f FROM Fiche f WHERE f.donneurComp = :donneurComp"),
    @NamedQuery(name = "Fiche.findByPreciseDonneur", query = "SELECT f FROM Fiche f WHERE f.preciseDonneur = :preciseDonneur"),
    @NamedQuery(name = "Fiche.findByDonneur", query = "SELECT f FROM Fiche f WHERE f.donneur = :donneur"),
    @NamedQuery(name = "Fiche.findByGreffeFaite", query = "SELECT f FROM Fiche f WHERE f.greffeFaite = :greffeFaite"),
    @NamedQuery(name = "Fiche.findByDelaiRappDiag", query = "SELECT f FROM Fiche f WHERE f.delaiRappDiag = :delaiRappDiag"),
    @NamedQuery(name = "Fiche.findByPourquoiNfaite", query = "SELECT f FROM Fiche f WHERE f.pourquoiNfaite = :pourquoiNfaite"),
    @NamedQuery(name = "Fiche.findByCyclophosphamide", query = "SELECT f FROM Fiche f WHERE f.cyclophosphamide = :cyclophosphamide"),
    @NamedQuery(name = "Fiche.findByFludarabine", query = "SELECT f FROM Fiche f WHERE f.fludarabine = :fludarabine"),
    @NamedQuery(name = "Fiche.findByBusulfan", query = "SELECT f FROM Fiche f WHERE f.busulfan = :busulfan"),
    @NamedQuery(name = "Fiche.findByDoseCyclo", query = "SELECT f FROM Fiche f WHERE f.doseCyclo = :doseCyclo"),
    @NamedQuery(name = "Fiche.findByDoseFlu", query = "SELECT f FROM Fiche f WHERE f.doseFlu = :doseFlu"),
    @NamedQuery(name = "Fiche.findByDoseBus", query = "SELECT f FROM Fiche f WHERE f.doseBus = :doseBus"),
    @NamedQuery(name = "Fiche.findByAutreConditionnement", query = "SELECT f FROM Fiche f WHERE f.autreConditionnement = :autreConditionnement"),
    @NamedQuery(name = "Fiche.findByIrradiation", query = "SELECT f FROM Fiche f WHERE f.irradiation = :irradiation"),
    @NamedQuery(name = "Fiche.findByDoseTotaleIrr", query = "SELECT f FROM Fiche f WHERE f.doseTotaleIrr = :doseTotaleIrr"),
    @NamedQuery(name = "Fiche.findBySerotherapie", query = "SELECT f FROM Fiche f WHERE f.serotherapie = :serotherapie"),
    @NamedQuery(name = "Fiche.findBySal", query = "SELECT f FROM Fiche f WHERE f.sal = :sal"),
    @NamedQuery(name = "Fiche.findByDoseSAL", query = "SELECT f FROM Fiche f WHERE f.doseSAL = :doseSAL"),
    @NamedQuery(name = "Fiche.findBySourceCellule", query = "SELECT f FROM Fiche f WHERE f.sourceCellule = :sourceCellule"),
    @NamedQuery(name = "Fiche.findBySortieAplasie", query = "SELECT f FROM Fiche f WHERE f.sortieAplasie = :sortieAplasie"),
    @NamedQuery(name = "Fiche.findByGradeaGvH", query = "SELECT f FROM Fiche f WHERE f.gradeaGvH = :gradeaGvH"),
    @NamedQuery(name = "Fiche.findByCGvH", query = "SELECT f FROM Fiche f WHERE f.cGvH = :cGvH"),
    @NamedQuery(name = "Fiche.findByMvo", query = "SELECT f FROM Fiche f WHERE f.mvo = :mvo"),
    @NamedQuery(name = "Fiche.findByComplicationPulmonaire", query = "SELECT f FROM Fiche f WHERE f.complicationPulmonaire = :complicationPulmonaire"),
    @NamedQuery(name = "Fiche.findByPreciseCompPulm", query = "SELECT f FROM Fiche f WHERE f.preciseCompPulm = :preciseCompPulm"),
    @NamedQuery(name = "Fiche.findBySurvieJ100", query = "SELECT f FROM Fiche f WHERE f.survieJ100 = :survieJ100"),
    @NamedQuery(name = "Fiche.findBySmd", query = "SELECT f FROM Fiche f WHERE f.smd = :smd"),
    @NamedQuery(name = "Fiche.findByAgeDiagSMD", query = "SELECT f FROM Fiche f WHERE f.ageDiagSMD = :ageDiagSMD"),
    @NamedQuery(name = "Fiche.findByCritereDiagSMD", query = "SELECT f FROM Fiche f WHERE f.critereDiagSMD = :critereDiagSMD"),
    @NamedQuery(name = "Fiche.findByTraitementSMD", query = "SELECT f FROM Fiche f WHERE f.traitementSMD = :traitementSMD"),
    @NamedQuery(name = "Fiche.findByLam", query = "SELECT f FROM Fiche f WHERE f.lam = :lam"),
    @NamedQuery(name = "Fiche.findByCritereDiagLAM", query = "SELECT f FROM Fiche f WHERE f.critereDiagLAM = :critereDiagLAM"),
    @NamedQuery(name = "Fiche.findByTraitementLAM", query = "SELECT f FROM Fiche f WHERE f.traitementLAM = :traitementLAM"),
    @NamedQuery(name = "Fiche.findByAutresCancers", query = "SELECT f FROM Fiche f WHERE f.autresCancers = :autresCancers"),
    @NamedQuery(name = "Fiche.findByDdn", query = "SELECT f FROM Fiche f WHERE f.ddn = :ddn"),
    @NamedQuery(name = "Fiche.findByTransformationAigue", query = "SELECT f FROM Fiche f WHERE f.transformationAigue = :transformationAigue"),
    @NamedQuery(name = "Fiche.findByAgeDiagLA", query = "SELECT f FROM Fiche f WHERE f.ageDiagLA = :ageDiagLA"),
    @NamedQuery(name = "Fiche.findByTraitementLA", query = "SELECT f FROM Fiche f WHERE f.traitementLA = :traitementLA"),
    @NamedQuery(name = "Fiche.findByCancerE", query = "SELECT f FROM Fiche f WHERE f.cancerE = :cancerE"),
    @NamedQuery(name = "Fiche.findByLocalisation", query = "SELECT f FROM Fiche f WHERE f.localisation = :localisation"),
    @NamedQuery(name = "Fiche.findByTypeHistologique", query = "SELECT f FROM Fiche f WHERE f.typeHistologique = :typeHistologique"),
    @NamedQuery(name = "Fiche.findByTraitementCancer", query = "SELECT f FROM Fiche f WHERE f.traitementCancer = :traitementCancer"),
    @NamedQuery(name = "Fiche.findByPreciseTraitement", query = "SELECT f FROM Fiche f WHERE f.preciseTraitement = :preciseTraitement"),
    @NamedQuery(name = "Fiche.findByEvolutionCyto", query = "SELECT f FROM Fiche f WHERE f.evolutionCyto = :evolutionCyto"),
    @NamedQuery(name = "Fiche.findByFormuleChrom", query = "SELECT f FROM Fiche f WHERE f.formuleChrom = :formuleChrom"),
    @NamedQuery(name = "Fiche.findByAgeE", query = "SELECT f FROM Fiche f WHERE f.ageE = :ageE"),
    @NamedQuery(name = "Fiche.findByStatut", query = "SELECT f FROM Fiche f WHERE f.statut = :statut"),
    @NamedQuery(name = "Fiche.findByCauseDeces", query = "SELECT f FROM Fiche f WHERE f.causeDeces = :causeDeces"),
    @NamedQuery(name = "Fiche.findByAutreCauseD", query = "SELECT f FROM Fiche f WHERE f.autreCauseD = :autreCauseD"),
    @NamedQuery(name = "Fiche.findBySurvieGlobale", query = "SELECT f FROM Fiche f WHERE f.survieGlobale = :survieGlobale"),
    @NamedQuery(name = "Fiche.findByCode", query = "SELECT f FROM Fiche f WHERE f.code = :code")})
public class Fiche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "N_Dossier", nullable = false, length = 10)
    private String nDossier;
    @Size(max = 10)
    @Column(name = "Date_Diagnostic")
    @Temporal(TemporalType.DATE)
    private Date dateDiagnostic;
    @Size(max = 10)
    @Column(name = "Date_Enregistrement")
    @Temporal(TemporalType.DATE)
    private Date dateEnregistrement;
    @Size(max = 10)
    @Column(name = "DateMAJ")
    @Temporal(TemporalType.DATE)
    private Date dateMAJ;
    @Size(max = 8)
    @Column(name = "medecin", length = 8)
    private String medecin;
    @Column(name = "Hopital")
    private Integer hopital;
    @Column(name = "Service")
    private Integer service;
    @Size(max = 50)
    @Column(name = "DegConsang", length = 50)
    private String degConsang;
    @Column(name = "PlaceEnfant")
    private Integer placeEnfant;
    @Column(name = "NbVivant")
    private Integer nbVivant;
    @Column(name = "NbMort")
    private Integer nbMort;
    @Column(name = "MortNe")
    private Integer mortNe;
    @Column(name = "Avortement")
    private Integer avortement;
    @Column(name = "Cousin")
    private Integer cousin;
    @Column(name = "Membre")
    private Integer membre;
    @Lob
    @Column(name = "Arbre_genealogique")
    private byte[] arbregenealogique;
    @Lob
    @Column(name = "Arbre_genealogique_cancer")
    private byte[] arbregenealogiquecancer;
    @Size(max = 4)
    @Column(name = "SyndromeAnemique", length = 4)
    private String syndromeAnemique;
    @Size(max = 4)
    @Column(name = "SyndromeHem", length = 4)
    private String syndromeHem;
    @Size(max = 4)
    @Column(name = "SyndromeInf", length = 4)
    private String syndromeInf;
    @Size(max = 4)
    @Column(name = "DecouverteFort", length = 4)
    private String decouverteFort;
    @Size(max = 4)
    @Column(name = "EnqueteFam", length = 4)
    private String enqueteFam;
    @Size(max = 30)
    @Column(name = "TypeCancer", length = 30)
    private String typeCancer;
    @Size(max = 3)
    @Column(name = "Cancer", length = 3)
    private String cancer;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TailleNaiss", precision = 12)
    private Float tailleNaiss;
    @Column(name = "PoidsNaiss", precision = 12)
    private Float poidsNaiss;
    @Size(max = 4)
    @Column(name = "Hypotrophie", length = 4)
    private String hypotrophie;
    @Size(max = 4)
    @Column(name = "TroubleCroi", length = 4)
    private String troubleCroi;
    @Column(name = "AAgeChDiag")
    private Integer aAgeChDiag;
    @Column(name = "MAgeChDiag")
    private Integer mAgeChDiag;
    @Column(name = "AAgeOssDiag")
    private Integer aAgeOssDiag;
    @Column(name = "MAgeOssDiag")
    private Integer mAgeOssDiag;
    @Column(name = "AgeRetard")
    private Integer ageRetard;
    @Column(name = "Poids", precision = 12)
    private Float poids;
    @Column(name = "PoidsDS", length = 20)
    private String poidsDS;
    @Column(name = "Taille", precision = 12)
    private Float taille;
    @Size(max = 20)
    @Column(name = "TailleDS", length = 20)
    private String tailleDS;
    @Size(max = 4)
    @Column(name = "AtteinteCut", length = 4)
    private String atteinteCut;
    @Size(max = 4)
    @Column(name = "TacheCaf", length = 4)
    private String tacheCaf;
    @Size(max = 4)
    @Column(name = "Ventre", length = 4)
    private String ventre;
    @Size(max = 4)
    @Column(name = "MembreSup", length = 4)
    private String membreSup;
    @Size(max = 4)
    @Column(name = "MembreInf", length = 4)
    private String membreInf;
    @Size(max = 4)
    @Column(name = "Visage", length = 4)
    private String visage;
    @Size(max = 4)
    @Column(name = "Thorax", length = 4)
    private String thorax;
    @Size(max = 4)
    @Column(name = "DOS", length = 4)
    private String dos;
    @Size(max = 4)
    @Column(name = "HyperPig", length = 4)
    private String hyperPig;
    @Size(max = 4)
    @Column(name = "Hypochromique", length = 4)
    private String hypochromique;
    @Size(max = 10)
    @Column(name = "CouleurPeau", length = 10)
    private String couleurPeau;
    @Size(max = 50)
    @Column(name = "AutreAtCut", length = 50)
    private String autreAtCut;
    @Size(max = 4)
    @Column(name = "AtteinteTete", length = 4)
    private String atteinteTete;
    @Size(max = 4)
    @Column(name = "Microcephalie", length = 4)
    private String microcephalie;
    @Size(max = 4)
    @Column(name = "Microphtalmie", length = 4)
    private String microphtalmie;
    @Size(max = 4)
    @Column(name = "FacieTrig", length = 4)
    private String facieTrig;
    @Size(max = 4)
    @Column(name = "TraitsFin", length = 4)
    private String traitsFin;
    @Size(max = 100)
    @Column(name = "AutreAtTete", length = 100)
    private String autreAtTete;
    @Size(max = 4)
    @Column(name = "Empreinte_digitiforme", length = 4)
    private String empreintedigitiforme;
    @Size(max = 4)
    @Column(name = "MalUro", length = 4)
    private String malUro;
    @Size(max = 9)
    @Column(name = "UIV", length = 9)
    private String uiv;
    @Size(max = 9)
    @Column(name = "Echo", length = 9)
    private String echo;
    @Size(max = 4)
    @Column(name = "ReinEctop", length = 4)
    private String reinEctop;
    @Size(max = 30)
    @Column(name = "SiegeEctopie", length = 30)
    private String siegeEctopie;
    @Size(max = 4)
    @Column(name = "ReinFerChev", length = 4)
    private String reinFerChev;
    @Size(max = 15)
    @Column(name = "PetitRein", length = 15)
    private String petitRein;
    @Size(max = 4)
    @Column(name = "ReinUnique", length = 4)
    private String reinUnique;
    @Size(max = 10)
    @Column(name = "EctopTest", length = 10)
    private String ectopTest;
    @Size(max = 30)
    @Column(name = "VergeInsuf", length = 30)
    private String vergeInsuf;
    @Size(max = 30)
    @Column(name = "AutreAnomVerge", length = 30)
    private String autreAnomVerge;
    @Size(max = 4)
    @Column(name = "RetardPubertaire", length = 4)
    private String retardPubertaire;
    @Size(max = 10)
    @Column(name = "MTanner", length = 10)
    private String mTanner;
    @Size(max = 10)
    @Column(name = "PTanner", length = 10)
    private String pTanner;
    @Size(max = 10)
    @Column(name = "TTanner", length = 10)
    private String tTanner;
    @Size(max = 4)
    @Column(name = "AnomUrin", length = 4)
    private String anomUrin;
    @Size(max = 100)
    @Column(name = "TypeAnomUrin", length = 100)
    private String typeAnomUrin;
    @Size(max = 4)
    @Column(name = "AtteinteOss", length = 4)
    private String atteinteOss;
    @Size(max = 50)
    @Column(name = "Radios_faites", length = 50)
    private String radiosfaites;
    @Size(max = 4)
    @Column(name = "AnomPouce", length = 4)
    private String anomPouce;
    @Size(max = 4)
    @Column(name = "Surnumerarie", length = 4)
    private String surnumerarie;
    @Size(max = 4)
    @Column(name = "AgenesiePouce", length = 4)
    private String agenesiePouce;
    @Size(max = 4)
    @Column(name = "Bifide", length = 4)
    private String bifide;
    @Size(max = 4)
    @Column(name = "HypoPouce", length = 4)
    private String hypoPouce;
    @Size(max = 4)
    @Column(name = "AspectPouce", length = 4)
    private String aspectPouce;
    @Size(max = 4)
    @Column(name = "HypoEminence", length = 4)
    private String hypoEminence;
    @Size(max = 4)
    @Column(name = "AbsenceRadial", length = 4)
    private String absenceRadial;
    @Size(max = 4)
    @Column(name = "PouceBas", length = 4)
    private String pouceBas;
    @Size(max = 50)
    @Column(name = "AutreAnomPouce", length = 50)
    private String autreAnomPouce;
    @Size(max = 4)
    @Column(name = "AnomAutDoigts", length = 4)
    private String anomAutDoigts;
    @Size(max = 4)
    @Column(name = "Courts_trapus", length = 4)
    private String courtstrapus;
    @Size(max = 4)
    @Column(name = "Syndactylie", length = 4)
    private String syndactylie;
    @Size(max = 50)
    @Column(name = "AutreAnomDoigts", length = 50)
    private String autreAnomDoigts;
    @Size(max = 4)
    @Column(name = "Anomalie_os", length = 4)
    private String anomalieos;
    @Size(max = 4)
    @Column(name = "AgenesieRadius", length = 4)
    private String agenesieRadius;
    @Size(max = 50)
    @Column(name = "Autre_anomalie_membre_sup", length = 50)
    private String autreanomaliemembresup;
    @Size(max = 4)
    @Column(name = "AnomOrteil", length = 4)
    private String anomOrteil;
    @Size(max = 50)
    @Column(name = "PreciseAnomOrt", length = 50)
    private String preciseAnomOrt;
    @Size(max = 4)
    @Column(name = "LCH", length = 4)
    private String lch;
    @Size(max = 50)
    @Column(name = "Autre_anomalie_membre_inf", length = 50)
    private String autreanomaliemembreinf;
    @Size(max = 4)
    @Column(name = "AnomRachis", length = 4)
    private String anomRachis;
    @Size(max = 50)
    @Column(name = "PreciseAnomRac", length = 50)
    private String preciseAnomRac;
    @Size(max = 50)
    @Column(name = "AutreAnomOss", length = 50)
    private String autreAnomOss;
    @Size(max = 4)
    @Column(name = "AnomNeuro", length = 4)
    private String anomNeuro;
    @Size(max = 4)
    @Column(name = "RetardMent", length = 4)
    private String retardMent;
    @Size(max = 4)
    @Column(name = "Hypoacousie", length = 4)
    private String hypoacousie;
    @Size(max = 4)
    @Column(name = "Strabisme", length = 4)
    private String strabisme;
    @Size(max = 13)
    @Column(name = "PerformanceScolaire", length = 13)
    private String performanceScolaire;
    @Size(max = 50)
    @Column(name = "Autre_anomalie_neurologique", length = 50)
    private String autreanomalieneurologique;
    @Size(max = 4)
    @Column(name = "AnomCardVas", length = 4)
    private String anomCardVas;
    @Size(max = 4)
    @Column(name = "EchoCoeur", length = 4)
    private String echoCoeur;
    @Size(max = 100)
    @Column(name = "PreciseAnomCardio", length = 100)
    private String preciseAnomCardio;
    @Size(max = 4)
    @Column(name = "AnomDig", length = 4)
    private String anomDig;
    @Size(max = 50)
    @Column(name = "PreciseAnomDig", length = 50)
    private String preciseAnomDig;
    @Size(max = 4)
    @Column(name = "Endocrinopathie", length = 4)
    private String endocrinopathie;
    @Size(max = 4)
    @Column(name = "Diabete", length = 4)
    private String diabete;
    @Size(max = 4)
    @Column(name = "InsulinoDep", length = 4)
    private String insulinoDep;
    @Size(max = 4)
    @Column(name = "Hypothyroidie", length = 4)
    private String hypothyroidie;
    @Column(name = "AgeDecouverte")
    private Integer ageDecouverte;
    @Size(max = 50)
    @Column(name = "AutreEndocrinopathie", length = 50)
    private String autreEndocrinopathie;
    @Size(max = 50)
    @Column(name = "AutreAnomCong", length = 50)
    private String autreAnomCong;
    @Column(name = "Date_Num_Sanguine")
    @Temporal(TemporalType.DATE)
    private Date dateNumSanguine;
    @Column(name = "Age")
    private Integer age;
    @Column(name = "Hb", precision = 12)
    private Float hb;
    @Column(name = "VGM", precision = 12)
    private Float vgm;
    @Column(name = "Retic", precision = 12)
    private Float retic;
    @Column(name = "Leuco", precision = 12)
    private Float leuco;
    @Column(name = "PNN", precision = 12)
    private Float pnn;
    @Column(name = "Plq", precision = 12)
    private Float plq;
    @Size(max = 4)
    @Column(name = "HbInf", length = 4)
    private String hbInf;
    @Size(max = 4)
    @Column(name = "PlqInf", length = 4)
    private String plqInf;
    @Size(max = 4)
    @Column(name = "PNNInf", length = 4)
    private String pNNInf;
    @Size(max = 9)
    @Column(name = "ElectrophoreseHb", length = 9)
    private String electrophoreseHb;
    @Column(name = "Hbf", precision = 12)
    private Float hbf;
    @Size(max = 8)
    @Column(name = "Myelogramme", length = 8)
    private String myelogramme;
    @Size(max = 8)
    @Column(name = "Cellularite", length = 8)
    private String cellularite;
    @Column(name = "Erythroblaste", precision = 12)
    private Float erythroblaste;
    @Size(max = 9)
    @Column(name = "MorphologieEryth", length = 9)
    private String morphologieEryth;
    @Size(max = 9)
    @Column(name = "MorphologieGran", length = 9)
    private String morphologieGran;
    @Size(max = 9)
    @Column(name = "MorphologieMega", length = 9)
    private String morphologieMega;
    @Column(name = "Granuleux", precision = 12)
    private Float granuleux;
    @Size(max = 4)
    @Column(name = "Dysmyelopoiese", length = 4)
    private String dysmyelopoiese;
    @Size(max = 7)
    @Column(name = "Megacaryocytes", length = 7)
    private String megacaryocytes;
    @Column(name = "Blaste", precision = 12)
    private Float blaste;
    @Size(max = 4)
    @Column(name = "Exces_blastes", length = 4)
    private String excesblastes;
    @Size(max = 10)
    @Column(name = "BOM", length = 10)
    private String bom;
    @Column(name = "Adipocytes", precision = 12)
    private Float adipocytes;
    @Size(max = 4)
    @Column(name = "Ubiquitination", length = 4)
    private String ubiquitination;
    @Size(max = 8)
    @Column(name = "ResUbiquitination", length = 8)
    private String resUbiquitination;
    @Size(max = 50)
    @Column(name = "GroupComp", length = 50)
    private String groupComp;
    @Size(max = 50)
    @Column(name = "Mutation_FANC", length = 50)
    private String mutationFANC;
    @Size(max = 9)
    @Column(name = "CongelationCellule", length = 9)
    private String congelationCellule;
    @Size(max = 30)
    @Column(name = "Labo", length = 30)
    private String labo;
    @Size(max = 30)
    @Column(name = "TypePrelevement", length = 30)
    private String typePrelevement;
    @Column(name = "ScoreClinique")
    private Integer scoreClinique;
    @Column(name = "ScoreEBMT")
    private Integer scoreEBMT;
    @Size(max = 8)
    @Column(name = "Score", length = 8)
    private String score;
    @Size(max = 4)
    @Column(name = "Transfusion", length = 4)
    private String transfusion;
    @Column(name = "AgeTransf")
    private Integer ageTransf;
    @Column(name = "DelaiDiag", precision = 12)
    private Float delaiDiag;
    @Size(max = 10)
    @Column(name = "NbCG", length = 10)
    private String nbCG;
    @Size(max = 10)
    @Column(name = "NbCP", length = 10)
    private String nbCP;
    @Size(max = 4)
    @Column(name = "ChelationFer", length = 4)
    private String chelationFer;
    @Size(max = 30)
    @Column(name = "Chelateur", length = 30)
    private String chelateur;
    @Size(max = 4)
    @Column(name = "Nilevar", length = 4)
    private String nilevar;
    @Size(max = 4)
    @Column(name = "Danatrol", length = 4)
    private String danatrol;

    public String getDanatrol() {
        return danatrol;
    }

    public void setDanatrol(String danatrol) {
        this.danatrol = danatrol;
    }
    @Size(max = 4)
    @Column(name = "Oxynethadone", length = 4)
    private String oxynethadone;
    @Size(max = 4)
    @Column(name = "Androtordyl", length = 4)
    private String androtordyl;
    @Size(max = 50)
    @Column(name = "AutreAndrogene", length = 50)
    private String autreAndrogene;
    @Size(max = 10)
    @Column(name = "AndroDebut")
    @Temporal(TemporalType.DATE)
    private Date androDebut;
    @Size(max = 10)
    @Column(name = "AndroFin")
    @Temporal(TemporalType.DATE)
    private Date androFin;
    @Size(max = 30)
    @Column(name = "Observance", length = 30)
    private String observance;
    @Size(max = 13)
    @Column(name = "Toxicite", length = 13)
    private String toxicite;
    @Size(max = 50)
    @Column(name = "AutreToxicite", length = 50)
    private String autreToxicite;
    @Size(max = 4)
    @Column(name = "EnqueteHLA", length = 4)
    private String enqueteHLA;
    @Size(max = 50)
    @Column(name = "PourquoiEnqHLA", length = 50)
    private String pourquoiEnqHLA;
    @Column(name = "NbFratTyp")
    private Integer nbFratTyp;
    @Column(name = "NbFratNTyp")
    private Integer nbFratNTyp;
    @Column(name = "DonneurComp")
    private Integer donneurComp;
    @Size(max = 30)
    @Column(name = "PreciseDonneur", length = 30)
    private String preciseDonneur;
    @Size(max = 20)
    @Column(name = "Donneur", length = 20)
    private String donneur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "GreffeFaite", nullable = false, length = 4)
    private String greffeFaite;
    @Column(name = "DelaiRappDiag", precision = 12)
    private Float delaiRappDiag;
    @Size(max = 50)
    @Column(name = "PourquoiNfaite", length = 50)
    private String pourquoiNfaite;
    @Size(max = 4)
    @Column(name = "Cyclophosphamide", length = 4)
    private String cyclophosphamide;
    @Size(max = 4)
    @Column(name = "Fludarabine", length = 4)
    private String fludarabine;
    @Size(max = 4)
    @Column(name = "Busulfan", length = 4)
    private String busulfan;
    @Column(name = "DoseCyclo", precision = 12)
    private Float doseCyclo;
    @Column(name = "DoseFlu", precision = 12)
    private Float doseFlu;
    @Column(name = "DoseBus", precision = 12)
    private Float doseBus;
    @Size(max = 50)
    @Column(name = "AutreConditionnement", length = 50)
    private String autreConditionnement;
    @Size(max = 30)
    @Column(name = "Irradiation", length = 30)
    private String irradiation;
    @Column(name = "DoseTotaleIrr", precision = 12)
    private Float doseTotaleIrr;
    @Size(max = 10)
    @Column(name = "Serotherapie", length = 10)
    private String serotherapie;
    @Size(max = 4)
    @Column(name = "SAL", length = 4)
    private String sal;
    @Column(name = "DoseSAL", precision = 12)
    private Float doseSAL;
    @Size(max = 17)
    @Column(name = "SourceCellule", length = 17)
    private String sourceCellule;
    @Column(name = "SortieAplasie")
    private Integer sortieAplasie;
    @Size(max = 3)
    @Column(name = "GradeaGvH", length = 3)
    private String gradeaGvH;
    @Size(max = 9)
    @Column(name = "cGvH", length = 9)
    private String cGvH;
    @Size(max = 4)
    @Column(name = "MVO", length = 4)
    private String mvo;
    @Size(max = 4)
    @Column(name = "ComplicationPulmonaire", length = 4)
    private String complicationPulmonaire;
    @Size(max = 30)
    @Column(name = "PreciseCompPulm", length = 30)
    private String preciseCompPulm;
    @Size(max = 4)
    @Column(name = "SurvieJ100", length = 4)
    private String survieJ100;
    @Size(max = 4)
    @Column(name = "SMD", length = 4)
    private String smd;
    @Column(name = "AgeDiagSMD")
    private Integer ageDiagSMD;
    @Size(max = 30)
    @Column(name = "CritereDiagSMD", length = 30)
    private String critereDiagSMD;
    @Size(max = 30)
    @Column(name = "TraitementSMD", length = 30)
    private String traitementSMD;
    @Size(max = 4)
    @Column(name = "LAM", length = 4)
    private String lam;
    @Size(max = 50)
    @Column(name = "CritereDiagLAM", length = 50)
    private String critereDiagLAM;
    @Size(max = 50)
    @Column(name = "TraitementLAM", length = 50)
    private String traitementLAM;
    @Size(max = 50)
    @Column(name = "AutresCancers", length = 50)
    private String autresCancers;
    @Size(max = 10)
    @Column(name = "DDN")
    @Temporal(TemporalType.DATE)
    private Date ddn;    
    @Size(max = 15)
    @Column(name = "TransformationAigue", length = 15)
    private String transformationAigue;
    @Column(name = "AgeDiagLA")
    private Integer ageDiagLA;
    @Size(max = 4)
    @Column(name = "TraitementLA", length = 4)
    private String traitementLA;
    @Size(max = 4)
    @Column(name = "CancerE", length = 4)
    private String cancerE;
    @Size(max = 30)
    @Column(name = "Localisation", length = 30)
    private String localisation;
    @Size(max = 30)
    @Column(name = "TypeHistologique", length = 30)
    private String typeHistologique;
    @Size(max = 4)
    @Column(name = "TraitementCancer", length = 4)
    private String traitementCancer;
    @Size(max = 100)
    @Column(name = "PreciseTraitement", length = 100)
    private String preciseTraitement;
    @Size(max = 4)
    @Column(name = "EvolutionCyto", length = 4)
    private String evolutionCyto;
    @Size(max = 100)
    @Column(name = "FormuleChrom", length = 100)
    private String formuleChrom;
    @Column(name = "AgeE")
    private Integer ageE;
    @Size(max = 6)
    @Column(name = "Statut", length = 6)
    private String statut;
    @Size(max = 50)
    @Column(name = "CauseDeces", length = 50)
    private String causeDeces;
    @Size(max = 300)
    @Column(name = "AutreCauseD", length = 300)
    private String autreCauseD;
    @Column(name = "SurvieGlobale", precision = 12)
    private Float survieGlobale;
    @Basic(optional = false)
    @Column(name = "Code", nullable = false)
    private int code;

    public Fiche() {
    }

    public Fiche(String nDossier) {
        this.nDossier = nDossier;
    }

    public Fiche(String nDossier, String greffeFaite, int code) {
        this.nDossier = nDossier;
        this.greffeFaite = greffeFaite;
        this.code = code;
    }

    public String getNDossier() {
        return nDossier;
    }

    public void setNDossier(String nDossier) {
        this.nDossier = nDossier;
    }

    public Date getDateDiagnostic() {
        return dateDiagnostic;
    }

    public void setDateDiagnostic(Date dateDiagnostic) {
        this.dateDiagnostic = dateDiagnostic;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public String getMedecin() {
        return medecin;
    }

    public void setMedecin(String medecin) {
        this.medecin = medecin;
    }

    public Integer getHopital() {
        return hopital;
    }

    public void setHopital(Integer hopital) {
        this.hopital = hopital;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }

    public String getDegConsang() {
        return degConsang;
    }

    public void setDegConsang(String degConsang) {
        this.degConsang = degConsang;
    }

    public Integer getPlaceEnfant() {
        return placeEnfant;
    }

    public void setPlaceEnfant(Integer placeEnfant) {
        this.placeEnfant = placeEnfant;
    }

    public Integer getNbVivant() {
        return nbVivant;
    }

    public void setNbVivant(Integer nbVivant) {
        this.nbVivant = nbVivant;
    }

    public Integer getNbMort() {
        return nbMort;
    }

    public void setNbMort(Integer nbMort) {
        this.nbMort = nbMort;
    }

    public Integer getMortNe() {
        return mortNe;
    }

    public void setMortNe(Integer mortNe) {
        this.mortNe = mortNe;
    }

    public Integer getAvortement() {
        return avortement;
    }

    public void setAvortement(Integer avortement) {
        this.avortement = avortement;
    }

    public Integer getCousin() {
        return cousin;
    }

    public void setCousin(Integer cousin) {
        this.cousin = cousin;
    }

    public Integer getMembre() {
        return membre;
    }

    public void setMembre(Integer membre) {
        this.membre = membre;
    }

    public byte[] getArbregenealogique() {
        return arbregenealogique;
    }

    public void setArbregenealogique(byte[] arbregenealogique) {
        this.arbregenealogique = arbregenealogique;
    }

    public byte[] getArbregenealogiquecancer() {
        return arbregenealogiquecancer;
    }

    public void setArbregenealogiquecancer(byte[] arbregenealogiquecancer) {
        this.arbregenealogiquecancer = arbregenealogiquecancer;
    }

    public String getSyndromeAnemique() {
        return syndromeAnemique;
    }

    public void setSyndromeAnemique(String syndromeAnemique) {
        this.syndromeAnemique = syndromeAnemique;
    }

    public String getSyndromeHem() {
        return syndromeHem;
    }

    public void setSyndromeHem(String syndromeHem) {
        this.syndromeHem = syndromeHem;
    }

    public String getSyndromeInf() {
        return syndromeInf;
    }

    public void setSyndromeInf(String syndromeInf) {
        this.syndromeInf = syndromeInf;
    }

    public String getDecouverteFort() {
        return decouverteFort;
    }

    public void setDecouverteFort(String decouverteFort) {
        this.decouverteFort = decouverteFort;
    }

    public String getEnqueteFam() {
        return enqueteFam;
    }

    public void setEnqueteFam(String enqueteFam) {
        this.enqueteFam = enqueteFam;
    }

    public String getTypeCancer() {
        return typeCancer;
    }

    public void setTypeCancer(String typeCancer) {
        this.typeCancer = typeCancer;
    }

    public String getCancer() {
        return cancer;
    }

    public void setCancer(String cancer) {
        this.cancer = cancer;
    }

    public Float getTailleNaiss() {
        return tailleNaiss;
    }

    public void setTailleNaiss(Float tailleNaiss) {
        this.tailleNaiss = tailleNaiss;
    }

    public Float getPoidsNaiss() {
        return poidsNaiss;
    }

    public void setPoidsNaiss(Float poidsNaiss) {
        this.poidsNaiss = poidsNaiss;
    }

    public String getHypotrophie() {
        return hypotrophie;
    }

    public void setHypotrophie(String hypotrophie) {
        this.hypotrophie = hypotrophie;
    }

    public String getTroubleCroi() {
        return troubleCroi;
    }

    public void setTroubleCroi(String troubleCroi) {
        this.troubleCroi = troubleCroi;
    }

    public Integer getAAgeChDiag() {
        return aAgeChDiag;
    }

    public void setAAgeChDiag(Integer aAgeChDiag) {
        this.aAgeChDiag = aAgeChDiag;
    }

    public Integer getMAgeChDiag() {
        return mAgeChDiag;
    }

    public void setMAgeChDiag(Integer mAgeChDiag) {
        this.mAgeChDiag = mAgeChDiag;
    }

    public Integer getAAgeOssDiag() {
        return aAgeOssDiag;
    }

    public void setAAgeOssDiag(Integer aAgeOssDiag) {
        this.aAgeOssDiag = aAgeOssDiag;
    }

    public Integer getMAgeOssDiag() {
        return mAgeOssDiag;
    }

    public void setMAgeOssDiag(Integer mAgeOssDiag) {
        this.mAgeOssDiag = mAgeOssDiag;
    }

    public Integer getAgeRetard() {
        return ageRetard;
    }

    public void setAgeRetard(Integer ageRetard) {
        this.ageRetard = ageRetard;
    }

    public Float getPoids() {
        return poids;
    }

    public void setPoids(Float poids) {
        this.poids = poids;
    }

    public String getPoidsDS() {
        return poidsDS;
    }

    public void setPoidsDS(String poidsDS) {
        this.poidsDS = poidsDS;
    }

    public Float getTaille() {
        return taille;
    }

    public void setTaille(Float taille) {
        this.taille = taille;
    }

    public String getTailleDS() {
        return tailleDS;
    }

    public void setTailleDS(String tailleDS) {
        this.tailleDS = tailleDS;
    }

    public String getAtteinteCut() {
        return atteinteCut;
    }

    public void setAtteinteCut(String atteinteCut) {
        this.atteinteCut = atteinteCut;
    }

    public String getTacheCaf() {
        return tacheCaf;
    }

    public void setTacheCaf(String tacheCaf) {
        this.tacheCaf = tacheCaf;
    }

    public String getVentre() {
        return ventre;
    }

    public void setVentre(String ventre) {
        this.ventre = ventre;
    }

    public String getMembreSup() {
        return membreSup;
    }

    public void setMembreSup(String membreSup) {
        this.membreSup = membreSup;
    }

    public String getMembreInf() {
        return membreInf;
    }

    public void setMembreInf(String membreInf) {
        this.membreInf = membreInf;
    }

    public String getVisage() {
        return visage;
    }

    public void setVisage(String visage) {
        this.visage = visage;
    }

    public String getThorax() {
        return thorax;
    }

    public void setThorax(String thorax) {
        this.thorax = thorax;
    }

    public String getDos() {
        return dos;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }

    public String getHyperPig() {
        return hyperPig;
    }

    public void setHyperPig(String hyperPig) {
        this.hyperPig = hyperPig;
    }

    public String getHypochromique() {
        return hypochromique;
    }

    public void setHypochromique(String hypochromique) {
        this.hypochromique = hypochromique;
    }

    public String getCouleurPeau() {
        return couleurPeau;
    }

    public void setCouleurPeau(String couleurPeau) {
        this.couleurPeau = couleurPeau;
    }

    public String getAutreAtCut() {
        return autreAtCut;
    }

    public void setAutreAtCut(String autreAtCut) {
        this.autreAtCut = autreAtCut;
    }

    public String getAtteinteTete() {
        return atteinteTete;
    }

    public void setAtteinteTete(String atteinteTete) {
        this.atteinteTete = atteinteTete;
    }

    public String getMicrocephalie() {
        return microcephalie;
    }

    public void setMicrocephalie(String microcephalie) {
        this.microcephalie = microcephalie;
    }

    public String getMicrophtalmie() {
        return microphtalmie;
    }

    public void setMicrophtalmie(String microphtalmie) {
        this.microphtalmie = microphtalmie;
    }

    public String getFacieTrig() {
        return facieTrig;
    }

    public void setFacieTrig(String facieTrig) {
        this.facieTrig = facieTrig;
    }

    public String getTraitsFin() {
        return traitsFin;
    }

    public void setTraitsFin(String traitsFin) {
        this.traitsFin = traitsFin;
    }

    public String getAutreAtTete() {
        return autreAtTete;
    }

    public void setAutreAtTete(String autreAtTete) {
        this.autreAtTete = autreAtTete;
    }

    public String getEmpreintedigitiforme() {
        return empreintedigitiforme;
    }

    public void setEmpreintedigitiforme(String empreintedigitiforme) {
        this.empreintedigitiforme = empreintedigitiforme;
    }

    public String getMalUro() {
        return malUro;
    }

    public void setMalUro(String malUro) {
        this.malUro = malUro;
    }

    public String getUiv() {
        return uiv;
    }

    public void setUiv(String uiv) {
        this.uiv = uiv;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

    public String getReinEctop() {
        return reinEctop;
    }

    public void setReinEctop(String reinEctop) {
        this.reinEctop = reinEctop;
    }

    public String getSiegeEctopie() {
        return siegeEctopie;
    }

    public void setSiegeEctopie(String siegeEctopie) {
        this.siegeEctopie = siegeEctopie;
    }

    public String getReinFerChev() {
        return reinFerChev;
    }

    public void setReinFerChev(String reinFerChev) {
        this.reinFerChev = reinFerChev;
    }

    public String getPetitRein() {
        return petitRein;
    }

    public void setPetitRein(String petitRein) {
        this.petitRein = petitRein;
    }

    public String getReinUnique() {
        return reinUnique;
    }

    public void setReinUnique(String reinUnique) {
        this.reinUnique = reinUnique;
    }

    public String getEctopTest() {
        return ectopTest;
    }

    public void setEctopTest(String ectopTest) {
        this.ectopTest = ectopTest;
    }

    public String getVergeInsuf() {
        return vergeInsuf;
    }

    public void setVergeInsuf(String vergeInsuf) {
        this.vergeInsuf = vergeInsuf;
    }

    public String getAutreAnomVerge() {
        return autreAnomVerge;
    }

    public void setAutreAnomVerge(String autreAnomVerge) {
        this.autreAnomVerge = autreAnomVerge;
    }

    public String getRetardPubertaire() {
        return retardPubertaire;
    }

    public void setRetardPubertaire(String retardPubertaire) {
        this.retardPubertaire = retardPubertaire;
    }

    public String getMTanner() {
        return mTanner;
    }

    public void setMTanner(String mTanner) {
        this.mTanner = mTanner;
    }

    public String getPTanner() {
        return pTanner;
    }

    public void setPTanner(String pTanner) {
        this.pTanner = pTanner;
    }

    public String getTTanner() {
        return tTanner;
    }

    public void setTTanner(String tTanner) {
        this.tTanner = tTanner;
    }

    public String getAnomUrin() {
        return anomUrin;
    }

    public void setAnomUrin(String anomUrin) {
        this.anomUrin = anomUrin;
    }

    public String getTypeAnomUrin() {
        return typeAnomUrin;
    }

    public void setTypeAnomUrin(String typeAnomUrin) {
        this.typeAnomUrin = typeAnomUrin;
    }

    public String getAtteinteOss() {
        return atteinteOss;
    }

    public void setAtteinteOss(String atteinteOss) {
        this.atteinteOss = atteinteOss;
    }

    public String getRadiosfaites() {
        return radiosfaites;
    }

    public void setRadiosfaites(String radiosfaites) {
        this.radiosfaites = radiosfaites;
    }

    public String getAnomPouce() {
        return anomPouce;
    }

    public void setAnomPouce(String anomPouce) {
        this.anomPouce = anomPouce;
    }

    public String getSurnumerarie() {
        return surnumerarie;
    }

    public void setSurnumerarie(String surnumerarie) {
        this.surnumerarie = surnumerarie;
    }

    public String getAgenesiePouce() {
        return agenesiePouce;
    }

    public void setAgenesiePouce(String agenesiePouce) {
        this.agenesiePouce = agenesiePouce;
    }

    public String getBifide() {
        return bifide;
    }

    public void setBifide(String bifide) {
        this.bifide = bifide;
    }

    public String getHypoPouce() {
        return hypoPouce;
    }

    public void setHypoPouce(String hypoPouce) {
        this.hypoPouce = hypoPouce;
    }

    public String getAspectPouce() {
        return aspectPouce;
    }

    public void setAspectPouce(String aspectPouce) {
        this.aspectPouce = aspectPouce;
    }

    public String getHypoEminence() {
        return hypoEminence;
    }

    public void setHypoEminence(String hypoEminence) {
        this.hypoEminence = hypoEminence;
    }

    public String getAbsenceRadial() {
        return absenceRadial;
    }

    public void setAbsenceRadial(String absenceRadial) {
        this.absenceRadial = absenceRadial;
    }

    public String getPouceBas() {
        return pouceBas;
    }

    public void setPouceBas(String pouceBas) {
        this.pouceBas = pouceBas;
    }

    public String getAutreAnomPouce() {
        return autreAnomPouce;
    }

    public void setAutreAnomPouce(String autreAnomPouce) {
        this.autreAnomPouce = autreAnomPouce;
    }

    public String getAnomAutDoigts() {
        return anomAutDoigts;
    }

    public void setAnomAutDoigts(String anomAutDoigts) {
        this.anomAutDoigts = anomAutDoigts;
    }

    public String getCourtstrapus() {
        return courtstrapus;
    }

    public void setCourtstrapus(String courtstrapus) {
        this.courtstrapus = courtstrapus;
    }

    public String getSyndactylie() {
        return syndactylie;
    }

    public void setSyndactylie(String syndactylie) {
        this.syndactylie = syndactylie;
    }

    public String getAutreAnomDoigts() {
        return autreAnomDoigts;
    }

    public void setAutreAnomDoigts(String autreAnomDoigts) {
        this.autreAnomDoigts = autreAnomDoigts;
    }

    public String getAnomalieos() {
        return anomalieos;
    }

    public void setAnomalieos(String anomalieos) {
        this.anomalieos = anomalieos;
    }

    public String getAgenesieRadius() {
        return agenesieRadius;
    }

    public void setAgenesieRadius(String agenesieRadius) {
        this.agenesieRadius = agenesieRadius;
    }

    public String getAutreanomaliemembresup() {
        return autreanomaliemembresup;
    }

    public void setAutreanomaliemembresup(String autreanomaliemembresup) {
        this.autreanomaliemembresup = autreanomaliemembresup;
    }

    public String getAnomOrteil() {
        return anomOrteil;
    }

    public void setAnomOrteil(String anomOrteil) {
        this.anomOrteil = anomOrteil;
    }

    public String getPreciseAnomOrt() {
        return preciseAnomOrt;
    }

    public void setPreciseAnomOrt(String preciseAnomOrt) {
        this.preciseAnomOrt = preciseAnomOrt;
    }

    public String getLch() {
        return lch;
    }

    public void setLch(String lch) {
        this.lch = lch;
    }

    public String getAutreanomaliemembreinf() {
        return autreanomaliemembreinf;
    }

    public void setAutreanomaliemembreinf(String autreanomaliemembreinf) {
        this.autreanomaliemembreinf = autreanomaliemembreinf;
    }

    public String getAnomRachis() {
        return anomRachis;
    }

    public void setAnomRachis(String anomRachis) {
        this.anomRachis = anomRachis;
    }

    public String getPreciseAnomRac() {
        return preciseAnomRac;
    }

    public void setPreciseAnomRac(String preciseAnomRac) {
        this.preciseAnomRac = preciseAnomRac;
    }

    public String getAutreAnomOss() {
        return autreAnomOss;
    }

    public void setAutreAnomOss(String autreAnomOss) {
        this.autreAnomOss = autreAnomOss;
    }

    public String getAnomNeuro() {
        return anomNeuro;
    }

    public void setAnomNeuro(String anomNeuro) {
        this.anomNeuro = anomNeuro;
    }

    public String getRetardMent() {
        return retardMent;
    }

    public void setRetardMent(String retardMent) {
        this.retardMent = retardMent;
    }

    public String getHypoacousie() {
        return hypoacousie;
    }

    public void setHypoacousie(String hypoacousie) {
        this.hypoacousie = hypoacousie;
    }

    public String getStrabisme() {
        return strabisme;
    }

    public void setStrabisme(String strabisme) {
        this.strabisme = strabisme;
    }

    public String getPerformanceScolaire() {
        return performanceScolaire;
    }

    public void setPerformanceScolaire(String performanceScolaire) {
        this.performanceScolaire = performanceScolaire;
    }

    public String getAutreanomalieneurologique() {
        return autreanomalieneurologique;
    }

    public void setAutreanomalieneurologique(String autreanomalieneurologique) {
        this.autreanomalieneurologique = autreanomalieneurologique;
    }

    public String getAnomCardVas() {
        return anomCardVas;
    }

    public void setAnomCardVas(String anomCardVas) {
        this.anomCardVas = anomCardVas;
    }

    public String getEchoCoeur() {
        return echoCoeur;
    }

    public void setEchoCoeur(String echoCoeur) {
        this.echoCoeur = echoCoeur;
    }

    public String getPreciseAnomCardio() {
        return preciseAnomCardio;
    }

    public void setPreciseAnomCardio(String preciseAnomCardio) {
        this.preciseAnomCardio = preciseAnomCardio;
    }

    public String getAnomDig() {
        return anomDig;
    }

    public void setAnomDig(String anomDig) {
        this.anomDig = anomDig;
    }

    public String getPreciseAnomDig() {
        return preciseAnomDig;
    }

    public void setPreciseAnomDig(String preciseAnomDig) {
        this.preciseAnomDig = preciseAnomDig;
    }

    public String getEndocrinopathie() {
        return endocrinopathie;
    }

    public void setEndocrinopathie(String endocrinopathie) {
        this.endocrinopathie = endocrinopathie;
    }

    public String getDiabete() {
        return diabete;
    }

    public void setDiabete(String diabete) {
        this.diabete = diabete;
    }

    public String getInsulinoDep() {
        return insulinoDep;
    }

    public void setInsulinoDep(String insulinoDep) {
        this.insulinoDep = insulinoDep;
    }

    public String getHypothyroidie() {
        return hypothyroidie;
    }

    public void setHypothyroidie(String hypothyroidie) {
        this.hypothyroidie = hypothyroidie;
    }

    public Integer getAgeDecouverte() {
        return ageDecouverte;
    }

    public void setAgeDecouverte(Integer ageDecouverte) {
        this.ageDecouverte = ageDecouverte;
    }

    public String getAutreEndocrinopathie() {
        return autreEndocrinopathie;
    }

    public void setAutreEndocrinopathie(String autreEndocrinopathie) {
        this.autreEndocrinopathie = autreEndocrinopathie;
    }

    public String getAutreAnomCong() {
        return autreAnomCong;
    }

    public void setAutreAnomCong(String autreAnomCong) {
        this.autreAnomCong = autreAnomCong;
    }

    public Date getDateNumSanguine() {
        return dateNumSanguine;
    }

    public void setDateNumSanguine(Date dateNumSanguine) {
        this.dateNumSanguine = dateNumSanguine;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHb() {
        return hb;
    }

    public void setHb(Float hb) {
        this.hb = hb;
    }

    public Float getVgm() {
        return vgm;
    }

    public void setVgm(Float vgm) {
        this.vgm = vgm;
    }

    public Float getRetic() {
        return retic;
    }

    public void setRetic(Float retic) {
        this.retic = retic;
    }

    public Float getLeuco() {
        return leuco;
    }

    public void setLeuco(Float leuco) {
        this.leuco = leuco;
    }

    public Float getPnn() {
        return pnn;
    }

    public void setPnn(Float pnn) {
        this.pnn = pnn;
    }

    public Float getPlq() {
        return plq;
    }

    public void setPlq(Float plq) {
        this.plq = plq;
    }

    public String getHbInf() {
        return hbInf;
    }

    public void setHbInf(String hbInf) {
        this.hbInf = hbInf;
    }

    public String getPlqInf() {
        return plqInf;
    }

    public void setPlqInf(String plqInf) {
        this.plqInf = plqInf;
    }

    public String getPNNInf() {
        return pNNInf;
    }

    public void setPNNInf(String pNNInf) {
        this.pNNInf = pNNInf;
    }

    public String getElectrophoreseHb() {
        return electrophoreseHb;
    }

    public void setElectrophoreseHb(String electrophoreseHb) {
        this.electrophoreseHb = electrophoreseHb;
    }

    public Float getHbf() {
        return hbf;
    }

    public void setHbf(Float hbf) {
        this.hbf = hbf;
    }

    public String getMyelogramme() {
        return myelogramme;
    }

    public void setMyelogramme(String myelogramme) {
        this.myelogramme = myelogramme;
    }

    public String getCellularite() {
        return cellularite;
    }

    public void setCellularite(String cellularite) {
        this.cellularite = cellularite;
    }

    public Float getErythroblaste() {
        return erythroblaste;
    }

    public void setErythroblaste(Float erythroblaste) {
        this.erythroblaste = erythroblaste;
    }

    public String getMorphologieEryth() {
        return morphologieEryth;
    }

    public void setMorphologieEryth(String morphologieEryth) {
        this.morphologieEryth = morphologieEryth;
    }

    public String getMorphologieGran() {
        return morphologieGran;
    }

    public void setMorphologieGran(String morphologieGran) {
        this.morphologieGran = morphologieGran;
    }

    public String getMorphologieMega() {
        return morphologieMega;
    }

    public void setMorphologieMega(String morphologieMega) {
        this.morphologieMega = morphologieMega;
    }

    public Float getGranuleux() {
        return granuleux;
    }

    public void setGranuleux(Float granuleux) {
        this.granuleux = granuleux;
    }

    public String getDysmyelopoiese() {
        return dysmyelopoiese;
    }

    public void setDysmyelopoiese(String dysmyelopoiese) {
        this.dysmyelopoiese = dysmyelopoiese;
    }

    public String getMegacaryocytes() {
        return megacaryocytes;
    }

    public void setMegacaryocytes(String megacaryocytes) {
        this.megacaryocytes = megacaryocytes;
    }

    public Float getBlaste() {
        return blaste;
    }

    public void setBlaste(Float blaste) {
        this.blaste = blaste;
    }

    public String getExcesblastes() {
        return excesblastes;
    }

    public void setExcesblastes(String excesblastes) {
        this.excesblastes = excesblastes;
    }

    public String getBom() {
        return bom;
    }

    public void setBom(String bom) {
        this.bom = bom;
    }

    public Float getAdipocytes() {
        return adipocytes;
    }

    public void setAdipocytes(Float adipocytes) {
        this.adipocytes = adipocytes;
    }

    public String getUbiquitination() {
        return ubiquitination;
    }

    public void setUbiquitination(String ubiquitination) {
        this.ubiquitination = ubiquitination;
    }

    public String getResUbiquitination() {
        return resUbiquitination;
    }

    public void setResUbiquitination(String resUbiquitination) {
        this.resUbiquitination = resUbiquitination;
    }

    public String getGroupComp() {
        return groupComp;
    }

    public void setGroupComp(String groupComp) {
        this.groupComp = groupComp;
    }

    public String getMutationFANC() {
        return mutationFANC;
    }

    public void setMutationFANC(String mutationFANC) {
        this.mutationFANC = mutationFANC;
    }

    public String getCongelationCellule() {
        return congelationCellule;
    }

    public void setCongelationCellule(String congelationCellule) {
        this.congelationCellule = congelationCellule;
    }

    public String getLabo() {
        return labo;
    }

    public void setLabo(String labo) {
        this.labo = labo;
    }

    public String getTypePrelevement() {
        return typePrelevement;
    }

    public void setTypePrelevement(String typePrelevement) {
        this.typePrelevement = typePrelevement;
    }

    public Integer getScoreClinique() {
        return scoreClinique;
    }

    public void setScoreClinique(Integer scoreClinique) {
        this.scoreClinique = scoreClinique;
    }

    public Integer getScoreEBMT() {
        return scoreEBMT;
    }

    public void setScoreEBMT(Integer scoreEBMT) {
        this.scoreEBMT = scoreEBMT;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTransfusion() {
        return transfusion;
    }

    public void setTransfusion(String transfusion) {
        this.transfusion = transfusion;
    }

    public Integer getAgeTransf() {
        return ageTransf;
    }

    public void setAgeTransf(Integer ageTransf) {
        this.ageTransf = ageTransf;
    }

    public Float getDelaiDiag() {
        return delaiDiag;
    }

    public void setDelaiDiag(Float delaiDiag) {
        this.delaiDiag = delaiDiag;
    }

    public String getNbCG() {
        return nbCG;
    }

    public void setNbCG(String nbCG) {
        this.nbCG = nbCG;
    }

    public String getNbCP() {
        return nbCP;
    }

    public void setNbCP(String nbCP) {
        this.nbCP = nbCP;
    }

    public String getChelationFer() {
        return chelationFer;
    }

    public void setChelationFer(String chelationFer) {
        this.chelationFer = chelationFer;
    }

    public String getChelateur() {
        return chelateur;
    }

    public void setChelateur(String chelateur) {
        this.chelateur = chelateur;
    }

    public String getNilevar() {
        return nilevar;
    }

    public void setNilevar(String nilevar) {
        this.nilevar = nilevar;
    }

    public String getOxynethadone() {
        return oxynethadone;
    }

    public void setOxynethadone(String oxynethadone) {
        this.oxynethadone = oxynethadone;
    }

    public String getAndrotordyl() {
        return androtordyl;
    }

    public void setAndrotordyl(String androtordyl) {
        this.androtordyl = androtordyl;
    }

    public String getAutreAndrogene() {
        return autreAndrogene;
    }

    public void setAutreAndrogene(String autreAndrogene) {
        this.autreAndrogene = autreAndrogene;
    }

    public Date getAndroDebut() {
        return androDebut;
    }

    public void setAndroDebut(Date androDebut) {
        this.androDebut = androDebut;
    }

    public Date getAndroFin() {
        return androFin;
    }

    public void setAndroFin(Date androFin) {
        this.androFin = androFin;
    }

    public String getObservance() {
        return observance;
    }

    public void setObservance(String observance) {
        this.observance = observance;
    }

    public String getToxicite() {
        return toxicite;
    }

    public void setToxicite(String toxicite) {
        this.toxicite = toxicite;
    }

    public String getAutreToxicite() {
        return autreToxicite;
    }

    public void setAutreToxicite(String autreToxicite) {
        this.autreToxicite = autreToxicite;
    }

    public String getEnqueteHLA() {
        return enqueteHLA;
    }

    public void setEnqueteHLA(String enqueteHLA) {
        this.enqueteHLA = enqueteHLA;
    }

    public String getPourquoiEnqHLA() {
        return pourquoiEnqHLA;
    }

    public void setPourquoiEnqHLA(String pourquoiEnqHLA) {
        this.pourquoiEnqHLA = pourquoiEnqHLA;
    }

    public Integer getNbFratTyp() {
        return nbFratTyp;
    }

    public void setNbFratTyp(Integer nbFratTyp) {
        this.nbFratTyp = nbFratTyp;
    }

    public Integer getNbFratNTyp() {
        return nbFratNTyp;
    }

    public void setNbFratNTyp(Integer nbFratNTyp) {
        this.nbFratNTyp = nbFratNTyp;
    }

    public Integer getDonneurComp() {
        return donneurComp;
    }

    public void setDonneurComp(Integer donneurComp) {
        this.donneurComp = donneurComp;
    }

    public String getPreciseDonneur() {
        return preciseDonneur;
    }

    public void setPreciseDonneur(String preciseDonneur) {
        this.preciseDonneur = preciseDonneur;
    }

    public String getDonneur() {
        return donneur;
    }

    public void setDonneur(String donneur) {
        this.donneur = donneur;
    }

    public String getGreffeFaite() {
        return greffeFaite;
    }

    public void setGreffeFaite(String greffeFaite) {
        this.greffeFaite = greffeFaite;
    }

    public Float getDelaiRappDiag() {
        return delaiRappDiag;
    }

    public void setDelaiRappDiag(Float delaiRappDiag) {
        this.delaiRappDiag = delaiRappDiag;
    }

    public String getPourquoiNfaite() {
        return pourquoiNfaite;
    }

    public void setPourquoiNfaite(String pourquoiNfaite) {
        this.pourquoiNfaite = pourquoiNfaite;
    }

    public String getCyclophosphamide() {
        return cyclophosphamide;
    }

    public void setCyclophosphamide(String cyclophosphamide) {
        this.cyclophosphamide = cyclophosphamide;
    }

    public String getFludarabine() {
        return fludarabine;
    }

    public void setFludarabine(String fludarabine) {
        this.fludarabine = fludarabine;
    }

    public String getBusulfan() {
        return busulfan;
    }

    public void setBusulfan(String busulfan) {
        this.busulfan = busulfan;
    }

    public Float getDoseCyclo() {
        return doseCyclo;
    }

    public void setDoseCyclo(Float doseCyclo) {
        this.doseCyclo = doseCyclo;
    }

    public Float getDoseFlu() {
        return doseFlu;
    }

    public void setDoseFlu(Float doseFlu) {
        this.doseFlu = doseFlu;
    }

    public Float getDoseBus() {
        return doseBus;
    }

    public void setDoseBus(Float doseBus) {
        this.doseBus = doseBus;
    }

    public String getAutreConditionnement() {
        return autreConditionnement;
    }

    public void setAutreConditionnement(String autreConditionnement) {
        this.autreConditionnement = autreConditionnement;
    }

    public String getIrradiation() {
        return irradiation;
    }

    public void setIrradiation(String irradiation) {
        this.irradiation = irradiation;
    }

    public Float getDoseTotaleIrr() {
        return doseTotaleIrr;
    }

    public void setDoseTotaleIrr(Float doseTotaleIrr) {
        this.doseTotaleIrr = doseTotaleIrr;
    }

    public String getSerotherapie() {
        return serotherapie;
    }

    public void setSerotherapie(String serotherapie) {
        this.serotherapie = serotherapie;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public Float getDoseSAL() {
        return doseSAL;
    }

    public void setDoseSAL(Float doseSAL) {
        this.doseSAL = doseSAL;
    }

    public String getSourceCellule() {
        return sourceCellule;
    }

    public void setSourceCellule(String sourceCellule) {
        this.sourceCellule = sourceCellule;
    }

    public Integer getSortieAplasie() {
        return sortieAplasie;
    }

    public void setSortieAplasie(Integer sortieAplasie) {
        this.sortieAplasie = sortieAplasie;
    }

    public String getGradeaGvH() {
        return gradeaGvH;
    }

    public void setGradeaGvH(String gradeaGvH) {
        this.gradeaGvH = gradeaGvH;
    }

    public String getCGvH() {
        return cGvH;
    }

    public void setCGvH(String cGvH) {
        this.cGvH = cGvH;
    }

    public String getMvo() {
        return mvo;
    }

    public void setMvo(String mvo) {
        this.mvo = mvo;
    }

    public String getComplicationPulmonaire() {
        return complicationPulmonaire;
    }

    public void setComplicationPulmonaire(String complicationPulmonaire) {
        this.complicationPulmonaire = complicationPulmonaire;
    }

    public String getPreciseCompPulm() {
        return preciseCompPulm;
    }

    public void setPreciseCompPulm(String preciseCompPulm) {
        this.preciseCompPulm = preciseCompPulm;
    }

    public String getSurvieJ100() {
        return survieJ100;
    }

    public void setSurvieJ100(String survieJ100) {
        this.survieJ100 = survieJ100;
    }

    public String getSmd() {
        return smd;
    }

    public void setSmd(String smd) {
        this.smd = smd;
    }

    public Integer getAgeDiagSMD() {
        return ageDiagSMD;
    }

    public void setAgeDiagSMD(Integer ageDiagSMD) {
        this.ageDiagSMD = ageDiagSMD;
    }

    public String getCritereDiagSMD() {
        return critereDiagSMD;
    }

    public void setCritereDiagSMD(String critereDiagSMD) {
        this.critereDiagSMD = critereDiagSMD;
    }

    public String getTraitementSMD() {
        return traitementSMD;
    }

    public void setTraitementSMD(String traitementSMD) {
        this.traitementSMD = traitementSMD;
    }

    public String getLam() {
        return lam;
    }

    public void setLam(String lam) {
        this.lam = lam;
    }

    public String getCritereDiagLAM() {
        return critereDiagLAM;
    }

    public void setCritereDiagLAM(String critereDiagLAM) {
        this.critereDiagLAM = critereDiagLAM;
    }

    public String getTraitementLAM() {
        return traitementLAM;
    }

    public void setTraitementLAM(String traitementLAM) {
        this.traitementLAM = traitementLAM;
    }

    public String getAutresCancers() {
        return autresCancers;
    }

    public void setAutresCancers(String autresCancers) {
        this.autresCancers = autresCancers;
    }

    public Date getDdn() {
        return ddn;
    }

    public void setDdn(Date ddn) {
        this.ddn = ddn;
    }

    public String getTransformationAigue() {
        return transformationAigue;
    }

    public void setTransformationAigue(String transformationAigue) {
        this.transformationAigue = transformationAigue;
    }

    public Integer getAgeDiagLA() {
        return ageDiagLA;
    }

    public void setAgeDiagLA(Integer ageDiagLA) {
        this.ageDiagLA = ageDiagLA;
    }

    public String getTraitementLA() {
        return traitementLA;
    }

    public void setTraitementLA(String traitementLA) {
        this.traitementLA = traitementLA;
    }

    public String getCancerE() {
        return cancerE;
    }

    public void setCancerE(String cancerE) {
        this.cancerE = cancerE;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getTypeHistologique() {
        return typeHistologique;
    }

    public void setTypeHistologique(String typeHistologique) {
        this.typeHistologique = typeHistologique;
    }

    public String getTraitementCancer() {
        return traitementCancer;
    }

    public void setTraitementCancer(String traitementCancer) {
        this.traitementCancer = traitementCancer;
    }

    public String getPreciseTraitement() {
        return preciseTraitement;
    }

    public void setPreciseTraitement(String preciseTraitement) {
        this.preciseTraitement = preciseTraitement;
    }

    public String getEvolutionCyto() {
        return evolutionCyto;
    }

    public void setEvolutionCyto(String evolutionCyto) {
        this.evolutionCyto = evolutionCyto;
    }

    public String getFormuleChrom() {
        return formuleChrom;
    }

    public void setFormuleChrom(String formuleChrom) {
        this.formuleChrom = formuleChrom;
    }

    public Integer getAgeE() {
        return ageE;
    }

    public void setAgeE(Integer ageE) {
        this.ageE = ageE;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCauseDeces() {
        return causeDeces;
    }

    public void setCauseDeces(String causeDeces) {
        this.causeDeces = causeDeces;
    }

    public String getAutreCauseD() {
        return autreCauseD;
    }

    public void setAutreCauseD(String autreCauseD) {
        this.autreCauseD = autreCauseD;
    }

    public Float getSurvieGlobale() {
        return survieGlobale;
    }

    public void setSurvieGlobale(Float survieGlobale) {
        this.survieGlobale = survieGlobale;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    public String getnDossier() {
        return nDossier;
    }

    public void setnDossier(String nDossier) {
        this.nDossier = nDossier;
    }

    public Date getDateMAJ() {
        return dateMAJ;
    }

    public void setDateMAJ(Date dateMAJ) {
        this.dateMAJ = dateMAJ;
    }

    public Integer getaAgeChDiag() {
        return aAgeChDiag;
    }

    public void setaAgeChDiag(Integer aAgeChDiag) {
        this.aAgeChDiag = aAgeChDiag;
    }

    public Integer getmAgeChDiag() {
        return mAgeChDiag;
    }

    public void setmAgeChDiag(Integer mAgeChDiag) {
        this.mAgeChDiag = mAgeChDiag;
    }

    public Integer getaAgeOssDiag() {
        return aAgeOssDiag;
    }

    public void setaAgeOssDiag(Integer aAgeOssDiag) {
        this.aAgeOssDiag = aAgeOssDiag;
    }

    public Integer getmAgeOssDiag() {
        return mAgeOssDiag;
    }

    public void setmAgeOssDiag(Integer mAgeOssDiag) {
        this.mAgeOssDiag = mAgeOssDiag;
    }

    public String getmTanner() {
        return mTanner;
    }

    public void setmTanner(String mTanner) {
        this.mTanner = mTanner;
    }

    public String getpTanner() {
        return pTanner;
    }

    public void setpTanner(String pTanner) {
        this.pTanner = pTanner;
    }

    public String gettTanner() {
        return tTanner;
    }

    public void settTanner(String tTanner) {
        this.tTanner = tTanner;
    }

    public String getpNNInf() {
        return pNNInf;
    }

    public void setpNNInf(String pNNInf) {
        this.pNNInf = pNNInf;
    }

    public String getcGvH() {
        return cGvH;
    }

    public void setcGvH(String cGvH) {
        this.cGvH = cGvH;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nDossier != null ? nDossier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fiche)) {
            return false;
        }
        Fiche other = (Fiche) object;
        if ((this.nDossier == null && other.nDossier != null) || (this.nDossier != null && !this.nDossier.equals(other.nDossier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tfar.entity.Fiche[ nDossier=" + nDossier + " ]";
    }
    

}
