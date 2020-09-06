import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class gui extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btnSubmit = new Button("Submit");

        //VBox will be used to hold all the panes to be placed in a scene
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 5, 10));
        vBox.setSpacing(10);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 5, 10));
        hBox.setSpacing(10);

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
        TextField middleInitialTxt = new TextField();
        TextField lastNameTxt = new TextField();
        TextField phoneNumberTxt = new TextField();
        TextField petNametxt = new TextField();
        TextField speciesTxt = new TextField();
        TextField weightTxt = new TextField();
        TextField discountTxt = new TextField();
        TextField animalFactorTxt = new TextField();

        TextArea receiptOutput = new TextArea();
        receiptOutput.setEditable(false);

        CheckBox chkOfficeVisit = new CheckBox();
        CheckBox chkXRay = new CheckBox();
        CheckBox chkSpecExam = new CheckBox();

        CheckBox chkRabies = new CheckBox();
        CheckBox chkKennel = new CheckBox();
        CheckBox chkAntiba = new CheckBox();

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

        vBox.getChildren().add(petOwnerInfo);
        vBox.getChildren().add(petOwnerPane);

        vBox.getChildren().add(petInformation);
        vBox.getChildren().add(petPane);

        vBox.getChildren().add(reasonForVisit);
        vBox.getChildren().add(visitPane);

        vBox.getChildren().add(discounts);
        vBox.getChildren().add(discountPane);

        vBox.getChildren().add(btnSubmit);

        outputBox.getChildren().add(receiptOutput);

        hBox.getChildren().add(vBox);
        hBox.getChildren().add(outputBox);

        //ActionEvent handler for the clear button, when there is text, the output field is cleared.
        class ClearHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                if (receiptOutput.getText() != null) {
                    receiptOutput.setText(null);
                }
            }
        }

        btnSubmit.setOnAction(e -> {
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
                    "------------------------------ VETS 'R' US ------------------------------\n" +
                            "Customer Information\n\n" +
                    owner.toString() + "\n\n" +
                    "Pet Information\n\n" +
                            pet.toString()

            );
        });

        //Adds all panes to a scene and sets scene size.
        Scene scene = new Scene(hBox, 520, 635);

        //Creates and displays the stage.
        primaryStage.setTitle("Vets 'R' Us");
        primaryStage.setScene(scene);
        primaryStage.setMaxWidth(1000);
        primaryStage.setMinWidth(1000);
        primaryStage.setMaxHeight(900);
        primaryStage.setMinHeight(900);
        primaryStage.show();
    }
}
