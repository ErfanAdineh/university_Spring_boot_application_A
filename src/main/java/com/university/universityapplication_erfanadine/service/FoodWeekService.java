package com.university.universityapplication_erfanadine.service;

import com.university.universityapplication_erfanadine.dto.FoodWeekDto;
import com.university.universityapplication_erfanadine.entity.FoodWeek;
import com.university.universityapplication_erfanadine.entity.Student;
import com.university.universityapplication_erfanadine.entity.Teacher;
import com.university.universityapplication_erfanadine.repository.StudentRepo;
import com.university.universityapplication_erfanadine.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodWeekService {

@Autowired
private StudentRepo studentRepo;

@Autowired
private TeacherRepo teacherRepo;















    public FoodWeekDto convertFoodModelToFoodDto(FoodWeek foodWeek) {


        List<Long>  student_longs = new ArrayList<>();
        List<Long>  teacher_longs = new ArrayList<>();

        if ( foodWeek == null ) {
            return null;
        }

        FoodWeekDto foodWeekDto = new FoodWeekDto();

        foodWeekDto.setId( foodWeek.getId() );
        foodWeekDto.setFoodName( foodWeek.getFoodName() );
        foodWeekDto.setDays( foodWeek.getDays() );
        foodWeekDto.setFoodDeliveryDateToCustomer( foodWeek.getFoodDeliveryDateToCustomer() );
        foodWeekDto.setFoodDeliveryTimeToCustomer( foodWeek.getFoodDeliveryTimeToCustomer() );
        foodWeekDto.setIsReceived( foodWeek.getIsReceived() );
        foodWeekDto.setFoodIsReady( foodWeek.getFoodIsReady() );
        List<Student> students = foodWeek.getStudents();
        if ( students != null ) {
            for (int i = 0; i <students.size(); i++) {
                student_longs.add(students.get(i).getId());
            }
            foodWeekDto.setStudents_Id( student_longs );
        }
        List<Teacher> teachers = foodWeek.getTeachers();
        if ( teachers != null ) {

            for (int i = 0; i <teachers.size(); i++) {
                teacher_longs.add(teachers.get(i).getId());
            }
            foodWeekDto.setTeachers_Id( teacher_longs );
        }

        return foodWeekDto;
    }


    public FoodWeek convertFoodDtoToFoodModel(FoodWeekDto foodWeekDto) {
        List<Teacher> listOfTeachers = new ArrayList<>();
        List<Student> listOfStudents = new ArrayList<>();

        if ( foodWeekDto == null ) {
            return null;
        }

        FoodWeek foodWeek = new FoodWeek();

        foodWeek.setId( foodWeekDto.getId() );
        foodWeek.setFoodName( foodWeekDto.getFoodName() );
        foodWeek.setDays( foodWeekDto.getDays() );
        foodWeek.setFoodDeliveryDateToCustomer( foodWeekDto.getFoodDeliveryDateToCustomer() );
        foodWeek.setFoodDeliveryTimeToCustomer( foodWeekDto.getFoodDeliveryTimeToCustomer() );
        foodWeek.setIsReceived( foodWeekDto.getIsReceived() );
        foodWeek.setFoodIsReady( foodWeekDto.getFoodIsReady() );

        List<Long> students = foodWeekDto.getStudents_Id();
        if ( students != null ) {
            for (int i = 0; i < students.size(); i++) {
                Student student = studentRepo.findById(students.get(i)).get();
                listOfStudents.add(student);
            }
            foodWeek.setStudents( listOfStudents );
        }

        List<Long> teachers = foodWeekDto.getTeachers_Id();
        if ( teachers != null ) {

            for (int i = 0; i < teachers.size(); i++) {
                Teacher teacher = teacherRepo.findById(teachers.get(i)).get();
                listOfTeachers.add(teacher);
            }

            foodWeek.setTeachers( listOfTeachers);
        }

        return foodWeek;
    }
}
