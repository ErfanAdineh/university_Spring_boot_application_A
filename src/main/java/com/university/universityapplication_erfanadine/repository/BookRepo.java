package com.university.universityapplication_erfanadine.repository;

import com.university.universityapplication_erfanadine.entity.Book;
import com.university.universityapplication_erfanadine.entity.Lesson;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    @Query("select b from Book b where b.bookName = ?1 and b.mainLanguage  = ?2 and b.printYear = ?3 ")
    List<Book> search(String name, String language, String printYear, Pageable pageable);
//    @Query("select b from Book b where b.bookName = ?1")

    @Query("select b from Book b where b.bookName = ?1")
    List<Book> findByBookName(String bookName, Pageable pageable);


    @Modifying
    @Query("update Book b set b.bookName = :bookName, b.mainLanguage = :mainLanguage, b.printYear = :printYear, b.lesson = :lesson where b.id = :id")
    int update(@Param("bookName") String bookName, @Param("mainLanguage") String mainLanguage, @Param("printYear") String printYear, @Param("lesson") Lesson lesson, @Param("id") Long id);

//    @Query("select b from Book b where b.id = ?1")
//    Book findById(Long bookId);
}
