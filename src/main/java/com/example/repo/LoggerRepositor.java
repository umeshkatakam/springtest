package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.domain.EmployeeDomain;
import com.example.domain.EmployeeLogger;

@Repository
public interface LoggerRepositor extends JpaRepository<EmployeeLogger, Long> {
	
    Optional<EmployeeLogger> findByEmpId(Long emp);

}
