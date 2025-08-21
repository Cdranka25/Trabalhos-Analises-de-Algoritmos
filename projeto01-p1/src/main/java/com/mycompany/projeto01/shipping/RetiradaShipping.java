package com.mycompany.projeto01.shipping;

public class RetiradaShipping implements ShippingMethod {
    @Override
    public double calculateShippingCost(double totalWeight) {
        return 0;
    }

}
