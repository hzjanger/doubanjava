package com.hzj.bookshop.control;

import com.hzj.bookshop.bean.BookCollection;
import com.hzj.bookshop.bean.BookNote;
import com.hzj.bookshop.bean.User;
import com.hzj.bookshop.service.BookCollectionService;
import com.hzj.bookshop.utlis.Jsonutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/bookCollection")
public class BookCollectionController {

    @Autowired
    private BookCollectionService bookCollectionService;

    /**
     * 添加用户收藏
     * @param bookCollection
     */
    @PostMapping("/addBookCollection")
    public void addBookCollection(@RequestBody BookCollection bookCollection) {
        System.out.println("开始添加收藏");
        System.out.println(bookCollection);
        System.out.println("收藏添加结束");
        bookCollectionService.addBookCollection(bookCollection);
    }


    /**
     * 用户删除收藏书籍
     * @param bookCollection
     */
    @PostMapping("/deleteByUserIdAndISBN")
    public void deleteByUserIdAndISBN(@RequestBody BookCollection bookCollection) {
        System.out.println(bookCollection);
        bookCollectionService.deleteByUserIdAndISBN(bookCollection);
    }

    /**
     * 查找用户收藏的一本书籍
     * @param bookCollectionJson
     * @return
     */
    @PostMapping("/findByUserIdAndISBN")
    public BookCollection findByUserIdAndISBN(@RequestBody String bookCollectionJson) {
        System.out.println("开始查找");
        BookCollection result = bookCollectionService.findByUserIdAndISBN(bookCollectionJson);
        System.out.println(result);
        System.out.println("查找结束");
        return result;
    }

    /**
     * 用户修改书籍
     * @param bookCollection
     */
    @RequestMapping("/updateBookCollection")
    public void updateBookCollection(@RequestBody BookCollection bookCollection) {
        bookCollectionService.updateBookCollection(bookCollection);
    }

    /**
     * 查找用户收藏的书籍, 查找想读的书籍
     */
    @PostMapping("/findCollectionBook")
    public List<User> findCollectionBook(@RequestBody String wantReadBookJson) {
        List<User> bookCollectionList = bookCollectionService.findCollectionBook(wantReadBookJson);
        return bookCollectionList;
    }




}
