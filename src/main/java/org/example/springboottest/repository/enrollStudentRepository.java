package org.example.springboottest.repository;

import org.example.springboottest.model.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface enrollStudentRepository  extends JpaRepository<StudentEnrollment,Integer> {



}
