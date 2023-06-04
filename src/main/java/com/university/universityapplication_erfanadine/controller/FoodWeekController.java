package com.university.universityapplication_erfanadine.controller;

import com.university.universityapplication_erfanadine.dto.FoodWeekDto;
import com.university.universityapplication_erfanadine.service.FoodWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodWeekController {

    @Autowired
    private FoodWeekService foodWeekService;

    @PostMapping
    public void save(FoodWeekDto foodWeekDto) {
        foodWeekService.save(foodWeekDto);
    }

    @GetMapping
    public void findById(Long id) {
        foodWeekService.findById(id);
    }

    @PutMapping
    public void update(FoodWeekDto foodWeekDto) {
        foodWeekService.save(foodWeekDto);
    }

}
