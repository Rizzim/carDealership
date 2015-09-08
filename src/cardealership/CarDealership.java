/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealership;

/**
 *
 * @author Rizwan Ali
 */

import java.io.*;
import java.util.*;

public class CarDealership {

    private static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        ArrayList<Car> cars = new ArrayList<>();
        Car newCar = new Car("ADS23", "Honda", "Accord", 2012, 56000, 5000.00F);
        cars.add(newCar);
        cars.add( new Car("EII33", "Toyota", "Carolla", 2000, 5000, 1900.00F) );
        
        new FileOutputStream("myCars.txt", true).close();
        int menuOption = 0;
        System.out.println("Welcome to the Dealership please pick from the following options (Press 0 for menu)");
        displayMenu();
        do {
            System.out.println("\n\nWhat would you like to do? (0 for main menu)");
            menuOption = sc.nextInt();
            while(menuOption <0 || menuOption >6)
            {
                System.out.println("Please enter a correct menu option.(0 to see the menu)");
                menuOption = sc.nextInt();
            }
            doMenuOption(menuOption,cars);
            
            
            
        } while(menuOption != 6);
        
        FileOutputStream fos = new FileOutputStream("myCars.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Car car : cars) {
            oos.writeObject(car);
        }
        fos.close();

    }
    public static void displayMenu() {
                System.out.println("What would you like to do?");
                System.out.println("----------------------------------------------------------------");
                System.out.println("1. Show all existing car records in the database (in any order).");
                System.out.println("2. Add a new car record to the database.");
                System.out.println("3. Delete a car record from a database.");
                System.out.println("4. Search for a car (given its VIN).");
                System.out.println("5. Show a list of cars within a given price range.");
                System.out.println("6. Exit program.\n\n");
    }
    public static void displayCars(ArrayList<Car> cars) {
        String formatter = "| %-2d | %-6s | %-15s | %-15s | %-5d | %-8d | $%.2f   |%n";
        System.out.format("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
        System.out.printf("| #  | VIN    | Make            | Model           | Year  | Mileage  | Price      |%n");
        System.out.format("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
        int i = 0;
        for (Car car : cars) {
            System.out.format(formatter,++i,car.getVIN(),car.getMake(),car.getModel(),car.getYear(),car.getMileage(),car.getPrice());
        }
        System.out.format("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
    }
    public static void displayCars(Car car) {
        String formatter = "| %-2d | %-6s | %-15s | %-15s | %-5d | %-8d | $%.2f   |%n";
        System.out.format("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
        System.out.printf("| #  | VIN    | Make            | Model           | Year  | Mileage  | Price      |%n");
        System.out.format("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
        System.out.format(formatter,1,car.getVIN(),car.getMake(),car.getModel(),car.getYear(),car.getMileage(),car.getPrice());
        System.out.format("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
    }
    public static void doMenuOption(int action, ArrayList<Car> cars) throws Exception {
        String newCar, VIN, make, model;
        Car foundCar = null;
        int carNumber = 0, year = 0, mileage = 0;
        float priceMin = 0.00F, priceMax = 0.00F, price = 0.00F;
        boolean validInput = true;
        switch (action) {
            case 0:
                System.out.println("Main Menu");
                displayMenu();
                break;
            case 1:
                System.out.println("List of Cars");
                displayCars(cars);
                break;
            case 2:
                System.out.println("Add new car to database.");
                addNewCar(cars);
                break;
            case 3:
                System.out.println("Delete a car from a database.");
                deleteCar(cars);
                break;
            case 4:
                System.out.println("Search for a Car.");
                searchCar(cars);
                break;
            case 5:
                System.out.println("List of cars by given price range.");
                listCarByPriceRange(cars);
                break;
            case 6:
                break;
            default:
                break;
                
        }
                
        
    }
    public static void addNewCar(ArrayList<Car> cars) {
        
        boolean validInput;
        String VIN, make, model;
        int mileage = 0, year = 0;
        float price = 0.0F;
        
        System.out.println("Enter a new car in the following format:");
        System.out.println("VIN MAKE MODEL YEAR MILEAGE PRICE");
        System.out.println("EX: 123456 Honda Accord 2015 9500 20000");
        do {
            validInput = true;
            VIN = sc.next();
            make = sc.next();
            model = sc.next();
            if(sc.hasNextInt()) 
                year = sc.nextInt();
            else validInput = false;
            if(sc.hasNextInt())
                mileage = sc.nextInt();
            else validInput = false;
            if(sc.hasNextFloat())
                price = sc.nextFloat();
            else validInput = false;
            if(!validInput)
            {
                System.out.println("\nIncorrect Format.");
                System.out.println("Enter a new car in the following format:");
                System.out.println("VIN MAKE MODEL YEAR MILEAGE PRICE");
                System.out.println("EX: 123456 Honda Accord 2015 9500 20000\n");
            }
        } while(validInput == false);
        cars.add(new Car(VIN,make,model,year,mileage,price));
        
    }
    
    public static void deleteCar(ArrayList<Car> cars)
    {
        int carNumber;
        
        if(cars.size()>0) {
            System.out.println("Please select # of the car you want to delete");
            displayCars(cars);
            do {
                System.out.print("Delete car #: ");
                while(!sc.hasNextInt())
                {
                    System.out.println("Thats not a valid input");
                    sc.next();
                }
                carNumber = sc.nextInt();

            } while (carNumber < 1 || carNumber > cars.size());
            cars.remove(carNumber-1);
        } else System.out.println("There are no cars to remove.");
    }
    
    public static void searchCar(ArrayList<Car> cars)
    {
        String VIN;
        Car foundCar = null;
        
        do {
            System.out.print("Enter VIN of the car (5 Alphanumeric): ");
            VIN = sc.next();   
        }while(!VIN.matches("^[a-zA-Z0-9]{3,15}$"));

        for (Car car : cars) {
            if(car.getVIN().equals(VIN))
            {
                foundCar = car;
            }    
        }
        if(foundCar != null)
            displayCars(foundCar);
        else
            System.out.println("No Cars found.");
    }
    
    public static void listCarByPriceRange(ArrayList<Car> cars)
    {
        float priceMin = 0, priceMax = 0;
        do {
            if(priceMin > priceMax) System.out.println("Minimum Price is greater than maximum.");
            System.out.print("Enter minimum amount: $");
            while(!sc.hasNextFloat())
            {
                System.out.print("Invalid Input!! Enter minimum amount: $");
                sc.next();
            }
            priceMin = sc.nextFloat();

            System.out.print("Enter maximum amount: $");
            while(!sc.hasNextFloat())
            {
                System.out.print("Invalid Input!! Enter maximum amount: $");
                sc.next();
            }
            priceMax = sc.nextFloat();
            System.out.println(priceMin+" "+priceMax);
        } while ( priceMin > priceMax );
    }
    
}
