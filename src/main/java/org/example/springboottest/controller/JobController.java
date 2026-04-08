package org.example.springboottest.controller;

import jakarta.validation.Valid;
import org.example.springboottest.dto.Request.JobCreateDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {


    @PostMapping
    public String createJob(@Valid @RequestBody JobCreateDTO jobCreateDTO) {
        return "Job created successfully  tét ";
    }
}
