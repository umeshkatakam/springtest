package com.example.domain;
 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="Employee")
public class EmployeeDomain {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
		
	private String email;
	
//	@Temporal(TemporalType.TIMESTAMP)
	private String dob;
	
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

	@Override
	public String toString() {
		return "EmployeeDomain [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", qualification="
				+ qualification + ", gendor=" + gendor + "]";
	}

	public EmployeeDomain(Long id, String name, String email, String dob, List<String> qualification, String gendor) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.qualification = qualification;
		this.gendor = gendor;
	}
	
	
	public EmployeeDomain() {
		// TODO Auto-generated constructor stub
	}
}
