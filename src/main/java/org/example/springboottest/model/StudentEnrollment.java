package org.example.springboottest.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "student_enrollments")
@Data
public class StudentEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
    @JoinColumn(name = "course_id")
    @ManyToOne
    Course course;
}
