package com.vendingMechine.state;

import com.vendingMechine.Shelf;
import com.vendingMechine.VandingMechine;

import java.util.List;

public class DispatchProducts implements State {

    VandingMechine vandingMechine;

    public DispatchProducts(VandingMechine vandingMechine) {
        this.vandingMechine = vandingMechine;
    }

    @Override
    public void selectProduct(int pid) {
        throw new UnsupportedOperationException("Action not supported");
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
        System.out.println("Product " + vandingMechine.selectedProduct.name + " dispatched.");
        vandingMechine.selectedProduct.quantity--;
        this.vandingMechine.state = this.vandingMechine.dispatchChange;
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
        throw new UnsupportedOperationException("Action not supported");
    }
}
