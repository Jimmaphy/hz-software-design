package com.strategy;

import products.Product;

/**
 * The BlackFridayDiscount class is an implementation of the DiscountStrategy interface.
 * It applies a fixed discount of 50% for any product during Black Friday.
 */
public class BlackFridayDiscount implements DiscountStrategy {

    /**
     * Retrieves the discount amount for a product at the specified index.
     * The discount amount is given as a percentage.
     *
     * @param product The product for which to retrieve the discount.
     * @param productIndex The index of the product in the shopping cart.
     * @return The discount percentage as a double value, 50% for all products.
     */
    @Override
    public double getDiscount(Product product, int productIndex) {
        return 0.50;
    }
}
