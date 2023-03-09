package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.domain.EmployeeDomain;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDomain, Long> {
		Optional<EmployeeDomain> findByEmail(String email);
	
	  @Query("SELECT e FROM EmployeeDomain e WHERE CONCAT(e.name, e.email) LIKE %:keyword%")
	  List<EmployeeDomain> search(String keyword);
		
		
	
}

