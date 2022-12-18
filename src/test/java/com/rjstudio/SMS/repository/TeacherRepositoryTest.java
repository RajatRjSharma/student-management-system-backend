package com.rjstudio.SMS.repository;

import com.rjstudio.SMS.entity.Course;
import com.rjstudio.SMS.entity.CourseMaterial;
import com.rjstudio.SMS.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course course1 = Course.builder()
                .title("DB")
                .credit(4)
                .build();

        Course course2 = Course.builder()
                .title("WEB")
                .credit(3)
                .build();

        Course course3 = Course.builder()
                .title("JAVA")
                .credit(2)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Vikash")
                .lastName("Sharma")
                //.courses(List.of(course1,course2,course3))
                .build();

        teacherRepository.save(teacher);
    }

    @Test
    public void printTeacher() {
        List<Teacher> listTeacher = teacherRepository.findAll();

        System.out.println(listTeacher);
    }

}