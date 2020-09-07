import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class GUI extends Application {

    private static DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public void start(Stage primaryStage) {

        Transaction currentTransaction = new Transaction();

        Button btnSubmit = new Button("Submit");
        Button btnClear = new Button("Clear");

        //VBox will be used to hold all the panes to be placed in a scene
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 5, 10));
        vBox.setSpacing(10);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 5, 10));
        hBox.setSpacing(10);

        HBox buttonsBox = new HBox();
        buttonsBox.setSpacing(10);

        HBox officeVisitBox = new HBox();
        HBox xRayBox = new HBox();
        HBox specExamBox = new HBox();

        HBox rabiesBox = new HBox();
        HBox kennelBox = new HBox();
        HBox antibaBox = new HBox();

        StackPane outputBox = new StackPane();
        outputBox.setPadding(new Insets(10, 10, 5, 10));

        //Primary GridPane to hold labels and text fields
        GridPane petOwnerPane = new GridPane();
        petOwnerPane.setPadding(new Insets(10, 30, 10, 10));
        petOwnerPane.setAlignment(Pos.CENTER);
        petOwnerPane.setHgap(10);
        petOwnerPane.setVgap(10);
        petOwnerPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #999999;");

        GridPane petPane = new GridPane();
        petPane.setPadding(new Insets(10, 30, 10, 10));
        petPane.setAlignment(Pos.CENTER);
        petPane.setHgap(10);
        petPane.setVgap(10);
        petPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #999999;");

        GridPane visitPane = new GridPane();
        visitPane.setPadding(new Insets(10, 30, 10, 10));
        visitPane.setAlignment(Pos.CENTER_LEFT);
        visitPane.setHgap(10);
        visitPane.setVgap(10);
        visitPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #999999;");

        GridPane vaccinationPane = new GridPane();
        vaccinationPane.setPadding(new Insets(10, 100, 10, 15));
        vaccinationPane.setAlignment(Pos.CENTER);
        vaccinationPane.setHgap(10);
        vaccinationPane.setVgap(10);
        vaccinationPane.setStyle("-fx-background-color: #e2e2e2; -fx-border-color: #999999;");

        GridPane discountPane = new GridPane();
        discountPane.setPadding(new Insets(10, 30, 10, 10));
        discountPane.setAlignment(Pos.CENTER_LEFT);
        discountPane.setHgap(10);
        discountPane.setVgap(10);
        discountPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #999999;");

        //All labels
        Label petOwnerInfo = new Label("Pet Owner Information");
        Label petInformation = new Label("Pet Information");
        Label reasonForVisit = new Label("Reason for Visit ");
        Label vaccination = new Label("Vaccination");
        Label discounts = new Label("Discounts ");

        Label firstName = new Label("First Name:");
        Label middleInitial = new Label("Middle Initial:");
        Label lastName = new Label("Last Name:");
        Label phoneNumber = new Label("Phone Number:");

        Label petName = new Label("Pet Name:");
        Label species = new Label("Species:");
        Label weight = new Label("Weight:");

        Label officeVisit = new Label("Office Visit ($25.00)");
        Label xRay = new Label("X-Ray ($15.00)");
        Label specimenExam = new Label("Specimen Examination ($12.50)");

        Label rabiesVac = new Label("Rabies ($8.00)");
        Label kennelVac = new Label("Kennel Cough ($6.00)");
        Label antibaVac = new Label("Antiva-V ($5.00/Unit Administered)");
        Label discountAmount = new Label("Discount: ");

        Label animalFactor = new Label("Animal Factor:");

        //All text fields that will be used to collect input
        TextField firstNameTxt = new TextField();
        LimitedTextField middleInitialTxt = new LimitedTextField(1);
        TextField lastNameTxt = new TextField();
        LimitedTextField phoneNumberTxt = new LimitedTextField(10);
        TextField petNametxt = new TextField();
        TextField speciesTxt = new TextField();
        LimitedTextField weightTxt = new LimitedTextField(4);
        TextField discountTxt = new TextField();
        LimitedTextField animalFactorTxt = new LimitedTextField(4);

        TextArea receiptOutput = new TextArea();
        receiptOutput.setEditable(false);

        CheckBox chkOfficeVisit = new CheckBox();
        CheckBox chkXRay = new CheckBox();
        CheckBox chkSpecExam = new CheckBox();

        CheckBox chkRabies = new CheckBox();
        CheckBox chkKennel = new CheckBox();
        CheckBox chkAntiba = new CheckBox();

        animalFactor.setVisible(false);
        animalFactorTxt.setVisible(false);

        petOwnerPane.add(firstName, 0,0);
        petOwnerPane.add(middleInitial, 1, 0);
        petOwnerPane.add(lastName, 2, 0);

        petOwnerPane.add(firstNameTxt, 0, 1);
        petOwnerPane.add(middleInitialTxt, 1, 1);
        petOwnerPane.add(lastNameTxt, 2, 1);

        petOwnerPane.add(phoneNumber, 0, 2);
        petOwnerPane.add(phoneNumberTxt, 0, 3);

        petPane.add(petName, 0, 0);
        petPane.add(species, 1, 0);
        petPane.add(weight, 2 ,0);
        petPane.add(petNametxt, 0, 1);
        petPane.add(speciesTxt, 1, 1);
        petPane.add(weightTxt, 2, 1);

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

        chkOfficeVisit.setOnAction(e -> {
            currentTransaction.setOfficeVisitSelected(chkOfficeVisit.isSelected());
        });

        chkXRay.setOnAction(e -> {
            currentTransaction.setxRaySelected(chkXRay.isSelected());
        });

        chkSpecExam.setOnAction(e -> {
            currentTransaction.setSpecExamSelected(chkSpecExam.isSelected());
        });

        chkRabies.setOnAction(e -> {
            currentTransaction.setRabiesSelected(chkRabies.isSelected());
        });

        chkKennel.setOnAction(e -> {
            currentTransaction.setKennelCoughSelected(chkKennel.isSelected());
        });

        chkAntiba.setOnAction(e -> {
            if (chkAntiba.isSelected()) {
                animalFactorTxt.setText("1");
                animalFactor.setVisible(true);
                animalFactorTxt.setVisible(true);
                currentTransaction.setAntivaVSelected(true);
            }
            else {
                animalFactorTxt.setText("");
                animalFactor.setVisible(false);
                animalFactorTxt.setVisible(false);
                currentTransaction.setAntivaVSelected(false);
            }

        });

        // force the phone number field to be numeric only
        phoneNumberTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    phoneNumberTxt.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // force the phone number, weight, animal factor and discount field to be numeric only
        limitNumeric(weightTxt, discountTxt, animalFactorTxt);

        //Clear the output text field
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

        btnSubmit.setOnAction(e -> {
            if (isPetOwnerFilled(firstNameTxt, middleInitialTxt, lastNameTxt, phoneNumberTxt) && isPetInfoFilled(petNametxt, speciesTxt, weightTxt)) {

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
                    else
                        displayError(animalFactor.getText());
                }

                if (isNumeric(weightTxt.getText()))
                    currentTransaction.setAnimalWeight(Double.parseDouble(weightTxt.getText()));
                else {
                    displayError("Pet Weight");
                    weightTxt.setText("0");
                    currentTransaction.setAnimalWeight(Double.parseDouble(weightTxt.getText()));
                }

                if (!discountTxt.getText().equals("")) {
                    if (isNumeric(discountTxt.getText()))
                        currentTransaction.setDiscountAmount(Double.parseDouble(discountTxt.getText()));
                    else {
                        displayError("Discount");
                        discountTxt.setText("0");
                        currentTransaction.setDiscountAmount(Double.parseDouble(discountTxt.getText()));
                    }
                }
                else {
                    discountTxt.setText("0");
                    currentTransaction.setDiscountAmount(Double.parseDouble(discountTxt.getText()));
                }

                PetOwner owner = new PetOwner(
                        firstNameTxt.getText(),
                        middleInitialTxt.getText(),
                        lastNameTxt.getText(),
                        phoneNumberTxt.getText()
                );

                Pet pet = new Pet(
                        petNametxt.getText(),
                        speciesTxt.getText(),
                        Integer.parseInt(weightTxt.getText())
                );

                receiptOutput.setText(
                        "-------------------------------- VETS 'R' US --------------------------------\n"
                                + "\t\t\t\t\t\t\t" + new DateTime().getDateAndTime()
                                + "\n\nCustomer Information\n\n"
                                + "\t\tCustomer Name:\t" + owner.getFullName() + "\n"
                                + "\t\tPhone Number:\t\t" + owner.getPhoneNumber() + "\n"
                                + "\nPet Information\n\n"
                                + "\t\tPet Name:\t\t" + pet.getPetName() + "\n"
                                + "\t\tPet Species:\t" + pet.getPetSpecies() + "\n"
                                + "\t\tPet Weight:\t\t" + pet.getPetWeight() + "lbs\n"
                                + "\nTransaction Info\n"
                );

                if (currentTransaction.getOfficeVisitSelected())
                    receiptOutput.appendText("\n\t\t$" + String.format("%.2f", currentTransaction.getOfficeVisitPrice()) + "\t\tOffice Visit");

                if (currentTransaction.getXRaySelected())
                    receiptOutput.appendText("\n\t\t$" + String.format("%.2f", currentTransaction.getXRayPrice()) + "\t\tX-Ray");

                if (currentTransaction.getSpecExamSelected())
                    receiptOutput.appendText("\n\t\t$" + String.format("%.2f", currentTransaction.getSpecExamPrice()) + "\t\tSpecimen Examination");

                if (currentTransaction.getRabiesSelected())
                    receiptOutput.appendText("\n\t\t$" + String.format("%.2f", currentTransaction.getRabiesPrice()) + "\t\tRabies Vaccination");

                if (currentTransaction.getKennelCoughSelected())
                    receiptOutput.appendText("\n\t\t$" + String.format("%.2f", currentTransaction.getKennelCoughPrice()) + "\t\tKennel Cough Vaccination");

                if (currentTransaction.getAntibaVSelected()) {
                    for (int i = 0; i < currentTransaction.getUnitsAdministered(); i++)
                        receiptOutput.appendText("\n\t\t$" + String.format("%.2f", currentTransaction.getAntibaVPrice()) + "\t\tAntiba-V Vaccination");
                }

                if (currentTransaction.getDiscount() > 0)
                    receiptOutput.appendText("\n\n\t\t$-" + String.format("%.2f", currentTransaction.getDiscount()) + "\t\tDiscount Amount");

                receiptOutput.appendText(
                        "\n\nSubtotal: $" + String.format("%.2f", currentTransaction.getSubtotal()) + " + $" + String.format("%.2f", currentTransaction.getTax()) + " Sales Tax\n"
                                + "\nGrand Total: $" + String.format("%.2f", currentTransaction.getTotal())
                );

                receiptOutput.appendText("\n-----------------------------------------------------------------------------\n");

            } else
                displayError("Pet and Owner Info");
        });

        //Adds all panes to a scene and sets scene size.
        Scene scene = new Scene(hBox, 520, 635);

        //Creates and displays the stage.
        primaryStage.setTitle("Vets 'R' Us");
        primaryStage.setScene(scene);
        primaryStage.setMaxWidth(1000);
        primaryStage.setMinWidth(1000);
        primaryStage.setMaxHeight(800);
        primaryStage.setMinHeight(800);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void limitNumeric(TextField weightTxt, TextField discountTxt, TextField animalFactorTxt) {
        weightTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                weightTxt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        // force the phone number field to be numeric only
        animalFactorTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                animalFactorTxt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        // force the phone number field to be numeric only
        discountTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                discountTxt.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    private boolean isPetInfoFilled(TextField petNametxt, TextField speciesTxt, TextField weightTxt) {
        return !petNametxt.getText().equals("")
                && !speciesTxt.getText().equals("")
                && !weightTxt.getText().equals("");
    }

    private boolean isPetOwnerFilled(TextField firstNameTxt, TextField middleInitialTxt, TextField lastNameTxt, TextField phoneNumberTxt) {
        return !firstNameTxt.getText().equals("")
                && !middleInitialTxt.getText().equals("")
                && !lastNameTxt.getText().equals("")
                && !phoneNumberTxt.getText().equals("");
    }

    //Displays an error message, intended for when fields are not filled.
    public static void displayError(String issue) {
        Stage errorStage =  new Stage();
        errorStage.setTitle("Error");
        errorStage.setScene(new Scene(new StackPane(new Label("Error! Please make sure " + issue.trim() + " is filled correctly!")), 400, 50));
        errorStage.show();
        errorStage.setResizable(false); //Error message window not resizable
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
