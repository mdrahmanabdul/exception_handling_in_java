package com.playground.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.playground.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
