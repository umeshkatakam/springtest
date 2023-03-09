package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.EmployeeDomain;
import com.example.domain.MemberDomain;

@RestController
@CrossOrigin
@RequestMapping("/api/member")
@ComponentScan(basePackages= {"com.example"})
@EntityScan("com.example")
public class MemberController {
	
	@Autowired MemberService dao;
	
	@GetMapping("/homes")
	String home() {
		
		return "home";
		
		
	}
	
	 @GetMapping(value="/search/{search}")
	 public ResponseEntity<Object> search(@PathVariable(value="search",required=false) String search){
	return dao.Search(search);
		 
	 }
	 
	 
	 @GetMapping(value="/members/{pageNo}")
	 public ResponseEntity<Object> Pagination(@PathVariable(value="pageNo",required=false) int pageNo){
			 
		return dao.pagination(pageNo);
			 
			 
		 }
	 

	 @PostMapping(value="/create")
	    public ResponseEntity<Object> create(@RequestBody MemberDomain model) {
		 
		 
	        return dao.createEmp(model);
	    }
	 
	 
	 

}
