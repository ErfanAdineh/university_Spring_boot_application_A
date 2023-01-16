package com.university.universityapplication_erfanadine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class UnitOfUniversity extends BaseEntity{

    private String nameOfUniversity_Unit;
    private String codeOfUnit;

    @ManyToMany(mappedBy = "unitOfUniversities")
    private List<Teacher> teachers = new ArrayList<>();

    @OneToMany(mappedBy = "unitOfUniversity")
    private List<Lesson> lessons = new ArrayList<>();
}
