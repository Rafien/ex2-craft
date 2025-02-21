import Patient from Patient.kt
import PatientGeneticFile from PatientGeneticFile.kt
import AvailableRessources from AvailableRessources.kt
import DateChecker from DateChecker.kt

// strategy ??
interface Treatment { bool check();}

class TreatmentX : Treatment {
    fun check(Patient Patient1) {
        return (Patient.isGammaProtocole() && Patient.WhiteCellsCount > 1500 || Patient.WhiteCellsCount > 2000 /*|| add check rechute apres 2019*/) ? true : false;
    }
}

class TreatmentY&Z : Treatment {
    fun check(Patient Patient1, AvailableRessources AvailableRessources) {
        PatientGeneticsFile = Patient1.getGeneticsFile();
        DateChecker dateChecker = new DateChecker();
        return (PatientGeneticsFile.hasBRCA() || DateChecker.isWednesday() && AvailableRessources.isAvailableIRM()) ? true : false;

    }
}

class TreatmentW : Treatment {
    fun check(Patient Patient1, Int wStock) {
        DateChecker dateChecker = new DateChecker();
        var stockNeeded: Int;
        if (DateChecker.isWeekend()) {
            //remove magic numbers
            stockNeeded = 3;
        } else {
            stockNeeded = (3*1.2).toInt()+1;
        }
        return (wStock > stockNeeded) ? true : false;
    }
}