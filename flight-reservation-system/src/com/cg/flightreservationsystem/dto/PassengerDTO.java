package com.cg.flightreservationsystem.dto;

public class PassengerDTO{
	
	private String id;
	private String name;
	private String age;
	private String mobileNo;
	private String emailId;
	
	public PassengerDTO() {
		super();
	}

	public PassengerDTO(String name, String age, String mobileNo, String emailId) {
		super();
		this.name = name;
		this.age = age;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}
	
	public PassengerDTO(String id, String name, String age, String mobileNo, String emailId) {
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
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
		return "Passenger :\n\tId: "+ id + "\n\tName: " + name + "\n\tAge: " + age + "\n\tMobile no.: " + mobileNo + "\n\tEmailId: " + emailId;
	}
}
