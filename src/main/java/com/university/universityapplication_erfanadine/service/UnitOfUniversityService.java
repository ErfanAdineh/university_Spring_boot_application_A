package com.university.universityapplication_erfanadine.service;

import com.university.universityapplication_erfanadine.dto.UnitOfUniversityDto;
import com.university.universityapplication_erfanadine.entity.Lesson;
import com.university.universityapplication_erfanadine.entity.Teacher;
import com.university.universityapplication_erfanadine.entity.UnitOfUniversity;
import com.university.universityapplication_erfanadine.repository.LessonRepo;
import com.university.universityapplication_erfanadine.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitOfUniversityService {

    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    public UnitOfUniversityDto convertUnitOfUniversityModelToUnitOfUniversityDto(UnitOfUniversity unitOfUniversity) {

        List<Long> teacher_longs = new ArrayList<>();
        List<Long> lesson_longs = new ArrayList<>();


        if (unitOfUniversity == null) {
            return null;
        }

        UnitOfUniversityDto unitOfUniversityDto = new UnitOfUniversityDto();

        unitOfUniversityDto.setId(unitOfUniversity.getId());
        unitOfUniversityDto.setNameOfUniversity_Unit(unitOfUniversity.getNameOfUniversity_Unit());
        unitOfUniversityDto.setCodeOfUnit(unitOfUniversity.getCodeOfUnit());

        List<Teacher> teachers = unitOfUniversity.getTeachers();
        if (teachers != null) {

            for (Teacher teacher : teachers) {
                teacher_longs.add(teacher.getId());
            }
            unitOfUniversityDto.setTeachers_Id(teacher_longs);
        }

        List<Lesson> lessons = unitOfUniversity.getLessons();
        if (lessons != null) {
            for (Lesson lesson : lessons) {
                lesson_longs.add(lesson.getId());
            }
            unitOfUniversityDto.setLessons_Id(lesson_longs);
        }

        return unitOfUniversityDto;
    }


    public UnitOfUniversity convertUnitOfUniversityDtoToUnitOfUniversityModel(UnitOfUniversityDto unitOfUniversityDto) {

        List<Teacher> teachers = new ArrayList<>();
        List<Lesson> lessons = new ArrayList<>();

        if (unitOfUniversityDto == null) {
            return null;
        }

        UnitOfUniversity unitOfUniversity = new UnitOfUniversity();

        unitOfUniversity.setId(unitOfUniversityDto.getId());
        unitOfUniversity.setNameOfUniversity_Unit(unitOfUniversityDto.getNameOfUniversity_Unit());
        unitOfUniversity.setCodeOfUnit(unitOfUniversityDto.getCodeOfUnit());

        List<Long> teachers_longs = unitOfUniversityDto.getTeachers_Id();
        if (teachers_longs != null) {

            for (Long teacherId : teachers_longs) {
                teachers.add(teacherRepo.findById(teacherId).orElse(null));
            }
            unitOfUniversity.setTeachers(teachers);
        }

        List<Long> lessons_longs = unitOfUniversityDto.getLessons_Id();
        if (lessons_longs != null) {

            for (Long lessonId : lessons_longs) {
                lessons.add(lessonRepo.findById(lessonId).orElse(null));
            }
            unitOfUniversity.setLessons(lessons);
        }

        return unitOfUniversity;
    }
}
