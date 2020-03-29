package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	
	
}
