package com.university.universityapplication_erfanadine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Student extends BaseInformation {

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "student_food",
            joinColumns = {@JoinColumn(name = "student_Id")},
            inverseJoinColumns = {@JoinColumn(name = "food_Id")})
    private List<FoodWeek> foodWeeks = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name ="student_lesson",
            joinColumns ={@JoinColumn(name = "student_Id")} ,
            inverseJoinColumns = {@JoinColumn(name = "lesson_Id")})
    private List<Lesson> lessons = new ArrayList<>();

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "wallet_Id")
    private Wallet wallet;

}
