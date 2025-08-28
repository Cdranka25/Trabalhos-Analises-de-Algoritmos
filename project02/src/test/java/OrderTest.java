

import com.mycompany.project02.*;
import com.mycompany.project02.OrderType;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void should_create_order_with_correct_properties() {
        Stock stock = new Stock("ITUB4", "Itaú Unibanco", 30.0);
        Investor investor = new Investor();
        investor.name = "Joaquim";
        
        Order order = new Order(OrderType.BUY, 30.50, stock, investor);

        assertEquals(OrderType.BUY, order.orderType, "O tipo da ordem deve ser BUY.");
        assertEquals(30.50, order.price, 0.001, "O preço da ordem deve ser 30.50.");
        assertEquals(stock, order.stock, "A ação da ordem deve ser a mesma instanciada.");
        assertEquals(investor, order.investor, "O investidor da ordem deve ser o mesmo instanciado.");
    }
}