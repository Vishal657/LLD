package com.vendingMechine;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    static List<Shelf> getInventory() {
        List<Shelf> shelfList = new ArrayList<>();

        shelfList.add(new Shelf(1,
                List.of(
                        new Product("Pepsi", 20, 101, 3),
                        new Product("Coca cola", 20, 102, 3),
                        new Product("Fruity", 20, 103, 3)
                )
        ));

        shelfList.add(new Shelf(2,
                List.of(
                        new Product("Pizza", 20, 201, 3),
                        new Product("Burger", 20, 202, 3),
                        new Product("Sweets", 20, 203, 3)
                )
        ));

        return  shelfList;
    }


    public static void main(String[] args) {
        VandingMechine vandingMechine = new VandingMechine();
        vandingMechine.refill(getInventory());

        vandingMechine.selectProduct(202);
        vandingMechine.cancelTransection();
        // vandingMechine.selectProduct(202); throw error

        vandingMechine.selectProduct(103);
        vandingMechine.makePayment(10);
        System.out.println();
        vandingMechine.makePayment(23);


        vandingMechine.selectProduct(103);
        vandingMechine.makePayment(10);
        System.out.println();
        vandingMechine.makePayment(23);


        System.out.println();
        vandingMechine.selectProduct(103);
        vandingMechine.makePayment(20);


        System.out.println();
        vandingMechine.selectProduct(103);

        System.out.println();
    }
}
