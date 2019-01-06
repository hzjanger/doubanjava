package com.hzj.bookshop.bean;

import java.util.Date;

/**
 * 读者的状态, 想读\在读\读过
 */
public class BookCollection {
    /**
     * 书籍主键
     */
    private String ISBN;
    /**
     * 作者主键
     */
    private Integer user_id;
    /**
     * 读者状态, 想读\在读\读过
     */
    private String book_status_type;
    /**
     * 简短附注
     */
    private String short_note;
    /**
     * 评价星级
     */
    private Integer command_gradue;
    /**
     * 评价时间
     */
    private Date command_time;

    /**
     * 收藏书籍的信息
     */
    private Book book;


    public BookCollection() {
    }

    public BookCollection(String ISBN, Integer user_id, String book_status_type, String short_note, Integer command_gradue, Date command_time) {
        this.ISBN = ISBN;
        this.user_id = user_id;
        this.book_status_type = book_status_type;
        this.short_note = short_note;
        this.command_gradue = command_gradue;
        this.command_time = command_time;
        this.book = book;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getBook_status_type() {
        return book_status_type;
    }

    public void setBook_status_type(String book_status_type) {
        this.book_status_type = book_status_type;
    }

    public String getShort_note() {
        return short_note;
    }

    public void setShort_note(String short_note) {
        this.short_note = short_note;
    }

    public Integer getCommand_gradue() {
        return command_gradue;
    }

    public void setCommand_gradue(Integer command_gradue) {
        this.command_gradue = command_gradue;
    }

    public Date getCommand_time() {
        return command_time;
    }

    public void setCommand_time(Date command_time) {
        this.command_time = command_time;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    @Override
    public String toString() {
        return "BookCollection{" +
                "ISBN='" + ISBN + '\'' +
                ", user_id=" + user_id +
                ", book_status_type='" + book_status_type + '\'' +
                ", short_note='" + short_note + '\'' +
                ", command_gradue=" + command_gradue +
                ", command_time=" + command_time +
                ", book=" + book +
                '}';
    }
}
