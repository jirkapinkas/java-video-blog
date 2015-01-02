package com.java.vlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.vlog.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

	@Query("select g from Group g left join fetch g.items where g.shortName = ?1")
	Group findByShortNameWithItems(String shortName);

	Group findByShortName(String shortName);
	
	@Query("select distinct g from Group g left join fetch g.items order by g.groupOrder")
	List<Group> findAllWithItems();
}
