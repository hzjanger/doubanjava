package com.hzj.bookshop.service;

import com.hzj.bookshop.bean.BookCollection;
import com.hzj.bookshop.mapper.BookCollectionMapper;
import com.hzj.bookshop.utlis.Jsonutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;

@Service
public class BookCollectionService {

    @Autowired
    private BookCollectionMapper bookCollectionMapper;

    /**
     * 添加用户收藏书籍
     * @param bookCollection
     */
    public void addBookCollection(BookCollection bookCollection) {
        bookCollection.setCommand_time(new Date());

        bookCollectionMapper.addBookCollection(bookCollection);

    }

    /**
     * 删除用户收藏书籍
     * @param bookCollection
     */
    public void deleteByUserIdAndISBN(BookCollection bookCollection) {
        bookCollectionMapper.deleteByUserIdAndISBN(bookCollection);
    }

    /**
     * 查找用户收藏书籍
     * @param bookCollectionJson
     */
    public BookCollection findByUserIdAndISBN(String bookCollectionJson) {
        BookCollection bookCollection = new BookCollection();
        System.out.println(bookCollectionJson);
        bookCollection.setISBN(String.valueOf(Jsonutils.getValue(bookCollectionJson, "isbn", "string")));
        bookCollection.setUser_id((Integer) Jsonutils.getValue(bookCollectionJson, "user_id", "int"));
        System.out.println(bookCollection);
        return bookCollectionMapper.findByUserIdAndISBN(bookCollection);
    }

    /**
     * 更新用户收藏书籍
     * @param bookCollection
     */
    public void updateBookCollection(BookCollection bookCollection) {
        bookCollection.setCommand_time(new Date());
        bookCollectionMapper.updateBookCollection(bookCollection);
    }
}
