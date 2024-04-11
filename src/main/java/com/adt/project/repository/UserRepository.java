package com.adt.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adt.project.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
