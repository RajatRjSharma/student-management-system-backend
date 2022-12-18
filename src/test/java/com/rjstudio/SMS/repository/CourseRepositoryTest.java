package com.rjstudio.SMS.repository;

import com.rjstudio.SMS.entity.Course;
import com.rjstudio.SMS.entity.Student;
import com.rjstudio.SMS.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepository.findAll();

        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Rampur")
                .lastName("Das")
                .build();

        Course course = Course.builder()
                .title("Business")
                .credit(3)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTWoRecords = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(secondPageWithTWoRecords).getContent();

        Long totalElements = courseRepository.findAll(secondPageWithTWoRecords).getTotalElements();

        Integer totalPages = courseRepository.findAll(secondPageWithTWoRecords).getTotalPages();

        System.out.println(courses);
        System.out.println(totalElements);
        System.out.println(totalPages);
    }

    @Test
    public void findAllWithSorting() {
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println(courses);

        List<Course> courses1 = courseRepository.findAll(Sort.by("title"));
        System.out.println(courses1);

        List<Course> courses2 = courseRepository.findAll(Sort.by("credit").descending());
        System.out.println(courses2);

        List<Course> courses3 = courseRepository.findAll(Sort.by("credit","title").descending());
        System.out.println(courses3);
    }

    @Test
    public void printByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining("D",firstPageTenRecords).getContent();

        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .lastName("Singh")
                .firstName("Para")
                .build();

        Student student = Student.builder()
                .firstName("RaDas")
                .lastName("SSingh")
                .emailId("ramdas@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(4)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }

}