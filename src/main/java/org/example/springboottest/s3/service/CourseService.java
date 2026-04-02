package org.example.springboottest.s3.service;

import org.example.springboottest.s3.Repositories.CourseRepository;
import org.example.springboottest.s3.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;


    public List<Course> getAllCourses() {

      return   courseRepository.findAll();
    }

    public Course getCourseById(int id) {

        return   courseRepository.findById(id);
    }

    public void createCourse(Course course) {

           courseRepository.create(course);
    }
    public void deleteCourseById(int id) {

           courseRepository.delete(id);
    }

}
