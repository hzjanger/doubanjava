package com.hzj.bookshop.control;

import com.hzj.bookshop.bean.BookCollection;
import com.hzj.bookshop.service.BookCollectionService;
import com.hzj.bookshop.utlis.Jsonutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
        System.out.println(bookCollection);
        bookCollectionService.addBookCollection(bookCollection);
    }


    @PostMapping("/deleteByUserIdAndISBN")
    public void deleteByUserIdAndISBN(@RequestBody BookCollection bookCollection) {
        System.out.println(bookCollection);
        bookCollectionService.deleteByUserIdAndISBN(bookCollection);
    }

    @PostMapping("/findByUserIdAndISBN")
    public BookCollection findByUserIdAndISBN(@RequestBody String bookCollectionJson) {
        BookCollection result = bookCollectionService.findByUserIdAndISBN(bookCollectionJson);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/updateBookCollection")
    public void updateBookCollection(@RequestBody BookCollection bookCollection) {
        bookCollectionService.updateBookCollection(bookCollection);
    }


}
