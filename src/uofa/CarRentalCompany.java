//package uofa;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CarRentalCompany {
//    private List<Car> cars;
//    private List<Renter> renters;
//    private List<Rental> rentals;
//    public CarRentalCompany() {
//        this.cars = new ArrayList<>();
//        this.renters = new ArrayList<>();
//        this.rentals = new ArrayList<>();
//    }
//    public void addCar(Car car) {
//        this.cars.add(car);
//    }
//    public void addRenter(Renter renter) {
//        this.renters.add(renter);
//    }
//    public Rental rentCar(Renter renter, Car car, LocalDate startDate, LocalDate endDate) {
//        if (!this.cars.contains(car)) {
//            System.out.println("Car not found in inventory.");
//            return null;
//        }
//        if (car.isRented()) {
//            System.out.println("Car already rented.");
//            return null;
//        }
//
//        car.setRented(true);
//        Rental rental = new Rental(this, renter, car, startDate, endDate);
//        rentals.add(rental);
//        renter.addRental(rental);
//
//        System.out.println(renter.getName() + " rented " + car.getModel() + " from " + startDate + " to " + endDate);
//        return rental;
//    }
//}
