package com.java.vlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.vlog.entity.Poll;

public interface PollRepository extends JpaRepository<Poll, Integer> {

}
