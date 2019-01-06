package com.hzj.bookshop.mapper;

import com.hzj.bookshop.bean.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookMapper {


    /**
     * 添加书籍
     * @param book 书籍实体
     */
    public void addBook(Book book);

    /**
     * 通过书籍主机那查找书籍
     * @param ISBN  书籍主键
     * @return
     */
    public Book findBookByISBN(String ISBN);

    /**
     * 通过书籍名查找书籍
     * @param book_name  书籍名称
     * @return
     */
    public List<Book> searchBook(String book_name);


    /**
     * 通过作者名查找书籍
     * @param author  书籍作者
     * @return
     */
    public List<Book> findBookByAuthor(String author);

    /**
     * 通过译者查找书籍
     * @param translator
     * @return
     */
    public List<Book> findBookBytranslator(String translator);


}
