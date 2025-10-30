package com.example.management.Exceptions;

import com.example.management.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class StudentGlobalException {
     @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<Map<String, Object>> handleTheStudentNotFound( StudentNotFound studentNotFound) {
       Map<String, Object> response = new HashMap<>();
       response.put("timestamp", LocalDateTime.now());
       response.put("status", HttpStatus.NOT_FOUND);
       response.put("error","Student Not Found");
       response.put("message",studentNotFound.getMessage());
 return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
     public ResponseEntity<Map<String, Object>> handleTheInternalException(Exception exception ) {
         Map<String, Object> response = new HashMap<>();
         response.put("timestamp", LocalDateTime.now());
         response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
         response.put("error","Internal Server Error");
         response.put("message",exception.getMessage());
         return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

     }
}
