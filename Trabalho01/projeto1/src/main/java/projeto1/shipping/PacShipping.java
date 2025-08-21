package main.java.projeto1.shipping;

public class PacShipping implements ShippingMethod {
    @Override
    public double calculateShippingCost(double totalWeight) {
        if (totalWeight <= 1) {
            return 10.00;
        } else if (totalWeight <= 2) {
            return 15.00;
        } else {
            throw new IllegalArgumentException(
                "PAC não aceita encomendas acima de 2 kg. Peso: " + totalWeight + " kg");
        }
    }

}
