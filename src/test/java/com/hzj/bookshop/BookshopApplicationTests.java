package com.hzj.bookshop;

import com.hzj.bookshop.bean.Book;
import com.hzj.bookshop.crawlingData.CrawlingBook;
import com.hzj.bookshop.service.BookService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookshopApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    public void contextLoads() {
        List<String> urlList = new ArrayList<>();
        for (int i = 0; i <= 100; i = i + 20) {
            String url = "https://book.douban.com/tag/编程?start=" + i + "&type=T";
            urlList.add(url);
        }

        CrawlingBook crawlingBook = new CrawlingBook();
        //获取所有书籍页面的信息
        List<String> bookInfolink = new ArrayList<>();
        for (String url: urlList) {
            Document document = null;
            try {
                document = Jsoup.parse(CrawlingBook.getHTMLContent(url));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements bookInfoUrlLink = document.select("a[class=nbg]").select("a[href]");
            for (Element e: bookInfoUrlLink) {
                bookInfolink.add(e.attr("href"));
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
//        System.out.println("到56行");

//        System.out.println((int)(Math.random()*bookInfolink.size()));
        int count = 0;
        for (String url : bookInfolink) {
            System.out.println(url);
            count++;
            if (count < 0) {
                continue;
            }
            try {
                Book book = crawlingBook.crawlingBookInfo(url);
                if (bookService.findBootByISBN(book.getISBN()) != null) {

                } else {
                    System.out.println(book.getBook_direction().length());
                    bookService.addBook(book);
                }
                System.out.println("存储成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

