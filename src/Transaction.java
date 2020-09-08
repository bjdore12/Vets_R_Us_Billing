/*

    Author: Benjamin J. Dore
    Date:   9/4/2020

    Description:    Transaction class is used to define the current transaction in the billing tool.
                    This class contains the prices for each service, plus whether or not a service has
                    been selected or not.

*/

public class Transaction {

    // Regular vet services
    private final double OFFICE_VISIT = 25.00;
    private final double X_RAY = 15.00;
    private final double SPEC_EXAM = 12.50;

    // Vaccinations
    private final double RABIES = 8.00;
    private final double KENNEL_COUGH = 6.00;
    private final double ANTIBA_V = 5.00;

    private final double MICH_SALES_TAX = 0.06;

    // Booleans to correspond to check boxes
    private boolean officeVisitSelected;
    private boolean xRaySelected;
    private boolean specExamSelected;
    private boolean rabiesSelected;
    private boolean kennelCoughSelected;
    private boolean antibaVSelected;

    // Used to calculate units administered for Antiba-V
    private double animalFactor;
    private double animalWeight;

    // Discount off subtotal
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

    public void setAntibaVSelected(boolean isSelected) {
        this.antibaVSelected = isSelected;
    }

    // Set the animal factor, NOTE: animal factor cannot be 0 otherwise there is a divide by 0 error
    public void setAnimalFactor(double animalFactor) {
        if (animalFactor > 0)
            this.animalFactor = animalFactor;
        else
            this.animalFactor = 1;
    }

    public void setAnimalWeight(double animalWeight) { this.animalWeight = animalWeight; }

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
        return this.antibaVSelected;
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
        return ANTIBA_V;
    }

    public double getSalesTax() { return MICH_SALES_TAX; }

    // Determine the number of units to administer for the Antiba-V Vaccine
    public double getUnitsAdministered() {
        if (animalFactor > animalWeight && animalWeight != 0) {
            return this.animalFactor / this.animalFactor;
        }
        return Math.round(this.animalWeight / this.animalFactor);
    }

    // Reset the current transation back to defaults
    public void clearTransaction() {
        this.officeVisitSelected = false;
        this.xRaySelected = false;
        this.specExamSelected = false;
        this.rabiesSelected = false;
        this.kennelCoughSelected = false;
        this.antibaVSelected = false;

        this.animalFactor = 0;
        this.animalWeight = 0;
        this.discountAmount = 0;
    }

    // Get the pre-tax total for the transaction
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
            subtotal += getUnitsAdministered() * ANTIBA_V;

        if (discountAmount > 0)
            subtotal -= discountAmount;

        return subtotal;
    }

    // Calculate the sales tax on the transaction
    public double getTax() {
        if (getSubtotal() > 0)  // There is no sales tax on totals less than or equal to 0
            return (Math.round((getSubtotal() * getSalesTax()) * 100) / 100.0);
        else
            return 0;
    }

    // Get the grand total for the transaction
    public double getTotal() {
        double total = getSubtotal();

        if (total > 0)  // There is no sales tax on totals less than or equal to 0
            total = total * (1.0 + MICH_SALES_TAX);

        return (Math.round(total * 100) / 100.0);
    }
}
