package org.example.springboottest.controller;


import jakarta.validation.Valid;
import org.example.springboottest.dto.ApiResponse;
import org.example.springboottest.dto.ApiResponse2;
import org.example.springboottest.dto.CandidateCreateDTO;
import org.example.springboottest.dto.CandidateUpdateDTO;
import org.example.springboottest.model.Candidate;
import org.example.springboottest.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
CandidateService candidateService;



    @PostMapping
    public ResponseEntity<ApiResponse2<Void>> createResponseResponseEntity(@Valid @RequestBody CandidateCreateDTO candidateCreateDTO
                                                                          ) {
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.badRequest()
//                    .body(ApiResponse.error(bindingResult.getAllErrors().get(0).getDefaultMessage()));
//        }

        candidateService.createCandidate(candidateCreateDTO);

        return ResponseEntity.status(201)
                .body(ApiResponse2.ok(null));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse2<Candidate>> updateCandidate(
            @PathVariable("id") int id,
            @Valid @ModelAttribute CandidateUpdateDTO dto) {

        Candidate updated = candidateService.updateCandidate(id, dto);

        return ResponseEntity.ok(ApiResponse2.ok(updated));
    }


}
