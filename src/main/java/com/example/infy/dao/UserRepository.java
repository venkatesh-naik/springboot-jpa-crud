package com.example.infy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.infy.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
