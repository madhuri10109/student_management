package com.example.management.Service;

import com.example.management.Entity.Student;
import com.example.management.Exceptions.StudentNotFound;
import com.example.management.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private  StudentRepository studentRepository;
    public Student insert (Student student) {
        return studentRepository.save(student);
    }
    public List<Student> insertAllStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFound("student id with"+id+"not found"));


    }
    public Student updateStudent(Integer id, Student student) {
        Student existingstudent=new Student(1,"murali",19,'m');
        if(existingstudent==null){
          throw   new RuntimeException("student id not found"+student.getSid());

        }
        existingstudent.setName(student.getName());
        existingstudent.setAge(student.getAge());
        existingstudent.setGender(student.getGender());
        return studentRepository.save(existingstudent);
    }

     public String deleteStudentById(Integer id) {
        Student student=studentRepository.findById(id).orElseThrow(()->
                new StudentNotFound("student id with" +id+"not found"));

        studentRepository.deleteById(id);
        return "student id succesfully removed " +id+"not found";
    }

}
