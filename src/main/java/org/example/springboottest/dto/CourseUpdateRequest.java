package org.example.springboottest.dto;

import lombok.Data;
import org.example.springboottest.model.CourseStatus;

@Data
public class CourseUpdateRequest {

    String title;
    CourseStatus status;
    int instructorId;
}
