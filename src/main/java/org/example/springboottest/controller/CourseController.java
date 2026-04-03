package org.example.springboottest.controller;

import jakarta.annotation.PostConstruct;
import org.example.springboottest.dto.ApiResponse;
import org.example.springboottest.dto.CourseCreateRequest;
import org.example.springboottest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
//
//    @PostConstruct
//    public void init() {
//        System.out.println(">>> S3 Controller LOADED !");
//    }
//
//    // 1. Lấy tất cả khóa học
//    @GetMapping("/all")
//    public ResponseEntity<ApiResponse<List<Course>>> getAll() {
//        List<Course> courses = courseService.getAllCourses();
//        return ResponseEntity.ok(ApiResponse.ok(courses));
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse<Course>> getById(@PathVariable Integer id) {
//        try {
//            Course course = courseService.getCourseById(id);
//            if (course == null) {
//                return ResponseEntity.status(404)
//                        .body(ApiResponse.error("Không tìm thấy khóa học có ID: " + id));
//            }
//            return ResponseEntity.ok(ApiResponse.ok(course));
//
//
//        }catch (RuntimeException e){
//
//            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
//        }
//
//
//    }
//
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> create(@RequestBody CourseCreateRequest courseCreateRequest) {

        try {
            courseService.createCourse(courseCreateRequest);
            return ResponseEntity.status(201)
                    .body(ApiResponse.ok(null));

        } catch (RuntimeException e) {

            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }


    }


    @PutMapping("up/{id}")
    public ResponseEntity<ApiResponse<Void>> update(@PathVariable("id") int id,@RequestBody CourseCreateRequest courseCreateRequest) {

        try {
            courseService.updateCourse(id,courseCreateRequest);
            return ResponseEntity.status(201)
                    .body(ApiResponse.ok(null));

        } catch (RuntimeException e) {

            return ResponseEntity.status(404).body(ApiResponse.error(e.getMessage()));
        }


    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
//        courseService.deleteCourseById(id);
//        return ResponseEntity.ok(ApiResponse.ok(null));
//    }
}