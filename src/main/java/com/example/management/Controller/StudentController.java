package com.example.management.Controller;

import com.example.management.Entity.Student;
import com.example.management.Repository.StudentRepository;
import com.example.management.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/add/student")
    public ResponseEntity<Student> insertTheStudent(@RequestBody Student student) {
        Student student1=studentService.insert(student);
        return  ResponseEntity.status(HttpStatus.CREATED).body(student1);
    }
    @PostMapping("/add/All/Student")
    public ResponseEntity<List<Student>> insertAllStudents(@RequestBody List<Student> students) {
       List<Student> student1= studentService.insertAllStudents(students);
       return ResponseEntity.status(HttpStatus.CREATED).body(student1);

    }
     @GetMapping("/All")
     public ResponseEntity<List<Student>>findAllTheStudentss(){
        List<Student> studentList=studentService.getAllStudents();
        if(studentList.isEmpty()) {
           return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentList);
     }
     @GetMapping("/findById/{id}")
     public ResponseEntity<Student> findByStudentId(@PathVariable Integer id){
        Student student=studentService.getStudentById(id);
        if(student!=null) {
            return ResponseEntity.ok(student);

        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
     }
     @PutMapping("/updateById/{id}")
     public ResponseEntity<Student> updateStudentById(@PathVariable Integer id ,@RequestBody Student student){
        Student student1 = studentService.updateStudent(id,student);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(student1);
     }
     @DeleteMapping("/deleteById/{id}")
     public  ResponseEntity<Student> deleteStudentById(@PathVariable Integer id){
        studentService.deleteStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
     }


}
