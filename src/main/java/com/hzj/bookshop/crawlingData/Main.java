package com.hzj.bookshop.crawlingData;

import com.hzj.bookshop.bean.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {


    }

    @Test
    public void test01() {
       String html = "<div class=\"indent\" id=\"dir_1139336_full\" style=\"display:none\">\n" +
               "    出版者的话\n" +
               "    <br> 专家指导委员会\n" +
               "    <br> 中文版序\n" +
               "    <br> 译者序\n" +
               "    <br> 校译者简介\n" +
               "    <br> 序\n" +
               "    <br> 第1版序\n" +
               "    <br> 引言\n" +
               "    <br> 第1章 导言\n" +
               "    <br> 1.1 入门\n" +
               "    <br> 1.2 变量与算术表态式\n" +
               "    <br> 1.3 for语句\n" +
               "    <br> 1.4 符号常量\n" +
               "    <br> 1.5 字符输入/输出\n" +
               "    <br> 1.6 数组\n" +
               "    <br> 1.7 函数\n" +
               "    <br> 1.8 参数——传值调用\n" +
               "    <br> 1.9 字符数组\n" +
               "    <br> 1.10 外部变量与作用域\n" +
               "    <br> 第2章 类型、运算符与表达式\n" +
               "    <br> 2.1 变量名\n" +
               "    <br> 2.2 数据类型及长度\n" +
               "    <br> 2.3 常量\n" +
               "    <br> 2.4 声明\n" +
               "    <br> 2.5 算术运算符\n" +
               "    <br> 2.6 关系运算符与逻辑运算符\n" +
               "    <br> 2.7 类型转换\n" +
               "    <br> 2.8 自增运算符与自减运算符\n" +
               "    <br> 2.9 按位运算符\n" +
               "    <br> 2.10 赋值运算符与表达式\n" +
               "    <br> 2.11 条件表达式\n" +
               "    <br> 2.12 运算符优先级与求值次序\n" +
               "    <br> 第3章 控制流\n" +
               "    <br> 3.1 语句与程序块\n" +
               "    <br> 3.2 if-else语句\n" +
               "    <br> 3.3 else-if语句\n" +
               "    <br> 3.4 switch语句\n" +
               "    <br> 3.5 whil循环与for特环\n" +
               "    <br> 3.6 do-while循环\n" +
               "    <br> 3.7 break语句与continue语句\n" +
               "    <br> 3.8 goto语句与标号\n" +
               "    <br> 第4章 涵数与程序结构\n" +
               "    <br> 第5章 指针与数组\n" +
               "    <br> 第6章 结构\n" +
               "    <br> 第7章 输入与输出\n" +
               "    <br> 第8章 UNIX系统接口\n" +
               "    <br> 附录A 参考手册\n" +
               "    <br> 附录B 标准库\n" +
               "    <br> 附录C 变更小结\n" +
               "    <br> 索引\n" +
               "</div>";

       Element element = Jsoup.parse(html);
       Elements elements = element.select("div");
       String[] values = String.valueOf(element.select("div")).split("style=\"display:none\">\n")[1].split("</div>")[0].split("<br>");
       System.out.println();



    }
}
