package com.hzj.bookshop.bean;

/**
 * 读书笔记实体类
 */
public class BookNote {
    /**
     * 用户主键
     */
    private String user_id;
    /**
     * 书籍主键
     */
    private String ISBN;
    /**
     * 书籍页数
     */
    private Integer page_counter;
    /**
     * 书籍章节
     */
    private String book_chapter;
    /**
     * 笔记内容
     */
    private String note_value;
    /**
     * 笔记标题
     */
    private String note_title;

    public BookNote() {
    }

    public BookNote(String user_id, String ISBN, Integer page_counter, String book_chapter, String note_value, String note_title) {
        this.user_id = user_id;
        this.ISBN = ISBN;
        this.page_counter = page_counter;
        this.book_chapter = book_chapter;
        this.note_value = note_value;
        this.note_title = note_title;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getPage_counter() {
        return page_counter;
    }

    public void setPage_counter(Integer page_counter) {
        this.page_counter = page_counter;
    }

    public String getBook_chapter() {
        return book_chapter;
    }

    public void setBook_chapter(String book_chapter) {
        this.book_chapter = book_chapter;
    }

    public String getNote_value() {
        return note_value;
    }

    public void setNote_value(String note_value) {
        this.note_value = note_value;
    }

    public String getNote_title() {
        return note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    @Override
    public String toString() {
        return "BookNote{" +
                "user_id='" + user_id + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", page_counter=" + page_counter +
                ", book_chapter='" + book_chapter + '\'' +
                ", note_value='" + note_value + '\'' +
                ", note_title='" + note_title + '\'' +
                '}';
    }
}
