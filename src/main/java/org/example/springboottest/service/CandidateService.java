package org.example.springboottest.service;


import org.example.springboottest.dto.CandidateCreateDTO;
import org.example.springboottest.dto.CandidateUpdateDTO;
import org.example.springboottest.model.Candidate;
import org.example.springboottest.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    @Autowired
    CandidateRepository candidateRepository;



    public void createCandidate(CandidateCreateDTO candidateCreateDTO) {


       Candidate candidate = new Candidate();

       candidate.setAge(candidateCreateDTO.getAge());
       candidate.setEmail(candidateCreateDTO.getEmail());
       candidate.setFullName(candidateCreateDTO.getFullName());
       candidate.setYearsOfExperience(candidateCreateDTO.getYearsOfExperience());
       candidate.setPhone(candidateCreateDTO.getPhone());
       candidateRepository.save(candidate);


    }


    public Candidate updateCandidate(int id, CandidateUpdateDTO dto) {

        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        candidate.setAddress(dto.getAddress());
        candidate.setBio(dto.getBio());

        return candidateRepository.save(candidate);
    }
}
