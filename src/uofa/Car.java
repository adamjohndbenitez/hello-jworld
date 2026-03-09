package uofa;

public class Car {
    private String licensePlate;
    private String model;
    private boolean rented;
    public Car(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.rented = false;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public String getModel() {
        return model;
    }
    public boolean isRented() {
        return rented;
    }
    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return this.model + " (" + this.licensePlate + ")";
    }
}
