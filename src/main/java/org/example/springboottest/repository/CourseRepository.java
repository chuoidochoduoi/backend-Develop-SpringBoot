package org.example.springboottest.repository;

import org.example.springboottest.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {



}
