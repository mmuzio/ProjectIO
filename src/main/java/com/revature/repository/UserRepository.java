package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
