package com.hzj.bookshop.bean;

/**
 * 书籍标签, 书籍属于什么类型
 */
public class BookTag {
    /**
     * 书籍主键
     */
    private String ISBN;
    /**
     * 标签主键
     */
    private Integer tag_id;

    public BookTag() {
    }

    public BookTag(String ISBN, Integer tag_id) {
        this.ISBN = ISBN;
        this.tag_id = tag_id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    @Override
    public String toString() {
        return "BookTag{" +
                "ISBN='" + ISBN + '\'' +
                ", tag_id=" + tag_id +
                '}';
    }
}
