package com.example.demo.dtos;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotBlank;

import com.example.domain.EmployeeDomain;

import lombok.Data;

@Data
public class EmployeeDto  {

	private Long id;
	@NotBlank(message = "The name is required")
	
	private String name;
	
	@NotBlank(message = "The email is required")
	private String email;
	
//	@Temporal(TemporalType.TIMESTAMP)
	@NotBlank(message = "The dob is required")
	private String dob;
//	@NotBlank(message = "The qualification is required")
	@ElementCollection
	private List<String> qualification ;
	 
	private String gendor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public List<String> getQualification() {
		return qualification;
	}

	public void setQualification(List<String> qualification) {
		this.qualification = qualification;
	}

	public String getGendor() {
		return gendor;
	}

	public void setGendor(String gendor) {
		this.gendor = gendor;
	}

	public EmployeeDomain toEmployee() {
		
		return new EmployeeDomain(id,name,email,dob,qualification,gendor);

	}

}
