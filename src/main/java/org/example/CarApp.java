package org.example;
import java.util.Scanner;
import java.util.ArrayList;

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
            System.out.println("3. Exit");
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
                    running = false;
                    break;
                default:
                    System.out.println("Choose 1, 2 or 3!");
            }

        }
    }

    private static void addCar() {
        System.out.println("Add a car brand: ");
        String brand = sc.nextLine();
        System.out.println("Enter type of model: ");
        String model = sc.nextLine();
        System.out.println("Choose a color: ");
        String color = sc.nextLine();

        Car newCar = new Car(brand, model, color);
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
                System.out.println("Choose a color: ");
                color = sc.nextLine();

                Car anotherCar = new Car(brand, model, color);
                cars.add(anotherCar);
                System.out.println("Car: " + anotherCar + " is added.");
            }else {
                System.out.println("You must choose y or n!");
            }
        }
    }

    public static void showCar() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
