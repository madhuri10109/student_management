package com.example.management;

import com.example.management.Controller.StudentController;
import com.example.management.Entity.Student;
import com.example.management.Service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class StudentControllerTest {
    @Mock
    private StudentService studentService;
    @InjectMocks
    private StudentController studentController;

    @Test
    public void insertTheStudentTest() {
        Student student = new Student(1, "aaa", 25, 'f');
        Mockito.when(studentService.insert(student)).thenReturn(student);
        ResponseEntity<Student> responseEntity = studentController.insertTheStudent(student);
        Integer statusCode = responseEntity.getStatusCode().value();
        Assertions.assertEquals(statusCode, 201);
        Student student1 = responseEntity.getBody();
        Assertions.assertNotNull(student1);
        Assertions.assertEquals("aaa", student1.getName());
        Assertions.assertEquals(25, student1.getAge());
        Assertions.assertEquals('f', student1.getGender());


    }

    @Test
    public void insertAllStudentsTest() {
        List<Student> students = Arrays.asList(new Student(1, "aaa", 25, 'f'),
                new Student(2, "bbb", 24, 'm'));
        Mockito.when(studentService.insertAllStudents(students)).thenReturn(students);
        ResponseEntity<List<Student>> responseEntity = studentController.insertAllStudents(students);
        Integer statusCode = responseEntity.getStatusCode().value();
        Assertions.assertEquals(statusCode, 201);


    }
//    @Test
//    public void testGetAllStudents() {
//        List<Student> students = Arrays.asList();
//        Mockito.when(studentService.getAllStudents()).thenReturn(students);
//        ResponseEntity<List<Student>> responseEntity = studentController.findAllTheStudentss();
//        Integer statusCode = responseEntity.getStatusCode().value();
//        Assertions.assertEquals(statusCode, 200);
//    }
//    @Test
//public void testGetStudentById() {
//        Student student = new Student(1, "aaa", 25, 'f');
//        Mockito.when(studentService.getStudentById(1)).thenReturn(student);
//        ResponseEntity<Student> responseEntity=studentController.findByStudentId()
//        Integer statusCode = responseEntity.getStatusCode().value();
//        Assertions.assertEquals(statusCode, 200);
//}
//@Test
//public void testUpdateStudent() {
//        Student student = new Student(1, "aaa", 25, 'f');
//        Mockito.when(studentService.updateStudent());
//        ResponseEntity<Student> responseEntity=studentController.updateStudentById()
//                Integer statusCode = responseEntity.getStatusCode().value();
//        Assertions.assertEquals(statusCode, 200);
//
//
//}
//@Test
//public void testDeleteStudentById() {
//Student student = new Student(1, "aaa", 25, 'f');
//Mockito.when(studentService.deleteStudentById(2));
//ResponseEntity<Student> responseEntity=studentController.deleteStudentById()
//        Integer statusCode = responseEntity.getStatusCode().value();
//Assertions.assertEquals(statusCode, 200);
//
//}

    }
