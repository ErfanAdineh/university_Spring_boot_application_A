package com.university.universityapplication_erfanadine.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Book extends BaseEntity {
    private String bookName;
    private String mainLanguage;
    private String printYear;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "lesson_ID")
    private Lesson lesson;

//    @ElementCollection
//    @CollectionTable(name="writers")
//    private List<Long> writers = new ArrayList<>();
//    @ElementCollection
//    @CollectionTable(name="translators")
//    private List<Long> translators = new ArrayList<>();
}
