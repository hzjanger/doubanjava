package com.hzj.bookshop.service;

import com.hzj.bookshop.bean.BookNote;
import com.hzj.bookshop.mapper.BookNoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookNoteService {

    @Autowired
    private BookNoteMapper bookNoteMapper;

    /**
     * 添加笔记
     * @param bookNote
     */
    public void addNote(BookNote bookNote) {
        bookNoteMapper.addNote(bookNote);
    }


    /**
     * 查找用户所有的笔记
     * @param userId
     * @return
     */
    public List<BookNote> findByUserId(Integer userId){
        List<BookNote> bookNoteList = bookNoteMapper.findByUserId(userId);
        return bookNoteList;

    }

    /**
     * 删除用户笔记
     * @param bookNote
     */
    public void deleteNote(BookNote bookNote) {
        bookNoteMapper.deleteNote(bookNote);
    }

    /**
     * 查找用户的一个笔记
     * @return
     */
    public BookNote findOneNote(BookNote bookNote){
        BookNote result = bookNoteMapper.findOneNote(bookNote);
        return result;
    }

    /**
     * 更新书籍信息
     * @param bookNote
     */
    public void updateNote(BookNote bookNote) {
        bookNoteMapper.updateNote(bookNote);

    }

    /**
     * 通过收藏书籍的主键查找收藏的书籍信息
     * @param noteId
     */
    public BookNote findNoteByNoteId(Integer noteId) {
        return  bookNoteMapper.findNoteByNoteId(noteId);
    }



}
