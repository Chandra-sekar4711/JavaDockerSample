package com.Basic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.Basic.Model.MTMstudents;
import com.Basic.Model.MTMcourses;
import com.Basic.Repository.MTMstudentsRepository;
import com.Basic.Repository.MTMcoursesRepository;

import java.util.HashSet;
import java.util.Set;

@RestController
public class MTMcontroller {

    @Autowired
    private MTMstudentsRepository mtmstudentrepository;

    @Autowired
    private MTMcoursesRepository mtmcoursesRepository;  // Inject Course Repository

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/manytomany")
    public ResponseEntity<MTMstudents> saveStudent(@RequestBody MTMstudents student) {
        System.out.println("student"+""+student);
        Set<MTMcourses> courses = new HashSet<>();
        
        for (MTMcourses course : student.getMtmcourses()) {
            course.getMtmstudents().add(student); // Add student to course  
            courses.add(mtmcoursesRepository.save(course));  // Save course
        }
  
        student.setMtmcourses(courses);  // Update student with managed courses
        
        MTMstudents savedStudent = mtmstudentrepository.save(student); // Save student
        
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
}
