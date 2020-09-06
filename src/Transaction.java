public class Transaction {

    private final double OFFICE_VISIT = 25.00;
    private final double X_RAY = 15.00;
    private final double SPEC_EXAM = 12.50;

    private final double RABIES = 8.00;
    private final double KENNEL_COUGH = 6.00;
    private final double ANTIVA_V = 5.00;

    private final double MICH_SALES_TAX = 0.06;

    private boolean officeVisitSelected;
    private boolean xRaySelected;
    private boolean specExamSelected;
    private boolean rabiesSelected;
    private boolean kennelCoughSelected;
    private boolean antivaVSelected;

    private double animalFactor;
    private double discountAmount;

    public void setOfficeVisitSelected(boolean isSelected) {
        this.officeVisitSelected = isSelected;
    }

    public void setxRaySelected(boolean isSelected) {
        this.xRaySelected = isSelected;
    }

    public void setSpecExamSelected(boolean isSelected) {
        this.specExamSelected = isSelected;
    }

    public void setRabiesSelected(boolean isSelected) {
        this.rabiesSelected = isSelected;
    }

    public void setKennelCoughSelected(boolean isSelected) {
        this.kennelCoughSelected = isSelected;
    }

    public void setAntivaVSelected(boolean isSelected) {
        this.antivaVSelected = isSelected;
    }

    public void setAnimalFactor(double animalFactor) {
        this.animalFactor = animalFactor;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public boolean getOfficeVisitSelected() {
        return this.officeVisitSelected;
    }

    public boolean getXRaySelected() {
        return this.xRaySelected;
    }

    public boolean getSpecExamSelected() {
        return this.specExamSelected;
    }

    public boolean getRabiesSelected() {
        return this.rabiesSelected;
    }

    public boolean getKennelCoughSelected() {
        return this.kennelCoughSelected;
    }

    public boolean getAntibaVSelected() {
        return this.antivaVSelected;
    }

    public double getAnimalFactor() {
        return this.animalFactor;
    }

    public double getDiscount() {
        return this.discountAmount;
    }
}
