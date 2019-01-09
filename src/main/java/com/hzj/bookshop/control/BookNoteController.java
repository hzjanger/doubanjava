package com.hzj.bookshop.control;

import com.hzj.bookshop.bean.BookNote;
import com.hzj.bookshop.service.BookNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class BookNoteController {

    @Autowired
    private BookNoteService bookNoteService;

    @PostMapping("/saveNote")
    public void saveNote(@RequestBody BookNote bookNote) {
        bookNoteService.addNote(bookNote);

    }

    @GetMapping("/findUserNote")
    public List<BookNote> findUserNote(@RequestParam("userId") Integer userId) {
        List<BookNote> bookNoteList = bookNoteService.findByUserId(userId);
        return bookNoteList;
    }

    @PostMapping("/deleteNote")
    public void deleteNote(@RequestBody BookNote bookNote) {
        bookNoteService.deleteNote(bookNote);
    }

    /**
     * 查找用户的一个笔记
     * @return
     */
    @PostMapping("/findOneNote")
    public BookNote findOneNote(@RequestBody BookNote bookNote){
        BookNote result = bookNoteService.findOneNote(bookNote);
        return result;
    }

    /**
     * 更新书籍信息
     * @param bookNote
     */
    @PostMapping("/updateNote")
    public void updateNote(@RequestBody BookNote bookNote) {
        bookNoteService.updateNote(bookNote);

    }

    /**
     * 通过收藏书籍的主键查找收藏的书籍信息
     * @param noteId
     */
    @GetMapping("/findNoteByNoteId")
    public BookNote findNoteByNoteId(@RequestParam("noteId") Integer noteId) {
        return  bookNoteService.findNoteByNoteId(noteId);
    }
}
