package com.cg.flightreservationsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class PassengerDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PASSENGER_SEQ")
	@SequenceGenerator(name = "PASSENGER_SEQ", sequenceName = "passenger_seq")
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int age;

	@Column(name = "mobile_no", nullable = false)
	private String mobileNo;

	@Column(name = "email_id")
	private String emailId;

	public PassengerDTO() {
		super();
	}

	public PassengerDTO(String name, int age, String mobileNo, String emailId) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}

	public PassengerDTO(String id, String name, int age, String mobileNo, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Passenger :\n\tId: " + id + "\n\tName: " + name + "\n\tAge: " + age + "\n\tMobile no.: " + mobileNo
				+ "\n\tEmailId: " + emailId;
	}
}
