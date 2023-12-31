package christmas;

import java.util.Arrays;
import java.util.List;

public class Menu {
    public static List<Menu> menuList = Arrays.asList(new Menu("양송이수프", 6000, MenuType.APPETIZER), new Menu("타파스", 5500, MenuType.APPETIZER), new Menu("시저샐러드", 8000, MenuType.APPETIZER), new Menu("티본스테이크", 55000, MenuType.MAIN), new Menu("바비큐립", 54000, MenuType.MAIN), new Menu("해산물파스타", 35000, MenuType.MAIN), new Menu("크리스마스파스타", 25000, MenuType.MAIN), new Menu("초코케이크", 15000, MenuType.DESSERT), new Menu("아이스크림", 5000, MenuType.DESSERT), new Menu("제로콜라", 3000, MenuType.BEVERAGE), new Menu("레드와인", 60000, MenuType.BEVERAGE), new Menu("샴페인", 25000, MenuType.BEVERAGE));

    private String name;
    private int price;
    private MenuType type;

    public Menu(String name, int price, MenuType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public MenuType getType() {
        return this.type;
    }

    public static MenuType getTypeByName(String name) {
        return menuList.stream().filter(menu -> menu.getName().equals(name)).findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 메뉴를 찾을 수 없습니다.")).getType();
    }
}
