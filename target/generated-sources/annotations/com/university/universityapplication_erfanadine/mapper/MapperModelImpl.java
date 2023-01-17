package com.university.universityapplication_erfanadine.mapper;

import com.university.universityapplication_erfanadine.dto.BookDto;
import com.university.universityapplication_erfanadine.dto.FoodWeekDto;
import com.university.universityapplication_erfanadine.dto.LessonDto;
import com.university.universityapplication_erfanadine.dto.StudentDto;
import com.university.universityapplication_erfanadine.dto.TeacherDto;
import com.university.universityapplication_erfanadine.dto.UnitOfUniversityDto;
import com.university.universityapplication_erfanadine.dto.WalletDto;
import com.university.universityapplication_erfanadine.entity.Book;
import com.university.universityapplication_erfanadine.entity.FoodWeek;
import com.university.universityapplication_erfanadine.entity.Lesson;
import com.university.universityapplication_erfanadine.entity.Student;
import com.university.universityapplication_erfanadine.entity.Teacher;
import com.university.universityapplication_erfanadine.entity.UnitOfUniversity;
import com.university.universityapplication_erfanadine.entity.Wallet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-17T16:28:36+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class MapperModelImpl implements MapperModel {

    @Override
    public BookDto convertBookModelToBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setBookName( book.getBookName() );
        bookDto.setMainLanguage( book.getMainLanguage() );
        bookDto.setPrintYear( book.getPrintYear() );
        bookDto.setLesson( book.getLesson() );

        return bookDto;
    }

    @Override
    public Book convertBookDtoToBookModel(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );
        book.setBookName( bookDto.getBookName() );
        book.setMainLanguage( bookDto.getMainLanguage() );
        book.setPrintYear( bookDto.getPrintYear() );
        book.setLesson( bookDto.getLesson() );

        return book;
    }

    @Override
    public FoodWeekDto convertFoodModelToFoodDto(FoodWeek foodWeek) {
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
        List<Student> list = foodWeek.getStudents();
        if ( list != null ) {
            foodWeekDto.setStudents( new ArrayList<Student>( list ) );
        }
        List<Teacher> list1 = foodWeek.getTeachers();
        if ( list1 != null ) {
            foodWeekDto.setTeachers( new ArrayList<Teacher>( list1 ) );
        }

        return foodWeekDto;
    }

    @Override
    public FoodWeek convertFoodDtoToFoodModel(FoodWeekDto foodWeekDto) {
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
        List<Student> list = foodWeekDto.getStudents();
        if ( list != null ) {
            foodWeek.setStudents( new ArrayList<Student>( list ) );
        }
        List<Teacher> list1 = foodWeekDto.getTeachers();
        if ( list1 != null ) {
            foodWeek.setTeachers( new ArrayList<Teacher>( list1 ) );
        }

        return foodWeek;
    }

    @Override
    public LessonDto convertLessonModelToLessonDto(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDto lessonDto = new LessonDto();

        lessonDto.setId( lesson.getId() );
        lessonDto.setNameOfCourse( lesson.getNameOfCourse() );
        lessonDto.setUniversityCourseUnit( lesson.getUniversityCourseUnit() );
        lessonDto.setUnitOfUniversity( convertUnitOfUniversityModelToUnitOfUniversityDto( lesson.getUnitOfUniversity() ) );
        List<Student> list = lesson.getStudents();
        if ( list != null ) {
            lessonDto.setStudents( new ArrayList<Student>( list ) );
        }
        List<Teacher> list1 = lesson.getTeachers();
        if ( list1 != null ) {
            lessonDto.setTeachers( new ArrayList<Teacher>( list1 ) );
        }
        List<Book> list2 = lesson.getBooks();
        if ( list2 != null ) {
            lessonDto.setBooks( new ArrayList<Book>( list2 ) );
        }

        return lessonDto;
    }

    @Override
    public Lesson convertLessonDtoToLessonModel(LessonDto lessonDto) {
        if ( lessonDto == null ) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setId( lessonDto.getId() );
        lesson.setNameOfCourse( lessonDto.getNameOfCourse() );
        lesson.setUniversityCourseUnit( lessonDto.getUniversityCourseUnit() );
        List<Student> list = lessonDto.getStudents();
        if ( list != null ) {
            lesson.setStudents( new ArrayList<Student>( list ) );
        }
        List<Teacher> list1 = lessonDto.getTeachers();
        if ( list1 != null ) {
            lesson.setTeachers( new ArrayList<Teacher>( list1 ) );
        }
        lesson.setUnitOfUniversity( convertUnitOfUniversityDtoToUnitOfUniversityModel( lessonDto.getUnitOfUniversity() ) );
        List<Book> list2 = lessonDto.getBooks();
        if ( list2 != null ) {
            lesson.setBooks( new ArrayList<Book>( list2 ) );
        }

        return lesson;
    }

    @Override
    public StudentDto convertStudentModelToStudentDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setId( student.getId() );
        List<FoodWeek> list = student.getFoodWeeks();
        if ( list != null ) {
            studentDto.setFoodWeeks( new ArrayList<FoodWeek>( list ) );
        }
        List<Lesson> list1 = student.getLessons();
        if ( list1 != null ) {
            studentDto.setLessons( new ArrayList<Lesson>( list1 ) );
        }
        studentDto.setWallet( student.getWallet() );

        return studentDto;
    }

    @Override
    public Student convertStudentDtoToStudentModel(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentDto.getId() );
        List<FoodWeek> list = studentDto.getFoodWeeks();
        if ( list != null ) {
            student.setFoodWeeks( new ArrayList<FoodWeek>( list ) );
        }
        List<Lesson> list1 = studentDto.getLessons();
        if ( list1 != null ) {
            student.setLessons( new ArrayList<Lesson>( list1 ) );
        }
        student.setWallet( studentDto.getWallet() );

        return student;
    }

    @Override
    public TeacherDto convertTeacherModelToTeacherDto(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDto teacherDto = new TeacherDto();

        teacherDto.setId( teacher.getId() );
        List<FoodWeek> list = teacher.getFoodWeeks();
        if ( list != null ) {
            teacherDto.setFoodWeeks( new ArrayList<FoodWeek>( list ) );
        }
        List<Lesson> list1 = teacher.getLessons();
        if ( list1 != null ) {
            teacherDto.setLessons( new ArrayList<Lesson>( list1 ) );
        }
        List<UnitOfUniversity> list2 = teacher.getUnitOfUniversities();
        if ( list2 != null ) {
            teacherDto.setUnitOfUniversities( new ArrayList<UnitOfUniversity>( list2 ) );
        }

        return teacherDto;
    }

    @Override
    public Teacher convertTeacherDtoToTeacherModel(TeacherDto teacherDto) {
        if ( teacherDto == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId( teacherDto.getId() );
        List<FoodWeek> list = teacherDto.getFoodWeeks();
        if ( list != null ) {
            teacher.setFoodWeeks( new ArrayList<FoodWeek>( list ) );
        }
        List<Lesson> list1 = teacherDto.getLessons();
        if ( list1 != null ) {
            teacher.setLessons( new ArrayList<Lesson>( list1 ) );
        }
        List<UnitOfUniversity> list2 = teacherDto.getUnitOfUniversities();
        if ( list2 != null ) {
            teacher.setUnitOfUniversities( new ArrayList<UnitOfUniversity>( list2 ) );
        }

        return teacher;
    }

    @Override
    public UnitOfUniversityDto convertUnitOfUniversityModelToUnitOfUniversityDto(UnitOfUniversity unitOfUniversity) {
        if ( unitOfUniversity == null ) {
            return null;
        }

        UnitOfUniversityDto unitOfUniversityDto = new UnitOfUniversityDto();

        unitOfUniversityDto.setId( unitOfUniversity.getId() );
        unitOfUniversityDto.setNameOfUniversity_Unit( unitOfUniversity.getNameOfUniversity_Unit() );
        unitOfUniversityDto.setCodeOfUnit( unitOfUniversity.getCodeOfUnit() );
        List<Teacher> list = unitOfUniversity.getTeachers();
        if ( list != null ) {
            unitOfUniversityDto.setTeachers( new ArrayList<Teacher>( list ) );
        }
        List<Lesson> list1 = unitOfUniversity.getLessons();
        if ( list1 != null ) {
            unitOfUniversityDto.setLessons( new ArrayList<Lesson>( list1 ) );
        }

        return unitOfUniversityDto;
    }

    @Override
    public UnitOfUniversity convertUnitOfUniversityDtoToUnitOfUniversityModel(UnitOfUniversityDto unitOfUniversityDto) {
        if ( unitOfUniversityDto == null ) {
            return null;
        }

        UnitOfUniversity unitOfUniversity = new UnitOfUniversity();

        unitOfUniversity.setId( unitOfUniversityDto.getId() );
        unitOfUniversity.setNameOfUniversity_Unit( unitOfUniversityDto.getNameOfUniversity_Unit() );
        unitOfUniversity.setCodeOfUnit( unitOfUniversityDto.getCodeOfUnit() );
        List<Teacher> list = unitOfUniversityDto.getTeachers();
        if ( list != null ) {
            unitOfUniversity.setTeachers( new ArrayList<Teacher>( list ) );
        }
        List<Lesson> list1 = unitOfUniversityDto.getLessons();
        if ( list1 != null ) {
            unitOfUniversity.setLessons( new ArrayList<Lesson>( list1 ) );
        }

        return unitOfUniversity;
    }

    @Override
    public WalletDto convertWalletModelToWalletDto(Wallet wallet) {
        if ( wallet == null ) {
            return null;
        }

        WalletDto walletDto = new WalletDto();

        walletDto.setId( wallet.getId() );
        walletDto.setCash( wallet.getCash() );
        walletDto.setStudent( wallet.getStudent() );

        return walletDto;
    }

    @Override
    public Wallet convertWalletDtoToWalletModel(WalletDto walletDto) {
        if ( walletDto == null ) {
            return null;
        }

        Wallet wallet = new Wallet();

        wallet.setId( walletDto.getId() );
        wallet.setCash( walletDto.getCash() );
        wallet.setStudent( walletDto.getStudent() );

        return wallet;
    }
}
