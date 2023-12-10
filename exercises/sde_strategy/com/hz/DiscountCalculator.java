package com.hz;

import com.strategy.DiscountStrategy;
import products.Product;

public class DiscountCalculator {

    private Customer customer;

//    private boolean isChristmasEve;

    private DiscountStrategy discountStrategy;

    public DiscountCalculator(Customer customer) {
        this.customer = customer;
    }

//    public void setChristmasEve(boolean christmasEve) {
//        isChristmasEve = christmasEve;
//    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double getDiscount(Product product, int index) {

        double discount = 0.0;

        // Apply a discount if necessary
        if(discountStrategy != null) {

            discount = discountStrategy.getDiscount(product, index);

        }

        // Otherwise new customers pay full price, regulars get 15% off
        else if(customer.isRegular()) {
            discount = .15;
        }

        return 1 - discount;
    }
}
