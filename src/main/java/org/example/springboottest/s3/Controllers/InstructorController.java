package org.example.springboottest.s3.Controllers;

import org.example.springboottest.s3.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test2")
public class InstructorController {



    @Autowired
    CourseService courseService;


}
