package org.example.springboottest.service;

import org.example.springboottest.dto.CourseCreateRequest;
import org.example.springboottest.model.Course;
import org.example.springboottest.repository.CourseRepository;
import org.example.springboottest.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    InstructorService instructorService;

    @Autowired
    CourseRepository courseRepository;
    public void createCourse(CourseCreateRequest  courseCreateRequest) {

        instructorService.findInstructorById(courseCreateRequest.getInstructorId());

        Course course = new Course();
        course.setTitle(courseCreateRequest.getTitle());
        course.setInstructor(instructorService.findInstructorById(courseCreateRequest.getInstructorId()));
        course.setStatus(courseCreateRequest.getStatus());

        courseRepository.save(course);
    }

    public void updateCourse(int id,CourseCreateRequest  courseCreateRequest) {

        instructorService.findInstructorById(courseCreateRequest.getInstructorId());


        Course course = new Course();
        course.setId(id);
        course.setTitle(courseCreateRequest.getTitle());
        course.setInstructor(instructorService.findInstructorById(courseCreateRequest.getInstructorId()));
        course.setStatus(courseCreateRequest.getStatus());

        courseRepository.save(course);
    }
}
