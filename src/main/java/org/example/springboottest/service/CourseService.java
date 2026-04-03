package org.example.springboottest.service;

import org.example.springboottest.dto.CourseCreateRequest;
import org.example.springboottest.dto.CourseResponse;
import org.example.springboottest.dto.CourseResponseV2;
import org.example.springboottest.dto.PageResponse;
import org.example.springboottest.model.Course;
import org.example.springboottest.model.CourseStatus;
import org.example.springboottest.repository.CourseRepository;
import org.example.springboottest.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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


    public PageResponse<CourseResponse> getPagedCourses(int page, int size, String sortBy, String direction, CourseStatus status) {

        if (page<0) page = 4;


        if (sortBy==null) sortBy = "id";

        if (direction==null) direction = "ASC";


        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction),sortBy));
        Page<CourseResponse> pageResult = courseRepository.findAllByStatus(status,pageable)
                .map(course -> {
                    CourseResponse response = new CourseResponse();
                    response.setId(course.getId());
                    response.setTitle(course.getTitle());
                    response.setStatus(course.getStatus());
                    return response;
                });


        return PageResponse.from(pageResult);
    }
    public PageResponse<CourseResponseV2> getPagedCoursesV2(int page, int size, String sortBy, String direction, CourseStatus status) {

        if (page<0) page = 4;


        if (sortBy==null) sortBy = "id";

        if (direction==null) direction = "ASC";


        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction),sortBy));



        return PageResponse.from(courseRepository.findAllByStatusV2(status, pageable));
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
