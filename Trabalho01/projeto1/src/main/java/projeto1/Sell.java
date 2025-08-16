package projeto1;

public class Sell {

    public double calculateTotal(Order order, ShippingType shippingType) {
        double shippingCost = calculateShipping(order, shippingType);
        return order.totalPrice() + shippingCost;
    }

    private double calculateShipping(Order order, ShippingType shippingType) {
        double totalWeight = order.totalWeight();

        switch (shippingType) {
            case PAC:
                if (totalWeight <= 1) {
                    return 10.00;
                } else if (totalWeight <= 2) {
                    return 15.00;
                } else {
                   throw new IllegalArgumentException(
                    "PAC não aceita encomendas acima de 2 kg. Peso: " + totalWeight + " kg");
                }

            case SEDEX:
                if (totalWeight <= 0.5) {
                    return 12.50;
                } else if (totalWeight <= 1) {
                    return 20.00;
                } else {
                    return 46.50 + (1.50 * Math.ceil((totalWeight - 1) * 10));
                }
            case RETIRADA:
                return 0;

            default:
                System.out.println("Tipo de entrega inválido.");
        }

        return 0;
    }
}