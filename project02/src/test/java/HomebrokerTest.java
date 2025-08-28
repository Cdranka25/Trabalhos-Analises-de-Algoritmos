
import com.mycompany.project02.*;
import com.mycompany.project02.OrderType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StockMarketFake extends StockMarket {
    public Order lastAddedOrder;
    public String lastRequestedStockCode;

    public StockMarketFake() {
    }

    @Override
    public void addOrder(Order order) {
        this.lastAddedOrder = order;
    }

    @Override
    public Double getStockPrice(String stockCode) {
        this.lastRequestedStockCode = stockCode;
        return 150.75; 
    }
}

class NotificationServiceFake extends NotificationService {
    public Investor lastSubscribedInvestor;
    public Stock lastSubscribedStock;

    public NotificationServiceFake() {

    }

    @Override
    public void subscribeInvestor(Investor investor, Stock stock) {
        this.lastSubscribedInvestor = investor;
        this.lastSubscribedStock = stock;
    }
}

public class HomebrokerTest {

    private Homebroker homebroker;
    private StockMarketFake stockMarketFake;
    private NotificationServiceFake notificationServiceFake;

    @BeforeEach
    public void setUp() {
        stockMarketFake = new StockMarketFake();
        notificationServiceFake = new NotificationServiceFake();
        homebroker = new Homebroker(notificationServiceFake, stockMarketFake);
    }

    @Test
    public void should_register_order_and_verify_it_was_added() {
        Stock stock = new Stock("XYZ", "XYZ Corp", 10.0);
        Investor investor = new Investor();
        Order order = new Order(OrderType.BUY, 10.0, stock, investor);
        
        homebroker.registerOrder(order);

        assertEquals(order, stockMarketFake.lastAddedOrder, "A ordem deve ser registrada na bolsa de valores.");
    }

    @Test
    public void should_return_formatted_price_string() {
        String stockCode = "AAPL";
        String result = homebroker.getStockPrice(stockCode);

        assertEquals("AAPL: 150.75", result);
        assertEquals(stockCode, stockMarketFake.lastRequestedStockCode);
    }
}