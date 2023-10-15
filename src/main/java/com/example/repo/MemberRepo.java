package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.EmployeeDomain;
import com.example.domain.MemberDomain;

@Repository
public interface MemberRepo extends JpaRepository<MemberDomain, Long>{

	 

	Optional<MemberDomain> findByMemberEmail(String email);
	
	 @Query("SELECT e FROM MemberDomain e WHERE CONCAT(e.memberName, e.memberEmail) LIKE %:keyword%")
	  List<MemberDomain> search(String keyword);
	
	
}
