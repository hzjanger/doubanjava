package com.hzj.bookshop.bean;

import java.util.List;

/**
 * 用户实体类
 */
public class User {
    /**
     * 用户id, 主键
     */
    private Integer user_id;
    /**
     * 用户账户
     */
    private String user_account;
    /**
     * 用户密码
     */
    private String user_password;
    /**
     * 昵称
     */
    private String user_name;
    /**
     * 图片路径
     */
    private String user_imgUrl;
    /**
     * 用户绑定邮箱
     */
    private String user_email;
    /**
     * 激活验证码
     */
    private String code_url;
    /**
     * 登录验证码
     */
    private String email_login;
    /**
     * 用户激活状态
     */
    private Integer activated;

    /**
     * 一个用户收藏多本书籍
     */
    private List<Book> bookList;

    public User() {
    }



    public User(Integer user_id, String user_account, String user_password, String user_name, String user_imgUrl, String user_email, String code_url, String email_login, Integer activated, List<Book> bookList) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_imgUrl = user_imgUrl;
        this.user_email = user_email;
        this.code_url = code_url;
        this.email_login = email_login;
        this.activated = activated;
        this.bookList = bookList;
    }

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_imgUrl() {
        return user_imgUrl;
    }

    public void setUser_imgUrl(String user_imgUrl) {
        this.user_imgUrl = user_imgUrl;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getCode_url() {
        return code_url;
    }

    public void setCode_url(String code_url) {
        this.code_url = code_url;
    }

    public String getEmail_login() {
        return email_login;
    }

    public void setEmail_login(String email_login) {
        this.email_login = email_login;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_account='" + user_account + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_imgUrl='" + user_imgUrl + '\'' +
                ", user_email='" + user_email + '\'' +
                ", code_url='" + code_url + '\'' +
                ", email_login='" + email_login + '\'' +
                ", activated=" + activated +
                ", bookList=" + bookList +
                '}';
    }
}
