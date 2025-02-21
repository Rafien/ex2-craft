class Patient {
    private var gammaProtocole: Boolean;
    private var whiteCellsCount: Int;
    private var geneticsFile: GeneticsFile;

    fun isGammaProtocole(): Boolean {
        return gammaProtocole;
    }

    fun getWhiteCellsCount(): Int {
        return whiteCellsCount;
    }

    fun setWhiteCellsCount(whiteCellsCount: Int) {
        this.whiteCellsCount = whiteCellsCount;
    }

    fun getGeneticsFile(): GeneticsFile {
        return geneticsFile;
    }

    private Patient(Builder builder) {
        this.gammaProtocole = builder.gammaProtocole;
        this.whiteCellsCount = builder.whiteCellsCount;
        this.geneticsFile = builder.geneticsFile;
    }


    public class Builder{
        public Builder gammaProtocole(Boolean gammaProtocole) {
            this.gammaProtocole = gammaProtocole;
            return this;
        }

        public Builder whiteCellsCount(Int whiteCellsCount) {
            this.whiteCellsCount = whiteCellsCount;
            return this;
        }

        public Builder geneticsFile(PatientGeneticsFile geneticsFile) {
            this.geneticsFile = geneticsFile;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }
    }
}