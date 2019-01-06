package com.hzj.bookshop.bean;

import java.util.List;

/**
 * 书籍实体类
 */

public class Book {
    /**
     * 书名
     */
    private String book_name;
    /**
     * 书籍图片路径
     */
    private String book_img;
    /**
     * 主键, 唯一标识
     */
    private String ISBN;
    /**
     * 书籍内容简介
     */
    private String book_introduction;
    /**
     * 作者简介
     */
    private String author_introduction;
    /**
     * 书籍目录
     */
    private String book_direction;
    /**
     * 书籍作者
     */
    private String book_author;
    /**
     * 书籍出版社
     */
    private String book_press;
    /**
     * 书籍装帧类型
     */
    private String book_binding;
    /**
     * 书籍译者
     */
    private String book_translator;
    /**
     * 出版年
     */
    private String publisher_time;
    /**
     * 书籍总页数
     */
    private Integer book_page;
    /**
     * 书籍价格
     */
    private Double book_prices;

    /**
     * 书籍评价等级
     */
    private Integer grade;

    /**
     * 一本书对应多个标签
     */
    private List<BookTag> bookTagList;

    public Book() {
    }

    public Book(String book_name, String book_img, String ISBN, String book_introduction, String author_introduction, String book_direction, String book_author, String book_press, String book_binding, String book_translator, String publisher_time, Integer book_page, Double book_prices) {
        this.book_name = book_name;
        this.book_img = book_img;
        this.ISBN = ISBN;
        this.book_introduction = book_introduction;
        this.author_introduction = author_introduction;
        this.book_direction = book_direction;
        this.book_author = book_author;
        this.book_press = book_press;
        this.book_binding = book_binding;
        this.book_translator = book_translator;
        this.publisher_time = publisher_time;
        this.book_page = book_page;
        this.book_prices = book_prices;
    }

    public Book(String book_name, String book_img, String ISBN, String book_introduction, String author_introduction, String book_direction, String book_author, String book_press, String book_binding, String book_translator, String publisher_time, Integer book_page, Double book_prices, List<BookTag> bookTagList) {
        this.book_name = book_name;
        this.book_img = book_img;
        this.ISBN = ISBN;
        this.book_introduction = book_introduction;
        this.author_introduction = author_introduction;
        this.book_direction = book_direction;
        this.book_author = book_author;
        this.book_press = book_press;
        this.book_binding = book_binding;
        this.book_translator = book_translator;
        this.publisher_time = publisher_time;
        this.book_page = book_page;
        this.book_prices = book_prices;
        this.bookTagList = bookTagList;
    }

    public Book(String book_name, String book_img, String ISBN, String book_introduction, String author_introduction, String book_direction, String book_author, String book_press, String book_binding, String book_translator, String publisher_time, Integer book_page, Double book_prices, Integer grade) {
        this.book_name = book_name;
        this.book_img = book_img;
        this.ISBN = ISBN;
        this.book_introduction = book_introduction;
        this.author_introduction = author_introduction;
        this.book_direction = book_direction;
        this.book_author = book_author;
        this.book_press = book_press;
        this.book_binding = book_binding;
        this.book_translator = book_translator;
        this.publisher_time = publisher_time;
        this.book_page = book_page;
        this.book_prices = book_prices;
        this.grade = grade;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_img() {
        return book_img;
    }

    public void setBook_img(String book_img) {
        this.book_img = book_img;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBook_introduction() {
        return book_introduction;
    }

    public void setBook_introduction(String book_introduction) {
        this.book_introduction = book_introduction;
    }

    public String getAuthor_introduction() {
        return author_introduction;
    }

    public void setAuthor_introduction(String author_introduction) {
        this.author_introduction = author_introduction;
    }

    public String getBook_direction() {
        return book_direction;
    }

    public void setBook_direction(String book_direction) {
        this.book_direction = book_direction;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_press() {
        return book_press;
    }

    public void setBook_press(String book_press) {
        this.book_press = book_press;
    }

    public String getBook_binding() {
        return book_binding;
    }

    public void setBook_binding(String book_binding) {
        this.book_binding = book_binding;
    }

    public String getBook_translator() {
        return book_translator;
    }

    public void setBook_translator(String book_translator) {
        this.book_translator = book_translator;
    }

    public String getPublisher_time() {
        return publisher_time;
    }

    public void setPublisher_time(String publisher_time) {
        this.publisher_time = publisher_time;
    }

    public Integer getBook_page() {
        return book_page;
    }

    public void setBook_page(Integer book_page) {
        this.book_page = book_page;
    }

    public Double getBook_prices() {
        return book_prices;
    }

    public void setBook_prices(Double book_prices) {
        this.book_prices = book_prices;
    }

    public List<BookTag> getBookTagList() {
        return bookTagList;
    }

    public void setBookTagList(List<BookTag> bookTagList) {
        this.bookTagList = bookTagList;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_name='" + book_name + '\'' +
                ", book_img='" + book_img + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", book_introduction='" + book_introduction + '\'' +
                ", author_introduction='" + author_introduction + '\'' +
                ", book_direction='" + book_direction + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_press='" + book_press + '\'' +
                ", book_binding='" + book_binding + '\'' +
                ", book_translator='" + book_translator + '\'' +
                ", publisher_time=" + publisher_time +
                ", book_page=" + book_page +
                ", book_prices=" + book_prices +
                ", bookTagList=" + bookTagList +
                '}';
    }
}
