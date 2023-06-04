package com.university.universityapplication_erfanadine.repository;

import com.university.universityapplication_erfanadine.entity.UnitOfUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitOfUniversityRepo extends JpaRepository<UnitOfUniversity,Long> {

//    @Query("select u from UnitOfUniversity u where u.name = ?1")
//    UnitOfUniversity findByName(String name);
}
