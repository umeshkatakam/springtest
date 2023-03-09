package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.domain.EmployeeDomain;
import com.example.domain.MemberDomain;
import com.example.repo.MemberPagegination;
import com.example.repo.MemberRepo;
 

@Service
public class MemberService {
	
	@Autowired MemberRepo repo;
	
	@Autowired MemberPagegination memberpagination;
	
	public ResponseEntity<Object> createEmp(MemberDomain modal){
		MemberDomain member=new MemberDomain();
		 if (repo.findByMemberEmail(modal.getMemberEmail()).isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email is already presetnt!!");

//	            return ResponseEntity.badRequest().body("The Email is already Present, Failed to Create new User");
	        } else {
	        	 member.setAddress(modal.getAddress());
	        	 member.setContactNumber(modal.getContactNumber());
	        	 member.setDateofBirth(modal.getDateofBirth());
	        	 member.setMemberEmail(modal.getMemberEmail());
	        	 member.setMemberName(modal.getMemberName());
	        	 member.setMemberType(modal.getMemberType());
	        	 member.setGender(modal.getGender());
	        	 member.setSumAssured(modal.getSumAssured());
	        	 MemberDomain saved=null;
	        	 
	        	 
	        	 
	             try {
	             	   saved = repo.save(member); 
	             }
	             catch(Exception e) {
	             	System.out.println("error "+e);
	             	return ResponseEntity.unprocessableEntity().body("exception"+e);
	             }
	             		
	          
	          
	             if (repo.findById(saved.getId()).isPresent())
	                 return ResponseEntity.ok("Member Created Successfully");
	             else return ResponseEntity.unprocessableEntity().body("Failed Creating Member as Specified");
	         }
	}


	public ResponseEntity<Object> Search(String search) {
		// TODO Auto-generated method stub
		 
		 if(search!=null) {
			 List result=repo.search(search);
			 System.out.println(search);
			 System.out.println(result);
			 return ResponseEntity.accepted().body(result);
		 }
		
		 else {
			 return ResponseEntity.accepted().body("result");
		 }
		 
	}


	public ResponseEntity<Object> pagination(int pageNo) {
		// TODO Auto-generated method stub
		 Page<MemberDomain> result;
		 
		 if(pageNo>=0) {
			 Pageable pageable = PageRequest.of(pageNo, 10);
			 result=memberpagination.findAll(pageable);
			 System.out.println(pageNo);
			 System.out.println(result);
			 return ResponseEntity.accepted().body(result);
		 }
		
		 else {
			 
			 List<MemberDomain> emps=new ArrayList<MemberDomain>();
			 emps=repo.findAll();
			 return ResponseEntity.accepted().body(emps);
			 
		 }
		 
	}

}
