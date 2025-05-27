package com.vendingMechine.state;

import com.vendingMechine.Shelf;
import com.vendingMechine.VandingMechine;

import java.util.List;

public class Refill implements State{

    VandingMechine vandingMechine;

    public Refill(VandingMechine vandingMechine) {
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
        throw new UnsupportedOperationException("Action not supported");
    }

    @Override
    public void refill(List<Shelf> shelfList) {
        vandingMechine.shelfList = shelfList;
        vandingMechine.state = vandingMechine.idle;
        System.out.println("Refilling completed. Machine is ready to use!!");
    }

    @Override
    public void startRefill() {
        throw new UnsupportedOperationException("Action not supported");
    }
}
