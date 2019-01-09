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
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
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

    @PostMapping("/addOneBook")
    public void addOneBook(@RequestBody Book book) {
        bookService.addBook(book);
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


    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，因为文件是空的.";
        }
    }

}
