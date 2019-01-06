package com.hzj.bookshop.crawlingData;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

public class HttpClientJsoupTest {

    @Test
    public void test() throws IOException {
        HttpGet httpGet = new HttpGet("http://sports.sina.com.cn/");
        httpGet.setConfig(RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build());
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        String responseStr = "";
        httpClient = HttpClientBuilder.create().build();
        HttpClientContext context = HttpClientContext.create();
        httpResponse = httpClient.execute(httpGet, context);
        int state = httpResponse.getStatusLine().getStatusCode();
        if (state != 200) {
            responseStr = "";
        }
        HttpEntity httpEntity = httpResponse.getEntity();
        if (httpEntity != null) {
            responseStr = EntityUtils.toString(httpEntity, "UTF-8");
        }

        httpResponse.close();
        httpClient.close();
        if (responseStr == null) {
            return;
        }

        //System.out.println(responseStr);

        Document document = Jsoup.parse(responseStr);
//       Document document = Jsoup.parse(responseStr);
        System.out.println(document);

    }

    @Test
    public void test02() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://book.douban.com/tag/编程?start=0&type=T");
        httpGet.setHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
//        HttpHost proxy = new HttpHost("218.22.7.62", 53281);
        HttpHost proxy = new HttpHost("222.188.140.187", 9999);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        httpGet.setConfig(config);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity, "UTF-8"));
            if (entity != null) {
                System.out.println("查看响应类型==============================");
                System.out.println(entity.getContentType().getValue());

            }

            System.out.println("状态码=======================================");
            System.out.println(response.getStatusLine().getStatusCode());
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
