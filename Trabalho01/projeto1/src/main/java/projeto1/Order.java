package projeto1;

import java.util.ArrayList;
import java.util.List;

import main.java.projeto1.shipping.ShippingMethod;

public class Order {
    private List<Product> products;
    public ShippingMethod shippingMethod;

    public Order(ShippingMethod shippingMethod) {
        this.products = new ArrayList<>();
        this.shippingMethod = shippingMethod;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product prodcut) {
        products.add(prodcut);
    }

    public double totalPrice() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }

    public double totalWeight() {
        double total = 0;
        for (Product p : products) {
            total += p.weight;
        }
        return total;
    }

    public void listProducts() {
        System.out.println("Pedido #" + id);
        for (Product p : products) {
            System.out.println(p.name + " - " + p.weight + "kg - R$ " + p.price);
        }
        System.out.println("Total: R$ " + totalPrice());
    }
}
