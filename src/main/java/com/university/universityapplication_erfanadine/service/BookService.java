package com.university.universityapplication_erfanadine.service;

import com.university.universityapplication_erfanadine.dto.BookDto;
import com.university.universityapplication_erfanadine.entity.Book;
import com.university.universityapplication_erfanadine.mapper.MapperModel;
import com.university.universityapplication_erfanadine.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    private MapperModel mapperModel;

    public BookDto save(BookDto bookDto) {
        Book save = bookRepo.save(mapperModel.convertBookDtoToBookModel(bookDto));
        return mapperModel.convertBookModelToBookDto(save);
    }

    public int update(BookDto book) {
        int update = bookRepo.update(book.getBookName(), book.getMainLanguage(), book.getPrintYear(), book.getLesson(), book.getId());
        return update;
    }

    public void delete(Long bookId) {
        bookRepo.deleteById(bookId);
    }

    public List<BookDto> search(String name, String language, String printYear, int page, int size) {
        List<BookDto> bookDtoList = new ArrayList<>();

        Pageable result = PageRequest.of(page, size);
        List<Book> search = bookRepo.search(name, language, printYear, result);
        for (Book book :
                search) {
            BookDto bookDto = mapperModel.convertBookModelToBookDto(book);
            bookDtoList.add(bookDto);
        }

        return bookDtoList;
    }

    public BookDto findById(Long bookId) {
        Book book = bookRepo.findById(bookId).orElseThrow(RuntimeException::new);
        return mapperModel.convertBookModelToBookDto(book);
    }

    public List<BookDto> findByName(String bookName, int page, int size) {
        List<BookDto> bookDtoList = new ArrayList<>();

        Pageable result = PageRequest.of(page, size);
        List<Book> books = bookRepo.findByBookName(bookName, result);
        for (Book book : books) {
            BookDto bookDto = mapperModel.convertBookModelToBookDto(book);
            bookDtoList.add(bookDto);
        }

        return bookDtoList;
    }

}
