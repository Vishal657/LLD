package com.vendingMechine;

public class Product {

    public String name;
    public int price;
    public int id;
    public int quantity;

    public Product(String name, int price, int id, int quantity) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
}
