package com.company;

public class CreditCard {
    private double accBal = 5000;

    public double getAccBal() {
        return accBal;
    }
    public void makeWithdraw( double withdrawammount){
        accBal -= withdrawammount;
    }
}
