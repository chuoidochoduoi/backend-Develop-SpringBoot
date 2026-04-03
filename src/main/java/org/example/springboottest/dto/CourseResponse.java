package org.example.springboottest.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.example.springboottest.model.CourseStatus;

@Data
public class CourseResponse {

    int id;
    String title;
    CourseStatus status;
}
