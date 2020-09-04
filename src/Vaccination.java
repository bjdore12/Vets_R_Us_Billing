public class Vaccination {

    private boolean rabiesSelected;
    private boolean kennelCoughtSelected;
    private boolean antibaVSelected;

    final private double RABIES_PRICE = 8.00;
    final private double KENNEL_COUGH_PRICE = 6.00;
    final private double ANTIBA_V_PRICE = 5.00;

    public void setRabiesSelected(boolean rabiesSelected) {
        this.rabiesSelected = rabiesSelected;
    }

    public void setKennelCoughtSelected(boolean kennelCoughtSelected) {
        this.kennelCoughtSelected = kennelCoughtSelected;
    }

    public void setAntibaVSelected(boolean antibaVSelected) {
        this.antibaVSelected = antibaVSelected;
    }

    public boolean getRabiesSelected() {
        return this.rabiesSelected;
    }

    public boolean getKennelCoughSelected() {
        return this.kennelCoughtSelected;
    }

    public boolean getAntibaVSelected() {
        return this.antibaVSelected;
    }
}
