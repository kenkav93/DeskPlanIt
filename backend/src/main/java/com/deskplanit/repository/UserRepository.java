package com.deskplanit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deskplanit.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
