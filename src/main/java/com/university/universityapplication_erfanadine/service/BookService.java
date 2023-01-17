package com.university.universityapplication_erfanadine.service;

import com.university.universityapplication_erfanadine.dto.BookDto;
import com.university.universityapplication_erfanadine.entity.Book;
import com.university.universityapplication_erfanadine.entity.Lesson;
import com.university.universityapplication_erfanadine.mapper.MapperModel;
import com.university.universityapplication_erfanadine.repository.BookRepo;
import com.university.universityapplication_erfanadine.repository.LessonRepo;
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

    @Autowired
    private LessonRepo lessonRepo;

    private MapperModel mapperModel;

    public BookDto save(BookDto bookDto) {
        Book save = bookRepo.save(convertBookDtoToBookModel(bookDto));
        return convertBookModelToBookDto(save);
    }

    public int update(BookDto book) {
//        int update = bookRepo.update(book.getBookName(), book.getMainLanguage(), book.getPrintYear(), book.getLesson(), book.getId());
        int update = bookRepo.update(book.getBookName(), book.getMainLanguage(), book.getPrintYear(),book.getId());
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

//*************************************
    public Book convertBookDtoToBookModel(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );
        book.setBookName( bookDto.getBookName() );
        book.setMainLanguage( bookDto.getMainLanguage() );
        book.setPrintYear( bookDto.getPrintYear() );
        book.setLesson(lessonRepo.findById(bookDto.getLessonId()).orElseGet(Lesson::new));

        return book;
    }

    public BookDto convertBookModelToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setBookName( book.getBookName() );
        bookDto.setMainLanguage( book.getMainLanguage() );
        bookDto.setPrintYear( book.getPrintYear() );
        bookDto.setLessonId(book.getLesson().getId());

        return bookDto;
    }
}
