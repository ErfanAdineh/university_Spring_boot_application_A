package com.university.universityapplication_erfanadine.controller;

import com.university.universityapplication_erfanadine.dto.UnitOfUniversityDto;
import com.university.universityapplication_erfanadine.service.UnitOfUniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unitOfUniversity")
public class UnitOfUniversityController {


    @Autowired
    private UnitOfUniversityService unitOfUniversityService;

    @PostMapping
    public void save(UnitOfUniversityDto unitOfUniversityDto){
        unitOfUniversityService.save(unitOfUniversityDto);
    }
    @GetMapping
    public void findById(Long id){
        unitOfUniversityService.findById(id);
    }
    @PutMapping
    public void update(UnitOfUniversityDto unitOfUniversityDto){

        unitOfUniversityService.save(unitOfUniversityDto);
    }
}
