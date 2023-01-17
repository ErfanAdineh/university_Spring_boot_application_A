package com.university.universityapplication_erfanadine.dto;

import com.university.universityapplication_erfanadine.entity.FoodWeek;
import com.university.universityapplication_erfanadine.entity.Lesson;
import com.university.universityapplication_erfanadine.entity.Wallet;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class StudentDto extends BaseInformation {

    private List<Long> foodWeeks_Id = new ArrayList<>();

    private List<Long> lessons_Id = new ArrayList<>();

    private Wallet wallet;

}
