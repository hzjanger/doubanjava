package com.hzj.bookshop.crawlingData;

import com.hzj.bookshop.bean.Book;
import com.hzj.bookshop.service.BookService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlingBookThread extends Thread {

    private BookService bookService;
    public CrawlingBookThread(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> urlList = new ArrayList<>();
        for (int i = 100; i <= 180; i = i + 20) {
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
            System.out.println(url);
        }
//        System.out.println("到56行");

//        System.out.println((int)(Math.random()*bookInfolink.size()));
        System.out.println("开始爬取书籍" + bookInfolink.size());
        int count = 0;
        for (String url : bookInfolink) {
            System.out.println(url);
            count++;
            if (count <= 46) {
                continue;
            }

            try {
                Book book = crawlingBook.crawlingBookInfo(url);
                if (bookService.findBookByISBN(book.getISBN()) != null) {

                } else {
                    System.out.println(book.getBook_direction().length());
                    if (book.getBook_direction().length() > 10900){
                        continue;
                    } else if (book.getAuthor_introduction().length() > 4900) {
                        continue;
                    } else if (book.getAuthor_introduction().length() > 4900){
                        continue;
                    }
                    bookService.addBook(book);
                }
                System.out.println("存储成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("count 到了" + count);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("书籍爬取结束");




    }
}

//https://book.douban.com/subject/26829016/