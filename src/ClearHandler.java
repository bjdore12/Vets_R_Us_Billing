import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

//ActionEvent handler for the clear button, when there is text, the output field is cleared.
class ClearHandler implements EventHandler<ActionEvent> {
    TextArea output;

    public ClearHandler(TextArea output) {
        this.output = output;
    }

    @Override
    public void handle(ActionEvent event) {
        if (output.getText() != null) {
            output.setText(null);
        }
    }
}