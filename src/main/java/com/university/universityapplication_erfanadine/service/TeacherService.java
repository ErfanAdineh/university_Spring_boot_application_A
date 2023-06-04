package com.university.universityapplication_erfanadine.service;

import com.university.universityapplication_erfanadine.dto.TeacherDto;
import com.university.universityapplication_erfanadine.entity.FoodWeek;
import com.university.universityapplication_erfanadine.entity.Lesson;
import com.university.universityapplication_erfanadine.entity.Teacher;
import com.university.universityapplication_erfanadine.entity.UnitOfUniversity;
import com.university.universityapplication_erfanadine.repository.FoodWeekRepo;
import com.university.universityapplication_erfanadine.repository.LessonRepo;
import com.university.universityapplication_erfanadine.repository.TeacherRepo;
import com.university.universityapplication_erfanadine.repository.UnitOfUniversityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {


    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private FoodWeekRepo foodWeekRepo;

    @Autowired
    private UnitOfUniversityRepo unitOfUniversityRepo;



    @Autowired
    public TeacherRepo teacherRepo;

    public TeacherDto save(TeacherDto lessonDto) {
        return convertTeacherModelToTeacherDto(teacherRepo.save(convertTeacherDtoToTeacherModel(lessonDto)));
    }

    public TeacherDto update(TeacherDto lessonDto) {
        return convertTeacherModelToTeacherDto(teacherRepo.save(convertTeacherDtoToTeacherModel(lessonDto)));
    }

    public TeacherDto findById(Long id) {
        return convertTeacherModelToTeacherDto(teacherRepo.findById(id).orElseThrow(() ->
                new RuntimeException("not found teacher by this id : " + id)));
    }

    public TeacherDto findByName(String firstName, String lastName) {
        return convertTeacherModelToTeacherDto(teacherRepo.findByFirstNameAndLastName(firstName, lastName));
//        .orElseThrow(() ->
//                new RuntimeException("not found teacher by this full firstName : " + firstName + " lastName : " + lastName))
    }



    public TeacherDto convertTeacherModelToTeacherDto(Teacher teacher) {

        List<Long> foodWeeks_Longs = new ArrayList<>();
        List<Long> lessons_Longs = new ArrayList<>();
        List<Long> unitOfUniversities_Longs = new ArrayList<>();


        if ( teacher == null ) {
            return null;
        }

        TeacherDto teacherDto = new TeacherDto();

        teacherDto.setId( teacher.getId() );

        List<FoodWeek> foodWeeks = teacher.getFoodWeeks();
        if ( foodWeeks != null ) {
            for (FoodWeek foodWeek : foodWeeks) {
                foodWeeks_Longs.add(foodWeek.getId());
            }
            teacherDto.setFoodWeeks_Id(foodWeeks_Longs);
        }
        List<Lesson> lessons = teacher.getLessons();
        if ( lessons != null ) {
            for (Lesson lesson :lessons ) {
                lessons_Longs.add(lesson.getId());
            }
            teacherDto.setLessons_Id(lessons_Longs);
        }
        List<UnitOfUniversity> unitOfUniversities = teacher.getUnitOfUniversities();
        if ( unitOfUniversities != null ) {
            for (UnitOfUniversity unitOfUniversity : unitOfUniversities) {
                unitOfUniversities_Longs.add(unitOfUniversity.getId());
            }
            teacherDto.setUnitOfUniversities_Id(unitOfUniversities_Longs);
        }

        return teacherDto;
    }


    public Teacher convertTeacherDtoToTeacherModel(TeacherDto teacherDto) {
        List<FoodWeek> foodWeeks = new ArrayList<>();
        List<Lesson> lessons = new ArrayList<>();
        List<UnitOfUniversity> unitOfUniversities = new ArrayList<>();

        if ( teacherDto == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId(teacherDto.getId());

        List<Long> foodWeek_longs = teacherDto.getFoodWeeks_Id();
        if ( foodWeek_longs != null ) {
            for (Long foodWeekId : foodWeek_longs) {
                foodWeeks.add(foodWeekRepo.findById(foodWeekId).orElse(null));
            }
            teacher.setFoodWeeks(foodWeeks);
        }


        List<Long> lesson_longs = teacherDto.getLessons_Id();
        if ( lesson_longs != null ) {

            for (Long lesson : lesson_longs) {
                lessons.add(lessonRepo.findById(lesson).orElse(null));
            }
            teacher.setLessons(lessons);
        }


        List<Long> unitOfUniversities_longs = teacherDto.getUnitOfUniversities_Id();
        if ( unitOfUniversities_longs != null ) {
            for (Long unitOfUniversity : unitOfUniversities_longs) {
                unitOfUniversities.add(unitOfUniversityRepo.findById(unitOfUniversity).orElse(null));
            }
            teacher.setUnitOfUniversities( unitOfUniversities );
        }

        return teacher;
    }
}
