package com.company;

import java.util.Random;

public class CardHolder implements Runnable{
    private CreditCard card;
    public CardHolder(CreditCard inputCard){
        card = inputCard;
    }
    Random rand = new Random();
    @Override
    public void run(){
        for (int i = 0; i < rand.nextInt(20); i++){
            makeWithdrawal(500);
            if(card.getAccBal() < 0){
                System.out.println("Account is overdrawn");
            }
        }
    }

    private synchronized void makeWithdrawal(double withdrawalAmmount) {
        if(card.getAccBal() < withdrawalAmmount){
            System.out.println("Not enough in: " + Thread.currentThread().getName() + " to withdraw: $" + withdrawalAmmount + ", Balance: $" + card.getAccBal());
        }else {
            System.out.println(Thread.currentThread().getName() + " before withdrawing: $" + withdrawalAmmount + " Balance: $" + card.getAccBal());
            try {
                Thread.sleep(3000);
            }catch (Exception e){

            }
            card.makeWithdraw(withdrawalAmmount);
            System.out.println(Thread.currentThread().getName() + " after withdrawing: $" + withdrawalAmmount + " Balance: $" + card.getAccBal());
        }
    }
}
