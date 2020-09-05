import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class gui extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btnSubmit = new Button("Submit");

        //VBox will be used to hold all the panes to be placed in a scene
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 5, 10));
        vBox.setSpacing(10);

        //Primary GridPane to hold labels and text fields
        GridPane petOwnerPane = new GridPane();
        petOwnerPane.setPadding(new Insets(30, 30, 30, 10));
        petOwnerPane.setAlignment(Pos.CENTER);
        petOwnerPane.setHgap(10);
        petOwnerPane.setVgap(10);
        petOwnerPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #999999;");

        GridPane petPane = new GridPane();
        petPane.setPadding(new Insets(30, 30, 30, 10));
        petPane.setAlignment(Pos.CENTER);
        petPane.setHgap(10);
        petPane.setVgap(10);
        petPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #999999;");

        GridPane visitPane = new GridPane();
        visitPane.setPadding(new Insets(30, 30, 30, 10));
        visitPane.setAlignment(Pos.CENTER);
        visitPane.setHgap(10);
        visitPane.setVgap(10);
        visitPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #999999;");

        GridPane discountPane = new GridPane();
        discountPane.setPadding(new Insets(30, 30, 30, 10));
        discountPane.setAlignment(Pos.CENTER);
        discountPane.setHgap(10);
        discountPane.setVgap(10);
        discountPane.setStyle("-fx-background-color: #e6e6e6; -fx-border-color: #999999;");

        //All labels
        Label petOwnerInfo = new Label("Pet Owner Information");
        Label petInformation = new Label("Pet Information");
        Label reasonForVisit = new Label("Reason for Visit");
        Label vaccination = new Label("Vaccination");
        Label discounts = new Label("Discounts");

        Label firstName = new Label("First Name:");
        Label middleInitial = new Label("Middle Initial:");
        Label lastName = new Label("Last Name:");
        Label phoneNumber = new Label("Phone Number:");

        Label petName = new Label("Pet Name:");
        Label species = new Label("Species:");

        //All text fields that will be used to collect input
        TextField firstNameTxt = new TextField();
        TextField middleInitialTxt = new TextField();
        TextField lastNameTxt = new TextField();
        TextField phoneNumberTxt = new TextField();
        TextField petNametxt = new TextField();
        TextField speciesTxt = new TextField();

        petOwnerPane.add(firstName, 0,0);
        petOwnerPane.add(middleInitial, 1, 0);
        petOwnerPane.add(lastName, 2, 0);

        petOwnerPane.add(firstNameTxt, 0, 1);
        petOwnerPane.add(middleInitialTxt, 1, 1);
        petOwnerPane.add(lastNameTxt, 2, 1);

        petOwnerPane.add(phoneNumber, 0, 2);
        petOwnerPane.add(phoneNumberTxt, 0, 3);

        vBox.getChildren().add(petOwnerInfo);
        vBox.getChildren().add(petOwnerPane);

        vBox.getChildren().add(petInformation);
        vBox.getChildren().add(petPane);

        vBox.getChildren().add(reasonForVisit);
        vBox.getChildren().add(visitPane);

        vBox.getChildren().add(discounts);
        vBox.getChildren().add(discountPane);

        vBox.getChildren().add(btnSubmit);

        //Adds all panes to a scene and sets scene size.
        Scene scene = new Scene(vBox, 520, 635);

        //Creates and displays the stage.
        primaryStage.setTitle("Vets 'R' Us");
        primaryStage.setScene(scene);
        primaryStage.setMaxWidth(520);
        primaryStage.setMinWidth(520);
        primaryStage.show();
    }
}
