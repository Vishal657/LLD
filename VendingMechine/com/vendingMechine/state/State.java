package com.vendingMechine.state;

import com.vendingMechine.Shelf;

import java.util.List;

public interface State {

    void selectProduct(int pid);

    void cancelTransection();

    boolean makePayment(int amt);

    void dispatchProduct();

    void dispatchChange();

    void refill(List<Shelf> shelfList);

    void startRefill();

}
