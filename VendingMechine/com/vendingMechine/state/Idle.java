package com.vendingMechine.state;

import com.vendingMechine.Product;
import com.vendingMechine.Shelf;
import com.vendingMechine.VandingMechine;

import java.util.List;

public class Idle implements State{

    VandingMechine vandingMechine;

    public Idle(VandingMechine vandingMechine) {
        this.vandingMechine = vandingMechine;
    }

    @Override
    public void selectProduct(int pid) {
        Product selectedProduct = null;
        for(Shelf shelf: vandingMechine.shelfList) {
            for(Product product: shelf.products) {
                if(product.id == pid) {
                    selectedProduct = product;
                    break;
                }
            }
        }
        if(selectedProduct == null) {
            System.out.println("Invalid product id entered.");
            return;
        }
        if(selectedProduct.quantity == 0) {
            System.out.println("Selected product is out of stock.");
            return;
        }
        System.out.println("Selected product: " + selectedProduct.name + ". Net Price to pay RS. " + selectedProduct.price);
        vandingMechine.selectedProduct = selectedProduct;
        vandingMechine.state = vandingMechine.makePayment;
    }

    @Override
    public void cancelTransection() {
        throw new UnsupportedOperationException("Action not supported");
    }

    @Override
    public boolean makePayment(int amt) {
        throw new UnsupportedOperationException("Action not supported");
    }

    @Override
    public void dispatchProduct() {
        throw new UnsupportedOperationException("Action not supported");
    }

    @Override
    public void dispatchChange() {
        throw new UnsupportedOperationException("Action not supported");
    }

    @Override
    public void refill(List<Shelf> shelfList) {
        throw new UnsupportedOperationException("Action not supported");
    }

    @Override
    public void startRefill() {
        System.out.println("Refilling started...");
        this.vandingMechine.state = vandingMechine.refill;
    }
}
