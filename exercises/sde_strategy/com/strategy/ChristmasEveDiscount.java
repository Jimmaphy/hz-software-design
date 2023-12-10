package com.strategy;

import products.Product;

/**
 * The ChristmasEveDiscount class implements the DiscountStrategy interface
 * and represents a discount strategy specifically for Christmas Eve.
 * It provides the logic to calculate the discount amount for a product
 * based on its index in the shopping cart.
 * Giving a 20% discount for the first product, 15% for others.
 */
public class ChristmasEveDiscount implements DiscountStrategy {

    /**
     * Retrieves the discount amount for a product at the specified index.
     * The discount amount is given as a percentage.
     *
     * @param product The product for which to retrieve the discount.
     * @param productIndex The index of the product in the shopping cart.
     * @return The discount percentage as a double value. Returns 0.20 if the product index is 0, 0.15 otherwise.
     */
    @Override
    public double getDiscount(Product product, int productIndex) {
        return productIndex == 0 ? .20 : .15;
    }
}
