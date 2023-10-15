package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.spi.LoggerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFoundException;
import com.example.domain.EmpAuthentication;
import com.example.domain.EmployeeDomain;
import com.example.domain.EmployeeLogger;
import com.example.domain.MemberDomain;
import com.example.repo.EmpAuthRepo;
import com.example.repo.EmployeeRepository;
import com.example.repo.LoggerRepositor;
import com.example.repo.MemberRepo;
 
 
@Service
@ComponentScan(basePackages= {"com.example.repo"})
@EntityScan("com.example.repo")
@EnableJpaRepositories("com.example.repo")
public class EmployeeService{
	
	@Autowired
	EmployeeRepository repo;
 
	@Autowired
	EmpAuthRepo authentication;
	
	@Autowired
	LoggerRepositor loggerRepo;

	public List<EmployeeDomain> getAll(){
		
		return repo.findAll();
		
		
	}
	
	
//	public ResponseEntity<Object> createEmp(EmployeeDomain model){
//		EmployeeDomain emp=new EmployeeDomain();
//		 if (repo.findByEmail(model.getEmail()).isPresent()) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email is already presetnt!!");
//
////	            return ResponseEntity.badRequest().body("The Email is already Present, Failed to Create new User");
//	        } else {
//	        	emp.setDepartment(model.getDepartment());
//	        	emp.setEmail(model.getEmail());
//	        	emp.setFirstName(model.getFirstName());
//	        	emp.setLastName(model.getLastName());
//	        	emp.setPass(model.getPass());
//	        	
//	        	 EmployeeDomain savedemp=null;
//	             try {
//	             	   savedemp = repo.save(emp); 
//	             }
//	             catch(Exception e) {
//	             	System.out.println("error "+e);
//	             	return ResponseEntity.unprocessableEntity().body("exception"+e);
//	             }
//	             		
//	          
//	          
//	             if (repo.findById(savedemp.getId()).isPresent())
//	                 return ResponseEntity.ok("Employee Created Successfully");
//	             else return ResponseEntity.unprocessableEntity().body("Failed Creating Employee as Specified");
//	         }
//	}
//	
//	
//	public ResponseEntity<Object> deleteuser(Long id) 
//			throws ResourceNotFoundException {
//				EmployeeDomain existingemp = this.repo.findById(id)
//						.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
////				RoleModel roleid=this.repo.findRoleID(existinguser.getRoles().ge);
////				if(roleid.getId()==1)
////				{
////				System.out.print("MANAGER id you can't make inactive");
////				return existinguser;
////				}
////				else{
////					System.out.print("hr user");	
////					existinguser.setStatus("inActive");
////					repo.save(existinguser);
////					return existinguser;
////				}
//			 
//				if(repo.findById(id).isPresent()) {
//					repo.deleteById(id);
//					return ResponseEntity.ok().body("Employee deleted successfully");
//					
//				}
//				else {
//					return ResponseEntity.badRequest().body("failed to delete");
//				}
//				
//				 
//		}
//
//
	public ResponseEntity<Object> logIn(String email,String pass) {
		// TODO Auto-generated method stub
		
		Optional<EmpAuthentication> employee=authentication.findByEmail(email);
		if(employee.isPresent()) {
			System.out.println("employee"+employee.toString());
			EmployeeLogger logger=new EmployeeLogger();
			
			EmpAuthentication emp= employee.get();
			System.out.println(emp.toString());
			
			
//			emp.setId(employee.get().getId());
//			emp.setDepartment(employee.get().getDepartment());
//			emp.set
			
			Optional<EmployeeLogger> logger1=loggerRepo.findByEmpId(emp.getId());
			
			if((emp.getEmail().equals(email) &&emp.getPassword().equals(pass)) &logger1.isPresent()) {
				System.out.println("logger from db"+logger1.toString());
				if(logger1.get().getIsLogged()==false) {
					logger.setId(logger1.get().getId());
					logger.setEmpId(emp.getId());
					logger.setIsLogged(false);
					loggerRepo.save(logger);
					System.out.println("second time login "+logger.toString());
					return ResponseEntity.accepted().body(emp);
				}
				else {
					
					return ResponseEntity.badRequest().body("resricted to one login at a time");
				}
				
			}
			else {
				
				logger.setEmpId(emp.getId());
				logger.setIsLogged(false);
				loggerRepo.save(logger);
				System.out.println("new Logger created"+logger.toString());
				
				return ResponseEntity.accepted().body(emp);
			}
			
//		 
			
			
		}
		else {
			
			return ResponseEntity.badRequest().body("Employee Not found");
		}
		
		
		 
	}


