package com.university.universityapplication_erfanadine.controller;

import com.university.universityapplication_erfanadine.dto.TeacherDto;
import com.university.universityapplication_erfanadine.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public void save(TeacherDto teacherDto){
        teacherService.save(teacherDto);
    }
    @GetMapping
    public void findById(Long id){
        teacherService.findById(id);
    }
    @PutMapping
    public void update(TeacherDto teacherDto){
        teacherService.save(teacherDto);
    }
}
