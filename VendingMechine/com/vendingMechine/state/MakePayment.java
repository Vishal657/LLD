package com.vendingMechine.state;

import com.vendingMechine.Shelf;
import com.vendingMechine.VandingMechine;

import java.util.List;

public class MakePayment implements State{

    VandingMechine vandingMechine;

    public MakePayment(VandingMechine vandingMechine) {
        this.vandingMechine = vandingMechine;
    }

    @Override
    public void selectProduct(int pid) {
        throw new UnsupportedOperationException("Action not supported");
    }

    @Override
    public void cancelTransection() {
        System.out.println("Payment canceled!!");
        this.vandingMechine.state = vandingMechine.idle;
    }

    void refundAmount() {
        System.out.println("Refunded amount " + vandingMechine.amountPaid);
    }

    public void insufficientPayment() {
        refundAmount();
        vandingMechine.amountPaid = 0;
    }

    @Override
    public boolean makePayment(int amt) {
        System.out.println("Amount paid RS. " + amt);
        this.vandingMechine.amountPaid = amt;

        if(amt < this.vandingMechine.selectedProduct.price) {
            System.out.println("Please pay the required amount.");
            insufficientPayment();
            return false;
        }
        this.vandingMechine.state = vandingMechine.dispatchProducts;
        return true;
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
        throw new UnsupportedOperationException("Action not supported");
    }
}
