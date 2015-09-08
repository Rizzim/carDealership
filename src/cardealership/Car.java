/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealership;

import java.io.*;

/**
 *
 * @author Rizwan Ali, Zachary
 */
public class Car implements Serializable{
    String VIN;
    String make;
    String model;
    int year;
    int mileage;
    float price;
    
    Car() {};   // default constructor
    Car(String VIN, String make, String model, int year, int mileage, float price) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }
    public boolean addNewCar(String VIN, String make, String model, int year, int mileage, float price) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        return true;
    }

    public String getVIN() {
        return VIN;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public float getPrice() {
        return price;
    }
    
    
   
}
