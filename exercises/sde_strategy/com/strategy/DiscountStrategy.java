package com.strategy;

import products.Product;

/**
 * The DiscountStrategy interface represents a strategy for applying discounts to products.
 */
public interface DiscountStrategy {

    /**
     * Retrieves the discount amount for a product at the specified index.
     * The discount amount is given as a percentage.
     *
     * @param product The product for which to retrieve the discount.
     * @param productIndex The index of the product in the shopping cart.
     * @return The discount percentage as a double value.
     */
    double getDiscount(Product product, int productIndex);
}
