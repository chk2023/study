package christmas;

import java.util.*;

public class Application {
    public static final int GIFT_THRESHOLD = 120000;
    private static final int MINIMUM_DAY = 1;
    private static final int MAXIMUM_DAY = 31;
    private static final int MAXIMUM_MENU_ORDER = 20;
    private static final int CHRISTMAS_DISCOUNT_START = 1000;
    private static final int CHRISTMAS_DISCOUNT_INCREMENT = 100;
    private static final int WEEKDAY_DISCOUNT = 2023;
    private static final int SPECIAL_DISCOUNT = 1000;
    static final int GIFT_PRICE = 25000;
    private static final List<Integer> STAR_DAYS = Arrays.asList(3, 10, 17, 24, 25, 31);

    public static void main(String[] args) {

        //사용자 입력 처리 및 검증
        InputView inputView = new InputView();
        int visitDay;
        String order;

        while (true) {
            try {
                String visitDayInput = inputView.readDate();
                visitDay = validateDay(visitDayInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        List<Order> orders = new ArrayList<>();
        while (true) {
            try {
                order = inputView.readOrder();
                orders = createOrders(order, visitDay);
                validateOrder(order);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        //<주문 메뉴>
        OutputView.printOrders(orders);

        //<할인 전 총 금액>
        int totalAmount = calculateTotalAmount(orders);
        OutputView.printTotalAmount(totalAmount);

        //<증정 메뉴>
        OutputView.printGift(totalAmount);

        //<혜택 내역>
        OutputView.printDiscounts(orders, visitDay, totalAmount);

        //<총 혜택 금액>
        int totalDiscount = calculateTotalDiscount(orders, visitDay, totalAmount);
        OutputView.printTotalDiscount(totalDiscount);

        //<할인 후 예상 결제 금액>
        int finalAmount = calculateFinalAmount(totalAmount, totalDiscount);
        OutputView.printFinalAmount(finalAmount);

        //<12월 이벤트 배지>
        String eventBadge = calculateEventBadge(totalAmount);
        OutputView.printEventBadge(eventBadge);
    }

    static int validateDay(String dayInput) {
        int day;
        try {
            day = Integer.parseInt(dayInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        if (day < MINIMUM_DAY || day > MAXIMUM_DAY) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return day;
    }

    private static void validateOrder(String order) {
        List<Menu> menuList = Menu.menuList;
        Map<String, Integer> menuPrices = new HashMap<>();
        Set<String> orderedMenus = new HashSet<>();

        for (Menu menu : menuList) {
            menuPrices.put(menu.getName(), menu.getPrice());
        }

        String[] orders = order.split(",");
        if (orders.length > MAXIMUM_MENU_ORDER) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        for (String singleOrder : orders) {
            String[] splitOrder = singleOrder.split("-");
            if (splitOrder.length != 2) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            String menu = splitOrder[0];
            if (!menuPrices.containsKey(menu)) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            if (orderedMenus.contains(menu)) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            orderedMenus.add(menu);

            int quantity;
            try {
                quantity = Integer.parseInt(splitOrder[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            if (quantity < 1) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private static List<Order> createOrders(String orderInput, int visitDay) {
        List<Order> orders = new ArrayList<>();
        String[] orderItems = orderInput.split(",");

        for (String item : orderItems) {
            String[] splitItem = item.split("-");
            if (splitItem.length != 2) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            String menu = splitItem[0].trim();
            int quantity;
            try {
                quantity = Integer.parseInt(splitItem[1].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            orders.add(new Order(menu, quantity, visitDay));
        }

        if (orders.stream().allMatch(order -> order.getMenuType() == MenuType.BEVERAGE)) {
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        return orders;
    }


    static int calculateTotalAmount(List<Order> orders) {
        int totalAmount = 0;
        for (Order order : orders) {
            totalAmount += order.getTotalAmount();
        }
        return totalAmount;
    }

    static int calculateChristmasDiscount(int visitDay) {
        if (visitDay < 1 || visitDay > 25) {
            return 0;
        }
        return CHRISTMAS_DISCOUNT_START + CHRISTMAS_DISCOUNT_INCREMENT * (visitDay - 1);
    }

    static int calculateWeekdayDiscount(List<Order> orders, int visitDay) {
        long count = 0;
        if (visitDay % 7 < 5) { // 일요일부터 목요일까지
            count = orders.stream().filter(order -> order.getMenuType() != null && order.getMenuType().equals(MenuType.DESSERT)).count();
        } else { // 금요일과 토요일
            count = orders.stream().filter(order -> order.getMenuType() != null && order.getMenuType().equals(MenuType.MAIN)).count();
        }
        return (int) count * WEEKDAY_DISCOUNT;
    }

    static int calculateWeekendDiscount(List<Order> orders, int visitDay) {
        if (visitDay % 7 >= 5) { // 금요일과 토요일
            long mainMenuCount = orders.stream().filter(order -> order.getMenuType() != null && order.getMenuType().equals(MenuType.MAIN)).count();
            return (int) mainMenuCount * 2023;
        } else {
            return 0;
        }
    }

    static int calculateSpecialDiscount(int visitDay) {
        if (isStarDay(visitDay)) { // 이벤트 달력에 별이 있는 날
            return SPECIAL_DISCOUNT;
        }
        return 0;
    }

    private static boolean isStarDay(int visitDay) {
        return STAR_DAYS.contains(visitDay);
    }

    static int calculateTotalDiscount(List<Order> orders, int visitDay, int totalAmount) {
        int christmasDiscount = calculateChristmasDiscount(visitDay);
        int weekdayDiscount = calculateWeekdayDiscount(orders, visitDay);
        int weekendDiscount = calculateWeekendDiscount(orders, visitDay);
        int specialDiscount = calculateSpecialDiscount(visitDay);
        int giftDiscount = 0;
        if (totalAmount >= GIFT_THRESHOLD) {
            giftDiscount = GIFT_PRICE;
        }
        return christmasDiscount + weekdayDiscount + weekendDiscount + specialDiscount + giftDiscount;
    }

    static int calculateFinalAmount(int totalAmount, int totalDiscount) {
        return totalAmount - totalDiscount;
    }

    static String calculateEventBadge(int totalAmount) {
        if (totalAmount >= 20000) {
            return "산타";
        } else if (totalAmount >= 10000) {
            return "트리";
        } else if (totalAmount >= 5000) {
            return "별";
        } else {
            return "없음";
        }
    }

}

