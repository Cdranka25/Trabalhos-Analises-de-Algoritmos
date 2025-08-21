package com.mycompany.projeto01;

import com.mycompany.projeto01.Order;


public class Sell {
    public double calculateTotal(Order order) {
        double shippingCost = calculateShipping(order);
        return order.totalPrice() + shippingCost;
    }

    private double calculateShipping(Order order) {
        double totalWeight = order.totalWeight();
        return order.shippingMethod.calculateShippingCost(totalWeight);
    }
}