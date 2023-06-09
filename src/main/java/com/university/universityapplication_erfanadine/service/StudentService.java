package com.university.universityapplication_erfanadine.service;

import com.university.universityapplication_erfanadine.dto.StudentDto;
import com.university.universityapplication_erfanadine.entity.FoodWeek;
import com.university.universityapplication_erfanadine.entity.Lesson;
import com.university.universityapplication_erfanadine.entity.Student;
import com.university.universityapplication_erfanadine.repository.FoodWeekRepo;
import com.university.universityapplication_erfanadine.repository.LessonRepo;
import com.university.universityapplication_erfanadine.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private FoodWeekRepo foodWeekRepo;

    @Autowired
    private WalletService walletService;
    private Long studentId;


    public StudentDto save(StudentDto lessonDto) {
        Student student = studentRepo.save(convertStudentDtoToStudentModel(lessonDto));
        studentId = student.getId();
        return convertStudentModelToStudentDto(student);
    }

    public StudentDto update(StudentDto lessonDto) {
        return convertStudentModelToStudentDto(studentRepo.save(convertStudentDtoToStudentModel(lessonDto)));
    }

    public StudentDto findById(Long id) {
        return convertStudentModelToStudentDto(studentRepo.findById(id).orElseThrow(() ->
                new RuntimeException("not found student by this id : " + id)));
    }

    public StudentDto findByName(String firstName, String lastName) {
        return convertStudentModelToStudentDto(studentRepo.findByFirstNameAndLastName(firstName, lastName));

//                .orElseThrow(() ->
//                new RuntimeException("not found student by this full firstName : " + firstName + " lastName : " + lastName))
    }


    public StudentDto convertStudentModelToStudentDto(Student student) {

        List<Long> foodWeeks_Longs = new ArrayList<>();
        List<Long> lessons_Longs = new ArrayList<>();


        if (student == null) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setId(student.getId());


        List<FoodWeek> foodWeeks = student.getFoodWeeks();
        if (foodWeeks != null) {
            for (FoodWeek foodWeek : foodWeeks) {
                foodWeeks_Longs.add(foodWeek.getId());
            }
            studentDto.setFoodWeeks_Id(foodWeeks_Longs);
        }


        List<Lesson> lessons = student.getLessons();
        if (lessons != null) {
            for (Lesson lesson : lessons) {
                lessons_Longs.add(lesson.getId());
            }
            studentDto.setLessons_Id(lessons_Longs);
        }

        student.getWallet().setStudent(student);
        studentDto.setWallet(walletService.convertWalletModelToWalletDto(student.getWallet()));

        return studentDto;
    }


    public Student convertStudentDtoToStudentModel(StudentDto studentDto) {

        List<FoodWeek> foodWeeks = new ArrayList<>();
        List<Lesson> lessons = new ArrayList<>();

        if (studentDto == null) {
            return null;
        }

        Student student = new Student();

        student.setId(studentDto.getId());


        List<Long> foodWeek_longs = studentDto.getFoodWeeks_Id();
        if (foodWeek_longs != null) {
            for (Long foodWeekId : foodWeek_longs) {
                foodWeeks.add(foodWeekRepo.findById(foodWeekId).orElse(null));
            }
            student.setFoodWeeks(foodWeeks);
        }


        List<Long> lesson_longs = studentDto.getLessons_Id();
        if (lesson_longs != null) {
            for (Long lessonId : lesson_longs) {
                lessons.add(lessonRepo.findById(lessonId).orElse(null));
            }
            student.setLessons(lessons);
        }
        studentDto.getWallet().setStudentId(studentId);
        student.setWallet(walletService.convertWalletDtoToWalletModel(studentDto.getWallet()));

        return student;
    }

}
