package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.function.Consumer;

public class CarApp {
public static final ArrayList<Car> cars = new ArrayList<>();
public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            System.out.println("Welcome to CarApp!");
            System.out.println("Choose an option");
            System.out.println("1. Add car");
            System.out.println("2. Show all cars");
            System.out.println("3. Remove car by ID");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    addCar();
                    break;
                case 2:
                    showCar();
                    break;
                case 3:
                    removeCar();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Choose 1, 2 or 3!");
            }
        }
            sc.close();
    }

    private static void addCar() {
        System.out.println("Add a car brand: ");
        String brand = sc.nextLine();
        System.out.println("Enter type of model: ");
        String model = sc.nextLine();
        System.out.println("Enter year: ");
        int year = sc.nextInt();
        System.out.println("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Car newCar = new Car(brand, model, year, id);
        cars.add(newCar);
        System.out.println("Car: " + newCar + " is added.");

        while(true) {
            System.out.println("Do you want to add another car, y or n?");
            String response = sc.nextLine();
            if(response.equals("n")) {
                break;
            }else if (response.equals("y")) {
                System.out.println("Add a car brand: ");
                brand = sc.nextLine();
                System.out.println("Enter type of model: ");
                model = sc.nextLine();
                System.out.println("Enter year: ");
                year = sc.nextInt();
                System.out.println("Enter ID: ");
                id = sc.nextInt();
                sc.nextLine();


                Car anotherCar = new Car(brand, model, year, id);
                cars.add(anotherCar);
                System.out.println("Car: " + anotherCar + " is added.");
            }else {
                System.out.println("You must choose y or n!");
            }
        }
    }

    public static void showCar() {
        Consumer<Car> printCar = System.out::println;
        cars.forEach(printCar);
    }

    public static void removeCar() {
        System.out.println("Enter ID of the car you want removed: ");
        int idToRemove = sc.nextInt();
        sc.nextLine();

         Car carToRemove = null;
         for(Car car : cars) {
             if(car.ID() == idToRemove) {
                 carToRemove = car;
                 break;
             }
         }
         if(carToRemove != null) {
             cars.remove(carToRemove);
             System.out.println("Car removed: " + carToRemove);
         }else {
             System.out.println("Car with ID " + idToRemove + " not found");
         }

    }
}
