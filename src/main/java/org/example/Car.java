package org.example;

public record Car(String brand, String model, int year, int id) {
    @Override
    public String toString() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year + ", ID: "+ id;
    }
}
