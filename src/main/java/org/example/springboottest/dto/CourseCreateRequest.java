package org.example.springboottest.dto;


import lombok.Data;
import org.example.springboottest.model.CourseStatus;

@Data
public class CourseCreateRequest {

    String title;
    CourseStatus status;
    int instructorId;

}
