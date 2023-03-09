package com.example.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.EmployeeDomain;

@Repository
public interface EmpPagegination extends PagingAndSortingRepository<EmployeeDomain, Long>{

}
