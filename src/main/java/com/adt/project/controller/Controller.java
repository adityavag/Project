package com.adt.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adt.project.model.Resume;
import com.adt.project.repository.ResumeRepository;


@RestController
public class Controller {
    @Autowired
    ResumeRepository resumeRepository;
    @PostMapping("/test")
    public String editProfile(@RequestBody Resume resume) {
        try {
            resumeRepository.save(resume);
            return "Success";
        } catch (Exception e) {
            return e.toString();
        }
    }
}