	public ResponseEntity<Object> createEmp(EmployeeDomain model){
		EmployeeDomain emp=new EmployeeDomain();
		 if (repo.findByEmail(model.getEmail()).isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email is already presetnt!!");

//	            return ResponseEntity.badRequest().body("The Email is already Present, Failed to Create new User");
	        } else {
	        	 
//	        	 emp.setDob(model.getDob());
	        	 emp.setEmail(model.getEmail());
//	        	 emp.setGendor(model.getGendor());
	        	 emp.setName(model.getName());
//	        	 emp.setQualification(model.getQualification());
	        	 EmployeeDomain savedemp=null;
	             try {
	             	   savedemp = repo.save(emp); 
	             }
	             catch(Exception e) {
	             	System.out.println("error "+e);
	             	return ResponseEntity.unprocessableEntity().body("exception"+e);
	             }
	             		
	          
	          
	             if (repo.findById(savedemp.getId()).isPresent())
	                 return ResponseEntity.ok("Employee Created Successfully");
	             else return ResponseEntity.unprocessableEntity().body("Failed Creating Employee as Specified");
	         }
	}
	
	public ResponseEntity<Object> deleteEmploye(Long id) 
	throws ResourceNotFoundException {
		EmployeeDomain existingemp = this.repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		 
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.ok().body("Employee deleted successfully");
			
		}
		else {
			return ResponseEntity.badRequest().body("failed to delete");
		}
		
		
		 
}

	public ResponseEntity<Object> updateEmp(EmployeeDomain model){
		EmployeeDomain emp=new EmployeeDomain();
		 
	        	 emp.setId(model.getId());
//	        	 emp.setDob(model.getDob());
	        	 emp.setEmail(model.getEmail());
//	        	 emp.setGendor(model.getGendor());
	        	 emp.setName(model.getName());
//	        	 emp.setQualification(model.getQualification());
	        	 EmployeeDomain savedemp=null;
	             try {
	             	   savedemp = repo.save(emp); 
	             }
	             catch(Exception e) {
	             	System.out.println("error "+e);
	             	return ResponseEntity.unprocessableEntity().body("exception"+e);
	             }
	             		
	          
	          
	             if (repo.findById(savedemp.getId()).isPresent())
	                 return ResponseEntity.ok("Employee updated Successfully");
	             else return ResponseEntity.unprocessableEntity().body("Failed Creating Employee as Specified");
	          
	}


	public ResponseEntity<Object> createAuth(EmpAuthentication model) {
		// TODO Auto-generated method stub
		EmpAuthentication emp=new EmpAuthentication();
		 if (authentication.findByEmail(model.getEmail()).isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email is already presetnt!!");

//	            return ResponseEntity.badRequest().body("The Email is already Present, Failed to Create new User");
	        } else {
	        	 
	        		emp.setEmail(model.getEmail());
	        
	        	 emp.setName(model.getName());
	        	 emp.setPassword(model.getPassword());
	        	 EmpAuthentication savedemp=null;
	             try {
	             	   savedemp = authentication.save(emp); 
	             }
	             catch(Exception e) {
	             	System.out.println("error "+e);
	             	return ResponseEntity.unprocessableEntity().body("exception"+e);
	             }
	             		
	          
	          
	             if (authentication.findById(savedemp.getId()).isPresent())
	                 return ResponseEntity.ok("EmpAuthentication Created Successfully");
	             else return ResponseEntity.unprocessableEntity().body("Failed Creating EmployeeAuthentication as Specified");
	         }

	}
	
	
	//Logout
	public ResponseEntity<Object> logOut(String email,String pass) {
		// TODO Auto-generated method stub
		
		Optional<EmpAuthentication> employee=authentication.findByEmail(email);
		if(employee.isPresent()) {
			System.out.println("employee"+employee.toString());
			EmployeeLogger logger=new EmployeeLogger();
			
			EmpAuthentication emp= employee.get();
			System.out.println(emp.toString());
			
			
//			emp.setId(employee.get().getId());
//			emp.setDepartment(employee.get().getDepartment());
//			emp.set
			
			Optional<EmployeeLogger> logger1=loggerRepo.findByEmpId(emp.getId());
			logger.setId(logger1.get().getId());
			logger.setEmpId(emp.getId());
			logger.setIsLogged(false);
			loggerRepo.save(logger);
			System.out.println("new Logger created"+logger.toString());
		 
			return ResponseEntity.accepted().body("logout succes");
			
			 
//		 
			
			
		}
		else {
			
			return ResponseEntity.badRequest().body("Employee Not found");
		}
		
		
		 
	}

	 

}
