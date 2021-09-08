package linkedin.advancejava.generics.substitution_principle;

public class House extends Building {
    private int numberOfRooms = 7;

    @Override
    public String toString() {
        return("House");
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

}
