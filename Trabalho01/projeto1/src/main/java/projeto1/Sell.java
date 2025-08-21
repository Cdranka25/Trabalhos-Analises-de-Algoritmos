package projeto1;

import main.java.projeto1.shipping.ShippingMethod;

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