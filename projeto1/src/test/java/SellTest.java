import main.java.projeto1.Product;
import main.java.projeto1.Sell;
import main.java.projeto1.ShippingType;


public class SellTest {
    public void main() {}

    @Test
    public void testCalculateTotal() {
        Product product1 = new Product("Book", 0.8, 50.0);
        Product product2 = new Product("Laptop", 1.5, 1500.0);
        Product product3 = new Product("TV", 3.0, 2000.0);

        Sell sell = new Sell();

        // Test PAC shipping
        assertEquals(60.0, sell.calculateTotal(product1, ShippingType.PAC));
        assertEquals(1515.0, sell.calculateTotal(product2, ShippingType.PAC));
        assertEquals(2000.0, sell.calculateTotal(product3, ShippingType.PAC));

        // Test SEDEX shipping
        assertEquals(62.5, sell.calculateTotal(product1, ShippingType.SEDEX));
        assertEquals(1520.0, sell.calculateTotal(product2, ShippingType.SEDEX));
        assertEquals(2050.0, sell.calculateTotal(product3, ShippingType.SEDEX));

        // Test RETIRADA shipping
        assertEquals(50.0, sell.calculateTotal(product1, ShippingType.RETIRADA));
        assertEquals(1500.0, sell.calculateTotal(product2, ShippingType.RETIRADA));
        assertEquals(2000.0, sell.calculateTotal(product3, ShippingType.RETIRADA));
    }
}