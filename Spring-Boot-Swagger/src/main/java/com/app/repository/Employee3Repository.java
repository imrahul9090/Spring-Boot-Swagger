package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Employee3;

@Repository
public interface Employee3Repository extends JpaRepository<Employee3, Integer> {

	/*
	 * @Query(value = "select * from jwt.empcrud e where e.NAME like %?1%",
	 * nativeQuery = true)
	 */
	/* List<Employee3> findByName(String name); */

}
