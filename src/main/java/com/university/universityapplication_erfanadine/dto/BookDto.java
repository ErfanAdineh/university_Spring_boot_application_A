package com.university.universityapplication_erfanadine.dto;

import com.university.universityapplication_erfanadine.entity.Lesson;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BookDto extends BaseEntityDto {
    private String bookName;
    private String mainLanguage;
    private String printYear;
    private Long lessonId;

}



