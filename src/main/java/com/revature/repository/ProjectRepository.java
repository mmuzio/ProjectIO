package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
