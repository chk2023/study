package christmas;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private MenuType menuType;
    private String menuName;
    private int quantity;

    private static final Map<String, Integer> MENU_PRICE = new HashMap<String, Integer>() {{
        put("양송이수프", 6000);
        put("타파스", 5500);
        put("시저샐러드", 8000);
        put("티본스테이크", 55000);
        put("바비큐립", 54000);
        put("해산물파스타", 35000);
        put("크리스마스파스타", 25000);
        put("초코케이크", 15000);
        put("아이스크림", 5000);
        put("제로콜라", 3000);
        put("레드와인", 60000);
        put("샴페인", 25000);
    }};

    public Order(String menuName, int quantity, int day) {
        this.menuName = menuName;
        this.quantity = quantity;
        this.menuType = Menu.getTypeByName(menuName);
    }


    public int getQuantity() {
        return quantity;
    }

    public int getTotalAmount() {
        return quantity * MENU_PRICE.get(menuName);
    }

    public String getMenuName() {
        return menuName;
    }

    public MenuType getMenuType() {
        return menuType;
    }


}

