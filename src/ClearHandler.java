import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.xml.soap.Text;

class ClearHandler implements EventHandler<ActionEvent> {
    TextArea output;

    TextField firstName;
    LimitedTextField middleInitial;
    TextField lastName;
    LimitedTextField phoneNumber;
    TextField petName;
    TextField species;
    TextField weight;
    TextField discount;

    CheckBox officeVisit;
    CheckBox xRay;
    CheckBox specExam;
    CheckBox rabies;
    CheckBox kenCough;
    CheckBox antibaV;

    Label animalFactor;
    TextField animalFactorTxt;

    Transaction currentTransaction;

    public ClearHandler(TextArea output,
                        TextField firstName,
                        LimitedTextField middleInitial,
                        TextField lastName,
                        LimitedTextField phoneNumber,
                        TextField petName,
                        TextField species,
                        TextField weight,
                        TextField discount,
                        CheckBox officeVisit,
                        CheckBox xRay,
                        CheckBox specExam,
                        CheckBox rabies,
                        CheckBox kenCough,
                        CheckBox antibaV,
                        Label animalFactor,
                        TextField animalFactorTxt,
                        Transaction currentTransaction) {
        this.output = output;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.petName = petName;
        this.species = species;
        this.weight = weight;
        this.discount = discount;
        this.officeVisit = officeVisit;
        this.xRay = xRay;
        this.specExam = specExam;
        this.rabies = rabies;
        this.kenCough = kenCough;
        this.antibaV = antibaV;
        this.animalFactor = animalFactor;
        this.animalFactorTxt = animalFactorTxt;
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void handle(ActionEvent event) {
        if (output.getText() != null) {
            output.setText(null);
        }

        this.firstName.clear();
        this.middleInitial.clear();
        this.lastName.clear();
        this.phoneNumber.clear();
        this.petName.clear();
        this.species.clear();
        this.weight.clear();
        this.discount.clear();
        this.officeVisit.setSelected(false);
        this.xRay.setSelected(false);
        this.specExam.setSelected(false);
        this.rabies.setSelected(false);
        this.kenCough.setSelected(false);
        this.antibaV.setSelected(false);
        this.animalFactor.setVisible(false);
        this.animalFactorTxt.setVisible(false);
        this.animalFactorTxt.clear();
        this.currentTransaction.clearTransaction();
    }
}
