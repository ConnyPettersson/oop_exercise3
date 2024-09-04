package org.example;

public record Car(String brand, String model, int year, int ID) {
    @Override
    public String toString() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year + ", ID: "+ ID;
    }
}
