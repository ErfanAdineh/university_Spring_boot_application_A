package com.university.universityapplication_erfanadine.controller;

import com.university.universityapplication_erfanadine.dto.BookDto;
import com.university.universityapplication_erfanadine.dto.search.BookFindByName;
import com.university.universityapplication_erfanadine.dto.search.BookSearch;
import com.university.universityapplication_erfanadine.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public BookDto save(@RequestBody BookDto bookDto) {
        return bookService.save(bookDto);
    }

    @PutMapping
    public int update(@RequestBody BookDto bookDto) {
        return bookService.update(bookDto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long bookId) {
        bookService.delete(bookId);
    }

    @PostMapping("/search")
    public List<BookDto> search(@RequestBody BookSearch bookSearch) {
        return bookService.search(bookSearch.getName(), bookSearch.getLanguage(), bookSearch.getPrintYear(), bookSearch.getPage(), bookSearch.getSize());
    }

    @GetMapping("/findById/{bookId}")
    public BookDto findById(@PathVariable Long bookId) {
        return bookService.findById(bookId);
    }

    @PostMapping("/findByName")
    public List<BookDto> findByName(@RequestBody BookFindByName bookFindByName) {
        return bookService.findByName(bookFindByName.getBookName(), bookFindByName.getPage(), bookFindByName.getSize());
    }
}
