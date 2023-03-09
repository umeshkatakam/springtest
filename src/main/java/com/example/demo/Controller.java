package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.ResourceNotFoundException;
import com.example.demo.dtos.EmployeeDto;
import com.example.domain.EmpAuthentication;
import com.example.domain.EmployeeDomain;
import com.example.domain.MemberDomain;
import com.example.repo.EmpPagegination;
import com.example.repo.EmployeeRepository;
import com.example.repo.MemberRepo;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
 


@RestController
@CrossOrigin
@RequestMapping("/api/emp")
 

public class Controller {

	@Autowired
	EmployeeService dao;
	
	@Autowired 
	EmployeeRepository repo;
	
	@Autowired
	EmpPagegination pagination;
	@GetMapping("/")
	public String get() {
		return ("<h1>welcome</h1>");
	}
	
//	 @PostMapping(value="/create")
//	    public ResponseEntity<Object> create(@RequestParam("firstName") String firstName,@RequestParam("lastName")String lastName, 
//	    		@RequestParam("email") String email,@RequestParam("department") String department
//	    		) {
//		 
//		 
//		 System.out.println("i amincreate");
//		 EmployeeDomain model=new EmployeeDomain();
//		 model.setFirstName(firstName);
//		 model.setLastName(lastName);
//		 model.setEmail(email);
//		 model.setDepartment(department);
//		 System.out.print(model.toString());
//	        return dao.createEmp(model);
//	    }
	 @GetMapping(value="/employees")
	 public List<EmployeeDomain> getAll() {
		 
		 System.out.println("in get req");
		 return repo.findAll();
	 }
//	 
//	 @PostMapping(value="/creatEmp")
//	 public ResponseEntity<Object> createUser(EmployeeDomain model) {
//		 System.out.println("at create method");
//	 
//		 
//		 EmployeeDomain emp3=new EmployeeDomain();
////		 emp1.setId(102L);
//		 emp3.setDepartment("tester");
//		 emp3.setEmail("surya@gmail.com");
//		 emp3.setFirstName("surya");
//		 emp3.setLastName("sivakumar");
//		 emp3.setPass("Surya123");
//		 
//		 return dao.createEmp(emp3);
//		 }
//	 
//	 @PostMapping(value="createEmp")
//	 public ResponseEntity<Object> create1(EmployeeDomain model) {
//		 System.out.println("at create method");
//		 EmployeeDomain emp1=new EmployeeDomain();
////		 emp1.setId(101L);
//		 emp1.setDepartment("developer");
//		 emp1.setEmail("umesh@gmail.com");
//		 emp1.setFirstName("umesh");
//		 emp1.setLastName("katakam");
//		 
//		 EmployeeDomain emp2=new EmployeeDomain();
////		 emp1.setId(102L);
//		 emp2.setDepartment("developer");
//		 emp2.setEmail("surya@gmail.com");
//		 emp2.setFirstName("surya");
//		 emp2.setLastName("sivakumar");
//		 
//		 EmployeeDomain emp3=new EmployeeDomain();
////		 emp1.setId(102L);
//		 emp3.setDepartment("tester");
//		 emp3.setEmail("surya2@gmail.com");
//		 emp3.setFirstName("surya");
//		 emp3.setLastName("sivakumar");
//		 
//		 repo.save(emp1);
//		 repo.save(emp2);
//		 
//		 return dao.createEmp(emp3);
//		 }
//	 
//	 
//	 
//	 @DeleteMapping("/delete/{id}")
//		public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
//		System.out.println("deleted with id"+id);		
//		 return dao.deleteuser(id);
//		}
//	 
//	 
//	 
	 @PostMapping("/login")
	 public ResponseEntity<Object> logIn( @RequestParam("email")String email,@RequestParam("password") String password){
		 
		 
		 
		  System.out.println("credentials"+ email+" "+password);
		return dao.logIn(email,password);
		 
		 
		 
	 }
	 @PostMapping("/logout")
	 public ResponseEntity<Object> logOut( @RequestParam("email")String email,@RequestParam("password") String password){
		 
		 
		 
		  System.out.println("credentials"+ email+" "+password);
		return dao.logIn(email,password);
		 
		 
		 
	 }
	
