/*

    Author: Benjamin J. Dore
    Date:   9/4/2020

    Description:    LimitedTextField extends the regular text field, except a cap on the number of
                    characters can be defined.

*/

import javafx.scene.control.TextField;

class LimitedTextField extends TextField {

    private final int limit;    // Used to define the limit on number of chars in a text field

    public LimitedTextField(int limit) {
        this.limit = limit;
    }

    // Replace text defined from 'start' to 'end', verify it doesn't exceed limit
    @Override
    public void replaceText(int start, int end, String text) {
        super.replaceText(start, end, text);
        verify();
    }

    // Replace text, verify it doesn't exceed limit
    @Override
    public void replaceSelection(String text) {
        super.replaceSelection(text);
        verify();
    }

    // Check to make sure text length is not past limit
    private void verify() {
        if (getText().length() > limit) {
            setText(getText().substring(0, limit));
        }
    }
};
