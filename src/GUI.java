/*

    Author: Benjamin J. Dore
    Date:   9/4/2020

    Description:    Main user interface class, contains the definition of the user interface view
                    as well as the functionality when buttons are selected

*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Defines the current transaction, contains the services and prices for the specific transaction
        Transaction currentTransaction = new Transaction();

        Button btnSubmit = new Button("Submit");
        Button btnClear = new Button("Clear");

        // Will hold all the form input fields and the buttons
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 5, 10));
        vBox.setSpacing(10);

        // Main HBox that will hold all UI components (i.e. the above VBox and the Output text area
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 5, 10));
        hBox.setSpacing(10);

        // HBox holds the submit and clear buttons
        HBox buttonsBox = new HBox();
        buttonsBox.setSpacing(10);

        // The following HBoxes hold the check boxes and labels for Office Visit, X-Ray, and Specimen Exam services
        HBox officeVisitBox = new HBox();
        HBox xRayBox = new HBox();
        HBox specExamBox = new HBox();

        // The following HBoxes hold the check boxes and labels for Rabies, Kennel Cough, and Antiba-V Vaccinations
        HBox rabiesBox = new HBox();
        HBox kennelBox = new HBox();
        HBox antibaBox = new HBox();

        // Holds the output textarea where the receipt will be printed
        StackPane outputBox = new StackPane();
        outputBox.setPadding(new Insets(10, 10, 5, 10));

        // GridPane to hold labels and text fields for the pet owner
        GridPane petOwnerPane = new GridPane();
        petOwnerPane.setPadding(new Insets(10, 30, 10, 10));
        petOwnerPane.setAlignment(Pos.CENTER);
        petOwnerPane.setHgap(10);
        petOwnerPane.setVgap(10);
        petOwnerPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #999999;");

        // GridPane to hold labels and text fields for the pet
        GridPane petPane = new GridPane();
        petPane.setPadding(new Insets(10, 30, 10, 10));
        petPane.setAlignment(Pos.CENTER);
        petPane.setHgap(10);
        petPane.setVgap(10);
        petPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #999999;");

        // GridPane to hold labels and text fields for the visit information (i.e. the services requested)
        GridPane visitPane = new GridPane();
        visitPane.setPadding(new Insets(10, 30, 10, 10));
        visitPane.setAlignment(Pos.CENTER_LEFT);
        visitPane.setHgap(10);
        visitPane.setVgap(10);
        visitPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #999999;");

        // GridPane to hold labels and text fields for the vaccinations
        GridPane vaccinationPane = new GridPane();
        vaccinationPane.setPadding(new Insets(10, 100, 10, 15));
        vaccinationPane.setAlignment(Pos.CENTER);
        vaccinationPane.setHgap(10);
        vaccinationPane.setVgap(10);
        vaccinationPane.setStyle("-fx-background-color: #e2e2e2; -fx-border-color: #999999;");

        // GridPane to hold labels and text fields for the discount field
        GridPane discountPane = new GridPane();
        discountPane.setPadding(new Insets(10, 30, 10, 10));
        discountPane.setAlignment(Pos.CENTER_LEFT);
        discountPane.setHgap(10);
        discountPane.setVgap(10);
        discountPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #999999;");

        // Titles for the different sections in the application
        Label petOwnerInfo = new Label("Pet Owner Information");
        Label petInformation = new Label("Pet Information");
        Label reasonForVisit = new Label("Reason for Visit ");
        Label vaccination = new Label("Vaccination");
        Label discounts = new Label("Discounts ");

        // Pet owner info
        Label firstName = new Label("First Name:");
        Label middleInitial = new Label("Middle Initial:");
        Label lastName = new Label("Last Name:");
        Label phoneNumber = new Label("Phone Number:");

        // Pet info
        Label petName = new Label("Pet Name:");
        Label species = new Label("Species:");
        Label weight = new Label("Weight:");

        // Basic office services
        Label officeVisit = new Label("Office Visit ($25.00)");
        Label xRay = new Label("X-Ray ($15.00)");
        Label specimenExam = new Label("Specimen Examination ($12.50)");

        // Vaccinations
        Label rabiesVac = new Label("Rabies ($8.00)");
        Label kennelVac = new Label("Kennel Cough ($6.00)");
        Label antibaVac = new Label("Antiba-V ($5.00/Unit Administered)");

        Label discountAmount = new Label("Discount: ");

        Label animalFactor = new Label("Animal Factor:");

        // Text fields for pet owner
        TextField firstNameTxt = new TextField();
        LimitedTextField middleInitialTxt = new LimitedTextField(1);
        TextField lastNameTxt = new TextField();
        LimitedTextField phoneNumberTxt = new LimitedTextField(10);

        // Text fields for pet
        TextField petNametxt = new TextField();
        TextField speciesTxt = new TextField();
        LimitedTextField weightTxt = new LimitedTextField(4);

        // Discount value and animal factor fields
        LimitedTextField discountTxt = new LimitedTextField(10);
        LimitedTextField animalFactorTxt = new LimitedTextField(4);

        // Receipt output field, set so user cannot edit
        TextArea receiptOutput = new TextArea();
        receiptOutput.setEditable(false);

        // Basic office services checkboxes
        CheckBox chkOfficeVisit = new CheckBox();
        CheckBox chkXRay = new CheckBox();
        CheckBox chkSpecExam = new CheckBox();

        // Vaccine check boxes
        CheckBox chkRabies = new CheckBox();
        CheckBox chkKennel = new CheckBox();
        CheckBox chkAntiba = new CheckBox();

        // Animal factor and text field are hidden, so long as Antiba-V is not selected
        animalFactor.setVisible(false);
        animalFactorTxt.setVisible(false);

        // Add all the pet owner labels and text fields to the Pet Owner Pane
        petOwnerPane.add(firstName, 0,0);             // Label
        petOwnerPane.add(middleInitial, 1, 0);        // Label
        petOwnerPane.add(lastName, 2, 0);             // Label
        petOwnerPane.add(firstNameTxt, 0, 1);         // Text Field
        petOwnerPane.add(middleInitialTxt, 1, 1);     // Text Field
        petOwnerPane.add(lastNameTxt, 2, 1);          // Text Field
        petOwnerPane.add(phoneNumber, 0, 2);          // Label
        petOwnerPane.add(phoneNumberTxt, 0, 3);       // Text Field

        // Add all the pet labels and text fields to the Pet Pane
        petPane.add(petName, 0, 0);         // Label
        petPane.add(species, 1, 0);         // Label
        petPane.add(weight, 2 ,0);          // Label
        petPane.add(petNametxt, 0, 1);      // Text Field
        petPane.add(speciesTxt, 1, 1);      // Text Field
        petPane.add(weightTxt, 2, 1);       // Text Field

        officeVisitBox.getChildren().add(chkOfficeVisit);
        officeVisitBox.getChildren().add(officeVisit);

        xRayBox.getChildren().add(chkXRay);
        xRayBox.getChildren().add(xRay);

        specExamBox.getChildren().add(chkSpecExam);
        specExamBox.getChildren().add(specimenExam);

        visitPane.add(officeVisitBox, 0, 0);
        visitPane.add(xRayBox, 0, 1);
        visitPane.add(specExamBox, 0, 2);

        visitPane.add(vaccination, 0, 3);
        visitPane.add(vaccinationPane,0,4);

        rabiesBox.getChildren().add(chkRabies);
        rabiesBox.getChildren().add(rabiesVac);

        kennelBox.getChildren().add(chkKennel);
        kennelBox.getChildren().add(kennelVac);

        antibaBox.getChildren().add(chkAntiba);
        antibaBox.getChildren().add(antibaVac);

        vaccinationPane.add(rabiesBox, 0, 0);
        vaccinationPane.add(kennelBox, 0, 1);
        vaccinationPane.add(antibaBox, 0, 2);
        vaccinationPane.add(animalFactor, 0 ,3);
        vaccinationPane.add(animalFactorTxt, 0 ,4);

        discountPane.add(discountAmount, 0, 0);
        discountPane.add(discountTxt, 1, 0);

        buttonsBox.getChildren().add(btnSubmit);
        buttonsBox.getChildren().add(btnClear);

        vBox.getChildren().add(petOwnerInfo);
        vBox.getChildren().add(petOwnerPane);

        vBox.getChildren().add(petInformation);
        vBox.getChildren().add(petPane);

        vBox.getChildren().add(reasonForVisit);
        vBox.getChildren().add(visitPane);

        vBox.getChildren().add(discounts);
        vBox.getChildren().add(discountPane);

        vBox.getChildren().add(buttonsBox);

        outputBox.getChildren().add(receiptOutput);

        hBox.getChildren().add(vBox);
        hBox.getChildren().add(outputBox);

        // Office visit selected? (Yes/No)
        chkOfficeVisit.setOnAction(e -> currentTransaction.setOfficeVisitSelected(chkOfficeVisit.isSelected()));

        // X-Ray selected? (Yes/No)
        chkXRay.setOnAction(e -> currentTransaction.setxRaySelected(chkXRay.isSelected()));

        // Specimen Examination selected? (Yes/No)
        chkSpecExam.setOnAction(e -> currentTransaction.setSpecExamSelected(chkSpecExam.isSelected()));

        // Rabies vaccine selected? (Yes/No)
        chkRabies.setOnAction(e -> currentTransaction.setRabiesSelected(chkRabies.isSelected()));

        // Kennel Cough vaccine selected? (Yes/No)
        chkKennel.setOnAction(e -> currentTransaction.setKennelCoughSelected(chkKennel.isSelected()));

        // Antiba-V selected? (Yes/No)
        //
        // NOTE: The animal factor label and text field only show if the Antiba-V
        //       check box is selected
        //
        chkAntiba.setOnAction(e -> {
            if (chkAntiba.isSelected()) {
                animalFactorTxt.setText("1");                   // Default animal factor
                animalFactor.setVisible(true);
                animalFactorTxt.setVisible(true);
                currentTransaction.setAntibaVSelected(true);
            }
            else {
                animalFactorTxt.setText("");
                animalFactor.setVisible(false);
                animalFactorTxt.setVisible(false);
                currentTransaction.setAntibaVSelected(false);
            }

        });

        // force the phone number, weight, animal factor and discount field to be numeric only
        limitNumeric(phoneNumberTxt, weightTxt, discountTxt, animalFactorTxt);

        // When the clear button is clicked, clear the output text field and all check boxes/text fields
        btnClear.setOnAction(new ClearHandler(receiptOutput,
                firstNameTxt,
                middleInitialTxt,
                lastNameTxt,
                phoneNumberTxt,
                petNametxt,
                speciesTxt,
                weightTxt,
                discountTxt,
                chkOfficeVisit,
                chkXRay,
                chkSpecExam,
                chkRabies,
                chkKennel,
                chkAntiba,
                animalFactor,
                animalFactorTxt,
                currentTransaction));


        // ------------ BELOW CODE OCCURS WHEN 'SUBMIT' BUTTON IS CLICKED ------------

        btnSubmit.setOnAction(e -> {
            // Are all the required fields filled?
            if (isPetOwnerFilled(firstNameTxt, middleInitialTxt, lastNameTxt, phoneNumberTxt) && isPetInfoFilled(petNametxt, speciesTxt, weightTxt)) {

                // If the Antiba-V is selected, make sure the animal factor isn't a blank string and is numeric, so long as that is true,
                // set the transaction animal factor to what is in the animal factor field (if 0, make it a 1 to avoid div/0).
                //
                // If the string isn't numeric, alert the user this is invalid and set to 1 by default.
                //
                // If the animal factor is blank, alert the user this is invalid and set to 1 by default.
                if (chkAntiba.isSelected()) {
                    if (!animalFactorTxt.getText().equals("")) {
                        if (isNumeric(animalFactorTxt.getText())) {
                            currentTransaction.setAnimalFactor(Double.parseDouble(animalFactorTxt.getText()));
                            if (Double.parseDouble(animalFactorTxt.getText()) == 0) animalFactorTxt.setText("1");
                        } else {
                            displayError("Animal Factor");
                            animalFactorTxt.setText("1");
                            currentTransaction.setAnimalFactor(Double.parseDouble(animalFactorTxt.getText()));
                        }
                    }
                    else {
                        animalFactorTxt.setText("1");
                        currentTransaction.setAnimalFactor(Double.parseDouble(animalFactorTxt.getText()));
                        displayError(animalFactor.getText());
                    }
                }

                // Check if the weight field has a numeric value, if so add it to the transaction,
                // if not, alert the user the weight value is invalid and default to 0
                if (isNumeric(weightTxt.getText()))
                    currentTransaction.setAnimalWeight(Double.parseDouble(weightTxt.getText()));
                else {
                    displayError("Pet Weight");
                    weightTxt.setText("0");
                    currentTransaction.setAnimalWeight(Double.parseDouble(weightTxt.getText()));
                }

                // Check if the discount field is not blank, if so make sure the discount value is a number and add it to the transaction.
                // If the discount value is not a number, alert the user this is invalid and set the discount value to 0
                if (!discountTxt.getText().equals("")) {
                    if (isNumeric(discountTxt.getText()))
                        currentTransaction.setDiscountAmount(Double.parseDouble(discountTxt.getText()));
                    else {
                        displayError("Discount");
                        discountTxt.setText("0");
                        currentTransaction.setDiscountAmount(Double.parseDouble(discountTxt.getText()));
                    }
                }
                // If the discount value is blank, default to 0. It is assumed that if the user doesn't enter a discount value, then
                // no discount is applied to the transaction
                else {
                    discountTxt.setText("0");
                    currentTransaction.setDiscountAmount(Double.parseDouble(discountTxt.getText()));
                }

                // Define the pet owner based on what was entered in the pet owner fields
                PetOwner owner = new PetOwner(
                        firstNameTxt.getText(),
                        middleInitialTxt.getText(),
                        lastNameTxt.getText(),
                        phoneNumberTxt.getText()
                );

                // Define the pet based on what was entered in the pet fields
                Pet pet = new Pet(
                        petNametxt.getText(),
                        speciesTxt.getText(),
                        Integer.parseInt(weightTxt.getText())
                );

                // Print the date and time, and customer/pet information in the receipt field.
                receiptOutput.setText(
                        "-------------------------------- VETS 'R' US --------------------------------\n"
                                + "\t\t\t\t\t" + new DateTime().getDateAndTime()
                                + "\n\nCustomer Information\n\n"
                                + "\t\tCustomer Name:\t\t" + owner.getFullName() + "\n"
                                + "\t\tPhone Number:\t\t" + owner.getPhoneNumber() + "\n"
                                + "\nPet Information\n\n"
                                + "\t\tPet Name:\t\t" + pet.getPetName() + "\n"
                                + "\t\tPet Species:\t\t" + pet.getPetSpecies() + "\n"
                                + "\t\tPet Weight:\t\t" + pet.getPetWeight() + "lbs\n"
                                + "\nTransaction Info\n"
                );

                // Print office visit price if the option was selected
                if (currentTransaction.getOfficeVisitSelected())
                    receiptOutput.appendText("\n\t\t$" + String.format("%.2f", currentTransaction.getOfficeVisitPrice()) + "\t\tOffice Visit");

                // Print X-Ray price if the option was selected
                if (currentTransaction.getXRaySelected())
                    receiptOutput.appendText("\n\t\t$" + String.format("%.2f", currentTransaction.getXRayPrice()) + "\t\tX-Ray");

                // Print office Specimen Examination price if the option was selected
                if (currentTransaction.getSpecExamSelected())
                    receiptOutput.appendText("\n\t\t$" + String.format("%.2f", currentTransaction.getSpecExamPrice()) + "\t\tSpecimen Examination");

                // Print Rabies Vaccine price if the option was selected
                if (currentTransaction.getRabiesSelected())
                    receiptOutput.appendText("\n\t\t$" + String.format("%.2f", currentTransaction.getRabiesPrice()) + "\t\tRabies Vaccination");

                // Print Kennel Cough Vaccine price if the option was selected
                if (currentTransaction.getKennelCoughSelected())
                    receiptOutput.appendText("\n\t\t$" + String.format("%.2f", currentTransaction.getKennelCoughPrice()) + "\t\tKennel Cough Vaccination");

                // Print Antiba-V price if the option was selected, do this for each unit administered (ex. if administered 3 times, print the price 3 times)
                if (currentTransaction.getAntibaVSelected()) {
                    for (int i = 0; i < currentTransaction.getUnitsAdministered(); i++)
                        receiptOutput.appendText("\n\t\t$" + String.format("%.2f", currentTransaction.getAntibaVPrice()) + "\t\tAntiba-V Vaccination");
                }

                // Print discount amount if a discount is entered
                if (currentTransaction.getDiscount() > 0)
                    receiptOutput.appendText("\n\n\t\t$-" + String.format("%.2f", currentTransaction.getDiscount()) + "\t\tDiscount Amount");

                // Print the subtotal before tax, the tax amount, and the final grand total of the transaction
                receiptOutput.appendText(
                        "\n\nSubtotal: $" + String.format("%.2f", currentTransaction.getSubtotal()) + " + $" + String.format("%.2f", currentTransaction.getTax()) + " Sales Tax\n"
                                + "\nGrand Total: $" + String.format("%.2f", currentTransaction.getTotal())
                );

                receiptOutput.appendText("\n-----------------------------------------------------------------------------\n");

            } else
                // Display an error message if any of the fields in the pet, or pet owner sections are not filled out
                displayError("Pet and Owner Info");
        });

        // ------------ ABOVE CODE OCCURS WHEN 'SUBMIT' BUTTON IS CLICKED ------------

        // Adds all panes to a scene and sets scene size.
        Scene scene = new Scene(hBox, 520, 635);

        // Creates and displays the stage.
        primaryStage.setTitle("Vets 'R' Us");
        primaryStage.setScene(scene);
        primaryStage.setMaxWidth(1000);
        primaryStage.setMinWidth(1000);
        primaryStage.setMaxHeight(800);
        primaryStage.setMinHeight(800);
        primaryStage.setResizable(false);   // Don't allow the user to modify the size of the window, Cannot maximize window
        primaryStage.show();
    }

    // Limit text fields so they can only accept numeric strings
    private void limitNumeric(TextField phoneNumberTxt, TextField weightTxt, TextField discountTxt, TextField animalFactorTxt) {

        // force the phone number field to be numeric only
        phoneNumberTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                phoneNumberTxt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        // force the weight factor field to be numeric only
        weightTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                weightTxt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        // force the animal factor field to be numeric only
        animalFactorTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                animalFactorTxt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        // force the discount field to be numeric only
        discountTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                discountTxt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

    }

    // Check that all fields for the Pet are filled
    private boolean isPetInfoFilled(TextField petNametxt, TextField speciesTxt, TextField weightTxt) {
        return !petNametxt.getText().equals("")
                && !speciesTxt.getText().equals("")
                && !weightTxt.getText().equals("");
    }

    // Check that all fields for the Pet Owner are filled
    private boolean isPetOwnerFilled(TextField firstNameTxt, TextField middleInitialTxt, TextField lastNameTxt, TextField phoneNumberTxt) {
        return !firstNameTxt.getText().equals("")
                && !middleInitialTxt.getText().equals("")
                && !lastNameTxt.getText().equals("")
                && !phoneNumberTxt.getText().equals("");
    }

    // Displays an error message, intended for when fields are not filled.
    public static void displayError(String issue) {
        Stage errorStage =  new Stage();
        errorStage.setTitle("Error");
        errorStage.setScene(new Scene(new StackPane(new Label("Error! Please make sure " + issue.trim() + " is filled correctly!")), 400, 50));
        errorStage.show();
        errorStage.setResizable(false); // Error message window not resizable
    }

    // Check to see if a particular string is a number
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

}
