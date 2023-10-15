package com.example.domain;

 

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MemberDomain {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String memberName;
	
	private String gender;
	
	@Temporal(TemporalType.DATE)
	private Date dateofBirth;
	private String memberType;
	private String sumAssured;
	private String contactNumber;
	private String address;
	private String memberEmail;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(String sumAssured) {
		this.sumAssured = sumAssured;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	@Override
	public String toString() {
		return "MemberDomain [id=" + id + ", memberName=" + memberName + ", gender=" + gender + ", dateofBirth="
				+ dateofBirth + ", memberType=" + memberType + ", sumAssured=" + sumAssured + ", contactNumber="
				+ contactNumber + ", address=" + address + ", memberEmail=" + memberEmail + "]";
	}
	public MemberDomain(Long id, String memberName, String gender, Date dateofBirth, String memberType,
			String sumAssured, String contactNumber, String address, String memberEmail) {
		super();
		this.id = id;
		this.memberName = memberName;
		this.gender = gender;
		this.dateofBirth = dateofBirth;
		this.memberType = memberType;
		this.sumAssured = sumAssured;
		this.contactNumber = contactNumber;
		this.address = address;
		this.memberEmail = memberEmail;
	}
	 
	
	
	public MemberDomain() {
		// TODO Auto-generated constructor stub
	}
	
	

}
