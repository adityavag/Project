package com.adt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adt.project.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

}
