package com.hzj.bookshop.control;

import com.hzj.bookshop.bean.Book;
import com.hzj.bookshop.crawlingData.CrawlingBook;
import com.hzj.bookshop.crawlingData.CrawlingBookThread;
import com.hzj.bookshop.service.BookService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 这是一个爬虫,自动爬取书籍
     */
    @GetMapping("/addbook")
    public void addBook() {
        CrawlingBookThread crawlingBookThread = new CrawlingBookThread(bookService);
        crawlingBookThread.start();
    }

    /**
     * 这个只是一个测试用的
     * @param ISBN
     */
    @GetMapping("/addbook1")
    public void addBook1(@RequestParam("ISBN") String ISBN) {
//        bookService.addBook(book);
        System.out.println(bookService.findBookByISBN(ISBN));

    }

    /**
     * 通过书籍的主键查找书籍
     * @param ISBN 书的主键
     * @return
     */
    @RequestMapping("/findOneBook/{ISBN}")
    public Book findOneBook(@PathVariable("ISBN") String ISBN) {
        System.out.println(ISBN);
        return bookService.findBookByISBN(ISBN);
    }

    /**
     * 通过书名查找书籍, 实现通过书籍名进行搜索
     * @param bookName  书籍名
     * @return
     */
    @GetMapping("/searchBook")
    public List<Book> searchBook(@RequestParam("bookName") String bookName) {
        List<Book> bookList = bookService.searchBook(bookName);
        return bookList;
    }

    /**
     * 通过作者名查找书籍, 查找作者的所有书
     * @param author
     * @return
     */
    @GetMapping("/findBookByAuthor")
    public List<Book> findBookByAuthor(@RequestParam("author") String author) {
        List<Book> bookList = null;
        bookList = bookService.findBookByAuthor(author);
        return bookList;
    }


    @GetMapping("/findBookByTranslator")
    public List<Book> findBookByTranslator(@RequestParam("translator") String translator) {
        System.out.println(translator);
        List<Book> bookList = bookService.findBookByTranslator(translator);
        return bookList;

    }

}
