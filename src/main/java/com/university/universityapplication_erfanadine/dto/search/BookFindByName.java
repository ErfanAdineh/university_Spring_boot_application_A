package com.university.universityapplication_erfanadine.dto.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookFindByName {
   private String bookName;
   private int page;
   private int size;
}
