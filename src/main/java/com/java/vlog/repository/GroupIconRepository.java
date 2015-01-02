package com.java.vlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.vlog.entity.GroupIcon;

public interface GroupIconRepository extends JpaRepository<GroupIcon, Integer> {

	@Query("select gi from GroupIcon gi join fetch gi.group g where g.shortName = ?1")
	GroupIcon findByGroupShortName(String shortName);

}
