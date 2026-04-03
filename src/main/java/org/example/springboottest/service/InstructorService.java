package org.example.springboottest.service;


import org.example.springboottest.dto.InstructorCreateRequest;
import org.example.springboottest.model.Instructor;
import org.example.springboottest.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public Instructor findInstructorById(int id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id));
    }

    public void create(InstructorCreateRequest instructorCreateRequest) {

         Instructor instructor = new Instructor();
         instructor.setName(instructorCreateRequest.getName());
         instructor.setEmail(instructorCreateRequest.getEmail());


         instructorRepository.save(instructor);

    }
}
