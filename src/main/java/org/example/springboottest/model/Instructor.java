package org.example.springboottest.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column( nullable = false)
    String name;
    @Column(unique = true, nullable = false)

    String email;

    @OneToMany(mappedBy = "instructor")
    List<Course> courses;
}
