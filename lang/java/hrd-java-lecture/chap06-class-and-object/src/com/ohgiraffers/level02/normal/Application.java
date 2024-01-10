package com.ohgiraffers.level02.normal;

public class Application {
    public static void main(String[] args) {
        BookDTO book = new BookDTO();
        System.out.println(book.printInformation());

        BookDTO book2 = new BookDTO("자바의 바이블", "교보문고", "조형기");
        System.out.println(book2.printInformation());

        BookDTO book3 = new BookDTO("홍길동전", "활빈당", "허균", 50000, 0.5);
        System.out.println(book3.printInformation());
        //System.out.println(book3.printInfo());
    }
}
