//moche
class AvailableRessources() {
    private var IRM : Boolean

    //buidler
    public class Builder{
        public Builder IRM(Boolean IRM) {
            this.IRM = IRM;
            return this;
        }

        public AvailableRessources build() {
            return new AvailableRessources(this);
        }
    }
    fun isAvailableIRM() {
        return IRM
    }
}