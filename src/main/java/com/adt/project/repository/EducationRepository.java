package com.adt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adt.project.model.Education;

public interface EducationRepository extends JpaRepository<Education, Integer> {

}
