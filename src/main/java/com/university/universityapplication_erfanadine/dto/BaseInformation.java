package com.university.universityapplication_erfanadine.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseInformation extends BaseEntityDto {
    private String firstName;
    private String lastName;
    private String address;
    private String nationalCode;
    private String photo;
    private String phoneNumber;
}
