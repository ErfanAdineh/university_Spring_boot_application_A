package com.university.universityapplication_erfanadine.dto;

import com.university.universityapplication_erfanadine.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Setter
@Getter
public class WalletDto extends BaseEntityDto {

    private BigInteger cash;
    private Student student;

}
