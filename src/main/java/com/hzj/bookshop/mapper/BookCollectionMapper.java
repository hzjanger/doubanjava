package com.hzj.bookshop.mapper;

import com.hzj.bookshop.bean.BookCollection;
import com.hzj.bookshop.bean.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookCollectionMapper {


    /**
     * 添加用户收藏书籍
     * @param bookCollection
     */
    public void addBookCollection(BookCollection bookCollection);

    /**
     * 删除用户收藏书籍
     * @param bookCollection
     */
    public void deleteByUserIdAndISBN(BookCollection bookCollection);


    /**
     * 查找用户收藏的书籍
     * @param bookCollection
     */
    public BookCollection findByUserIdAndISBN(BookCollection bookCollection);

    /**
     * 更新用户收藏的书籍信息
     * @param bookCollection
     */
    public void updateBookCollection(BookCollection bookCollection);

    /**
     * 查找用户收藏书籍
     * @param bookCollection
     * @return
     */
    public List<User> findCollectionBook(BookCollection bookCollection);
}
