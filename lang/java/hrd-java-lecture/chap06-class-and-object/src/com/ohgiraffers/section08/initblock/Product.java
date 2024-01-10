package com.ohgiraffers.section08.initblock;

public class Product {

    /* 1. 필드를 초기화 하지 않으면 JVM이 지정한 기본 값으로 초기화 되며 객체가 생성 된다. */
//    private String name;
//    private int price;
//    private static String brand;

    /* 2. 명시적 초기화 */
    private String name = "갤럭시";
    private int price = 1000000;
    private static String brand = "삼송";

    /* 3. 초기화 블럭 */
    /* 인스턴스 초기화 블럭 */
    {
        name = "사이언";
        price = 800000;
        /* static 초기화 블럭에서 이미 "헬지"로 초기화 되어 있지만
        * 인스턴스 생성 시 다시 인스턴스 초기화 블럭이 동작하며 "사과"로 값이 변경 된다. */
        brand = "사과";

        System.out.println("인스턴스 초기화 블럭 동작함...");
    }


    /* static 초기화 블럭 */
    static {
        brand = "헬지";

        /* static 초기화 블럭에서는 non-static 필드를 초기화 할 수 없다.
        * 정적 초기화 블럭 동작 시에는 인스턴스가 존재하지 않기 때문이다. */
//        name = "아이뽕";
//        price = 1500000;

        System.out.println("static 초기화 블럭 동작함...");
    }

    public static void setBrand(String brand) {
        Product.brand = brand;
    }

    public Product() {
        System.out.println("기본 생성자 동작함...");
    }

    public Product(String name, int price, String brand) {
        this.name = name;
        this.price = price;
        Product.brand = brand;
        System.out.println("매개변수 생성자 동작함...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static String getBrand() {
        return brand;
    }

    public String getInformation() {
        return "Product[name=" + this.name + ", price = " + this.price + ", brand = " + Product.brand + "]";
    }
}
