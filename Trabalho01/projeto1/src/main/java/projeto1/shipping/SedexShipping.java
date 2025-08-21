package main.java.projeto1.shipping;

public class SedexShipping implements ShippingMethod {
    @Override
    public double calculateShippingCost(double totalWeight) {
        if (totalWeight <= 0.5) {
            return 12.50;
        } else if (totalWeight <= 1) {
            return 20.00;
        } else {
            return 46.50 + (1.50 * Math.ceil((totalWeight - 1) * 10));
        }
    }

}
