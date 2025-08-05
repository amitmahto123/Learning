package com.amit.UserService.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.UserService.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
