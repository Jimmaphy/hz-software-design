package com.hz;

import products.Product;

public class Customer {

    private CustomerType customerType;

    public String getName() {
        return name;
    }

    private String name;

    public ShoppingCart getCart() {
        return cart;
    }

    private ShoppingCart cart;

    public Customer(CustomerType customerType, String name) {
        this.customerType = customerType;
        this.name = name;

        this.cart = new ShoppingCart();
    }

    public void buys(Product product) {
        this.cart.add(product);
    }

    public boolean isRegular() {

        return this.customerType == CustomerType.Regular;
    }
}