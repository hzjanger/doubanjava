package com.hzj.bookshop.service;

import com.hzj.bookshop.bean.Book;
import com.hzj.bookshop.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * 添加书籍
     * @param book
     */
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    /**
     * 查找书籍， 通过主键
     * @param ISBN 书籍主键
     * @return
     */
    public Book findBookByISBN(String ISBN) {
        return bookMapper.findBookByISBN(ISBN);
    }

    /**
     * 查找书籍， 通过书籍名称
     * @param bookName
     * @return
     */
    public List<Book> searchBook(String bookName) {
        return bookMapper.searchBook(bookName);
    }

    /**
     * 查找书籍， 通过作者
     * @param author
     * @return
     */
    public List<Book> findBookByAuthor(String author) {
        return bookMapper.findBookByAuthor(author);
    }

    public List<Book> findBookByTranslator(String translator) {
        return bookMapper.findBookBytranslator(translator);
    }


}
