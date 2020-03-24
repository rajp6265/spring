package com.example.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
public class Patient 
{
	 @Id
	 @GeneratedValue(strategy= GenerationType.AUTO)
	 private Long patientID;
	 private String patientName;
	 
	 
	 @Temporal(TemporalType.DATE)
	 private Date dateOfBirth;
	 private char gender;
	 private String bloodgroup;
	 private String allergiesOrHabits;
	 private long contact;
	 
	 @Column(unique = true)
	 private String email;
	 private String password;
	 
	 
	 public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	@Override
	public String toString() {
		return "Patient [patientID=" + patientID + ", patientName=" + patientName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", bloodgroup=" + bloodgroup + ", allergiesOrHabits=" + allergiesOrHabits
				+ ", contact=" + contact + ", email=" + email + ", password=" + password + "]";
	}
	public String getAllergiesOrHabits() {
		return allergiesOrHabits;
	}
	public void setAllergiesOrHabits(String allergiesOrHabits) {
		this.allergiesOrHabits = allergiesOrHabits;
	}
	
	public Long getPatientID() {
		return patientID;
	}
	public void setPatientID(Long patientID) {
		this.patientID = patientID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
