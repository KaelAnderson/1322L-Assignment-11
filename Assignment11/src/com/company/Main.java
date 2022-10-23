package com.company;

public class Main {

    public static void main(String[] args) {
        CreditCard newcard = new CreditCard();
        CardHolder newCardHolder = new CardHolder(newcard);
    CardHolder newCardHolder2 = new CardHolder(newcard);


        Thread John = new Thread(newCardHolder);
        Thread Mary = new Thread(newCardHolder);
        John.start();
        John.setName("John");
        Mary.start();
        Mary.setName("Mary");

    }
}
