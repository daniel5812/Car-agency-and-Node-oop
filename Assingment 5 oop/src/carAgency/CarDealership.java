package carAgency;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
//Assignment:5
//Author:Daniel Dahan , ID:318840196
public class CarDealership {
    /**
     * The CarDealership class represents a car dealership program. It provides functionality
     * to manage employees, car inventory, and perform various operations such as listing employees,
     * listing unsold cars, selling cars, and adding cars.
     */

    public enum Menu {
        /**
         * Represents the available options in the menu.
         */
        LIST_EMPLOYEES(1), LIST_UNSOLD_CARS(2), SELL_CAR(3), ADD_CAR(4), EXIT(5);

        private final int option;

        Menu(int option) {
            this.option = option;
        }

        public int getOption() {
            return option;
        }

        public static Menu fromOption(int option) {
            for (Menu menu : Menu.values()) {
                if (menu.getOption() == option) {
                    return menu;
                }
            }
            return null;
        }
    }

    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Car> carInventory = new ArrayList<>();
    /**
     * The entry point of the CarDealership program.
     *
     * @param args command line arguments
     * @throws IOException if an I/O error occurs
     */

    public static void main(String[] args) throws IOException {
        saveCarsToFile("sold.txt");
        loadEmployeesFromFile("Employee.txt");
        loadCarsFromFile("CarDealership.txt");

        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram) {
            displayMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Menu selectedOption = Menu.fromOption(option);

            if (selectedOption == null) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            switch (selectedOption) {
                case LIST_EMPLOYEES:
                    listEmployees();
                    break;

                case LIST_UNSOLD_CARS:
                    listUnsoldCars();
                    break;

                case SELL_CAR:
                    sellCar();
                    break;

                case ADD_CAR:
                    addCar();
                    break;

                case EXIT:
                    exitProgram = true;
                    break;
            }
        }
    }

    /**
     * Sorts an ArrayList in ascending order using the natural order of elements.
     *
     * @param list the ArrayList to be sorted
     * @param <T>  the type of elements in the ArrayList, must implement Comparable interface
     */
    public static <T extends Comparable<T>> void sortArrayList(ArrayList<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    // Swap elements
                    T temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    /**
     * Displays the menu options on the console.
     */
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. List employees");
        System.out.println("2. List unsold cars");
        System.out.println("3. Sell car");
        System.out.println("4. Add car");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }
    /**
     * Loads employee data from a file and populates the employees list.
     *
     * @param fileName the name of the file to load employee data from
     */
    private static void loadEmployeesFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String name = input.next();
                String id = input.next();
                int sells = input.nextInt();
                Employee employee = new Employee(name, id, sells);
                employees.add(employee);
            }

        } catch (IOException e) {
            System.out.println("Failed to load employees from file: " + e.getMessage());
        }
    }

    /**
     * Loads car data from a file and populates the car inventory list.
     *
     * @param fileName the name of the file to load car data from
     */
    public static void loadCarsFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                int carNumInt = input.nextInt();
                String carNum = String.valueOf(carNumInt);
                int year = input.nextInt();
                String manufacturer = input.next();
                int mileage = input.nextInt();
                int price = input.nextInt();

                Car car = new Car(carNum, year, manufacturer, mileage, price);
                carInventory.add(car);
            }

            input.close();
        } catch (IOException e) {
            System.out.println("Failed to load cars from file: " + e.getMessage());
        }
    }


    /**
     * Saves car data to a file.
     *
     * @param fileName the name of the file to save car data to
     */
    private static void saveCarsToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);

            for (Car car : carInventory) {
                writer.write(car.getCarNumber() + "," + car.getYear() + "," +
                        car.getManufacturer() + "," + car.getMileage() + "," + car.getPrice() + "\n");
            }
            writer.close();
            System.out.println("Cars saved to file.");

        } catch (IOException e) {
            System.out.println("Failed to save cars to file: " + e.getMessage());
        }
    }
    /**
     * Adds a new car to the car inventory.
     */
    private static void addCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter the mileage: ");
        int mileage = scanner.nextInt();
        System.out.print("Enter the price: ");
        int price = scanner.nextInt();
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the car number: ");
        int carNumInt = scanner.nextInt();
        String carNum=String.valueOf(carNumInt);

        Car car = new Car(carNum, year, manufacturer, mileage, price);
        carInventory.add(car);
        saveSoldCarToFile(car);

        System.out.println("Car added successfully.");
    }
    /**
     * Sells a car from the car inventory.
     */
    private static void sellCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the employee ID: ");
        String employeeID = scanner.nextLine();

        Employee employee = findEmployeeByID(employeeID);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("Enter the car number: ");
        String carNum = scanner.nextLine();

        Car car = findCarByNumber(carNum);
        if (car == null) {
            System.out.println("Car not found.");
            return;
        }

        carInventory.remove(car);
        employee.getSales();
        saveCarsToFile("CarDealership.txt");
        saveSoldCarToFile(car);
        System.out.println("Car sold successfully.");
    }
    /**
     * Finds an employee by ID in the employees list.
     *
     * @param employeeID the ID of the employee to find
     * @return the Employee object if found, or null if not found
     */
    private static Employee findEmployeeByID(String employeeID) {
        for (Employee employee : employees) {
            if (employee.getId().equalsIgnoreCase(employeeID)) {
                return employee;
            }
        }
        return null;
    }
    /**
     * Finds a car by car number in the car inventory.
     *
     * @param carNum the car number to find
     * @return the Car object if found, or null if not found
     */
    private static Car findCarByNumber(String carNum) {
        for (Car car : carInventory) {
            if (car.getCarNumber().equalsIgnoreCase(carNum)) {
                return car;
            }
        }
        return null;
    }
    /**
     * Saves sold car data to a file.
     *
     * @param car the Car object representing the sold car
     */
    private static void saveSoldCarToFile(Car car) {
        Path soldFilePath = Paths.get("sold.txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(soldFilePath.toString(), true))) {
            writer.println(car.toString());
        } catch (IOException e) {
            System.out.println("Failed to save sold car to file: " + e.getMessage());
        }
    }

    private static void listUnsoldCars() {
        System.out.println("Unsold Cars:");
        for (int i = 0; i < carInventory.size(); i++) {
            System.out.println((i + 1) + ". " + carInventory.get(i).toString());
        }
    }

    private static void listEmployees() {
        sortArrayList(employees);
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
    }
}
