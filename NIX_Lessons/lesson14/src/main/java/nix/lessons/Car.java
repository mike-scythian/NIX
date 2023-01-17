package nix.lessons;

import java.time.LocalDate;

public class Car implements Comparable<Car> {

    private LocalDate yearOfManufacture;
    private double engineCapacity;

    public Car(LocalDate manufactureDate, double engineCapacity) {
        this.yearOfManufacture = manufactureDate;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "yearOfManufacture=" + yearOfManufacture +
                ", engineCapacity=" + engineCapacity +
                "}";
    }

    public LocalDate getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public int compareTo(Car car) {
        return this.yearOfManufacture.compareTo(car.getYearOfManufacture());
    }
}
