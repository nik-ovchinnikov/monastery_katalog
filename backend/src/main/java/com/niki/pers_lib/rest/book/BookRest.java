package com.niki.pers_lib.rest.book;

import com.niki.pers_lib.entities.book.Book;
import com.niki.pers_lib.entities.book.BookPicture;
import com.niki.pers_lib.entities.book.book_place.BookPlace;
import com.niki.pers_lib.entities.book.book_place.BookSubPlace;
import com.niki.pers_lib.entities.book.book_type.BookSubType;
import com.niki.pers_lib.services.book.BookService;
import com.niki.pers_lib.services.book.book_place.BookPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRest {
    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public List<String> addBook(@RequestBody Book book) {
        System.out.println(book);
        prepareBook(book);
        return bookService.create(book);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Book> detAllBookList() {
        return bookService.getAll();
    }

    @GetMapping("/checkKey")
    @ResponseBody
    public List<Book> checkKey(@RequestParam String key) {
        return bookService.checkKey(key);

    }

    @PostMapping("/deleteItems")
    public void deleteItems(@RequestBody Book[] books) {
        for(Book book: books) {
            prepareBook(book);
        }
        bookService.deleteItemList(books);
    }

    @PostMapping("/update")
    public List<String> updateBook(@RequestBody Book book) {
        prepareBook(book);
        return bookService.update(book);
    }

    @PostMapping("/deleteOldPictures")
    public void deleteOldPictures(@RequestBody List<Long> idArray) {
        this.bookService.deleteOldPictures(idArray);
    }


    public void prepareBook(Book book) {
        book.getPlace().setSubPlaceList(null);
        book.getType().setSubTypeList(null);
        book.getSubPlace().setPlace(book.getPlace());
        book.getSubType().setType(book.getType());
        //для пустого списка подтипов или точного места
        if(book.getSubType().getId() == -1){
            book.setSubType(null);
        }
        if(book.getSubPlace().getId() == -1){
            book.setSubPlace(null);
        }
        //создаём связь между книгой и фото
        if(book.getPictureList() != null) {
            for(BookPicture bookPicture: book.getPictureList()) {
                bookPicture.setBook(book);
            }
        }

    }
}
