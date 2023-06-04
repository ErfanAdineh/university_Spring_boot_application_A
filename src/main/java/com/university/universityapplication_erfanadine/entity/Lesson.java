package com.university.universityapplication_erfanadine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Lesson extends BaseEntity {

    private String nameOfCourse;
    private Integer universityCourseUnit;

    @ManyToMany(mappedBy = "lessons",cascade = CascadeType.DETACH)
    private List<Student>  students = new ArrayList<>();

    @ManyToMany(mappedBy = "lessons",cascade = CascadeType.DETACH)
    private List<Teacher>  teachers = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "unit_university_ID")
    private UnitOfUniversity unitOfUniversity;

    @OneToMany(mappedBy = "lesson",cascade = CascadeType.DETACH)
    private List<Book> books = new ArrayList<>();


}
