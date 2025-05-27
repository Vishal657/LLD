package com.vendingMechine;

import java.util.List;

public class Shelf {

    public int id;     // can be auto incremented
    public List<Product> products;

    public Shelf(int id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

}
