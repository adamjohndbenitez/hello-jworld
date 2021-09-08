package linkedin.advancejava.generics.substitution_principle;

class Office extends Building {
    private int numberOfRooms = 7;

    @Override
    public String toString() {
        return("Office");
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
