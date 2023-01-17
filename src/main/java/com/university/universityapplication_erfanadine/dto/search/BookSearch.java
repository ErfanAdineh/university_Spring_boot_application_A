package com.university.universityapplication_erfanadine.dto.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSearch {
   private String name;
   private String language;
   private String printYear;
   private int page;
   private int size;
}
