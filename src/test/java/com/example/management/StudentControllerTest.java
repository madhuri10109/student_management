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
import org.springframework.http.HttpStatus;
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
        Mockito.verify(studentService, Mockito.times(1)).insert(student);



    }

    @Test
    public void insertAllStudentsTest() {
        List<Student> students = Arrays.asList(new Student(1, "aaa", 25, 'f'),
                new Student(2, "bbb", 24, 'm'));
        Mockito.when(studentService.insertAllStudents(students)).thenReturn(students);
        ResponseEntity<List<Student>> responseEntity = studentController.insertAllStudents(students);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertEquals(2, responseEntity.getBody().size());
        Assertions.assertEquals("xxx", responseEntity.getBody().get(0).getName());
        Mockito.verify(studentService, Mockito.times(1)).insertAllStudents(students);




    }
    @Test
    public void testGetAllStudents() {
        List<Student> students = Arrays.asList(new Student(1,"xxx",25,'f'),
                new Student(2,"yyy",24,'m'));
        Mockito.when(studentService.getAllStudents()).thenReturn(students);
        ResponseEntity<List<Student>> responseEntity = studentController.findAllTheStudentss();
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(2, responseEntity.getBody().size());
        Assertions.assertEquals("xxx", responseEntity.getBody().get(0).getName());
        Mockito.verify(studentService, Mockito.times(1)).getAllStudents();




    }
    @Test
public void testGetStudentById() {
        Integer id = 1;
        Student student = new Student(1, "aaa", 25, 'f');
        Mockito.when(studentService.getStudentById(1)).thenReturn(student);
        ResponseEntity<Student> responseEntity=studentController.findByStudentId(id);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        Assertions.assertEquals(student,responseEntity.getBody());
        Assertions.assertEquals("aaa", responseEntity.getBody().getName());
        Assertions.assertEquals(25, responseEntity.getBody().getAge());
        Assertions.assertEquals('f', responseEntity.getBody().getGender());
        Mockito.verify(studentService, Mockito.times(1)).getStudentById(1);

}
@Test
public void testUpdateStudent() {
        Integer id = 1;
        Student student = new Student(1, "aaa", 25, 'f');
        Mockito.when(studentService.updateStudent(id ,student)).thenReturn(student);
        ResponseEntity<Student> responseEntity=studentController.updateStudentById(id, student);
                Assertions.assertNotNull(responseEntity);
                Assertions.assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
                Assertions.assertEquals(student,responseEntity.getBody());
                Mockito.verify(studentService).updateStudent(id,student);


}
@Test
public void testDeleteStudentById() {
        Integer studentId = 1;

String message = "delete student successfully";
Mockito.when(studentService.deleteStudentById(studentId)).thenReturn(message);
ResponseEntity<String> responseEntity=studentController.deleteStudentById(studentId);
       Assertions.assertNull(responseEntity);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(message, responseEntity.getBody());
        Mockito.verify(studentService, Mockito.times(1)).deleteStudentById(studentId);


}

    }
