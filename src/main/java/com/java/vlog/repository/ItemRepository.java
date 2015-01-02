package com.java.vlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.vlog.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	@Query("select i from Item i join fetch i.group where i.shortName = ?1")
	Item findByShortName(String shortName);

}
