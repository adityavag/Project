package com.adt.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adt.project.model.Education;
import com.adt.project.model.Experience;
import com.adt.project.model.Header;
import com.adt.project.model.Project;
import com.adt.project.model.Resume;
import com.adt.project.repository.ResumeRepository;

@RestController
public class Controller {
    @Autowired
    ResumeRepository resumeRepository;

    @PostMapping("/test")
    public String editProfile(@RequestBody Resume resume) {
        try {
            for (Education education : resume.getEducation()) {
                education.setResume(resume);
            }
            for (Experience experience : resume.getExperience()) {
                experience.setResume(resume);
            }
            for (Project project : resume.getProject()) {
                project.setResume(resume);
            }
            for (Header header : resume.getHeader()) {
                header.setResume(resume);
            }
            resumeRepository.save(resume);
            return "Success";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @GetMapping("/get/")
    public ResponseEntity<?> getProfile(@RequestParam(value = "name") String name) {
        try {
            Resume profile =  (Resume) resumeRepository.findByUserName(name);
            return ResponseEntity.ok(profile);
        } catch (Exception e) {
            return ResponseEntity.ok("Error");
        }
    }
}
