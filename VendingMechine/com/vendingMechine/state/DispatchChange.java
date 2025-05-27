package com.vendingMechine.state;

import com.vendingMechine.Shelf;
import com.vendingMechine.VandingMechine;

import java.util.List;

public class DispatchChange implements State{

    VandingMechine vandingMechine;

    public DispatchChange(VandingMechine vandingMechine) {
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
        throw new UnsupportedOperationException("Action not supported");
    }

    @Override
    public void dispatchChange() {
        System.out.println("Your change dispatched!! Amount: " + (vandingMechine.amountPaid - vandingMechine.selectedProduct.price));
        vandingMechine.state = vandingMechine.idle;
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