	 @PostMapping(value="/createEmp")
	    public ResponseEntity<Object> create(@Valid @RequestBody EmployeeDto model) {
		 
		 System.out.println("In create");
		 
//		 
//		 EmployeeDomain emp=new EmployeeDomain();
//		 emp.setName("umesh");
//		 emp.setEmail("umesh@gmail.com");
//		 emp.setGendor("male");
//		 List<String> list=new ArrayList<String>();
//		 list.add("btech");
//		 emp.setQualification(list);
		 EmployeeDomain emp= model.toEmployee();
	        return dao.createEmp(emp);
	    }
	 
	 @PutMapping(value="/updateEmp")
	    public ResponseEntity<Object> update(@RequestBody EmployeeDomain model) {
		 
		 System.out.println("In update");
		 System.out.print(model.getName());
		 
		 EmployeeDomain emp=new EmployeeDomain();
		 emp.setName("umesh");
		 emp.setEmail("umesh@gmail.com");
		 emp.setGendor("male");
		 List<String> list=new ArrayList<String>();
		 list.add("btech");
		 emp.setQualification(list);
	        return dao.updateEmp(model);
	    }
	 
	 @GetMapping(value="/home")
	 public String home() {
		 
		 return "home";
	 }
	 
	 @DeleteMapping("/delete/{id}")
		public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		System.out.println("deleted with id"+id);		
		 return dao.deleteEmploye(id);
		}
	 
	 
	 @GetMapping(value="/search/{search}")
	 public ResponseEntity<Object> search(@PathVariable(value="search",required=false) String search){
		 
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
	 
	 @PostMapping(value="/createAuth")
	    public ResponseEntity<Object> createAuth(@RequestBody EmpAuthentication model) {
		 
		 System.out.println("In create Auth");
		 System.out.print(model.getName());
		 
		 EmployeeDomain emp=new EmployeeDomain();
		 emp.setName("umesh");
		 emp.setEmail("umesh@gmail.com");
		 emp.setGendor("male");
		 List<String> list=new ArrayList<String>();
		 list.add("btech");
		 emp.setQualification(list);
	        return dao.createAuth(model);
	    }
	 
	 
	 
	 
	 
	 @GetMapping(value="/getEmp/{pageNo}")
 public ResponseEntity<Object> Pagination(@PathVariable(value="pageNo",required=false) int pageNo){
		 
		 Page<EmployeeDomain> result;
		 
		 if(pageNo>=0) {
			 Pageable pageable = PageRequest.of(pageNo, 10);
			 result=pagination.findAll(pageable);
			 System.out.println(pageNo);
			 System.out.println(result);
			 return ResponseEntity.accepted().body(result);
		 }
		
		 else {
			 
			 List<EmployeeDomain> emps=new ArrayList<EmployeeDomain>();
			 emps=repo.findAll();
			 return ResponseEntity.accepted().body(emps);
			 
		 }
		 
		 
	 }
	 
	 @Autowired MemberRepo memberRepo;
	 @PostMapping(value="/upload")
		public ResponseEntity<Object> upload( @RequestBody List<MemberDomain> member) {
			 
			List<MemberDomain> saved=new ArrayList<MemberDomain>();
			for (MemberDomain modal: member) {
				System.out.println("name"+modal.getMemberName());
				MemberDomain membersample =new MemberDomain();
				
				membersample.setDateofBirth(modal.getDateofBirth());
				membersample.setGender(modal.getGender());
				membersample.setMemberName(modal.getMemberName());
				membersample.setMemberType(modal.getMemberType());
				membersample.setSumAssured(modal.getSumAssured());
				membersample.setAddress(modal.getAddress());
				membersample.setContactNumber(modal.getContactNumber());
				membersample.setMemberEmail(modal.getMemberEmail());
				saved.add(membersample);
			}
			 
			List<MemberDomain> status=memberRepo.saveAll(saved);
			
			if(status!=null) {
			return ResponseEntity.accepted().body("created succesfully");	
			}
			else {
				
				return ResponseEntity.badRequest().body("failed to create");
			}
			
			}
	 
	 
	 @PostMapping(value="/createBulk")
	 public String createBulk() {
		 List<EmployeeDomain> bulk=new ArrayList<EmployeeDomain>();
		 for(int i=0;i<=30;i++) {
			 
			 EmployeeDomain emp =new EmployeeDomain();
			 emp.setDob("2021/04/04");
			 emp.setEmail("test"+i+"@mail.com");
			 emp.setName("test"+i);
			 List<String> qual= new ArrayList<String>();
			 qual.add("btech");
			 emp.setQualification(qual);
			 emp.setGendor("Male");
			 bulk.add(emp);
			
		 }
		 
		 repo.saveAll(bulk);
		 return "created";
	 }
	 
}
