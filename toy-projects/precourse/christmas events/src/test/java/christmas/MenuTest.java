package christmas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    @Test
    public void testMenuCreation() {
        Menu menu = new Menu("양송이수프", 6000, MenuType.APPETIZER);
        assertEquals("양송이수프", menu.getName());
        assertEquals(6000, menu.getPrice());
        assertEquals(MenuType.APPETIZER, menu.getType());
    }

    @Test
    public void testGetTypeByName() {
        assertEquals(MenuType.APPETIZER, Menu.getTypeByName("양송이수프"));
        assertEquals(MenuType.MAIN, Menu.getTypeByName("티본스테이크"));
        assertEquals(MenuType.BEVERAGE, Menu.getTypeByName("레드와인"));
    }

    @Test
    public void testGetTypeByNameWithInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> Menu.getTypeByName("Invalid Menu Name"));
    }
}
