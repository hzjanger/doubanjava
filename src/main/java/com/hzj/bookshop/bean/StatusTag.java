package com.hzj.bookshop.bean;

/**
 * 状态标签实体类
 */
public class StatusTag {
    /**
     * 书籍主键
     */
    private String ISBN;
    /**
     * 用户主键
     */
    private Integer user_id;
    /**
     * 标签主键
     */
    private Integer tag_id;

    public StatusTag() {
    }

    public StatusTag(String ISBN, Integer user_id, Integer tag_id) {
        this.ISBN = ISBN;
        this.user_id = user_id;
        this.tag_id = tag_id;
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

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    @Override
    public String toString() {
        return "StatusTag{" +
                "ISBN='" + ISBN + '\'' +
                ", user_id=" + user_id +
                ", tag_id=" + tag_id +
                '}';
    }
}
