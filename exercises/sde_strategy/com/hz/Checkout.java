package com.hz;

import com.strategy.DiscountStrategy;

public class Checkout {

//    private SalesAction salesAction;

//    public Checkout(SalesAction action) {
//        this.salesAction = action;
//    }

    private DiscountStrategy salesAction;

    public Checkout(DiscountStrategy discountStrategy) {
        this.salesAction = discountStrategy;
    }

    public void nextInLine(Customer customer) {

        // init checkout
        DiscountCalculator discountCalculator = new DiscountCalculator(customer);
        discountCalculator.setDiscountStrategy(salesAction);

        // Welcome customer
        String welcome = String.format("Hello %s, would you pass me your shopping cart?",
                customer.getName());
        Console.write(welcome);

        // perform checkout
        ShoppingCart cart = customer.getCart();

        double amountToPay = cart.getTotalPrice(discountCalculator);
        String payinfo = String.format("Let's see, that will be.. %.02f. Cash or card?", amountToPay);
        Console.write(payinfo);
    }
}
