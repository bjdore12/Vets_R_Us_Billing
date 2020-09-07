/*

    Author: Benjamin J. Dore
    Date:   9/4/2020

    Description:    Pet owner class is used to define a pet owners characteristics
                    (i.e. name and phone number).

*/

public class PetOwner {

    private String firstName;
    private String middleInitial;
    private String lastName;
    private String phoneNumber;

    public PetOwner(String firstName, String middleInitial, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public void setMiddleInitial(String newMiddleInitial) {
        this.middleInitial = newMiddleInitial;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public String getFullName() {
        return this.firstName + " " + this.middleInitial + ". " + this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleInitial() {
        return this.middleInitial;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return String.valueOf(this.phoneNumber).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.middleInitial + ". " + this.lastName + "\n" + "Phone: " + this.phoneNumber;
    }
}
