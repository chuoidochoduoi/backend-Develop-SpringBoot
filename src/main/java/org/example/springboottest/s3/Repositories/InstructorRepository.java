package org.example.springboottest.s3.Repositories;

import org.example.springboottest.s3.models.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstructorRepository {
    public List<Instructor> instructors = new ArrayList<>(List.of(
            new Instructor(1, "Nguyễn Văn A", "nva@university.edu.vn"),
            new Instructor(2, "Trần Thị B", "ttb@university.edu.vn"),
            new Instructor(3, "Lê Văn C", "lvc@university.edu.vn")
    ));

//    public Course findById(int id) {
//
//        return  courses.stream().filter(course -> course.getId() == id).findFirst().orElse(null);
//    }


}
