package org.example.springboottest.service;

import org.example.springboottest.dto.enrollStudentRequest;
import org.example.springboottest.model.Course;
import org.example.springboottest.model.Student;
import org.example.springboottest.model.StudentEnrollment;
import org.example.springboottest.repository.CourseRepository;
import org.example.springboottest.repository.StudentRepository;
import org.example.springboottest.repository.enrollStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnrollStudentService {



    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private enrollStudentRepository enrollmentRepository;

    public void enrollStudent(enrollStudentRequest e) {



        Student student = studentRepository.findById(e.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + e.getStudentId()));

        Course course = courseRepository.findById(e.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + e.getCourseId()));

        StudentEnrollment enrollment = new StudentEnrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        enrollmentRepository.save(enrollment);
    }


}
