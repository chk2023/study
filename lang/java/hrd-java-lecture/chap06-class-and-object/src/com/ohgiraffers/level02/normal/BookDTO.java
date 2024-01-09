package com.ohgiraffers.level02.normal;

public class BookDTO {
    /* 필드 선언부 */
    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;

    /* 생성자 선언부 */
    public BookDTO() {}

    public BookDTO(String title, String publisher, String author) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }

    public BookDTO(String title, String publisher, String author, int price, double discountRate) {
        this(title, publisher, author);
        this.price = price;
        this.discountRate = discountRate;
    }

    /* 게터와 세터 */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    /* 모든 필드에 대한 내용을 출력한다. */
    public String printInformation() {
        return "[" + this.title + ", " + this.publisher + ", " + this.author + ", " + this.price + ", " + this.discountRate + "]";
    }
}
