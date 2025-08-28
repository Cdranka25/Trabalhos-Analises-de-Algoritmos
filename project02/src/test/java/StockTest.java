

import com.mycompany.project02.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StockTest {

    @Test
    public void should_create_stock_with_correct_properties() {
        Stock stock = new Stock("PETR4", "Petrobras", 35.0);
        assertEquals("PETR4", stock.code, "O código da ação deve ser 'PETR4'.");
        assertEquals("Petrobras", stock.name, "O nome da ação deve ser 'Petrobras'.");
        assertEquals(35.0, stock.currentPrice, 0.001, "O preço da ação deve ser 35.0.");
    }

    @Test
    public void should_update_price_correctly() {
        Stock stock = new Stock("VALE3", "Vale", 60.0);
        stock.currentPrice = 61.50;
        assertEquals(61.50, stock.currentPrice, 0.001, "O preço da ação deve ser atualizado.");
    }
}