package christmas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    @Test
    public void testOrderCreation() {
        Order order = new Order("양송이수프", 2, 7);
        assertEquals("양송이수프", order.getMenuName());
        assertEquals(2, order.getQuantity());
        assertEquals(MenuType.APPETIZER, order.getMenuType());
    }

    @Test
    public void testTotalAmount() {
        Order order = new Order("양송이수프", 2, 7);
        assertEquals(12000, order.getTotalAmount());
    }
}
