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
    private double animalWeight;
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
        if (animalFactor > 0)
            this.animalFactor = animalFactor;
        else
            this.animalFactor = 1;
    }

    public void setAnimalWeight(double animalWeight) {
        if (animalWeight > 0)
            this.animalWeight = animalWeight;
        else
            this.animalWeight = 1;
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

    public double getAnimalWeight() {
        return this.animalWeight;
    }

    public double getAnimalFactor() {
        return this.animalFactor;
    }

    public double getDiscount() {
        return this.discountAmount;
    }

    public double getOfficeVisitPrice() {
        return OFFICE_VISIT;
    }

    public double getXRayPrice() {
        return X_RAY;
    }

    public double getSpecExamPrice() {
        return SPEC_EXAM;
    }

    public double getRabiesPrice() {
        return RABIES;
    }

    public double getKennelCoughPrice() {
        return KENNEL_COUGH;
    }

    public double getAntibaVPrice() {
        return ANTIVA_V;
    }

    public double getSalesTax() { return MICH_SALES_TAX; }

    public double getUnitsAdministered() {
        return (Math.round(getAnimalWeight()) / getAnimalFactor());
    }

    public double getSubtotal() {

        double subtotal = 0;

        if (getOfficeVisitSelected())
            subtotal += OFFICE_VISIT;

        if (getXRaySelected())
            subtotal += X_RAY;

        if (getSpecExamSelected())
            subtotal += SPEC_EXAM;

        if (getRabiesSelected())
            subtotal += RABIES;

        if (getKennelCoughSelected())
            subtotal += KENNEL_COUGH;

        if (getAntibaVSelected())
            subtotal += getUnitsAdministered() * ANTIVA_V;

        if (discountAmount > 0)
            subtotal -= discountAmount;

        return (Math.round(subtotal * 100) / 100.0);
    }

    public double getTax() {
        return (Math.round((getSubtotal() * getSalesTax()) * 100) / 100.0);
    }

    public double getTotal() {
        double total = getSubtotal();

        total = total * (1.0 + MICH_SALES_TAX);

        return (Math.round(total * 100) / 100.0);
    }
}
