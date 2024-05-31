package org.example;

public class ProductInfo {
    private String name;
    private String price;
    private String availability;

    public ProductInfo(String name, String price, String availability) {
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getAvailability() {
        return availability;
    }

}
