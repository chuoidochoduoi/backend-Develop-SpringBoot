package org.example.springboottest.controller;


import org.example.springboottest.dto.ApiResponse;
import org.example.springboottest.dto.enrollStudentRequest;
import org.example.springboottest.service.EnrollStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/e/student")
public class EnrollmentController {

    @Autowired
    EnrollStudentService enrollStudentService;




    @PostMapping
    public ResponseEntity<ApiResponse<Void>> getEnrollStudentService(@RequestBody enrollStudentRequest a) {


        try {
            enrollStudentService.enrollStudent(a);
            return ResponseEntity.status(201)
                    .body(ApiResponse.ok(null));

        }catch (RuntimeException e){
            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }



    }
}
