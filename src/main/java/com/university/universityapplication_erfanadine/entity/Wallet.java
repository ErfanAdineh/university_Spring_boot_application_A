package com.university.universityapplication_erfanadine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Setter
@Getter
public class Wallet extends BaseEntity{

    private BigInteger cash;

    @OneToOne(mappedBy = "wallet")
    private Student student;
}
