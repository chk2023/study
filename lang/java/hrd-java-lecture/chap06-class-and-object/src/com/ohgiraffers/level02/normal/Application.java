package com.ohgiraffers.level02.normal;

public class Application {
    public static void main(String[] args) {
        BookDTO book = new BookDTO();
        System.out.println(book.getTitle() + ", " + book.getAuthor() + ", " + book.getPublisher()
                + ", " + book.getPrice() + ", " + book.getDiscountRate());
        System.out.println("");

        BookDTO book2 = new BookDTO("자바의 바이블", "교보문고", "조형기");
        System.out.println(book2.getTitle() + ", " + book.getAuthor() + ", " + book.getPublisher());
        System.out.println("");

        BookDTO book3 =
    }
}
