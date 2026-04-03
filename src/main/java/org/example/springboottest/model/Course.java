package org.example.springboottest.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Table
@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    CourseStatus status;
    @JoinColumn(name = "instructor_id")
    @ManyToOne
    Instructor instructor;

    @OneToMany(mappedBy = "course")
    List<StudentEnrollment> enrollments;

}




