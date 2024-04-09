package com.adt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adt.project.model.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Integer> {

}
