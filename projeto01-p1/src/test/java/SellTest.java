import com.mycompany.projeto01.Product;
import com.mycompany.projeto01.*;
import com.mycompany.projeto01.shipping.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SellTest {

    private Sell sell;

    @Test
    public void should_return_correct_value_when_PAC() {
        sell = new Sell();
        Order order = new Order(new PacShipping());

        order.addProduct(new Product("Controle", 0.5, 80.0));
        assertEquals(90.0, sell.calculateTotal(order), 0.001);
    }

    @Test
    public void should_return_error_when_PAC_more_than_2kg() {
        sell = new Sell();
        Order order = new Order(new PacShipping());

        order.addProduct(new Product("Notebook", 3.0, 3000.0));
        assertThrows(IllegalArgumentException.class, () -> sell.calculateTotal(order));
    }
 
    @Test
    public void should_return_correct_value_when_SEDEX_and_weight_less_500g() {
        sell = new Sell();
        Order order = new Order(new PacShipping());

        order.addProduct(new Product("livro", 0.450, 20.0));

        sell.calculateTotal(order);
    }

    @Test
    public void should_return_correct_value_when_SEDEX_and_weight_between_500g_and_1000g() {
        sell = new Sell();
        Order order = new Order(new PacShipping());

        order.addProduct(new Product("celular", 0.8, 2000.0));

        sell.calculateTotal(order);
    }

    @Test
    public void should_return_correct_value_when_SEDEX_and_weight_greater_then_1000g() {
        sell = new Sell();
        Order order = new Order(new PacShipping());

        order.addProduct(new Product("box livros colecionavel", 2.0, 300.0));

        sell.calculateTotal(order);
    }

    @Test
    public void should_return_0_when_RETIRADA() {
        sell = new Sell();
        Order order = new Order(new RetiradaShipping());

        order.addProduct(new Product("Marcadores", 0.1, 5.0));
        assertEquals(5.0, sell.calculateTotal(order), 0.001);
    }
}