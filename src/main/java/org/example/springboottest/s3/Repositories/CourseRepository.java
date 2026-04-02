package org.example.springboottest.s3.Repositories;

import org.example.springboottest.s3.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CourseRepository {
    public List<Course> courses = new ArrayList<>(List.of(
            new Course(101, "Lập trình Java Core", "Active", 1),
            new Course(102, "Spring Boot Microservices", "Active", 1),
            new Course(103, "Thiết kế Web ReactJS", "Active", 2),
            new Course(104, "Cơ sở dữ liệu MySQL", "Pending", 2),
            new Course(105, "Triển khai Docker & CI/CD", "Active", 3)
    ));


   public List<Course> findAll() {

        return courses;
   }


    public Course findById(int id) {
        return courses.stream()
                .filter(c -> c.getId()== id).findFirst().orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void create(Course course) {


       courses.add(course);
    }

    public void update(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == course.getId()) {
                courses.set(i, course);
                return;
            }
        }
    }

    public void delete(int id) {
       Course cd = courses.stream()
               .filter(c -> c.getId()== id).findFirst().orElseThrow(() -> new RuntimeException("Course not found"));

       courses.remove(cd);
    }
}
