package org.example.springboottest.controller;

import org.example.springboottest.dto.ApiResponse;
import org.example.springboottest.dto.InstructorCreateRequest;
import org.example.springboottest.model.Instructor;
import org.example.springboottest.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("instructor")
public class InstructorController {


    @Autowired
    private InstructorService instructorService;


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> findById(@PathVariable("id") int id) {

        System.out.println( "aaaa" );

       Instructor instructor= instructorService.findInstructorById(id);

        System.out.println( "aaaa" +instructor);
        return ResponseEntity.ok(ApiResponse.ok(instructor));
    }



    @PostMapping("create")
    public ResponseEntity<ApiResponse<Void>> createInstructor(@RequestBody InstructorCreateRequest instructorCreateRequest) {


       instructorService.create(instructorCreateRequest);

        return ResponseEntity.status(201)
                .body(ApiResponse.ok(null));
    }
//    @Autowired
//    CourseService courseService;


}
