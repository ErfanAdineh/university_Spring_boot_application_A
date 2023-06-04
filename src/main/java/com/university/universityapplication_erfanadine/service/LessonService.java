package com.university.universityapplication_erfanadine.service;

import com.university.universityapplication_erfanadine.dto.LessonDto;
import com.university.universityapplication_erfanadine.entity.Book;
import com.university.universityapplication_erfanadine.entity.Lesson;
import com.university.universityapplication_erfanadine.entity.Student;
import com.university.universityapplication_erfanadine.entity.Teacher;
import com.university.universityapplication_erfanadine.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private UnitOfUniversityRepo unitOfUniversityRepo;


    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private BookRepo bookRepo;


    public LessonDto save(LessonDto lessonDto) {
        return convertLessonModelToLessonDto(lessonRepo.save(convertLessonDtoToLessonModel(lessonDto)));
    }

    public LessonDto update(LessonDto lessonDto) {
        return convertLessonModelToLessonDto(lessonRepo.save(convertLessonDtoToLessonModel(lessonDto)));
    }

    public LessonDto findById(Long id) {
        return convertLessonModelToLessonDto(lessonRepo.findById(id).orElseThrow(() ->
                new RuntimeException("not found lesson by this id : " + id)));
    }

    public LessonDto findByName(String nameOfCourse) {
        return convertLessonModelToLessonDto(lessonRepo.findByNameOfCourse(nameOfCourse));
    }



    public LessonDto convertLessonModelToLessonDto(Lesson lesson) {

        List<Long> student_longs = new ArrayList<>();
        List<Long> teacher_longs = new ArrayList<>();
        List<Long> book_longs = new ArrayList<>();


        if (lesson == null) {
            return null;
        }

        LessonDto lessonDto = new LessonDto();

        lessonDto.setId(lesson.getId());
        lessonDto.setNameOfCourse(lesson.getNameOfCourse());
        lessonDto.setUniversityCourseUnit(lesson.getUniversityCourseUnit());
        lessonDto.setUnitOfUniversity(lesson.getUnitOfUniversity().getId());

        List<Student> students = lesson.getStudents();
        if (students != null) {

            for (Student student : students) {
                student_longs.add(student.getId());
            }
            lessonDto.setStudents_Id(student_longs);
        }

        List<Teacher> teachers = lesson.getTeachers();
        if (teachers != null) {
            for (Teacher teacher : teachers) {
                student_longs.add(teacher.getId());
            }
            lessonDto.setTeachers_Id(teacher_longs);
        }

        List<Book> books = lesson.getBooks();
        if (books != null) {
            for (Book book : books) {
                student_longs.add(book.getId());
            }
            lessonDto.setBooks_Id(book_longs);
        }

        return lessonDto;
    }


    public Lesson convertLessonDtoToLessonModel(LessonDto lessonDto) {
        List<Student> student_longs = new ArrayList<>();
        List<Teacher> teacher_longs = new ArrayList<>();
        List<Book> book_longs = new ArrayList<>();

        if (lessonDto == null) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setId(lessonDto.getId());
        lesson.setNameOfCourse(lessonDto.getNameOfCourse());
        lesson.setUniversityCourseUnit(lessonDto.getUniversityCourseUnit());
        List<Long> students = lessonDto.getStudents_Id();
        if (students != null) {

            for (Long student : students) {
                student_longs.add(studentRepo.findById(student).orElse(null));
            }
            lesson.setStudents(student_longs);
        }
        List<Long> teachers = lessonDto.getTeachers_Id();
        if (teachers != null) {

            for (Long teacher : teachers) {
                teacher_longs.add(teacherRepo.findById(teacher).orElse(null));
            }
            lesson.setTeachers(teacher_longs);
        }

        lesson.setUnitOfUniversity(unitOfUniversityRepo.findById(lessonDto.getUnitOfUniversity()).get());
        List<Long> books = lessonDto.getBooks_Id();
        if (books != null) {

            for (Long book : books) {
                teacher_longs.add(teacherRepo.findById(book).orElse(null));
            }
            lesson.setBooks(book_longs);
        }

        return lesson;
    }
}
