package com.hzj.bookshop.service;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.hzj.bookshop.bean.BookCollection;
import com.hzj.bookshop.bean.User;
import com.hzj.bookshop.mapper.BookCollectionMapper;
import com.hzj.bookshop.utlis.Jsonutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
public class BookCollectionService {

    @Autowired
    private BookCollectionMapper bookCollectionMapper;

    /**
     * 添加用户收藏书籍
     * @param bookCollection
     */
    public void addBookCollection(BookCollection bookCollection) {
        if (bookCollectionMapper.findByUserIdAndISBN(bookCollection) != null) {
            bookCollectionMapper.updateBookCollection(bookCollection);
        } else {
            bookCollectionMapper.addBookCollection(bookCollection);
        }
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
        System.out.println(bookCollectionJson);
        BookCollection bookCollection = new BookCollection();
        bookCollection.setISBN(String.valueOf(Jsonutils.getValue(bookCollectionJson, "isbn", "string")));
        bookCollection.setUser_id((Integer) Jsonutils.getValue(bookCollectionJson, "user_id", "int"));
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

    public List<User> findCollectionBook(String collectionBookJson) {
        BookCollection bookCollection = new BookCollection();
        bookCollection.setBook_status_type(String.valueOf(Jsonutils.getValue(collectionBookJson, "book_status_type", "string")));
        bookCollection.setUser_id((Integer) Jsonutils.getValue(collectionBookJson, "user_id", "int"));
        return bookCollectionMapper.findCollectionBook(bookCollection);
    }
}
