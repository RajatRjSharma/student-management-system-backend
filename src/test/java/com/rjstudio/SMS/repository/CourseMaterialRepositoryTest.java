package com.rjstudio.SMS.repository;

import com.rjstudio.SMS.entity.Course;
import com.rjstudio.SMS.entity.CourseMaterial;
import com.rjstudio.SMS.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("1Google")
                .credit(3)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.1google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> listOfCourseMaterial = courseMaterialRepository.findAll();

        System.out.println(listOfCourseMaterial);
    }
}