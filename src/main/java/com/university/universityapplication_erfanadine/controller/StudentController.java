package com.university.universityapplication_erfanadine.controller;

import com.university.universityapplication_erfanadine.dto.StudentDto;
import com.university.universityapplication_erfanadine.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping
    public void save(StudentDto studentDto){
        studentService.save(studentDto);
    }
    @GetMapping
    public void findById(Long id){
        studentService.findById(id);
    }
    @PutMapping
    public void update(StudentDto studentDto){

        studentService.save(studentDto);
    }
}
