package carAgency;

import java.io.FileWriter;
import java.io.IOException;
//Assignment:5
//Author:Daniel Dahan , ID:318840196
/**
 Represents a car in the car agency inventory.
 Each car has a car number, year, manufacturer, mileage, and price.
 The car number is a unique identifier for the car.
 The year must be 2017 or later.
 The price must be positive.
 */
public class Car {
    private String carNumber;
    private final int year;
    private final String manufacturer;
    private int mileage;
    private double price;
    /**
     Constructs a new Car object with the specified details.
     @param carNum the car number
     @param year the year of the car
     @param manufacturer the manufacturer of the car
     @param mileage the mileage of the car
     @param price the price of the car
     @throws IllegalArgumentException if the year is less than 2017 or the price is negative
     */
    public Car(String carNum, int year, String manufacturer, int mileage, int price) {
        if (year < 2017) {
            throw new IllegalArgumentException("Car year must be 2017 or later.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }

        this.carNumber = carNum;
        this.year = year;
        this.manufacturer = manufacturer;
        this.mileage = mileage;
        this.price = price;
    }
    /**
     Retrieves the car number.
     @return the car number
     */
    public String getCarNumber() {
        return carNumber;
    }
    /**
     Retrieves the year of the car.
     @return the year of the car
     */
    public int getYear() {
        return year;
    }
    /**
     Retrieves the manufacturer of the car.
     @return the manufacturer of the car
     */
    public String getManufacturer() {
        return manufacturer;
    }
    /**
     Retrieves the mileage of the car.
     @return the mileage of the car
     */
    public int getMileage() {
        return mileage;
    }
    /**
     Retrieves the price of the car.
     @return the price of the car
     */
    public double getPrice() {
        return price;
    }
    /**
     Sets a price discount on the car.
     The discount percentage must be a non-negative value.
     If the discount amount exceeds the limit of $5000, an exception is thrown.
     @param discountPercentage the discount percentage to apply
     @throws IllegalArgumentException if the discount percentage is negative or the discount amount exceeds the limit
     */
    public void setPriceDiscount(double discountPercentage) {
        if (discountPercentage < 0) {
            throw new IllegalArgumentException("Discount percentage cannot be negative.");
        }

        double discountAmount = price * discountPercentage / 100;

        if (discountAmount > 5000) {
            throw new IllegalArgumentException("Discount amount exceeds limit.");
        }

        price -= discountAmount;
    }
    /**
     Writes the car details to a FileWriter.
     @param fileWriter the FileWriter to write the car details to
     @throws IOException if an I/O error occurs while writing the car details
     */
    public void sellCar(FileWriter fileWriter) throws IOException {
        String carDetails = carNumber + " " + year + " " + manufacturer + " " + mileage + " " + price + "\n";
        fileWriter.write(carDetails);
    }
    /**
     Returns a string representation of the car.
     @return a string representation of the car
     */

    @Override
    public String toString() {
        return carNumber + " " + year + " " + manufacturer + " " + mileage + " " + price;
    }
}











