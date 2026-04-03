package org.example.springboottest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboottest.model.CourseStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseV2 {

    int id;
    String title;
    CourseStatus status;
}
