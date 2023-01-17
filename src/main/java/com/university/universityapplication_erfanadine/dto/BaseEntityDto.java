package com.university.universityapplication_erfanadine.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntityDto {

    private Long id;

}
