package carAgency;

import java.io.FileWriter;
import java.io.IOException;
//Assignment:5
//Author:Daniel Dahan , ID:318840196
/**
 Represents an employee in the car agency.
 Each employee has a name, ID, and sales count.
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private String id;
    private int sales;
/**

 Constructs a new Employee object with the specified details.
 @param name the name of the employee
 @param id the ID of the employee
 @param sales the sales count of the employee
 @throws IllegalArgumentException if the name contains non-alphabetic characters,
 if the ID length is not 9 digits long, or if the sales count is negative.
 */
    public Employee(String name, String id, int sales) {
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name must contain only letters.");
        }
        if (id.length() != 9) {
            throw new IllegalArgumentException("ID must be exactly 9 digits long.");
        }
        if (sales < 0) {
            throw new IllegalArgumentException("Sales must be a non-negative number.");
        }

        this.name = name;
        this.id = id;
        this.sales = sales;
    }
    /**
     Sells a car and updates the sales count.
     @param car the car to be sold
     @param fileWriter the FileWriter to write the car details to
     @throws IOException if an I/O error occurs while writing the car details
     */
    public void sellCar(Car car, FileWriter fileWriter) throws IOException {
        car.sellCar(fileWriter);
        sales++;
    }
    /**
     Retrieves the name of the employee.
     @return the name of the employee
     */
    public String getName() {
        return name;
    }
    /**
     Retrieves the ID of the employee.
     @return the ID of the employee
     */
    public String getId() {
        return id;
    }
    /**
     Retrieves the sales count of the employee.
     @return the sales count of the employee
     */
    public int getSales() {
        return sales;
    }
    /**
     Sets the sales count of the employee.
     @param sales the sales count of the employee
     */
    public void setSales(int sales) {
        this.sales = sales;
    }
    /**
     Calculates the salary of the employee based on the sales count.
     @return the calculated salary of the employee
     */
    public double calculateSalary() {
        return 6000 + (sales * 100);
    }
    /**
     Returns a string representation of the employee, including their name, ID, sales count, and salary.
     @return a string representation of the employee
     */
    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Sales: " + sales + ", Salary: " + calculateSalary();
    }
/**
 Compares this employee to another employee based on their sales count.
 @param other the other employee to compare to
 @return 0 if the sales counts are equal,
 -1 if this employee's sales count is less than the other employee's sales count,
 1 if this employee's sales count is greater than the other employee's sales count.
 */
    @Override
    public int compareTo(Employee other) {
        if (this.sales == other.sales) {
            return 0;
        } else if (this.sales < other.sales) {
            return -1;
        } else {
            return 1;
        }
    }
}
