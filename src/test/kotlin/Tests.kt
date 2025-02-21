package tests

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import main.java.Patient
import main.java.PatientGeneticsFile
import main.java.TreatmentX

class AcceptanceTests {
    // rule 801
    @Test
    fun `test rule 801 case gamma should not receive when having not enough white cells even under gamma Protocole`() {
        Patient Patient1 =  new Patient().GammaProtocole(true).whiteCellsCount(1500).geneticsFile(new PatientGeneticsFile().BRCA(false));
        TreatmentX treatmentX = new TreatmentX();
        assertFalse(treatmentX.check(Patient1));
    }
    @Test
    fun `test rule 801 should not receive when meeting no conditions`() {
        Patient Patient1 =  new Patient().GammaProtocole(false).whiteCellsCount(1500).geneticsFile(new PatientGeneticsFile().BRCA(false));
        TreatmentX treatmentX = new TreatmentX();
        assertFalse(treatmentX.check(Patient1));
    }
    @Test
    fun `test rule 801 case gamma should receive when meeting white cells count and under gamma protocole`() {
        Patient Patient1 =  new Patient().GammaProtocole(true).whiteCellsCount(1501).geneticsFile(new PatientGeneticsFile().BRCA(false));
        TreatmentX treatmentX = new TreatmentX();
        assertTrue(treatmentX.check(Patient1));
    }
    @Test
    fun `test rule 801 should not receive when not meeting white cells count`() {
        Patient Patient1 =  new Patient().GammaProtocole(false).whiteCellsCount(2000).geneticsFile(new PatientGeneticsFile().BRCA(false));
        TreatmentX treatmentX = new TreatmentX();
        assertFalse(treatmentX.check(Patient1));
    }
    @Test
    fun `test rule 801 should receive when meeting white cells count`() {
        Patient Patient1 =  new Patient().GammaProtocole(false).whiteCellsCount(2001).geneticsFile(new PatientGeneticsFile().BRCA(false));
        TreatmentX treatmentX = new TreatmentX();
        assertTrue(treatmentX.check(Patient1));
    }

    // rule 327
    // need mock date

    //need mock date mercredi
    @Test
    fun `test rule 327 should receive when having acces to an IRM on wednesday`() {
        Patient Patient1 =  new Patient().geneticsFile(new PatientGeneticsFile().BRCA(false));
        AvailableRessources availableRessources = AvailableRessources().IRM(true);
        TreatmentY&Z treatmentY&Z = new TreatmentY&Z();
        assertTrue(treatmentY&Z.check(Patient1, availableRessources));
    }
    @Test
    fun `test rule 327 should receive when meetting Genetics conditions`() {
        Patient Patient1 =  new Patient().geneticsFile(new PatientGeneticsFile().BRCA(true));
        AvailableRessources availableRessources = AvailableRessources().IRM(false);
        TreatmentY&Z treatmentY&Z = new TreatmentY&Z();
        assertTrue(treatmentY&Z.check(Patient1, availableRessources));
    }
    @Test
    fun `test rule 327 should not receive when not meeting Genetics conditions and not having access to an IRM`() {
        Patient Patient1 =  new Patient().geneticsFile(new PatientGeneticsFile().BRCA(false));
        AvailableRessources availableRessources = AvailableRessources().IRM(false);
        TreatmentY&Z treatmentY&Z = new TreatmentY&Z();
        assertTrue(treatmentY&Z.check(Patient1, availableRessources));
    }
    //rule 666
    // need mock date

    // avec mock date weekend
    @Test
    fun `test rule 666 should receive when stock is sufficient`() {
        Patient Patient1 =  new Patient();
        TreatmentW treatmentW = new TreatmentW();
        assertTrue(treatmentW.check(Patient1, 4));
    }
    // avec mock date hors weekend
    @Test
    fun `test rule 666 should receive when out of weekend and stock is suffiscient`() {
        Patient Patient1 =  new Patient();
        TreatmentW treatmentW = new TreatmentW();
        assertTrue(treatmentW.check(Patient1, 3));
    }
    // avec mock date weekend
    @Test
    fun `test rule 666 should not receive during weekend when stock isn't sufficient`() {
        Patient Patient1 =  new Patient();
        TreatmentW treatmentW = new TreatmentW();
        assertTrue(treatmentW.check(Patient1, 3));
    }
    @Test
    fun `test rule 666 should not receive when stock isn't sufficient`() {
        Patient Patient1 =  new Patient();
        TreatmentW treatmentW = new TreatmentW();
        assertTrue(treatmentW.check(Patient1, 2));
    }
}
