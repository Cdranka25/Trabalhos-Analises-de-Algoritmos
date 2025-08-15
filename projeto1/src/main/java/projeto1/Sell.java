package projeto1;

public class Sell {
    public double calculateTotal(Product product, ShippingType shippingType) {
      double shippingCost = calculateShipping(product, shippingType);
      return product.price + shippingCost;
    }

    private double calculateShipping(Product product, ShippingType shippingType) {
        switch (shippingType) {
            case PAC:
                if (product.weight <= 1) {
                    return 10.00;
                } else if (product.weight <= 2) {
                    return 15.00;
                } else {
                    System.out.println("PAC não aceita encomendas acima de 2 kg.");
                }
                break;

            case SEDEX:
                if (product.weight <= 0.5) {
                    return 12.50;
                } else if (product.weight <= 1) {
                    return 20.00;
                } else {
                    return 46.50 + (1.50 * Math.ceil((product.weight - 1) * 10));
                }
                break;

            case RETIRADA:
                return 0;

            default:
                System.out.println("Tipo de entrega inválido.");
        }

        return 0;
    }
}