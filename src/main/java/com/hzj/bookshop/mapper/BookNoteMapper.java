package com.hzj.bookshop.mapper;

import com.hzj.bookshop.bean.BookNote;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookNoteMapper {

    /**
     * 添加笔记
     * @param bookNote
     */
    public void addNote(BookNote bookNote);

    /**
     * 通过用户id查找笔记
     * @param userId
     * @return
     */
    public List<BookNote> findByUserId(Integer userId);

    /**
     * 删除用户笔记
     * @param bookNote
     */
    public void deleteNote(BookNote bookNote);


    /**
     * 查找用户的一个笔记
     * @return
     */
    public BookNote findOneNote(BookNote bookNote);

    /**
     * 更新书籍信息
     * @param bookNote
     */
    public void updateNote(BookNote bookNote);

    /**
     * 通过收藏书籍的主键查找收藏的书籍信息
     * @param noteId
     */
    public BookNote findNoteByNoteId(Integer noteId);
}
