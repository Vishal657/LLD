package com.vendingMechine;

import com.vendingMechine.state.*;

import java.util.List;

public class VandingMechine {

    public DispatchProducts dispatchProducts;
    public DispatchChange dispatchChange;
    public MakePayment makePayment;
    public Refill refill;
    public Idle idle;


    public State state;
    public List<Shelf> shelfList;

    public Product selectedProduct;
    public int amountPaid;


    public VandingMechine() {
        dispatchProducts = new DispatchProducts(this);
        dispatchChange = new DispatchChange(this);
        makePayment = new MakePayment(this);
        refill = new Refill(this);
        idle = new Idle(this);

        state = idle;
    }

    public void cancelTransection() {
        state.cancelTransection();
    }

    public void makePayment(int amt) {
        boolean success = state.makePayment(amt);
        if(success) {
            state.dispatchProduct();
            state.dispatchChange();
        }
    }

    public void selectProduct(int pid) {
        state.selectProduct(pid);
    }

    public void refill(List<Shelf> shelfList) {
        state.startRefill();
        state.refill(shelfList);
    }

}
