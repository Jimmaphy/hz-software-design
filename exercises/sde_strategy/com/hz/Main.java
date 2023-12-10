package com.hz;

import com.strategy.ChristmasEveDiscount;
import products.CuteTeddyBear;
import products.TVScreen;

public class Main {

    // Main scenario
    public static void main(String[] args) {

        // There is a shop with a checkout
        Checkout registerFive = new Checkout(new ChristmasEveDiscount());

        // Two customers enter the shop
        Customer piet = new Customer(CustomerType.Regular, "Piet");
        Customer anne = new Customer(CustomerType.New, "Anne");

        // buying stuff
        piet.buys(new CuteTeddyBear());
        anne.buys(new TVScreen());

        // and proceed to checkout
        registerFive.nextInLine(piet);
        registerFive.nextInLine(anne);
    }
}
