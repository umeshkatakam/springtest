package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.EmpAuthentication;
import com.example.domain.EmployeeDomain;

@Repository
public interface EmpAuthRepo extends JpaRepository<EmpAuthentication, Long>{

	Optional<EmpAuthentication> findByEmail(String email);
}
