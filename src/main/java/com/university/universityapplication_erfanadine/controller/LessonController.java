package com.university.universityapplication_erfanadine.controller;

import com.university.universityapplication_erfanadine.dto.LessonDto;
import com.university.universityapplication_erfanadine.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping
    public void save(LessonDto lessonDto){
        lessonService.save(lessonDto);
    }
    @GetMapping
    public void findById(Long id){
        lessonService.findById(id);
    }
    @PutMapping
    public void update(LessonDto lessonDto){
        lessonService.save(lessonDto);
    }
}
