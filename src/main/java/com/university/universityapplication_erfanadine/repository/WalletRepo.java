package com.university.universityapplication_erfanadine.repository;

import com.university.universityapplication_erfanadine.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepo extends JpaRepository<Wallet,Long> {
}
