package com.hzj.bookshop.bean;

import java.util.Date;

/**
 * 读书笔记实体类
 */
public class BookNote {

    /**
     * 笔记的主键
     */
    private Integer noteId;

    /**
     * 用户主键
     */
    private Integer user_id;
    /**
     * 书籍主键
     */
    private String ISBN;
    /**
     * 书籍开始页数
     */
    private Integer begain_page;

    /**
     * 结束页数
     */
    private Integer end_page;
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

    /**
     * 笔记创建时间
     */
    private Date createTime;

    /**
     * 笔记的html代码
     */
    private String noteHtml;

    public BookNote() {
    }

    public BookNote(Integer noteId, Integer user_id, String ISBN, Integer begain_page, Integer end_page, String book_chapter, String note_value, String note_title, Date createTime, String noteHtml) {
        this.noteId = noteId;
        this.user_id = user_id;
        this.ISBN = ISBN;
        this.begain_page = begain_page;
        this.end_page = end_page;
        this.book_chapter = book_chapter;
        this.note_value = note_value;
        this.note_title = note_title;
        this.createTime = createTime;
        this.noteHtml = noteHtml;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public Integer getBegain_page() {
        return begain_page;
    }

    public void setBegain_page(Integer begain_page) {
        this.begain_page = begain_page;
    }

    public Integer getEnd_page() {
        return end_page;
    }

    public void setEnd_page(Integer end_page) {
        this.end_page = end_page;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNoteHtml() {
        return noteHtml;
    }

    public void setNoteHtml(String noteHtml) {
        this.noteHtml = noteHtml;
    }

    @Override
    public String toString() {
        return "BookNote{" +
                "noteId=" + noteId +
                ", user_id=" + user_id +
                ", ISBN='" + ISBN + '\'' +
                ", begain_page=" + begain_page +
                ", end_page=" + end_page +
                ", book_chapter='" + book_chapter + '\'' +
                ", note_value='" + note_value + '\'' +
                ", note_title='" + note_title + '\'' +
                ", createTime=" + createTime +
                ", noteHtml='" + noteHtml + '\'' +
                '}';
    }
}
