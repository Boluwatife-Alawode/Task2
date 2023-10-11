
import java.io.*;
import java.util.*;

class Car {
    private int id;
    private String make;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double price;
    private String registrationNumber;

    public Car(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getPrice() {
        return price;
    }

    
    public String toString() {
        return "Car [id=" + id + ", make=" + make + ", model=" + model + ", yearOfManufacture=" + yearOfManufacture
                + ", color=" + color + ", price=" + price + ", registrationNumber=" + registrationNumber + "]";
    }
}

public class CarManagement {
    public static void main(String[] args) {
        
        Car[] cars = {
            new Car(1, "Nissan", "Rouge", 2010, "Black", 25000.0, "ADF206"),
            new Car(2, "Tesla", "Model3", 2011, "Grey", 22000.0, "LAL509"),
            new Car(3, "GMC", "Sierra", 2012, "Blue", 35000.0, "COM529"),
            
        };

        
        filterAndSaveByMake(cars, "Nissan", "NissanCars.txt");
        filterAndSaveByModelAndYears(cars, "Tesla", 2, "TeslaCarsOver2Years.txt");
        filterAndSaveByYearAndPrice(cars, 2010, 23000.0, "CarsFrom2010Above23000.txt");
    }

    
    public static void filterAndSaveByMake(Car[] cars, String make, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Car car : cars) {
                if (car.getMake().equalsIgnoreCase(make)) {
                    writer.println(car);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void filterAndSaveByModelAndYears(Car[] cars, String model, int years, String fileName) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Car car : cars) {
                if (car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYearOfManufacture()) > years) {
                    writer.println(car);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public static void filterAndSaveByYearAndPrice(Car[] cars, int year, double price, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Car car : cars) {
                if (car.getYearOfManufacture() == year && car.getPrice() > price) {
                    writer.println(car);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
