package com.rjstudio.SMS.repository;

import com.rjstudio.SMS.entity.Guardian;
import com.rjstudio.SMS.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("two@gmail.com")
                .firstName("Ram")
                .lastName("Prasad")
                .guardian(new Guardian("Sam Prasad", "guard@gmail.com", "9999999999"))
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("guardian@mail.com")
                .name("Guardian Ram")
                .mobile("8888888888")
                .build();

        Student student = Student.builder()
                .emailId("three@gmail.com")
                .firstName("Sam")
                .lastName("Prasad")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstname() {
        List<Student> studentList = studentRepository.findByFirstName("Ram");

        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstnameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("am");

        System.out.println(studentList);
    }

    @Test
    public void printStudentByGuardianNameNotNull() {
        List<Student> studentList = studentRepository.findByGuardianNameNotNull();

        System.out.println(studentList);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("two@gmail.com");

        System.out.println(student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String student = studentRepository.getStudentFirstNameByEmailAddress("two@gmail.com");

        System.out.println(student);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("two@gmail.com");

        System.out.println(student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeWithParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("two@gmail.com");

        System.out.println(student);
    }

    @Test
    public void updateStudentFirstNameByEmailId() {
        int student = studentRepository.updateStudentNameByEmailId("RahulJi", "two@gmail.com");
        System.out.println(student);
    }
}