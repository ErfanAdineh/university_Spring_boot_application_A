package com.university.universityapplication_erfanadine.entity;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Setter
@Getter
public class BaseInformation extends BaseEntity{
    private String firstName;
    private String lastName;
    private String address;
    private String nationalCode;
    private String photo;
    private String phoneNumber;
}
