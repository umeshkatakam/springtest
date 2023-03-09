package com.example.Exception;

import java.util.Date;
import java.util.List;

import org.springframework.validation.FieldError;

public class ErrorMessage {

	private int statusCode;
	private Date timeStamp;
	private List<String> message;
	private String description;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	 
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	public ErrorMessage(int statusCode, Date timeStamp, List<String> message, String description) {
		super();
		this.statusCode = statusCode;
		this.timeStamp = timeStamp;
		this.message = message;
		this.description = description;
	}
	 
	
	
}
