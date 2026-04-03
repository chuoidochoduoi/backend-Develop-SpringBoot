package org.example.springboottest.repository;

import org.example.springboottest.dto.CourseResponse;
import org.example.springboottest.dto.CourseResponseV2;
import org.example.springboottest.model.Course;
import org.example.springboottest.model.CourseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Integer> {



    @Query("SELECT c from Course c where c.status = :status")
    public Page<Course> findAllByStatus(@Param("status") CourseStatus status, Pageable pageable);


    @Query("""  
            SELECT new org.example.springboottest.dto.CourseResponseV2(
                 c.id,
                 c.title,
                 c.status
            )
            FROM Course c
            WHERE c.status = :status""")
    public Page<CourseResponseV2> findAllByStatusV2(@Param("status") CourseStatus status, Pageable pageable);

}
