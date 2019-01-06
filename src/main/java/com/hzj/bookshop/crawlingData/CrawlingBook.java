package com.hzj.bookshop.crawlingData;

import com.hzj.bookshop.bean.Book;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class CrawlingBook {


    public String crawlingBookUrl(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        HttpHost proxy = new HttpHost("218.22.7.62", 53281);
//        HttpHost proxy = new HttpHost("222.188.140.187", 9999);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        httpGet.setConfig(config);
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            System.out.println(entity);
//            System.out.println(EntityUtils.toString(entity, "UTF-8"));
//            if (entity != null) {
//                System.out.println("查看响应类型==============================");
//                System.out.println(entity.getContentType().getValue());
//
//            }
//            System.out.println("状态码=======================================");
//            System.out.println(response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(EntityUtils.toString(entity, "UTF-8"));
        String responseStr = EntityUtils.toString(entity, "UTF-8");
        response.close();
        httpClient.close();

        return responseStr;
//        return EntityUtils.toString(entity, "UTF-8");
    }

    public Book crawlingBookInfo(String url) throws IOException {
        Document document = Jsoup.parse(getHTMLContent(url));
        Element subject = null;
        if (document.select("div[class=subject clearfix]").size() == 0) {
            subject = document.select("div[class=subjectwrap clearfix]").get(0);
        } else {
            subject = document.select("div[class=subject clearfix]").get(0);
        }


//        System.out.println(subject);
        String book_name = subject.select("a[class=nbg]").attr("title");
        String book_img = subject.select("a[class=nbg]").attr("href");
        Element info = subject.getElementById("info");
        String[] infos = String.valueOf(info).split("<br>");
        String ISBN = "";
        String book_author = "";
        String book_press = "";
        String book_bind = "";
        String book_translator = "";
        String publisher_time = "";
        Integer book_page = 0;
        Double book_price = 0.00;
        for (String str : infos) {
            String in = Jsoup.parse(str).text();
            System.out.println(in);
            if (in.contains("作者:")) {
                book_author = in.split("作者: ")[1];
//                System.out.println(book_author);
            } else if (in.contains("出版社:")) {
                book_press = in.split("出版社: ")[1];
            } else if (in.contains("装帧:")) {
                book_bind = in.split("装帧: ")[1];
            } else if (in.contains("译者:")) {
                book_translator = in.split("译者: ")[1];

            } else if (in.contains("出版年:")) {
                publisher_time = in.split("出版年: ")[1];
            } else if (in.contains("页数:")) {
                in = in.split("页数: ")[1];
                if (in.contains(" 页")) {
                    book_price = Double.valueOf(in.split(" 页")[0]);
                } else {
                    book_price = Double.valueOf(in);
                }

            } else if (in.contains("定价:")) {
                in = in.split("定价: ")[1];
                if (in.contains("CNY ")) {
                    book_price = Double.parseDouble(in.split("CNY ")[1]);
                } else if(in.contains("元")){
                    book_price = Double.parseDouble(in.split("元")[0]);
                } else if (in.contains("USD ")) {
                    book_price = Double.parseDouble(in.split("USD ")[1]);
                }
            } else if (in.contains("ISBN:")) {
                ISBN = in.split("ISBN: ")[1];
            }
        }

        //书籍简介html

        Element book_introduction_el = null;
        Elements book_introduction_els = document.select("div[class=intro]");
        //书籍简介
        String book_introduction = "";
        if (book_introduction_els != null) {
            for (Element el : book_introduction_els) {
                book_introduction_el = el;
            }
            if (book_introduction_el != null) {
                book_introduction_els = book_introduction_el.select("p");
                for (Element el : book_introduction_els) {
                    System.out.println(el);
                    book_introduction = book_introduction + el.text() + "\n";
                }
            }


        }

        Element author_introduction_el = null;
        Elements author_introduction_els = document.select("div[class=intro]");

        //作者简介
        String author_introduction = "";
        if (author_introduction_els != null) {
            for (Element el : author_introduction_els) {
                author_introduction_el = el;
            }
            if (author_introduction_el != null) {
                author_introduction_els = author_introduction_el.select("p");
                for (Element el : author_introduction_els) {
                    author_introduction = author_introduction + el.text() + "\n";
                }
            }

        }


        String book_directory = "";
        Element book_directory_el = document.getElementById("dir_"+url.split("subject")[1].split("/")[1]+"_full");
        if (book_directory_el != null) {
            book_directory_el = Jsoup.parse(String.valueOf(book_directory_el).split("<br> · · · · · · ")[0] + "</div>");
            String[] book_directories = String.valueOf(book_directory_el.select("div")).split("style=\"display:none\">\n")[1].split("</div>")[0].split("<br>");
            for (String str : book_directories) {
                book_directory = book_directory + str + "\n";
            }
        }

//        book_directory = String.valueOf(book_directory_el).split("<br> · · · · · · ")[0] + "</div>";
        Book book = new Book(book_name, book_img, ISBN, book_introduction, author_introduction, book_directory, book_author, book_press, book_bind, book_translator, publisher_time, book_page, book_price);
        return book;
    }

    //根据url地址获取对应页面的HTML内容，我们将上一节中的内容打包成了一个方法，方便调用
    public static String getHTMLContent( String url ) throws IOException {

        List<IPAddress> ipAddresses = new ArrayList<>();
        ipAddresses.add(new IPAddress("124.152.32.140", 53281));
        ipAddresses.add(new IPAddress("119.57.109.129", 53281));
        //117.141.155.242

        ipAddresses.add(new IPAddress("119.57.108.73", 53281));
        ipAddresses.add(new IPAddress("118.24.150.126", 3128));

        int count = (int) (Math.random()*4);
        IPAddress ipAddress = ipAddresses.get(count);

        //建立一个新的请求客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //使用HttpGet方式请求网址
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
//        HttpHost proxy = new HttpHost("124.152.32.140", 53281);
//        HttpHost proxy = new HttpHost("112.91.218.21", 9000);
//        HttpHost proxy = new HttpHost("218.22.7.62", 53281);
//        HttpHost proxy = new HttpHost("222.188.140.187", 9999);
        HttpHost proxy = new HttpHost("118.24.150.126", 3128);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(6000).setSocketTimeout(6000).build();
        httpGet.setConfig(config);

        //获取网址的返回结果
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //获取返回结果中的实体
        HttpEntity entity = response.getEntity();
//        System.out.println(EntityUtils.toString(entity));
        String content = EntityUtils.toString(entity);
//        System.out.println(content);

        //关闭HttpEntity流
        EntityUtils.consume(entity);
        response.close();
        httpClient.close();

        return content;

    }

    @Test
    public void testC() {
        try {
            String url = "https://book.douban.com/subject/4822685/";
//            String url = "https://www.baidu.com/";
            System.out.println(CrawlingBook.getHTMLContent(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
