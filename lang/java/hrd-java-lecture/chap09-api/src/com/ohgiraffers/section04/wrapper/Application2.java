package com.ohgiraffers.section04.wrapper;

public class Application2 {
    public static void main(String[] args) {
        /* parsing : 문자열 값을 기본 자료형 값으로 변경하는 것을 parsing 이라고 한다. */

        /* 해당 자료형으로 parsing 될 수 없는 문자열이 제공되면 Exception 발생한다. */
        byte b = Byte.parseByte("1");
        short s = Short.parseShort("2");
        int i = Integer.parseInt("4");
        long l = Long.parseLong("8");
        float f = Float.parseFloat("4.0");
        double d = Double.parseDouble("8.0");
        boolean bl = Boolean.parseBoolean("true");
        /* Character는 parsing 기능을 제공하지 않는다. */
        char c = "abc".charAt(0);

    }
}
