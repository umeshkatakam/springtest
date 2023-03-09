package com.example.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.domain.EmployeeDomain;
import com.example.domain.MemberDomain;

@Repository
public interface MemberPagegination extends PagingAndSortingRepository<MemberDomain, Long>{

}
