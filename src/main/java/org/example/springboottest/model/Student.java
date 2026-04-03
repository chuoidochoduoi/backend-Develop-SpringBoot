package org.example.springboottest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    int id;

    String name;
    String email;


    @OneToMany(mappedBy = "student")
    List<StudentEnrollment> enrollments;


}
