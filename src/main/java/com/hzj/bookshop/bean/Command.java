package com.hzj.bookshop.bean;

/**
 * 书籍评论实体类
 */
public class Command {
    /**
     * 用户主键
     */
    private Integer user_id;
    /**
     * 书籍主键
     */
    private String ISBN;
    /**
     * 评论时间
     */
    private String command_time;
    /**
     * 评论内容
     */
    private String command_value;
    /**
     * 评论星级
     */
    private String command_grade;
    /**
     * 评论标题
     */
    private String command_title;

    public Command() {
    }

    public Command(Integer user_id, String ISBN, String command_time, String command_value, String command_grade, String command_title) {
        this.user_id = user_id;
        this.ISBN = ISBN;
        this.command_time = command_time;
        this.command_value = command_value;
        this.command_grade = command_grade;
        this.command_title = command_title;
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

    public String getCommand_time() {
        return command_time;
    }

    public void setCommand_time(String command_time) {
        this.command_time = command_time;
    }

    public String getCommand_value() {
        return command_value;
    }

    public void setCommand_value(String command_value) {
        this.command_value = command_value;
    }

    public String getCommand_grade() {
        return command_grade;
    }

    public void setCommand_grade(String command_grade) {
        this.command_grade = command_grade;
    }

    public String getCommand_title() {
        return command_title;
    }

    public void setCommand_title(String command_title) {
        this.command_title = command_title;
    }

    @Override
    public String toString() {
        return "Command{" +
                "user_id='" + user_id + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", command_time='" + command_time + '\'' +
                ", command_value='" + command_value + '\'' +
                ", command_grade='" + command_grade + '\'' +
                ", command_title='" + command_title + '\'' +
                '}';
    }
}
