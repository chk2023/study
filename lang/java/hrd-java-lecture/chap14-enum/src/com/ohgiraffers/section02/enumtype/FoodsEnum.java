package com.ohgiraffers.section02.enumtype;

public enum FoodsEnum {
    /* 작성 순서대로 0부터 값이 자동으로 부여 된다. */
    MEAL_AN_BUTTER_KIMCHI_STEW(0),
    MEAL_MINT_SEAWEED_SOUP(1),
    MEAL_BUNGEOPPANG_SUSHI(2),
    DRINK_RADISH_KIMCHI_LATTE(0),
    DRINK_WOOLUCK_SMOOTHIE(1),
    DRINK_RAW_CUTTLEFISH_SHAKE(2);

    private final int value;

    private final int var = 10;

    FoodsEnum(int value) {
        this.value = value;
    }

    public void printVar() {
        System.out.println("print var : " + var);
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

}