import com.mycompany.project02.Order;
import com.mycompany.project02.Stock;
import com.mycompany.project02.Investor;
import com.mycompany.project02.OrderType;
import com.mycompany.project02.StockMarket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StockMarketTest {

    private StockMarket stockMarket;
    private Stock bbas3;

    @BeforeEach
    public void setUp() {
        stockMarket = new StockMarket();
        bbas3 = new Stock("BBAS3", "Banco do Brasil", 23.50);
        stockMarket.addStock(bbas3);
    }

    @Test
    public void should_match_buy_and_sell_orders_and_update_price() {
        Investor investorJoaquim = new Investor();
        investorJoaquim.name = "Joaquim";
        
        Investor investorMariana = new Investor();
        investorMariana.name = "Mariana";
        
        Order buyOrder = new Order(OrderType.BUY, 24.0, bbas3, investorJoaquim);
        Order sellOrder = new Order(OrderType.SELL, 24.0, bbas3, investorMariana);

        stockMarket.addOrder(buyOrder);
        stockMarket.addOrder(sellOrder);

        assertEquals(24.0, bbas3.currentPrice, 0.001, "O valor da ação deve ser atualizado após o match.");
    }

    @Test
    public void should_not_match_orders_with_different_values() {
        Investor investorPedro = new Investor();
        investorPedro.name = "Pedro";
        
        Investor investorAna = new Investor();
        investorAna.name = "Ana";
        
        Order buyOrder = new Order(OrderType.BUY, 23.0, bbas3, investorPedro);
        Order sellOrder = new Order(OrderType.SELL, 24.0, bbas3, investorAna);

        stockMarket.addOrder(buyOrder);
        stockMarket.addOrder(sellOrder);

        assertEquals(23.50, bbas3.currentPrice, 0.001, "O valor da ação não deve ser alterado se não houver match.");
    }
}