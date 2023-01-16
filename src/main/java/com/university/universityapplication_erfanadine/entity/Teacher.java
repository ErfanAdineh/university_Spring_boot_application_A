package com.university.universityapplication_erfanadine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Teacher extends BaseInformation {

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "teacher_food",
            joinColumns = {@JoinColumn(name = "teacher_Id")},
            inverseJoinColumns = {@JoinColumn(name = "food_Id")})
    private List<FoodWeek> foodWeeks = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "teacher_lesson",
            joinColumns = {@JoinColumn(name = "teacher_Id")},
            inverseJoinColumns = {@JoinColumn(name = "lesson_Id")})
    private List<Lesson> lessons = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "teacher_unitOfUniversity",
            joinColumns = {@JoinColumn(name = "teacher_Id")},
            inverseJoinColumns = {@JoinColumn(name = "unit_university_Id")})
    private List<UnitOfUniversity> unitOfUniversities = new ArrayList<>();
}
