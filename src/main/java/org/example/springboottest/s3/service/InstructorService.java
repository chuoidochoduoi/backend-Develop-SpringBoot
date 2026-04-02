package org.example.springboottest.s3.service;

import org.example.springboottest.s3.Repositories.CourseRepository;
import org.example.springboottest.s3.models.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class InstructorService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseService courseService;
//
//    public List<Instructor> findAllTasks(String titlle) {
//
//        List<Instructor> search = courseRepository.instructors;
//        List<Instructor> instructors = new ArrayList<>();
//
//        for (Instructor t : search) {
//            if (t.getTitle().contains(titlle)){
//                instructors.add(t);
//            }
//        }
//
//        return instructors;
//    }
//
//    public boolean saveTask(Instructor instructor) {
//
//        if (courseService.findUserByID(instructor.getUserId()) == null) {
//            return false;
//        }
//
//        courseRepository.add(instructor);
//
//        return true;
//
//    }

}
