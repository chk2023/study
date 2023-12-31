package christmas;

import java.util.List;

import static christmas.Application.*;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    static void printOrders(List<Order> orders) {
        System.out.println("\n<주문 메뉴>");
        for (Order order : orders) {
            System.out.println(order.getMenuName() + " " + order.getQuantity() + "개");
        }
    }

    public static void printTotalAmount(int totalAmount) {
        System.out.println("\n<할인 전 총주문 금액>\n" + totalAmount + "원");
    }

    public static void printGift(int totalAmount) {
        String giftMenu = "없음";
        if (totalAmount >= Application.GIFT_THRESHOLD) {
            giftMenu = "샴페인 1개";
        }
        System.out.println("\n<증정 메뉴>\n" + giftMenu);
    }

    static void printDiscounts(List<Order> orders, int visitDay, int totalAmount) {
        // 총 주문 금액이 10,000원 미만인 경우, 이벤트 적용 없음
        if (totalAmount < 10000) {
            System.out.println("<혜택 내역>" + LINE_SEPARATOR + "없음");
            return;
        }

        int christmasDiscount = calculateChristmasDiscount(visitDay);
        int weekdayDiscount = calculateWeekdayDiscount(orders, visitDay);
        int weekendDiscount = calculateWeekendDiscount(orders, visitDay); // 주말 할인 계산
        int specialDiscount = calculateSpecialDiscount(visitDay);
        int giftDiscount = 0;
        if (totalAmount >= GIFT_THRESHOLD) {
            giftDiscount = GIFT_PRICE;
        }

        // 모든 이벤트가 적용되지 않은 경우, "없음" 출력
        if (christmasDiscount == 0 && weekdayDiscount == 0 && weekendDiscount == 0 && specialDiscount == 0 && giftDiscount == 0) {
            System.out.println("\n<혜택 내역>" + LINE_SEPARATOR + "없음");
            return;
        }

        System.out.println("\n<혜택 내역>");
        if (christmasDiscount > 0) {
            System.out.println("크리스마스 디데이 할인: -" + christmasDiscount + "원");
        }
        if (weekdayDiscount > 0) {
            System.out.println("평일 할인: -" + weekdayDiscount + "원");
        }
        if (weekendDiscount > 0) {
            System.out.println("주말 할인: -" + weekendDiscount + "원"); // 주말 할인 출력 추가
        }
        if (specialDiscount > 0) {
            System.out.println("특별 할인: -" + specialDiscount + "원");
        }
        if (giftDiscount > 0) {
            System.out.println("증정 이벤트: -" + giftDiscount + "원");
        }
    }

    public static void printTotalDiscount(int totalDiscount) {
        System.out.println("\n<총혜택 금액>\n" + totalDiscount + "원");
    }

    public static void printFinalAmount(int finalAmount) {
        System.out.println("\n<할인 후 예상 결제 금액>\n" + finalAmount + "원");
    }

    public static void printEventBadge(String eventBadge) {
        System.out.println("\n<12월 이벤트 배지>\n" + eventBadge);
    }
}
