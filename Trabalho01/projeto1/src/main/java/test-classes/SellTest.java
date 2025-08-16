
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import projeto1.Order;
import projeto1.Product;
import projeto1.Sell;
import projeto1.ShippingType;

public class SellTest {

    private Sell sell;
    private Order order01;
    private Order order02;
    private Order order03;
    private Order order04;
    private Order order05;
    private Order order06;
    private Order order07;

    @Before
    public void setUp() {
        sell = new Sell();
        order01 = new Order(1);
        order02 = new Order(2);
        order03 = new Order(3);
        order04 = new Order(4);
        order05 = new Order(5);
        order06 = new Order(6);
        order07 = new Order(7);
    }

    @Test
    public void test01_alculate_PAC() {

        order01.addProduct(new Product("Controle", 0.5, 80.0));
        assertEquals(90.0, sell.calculateTotal(order01, ShippingType.PAC), 0.001);

        order02.addProduct(new Product("Box de Livros", 1.8, 200.0));
        assertEquals(215.0, sell.calculateTotal(order02, ShippingType.PAC), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test02_Calculate_PAC_naoSuportado() {

        order03.addProduct(new Product("Notebook", 3.0, 3000.0));
        assertEquals(3000.0, sell.calculateTotal(order03, ShippingType.PAC), 0.001);
    }

    @Test
    public void test03_Calculate_SEDEX() {
        order04.addProduct(new Product("livro", 0.450, 20.0));
        order05.addProduct(new Product("celular", 0.8, 2000.0));
        order06.addProduct(new Product("box livros colecionavel", 2.0, 300.0));

        sell.calculateTotal(order04, ShippingType.SEDEX);
        sell.calculateTotal(order05, ShippingType.SEDEX);
        sell.calculateTotal(order06, ShippingType.SEDEX);
    }

    @Test
    public void test04_Calculate_RETIRADA() {
        order07.addProduct(new Product("Marcadores", 0.1, 5.0));
        assertEquals(5.0, sell.calculateTotal(order07, ShippingType.RETIRADA), 0.001);
    }
}