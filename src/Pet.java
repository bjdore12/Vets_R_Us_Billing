/*

    Author: Benjamin J. Dore
    Date:   9/4/2020

    Description:    Pet class is used to define characteristics of the visiting pet
                    (i.e. pet name, species, and weight.

*/

public class Pet {

    // Basic pet information
    private String petName;
    private String petSpecies;
    private int petWeight;

    public Pet(String petName, String petSpecies, int petWeight) {
        this.petName = petName;
        this.petSpecies = petSpecies;
        this.petWeight = petWeight;
    }

    public void setPetName(String newPetName) {
        this.petName = newPetName;
    }

    public void setPetSpecies(String newPetSpecies) {
        this.petSpecies = newPetSpecies;
    }

    public void setPetWeight(int newPetWeight) {
        this.petWeight = newPetWeight;
    }

    public String getPetName() {
        return this.petName;
    }

    public String getPetSpecies() {
        return this.petSpecies;
    }

    public int getPetWeight() {
        return this.petWeight;
    }

    @Override
    public String toString() {
        return "Pet Name: " + this.petName + "\n" +
                "Pet Species: " + this.petSpecies + "\n" +
                "Pet Weight: " + this.petWeight;
    }
}
