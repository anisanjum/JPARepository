package com.learn.springbootcrudrepository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long studentId;

	@NotNull(message= "First Name canot be null")
	@Column(name = "student_firstnm")
	@Size(min=2, max=30)
	private String studentFirstName;

	@Column(name = "student_lastnm")
	@NotNull(message= "Last Name canot be null")
	@Size(min=2, max=30)
	private String studentLastName;

	@Column(name = "student_course")
	@NotBlank(message="Please enter your course")
	private String studentCourse;

	@Column
	@NotBlank(message="Please enter your country")
	private String country;

	@Column
	@NotBlank(message="Please enter your state")
	private String state;

	@Column
	@NotBlank(message="Please enter your city")
	private String city;

	@Column
	@Email
	@NotBlank(message="Please enter your email")
	@NotNull(message= "Email Id cannot be null")
	private String email;

	@Column
	@NotBlank(message="Please enter your phone number")
	@NotNull(message= "Phone Number cannot be null")
	private String phoneNo;


	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
