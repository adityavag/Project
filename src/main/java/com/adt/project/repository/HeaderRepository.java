package com.adt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adt.project.model.Header;

public interface HeaderRepository extends JpaRepository<Header, Integer> {

}
