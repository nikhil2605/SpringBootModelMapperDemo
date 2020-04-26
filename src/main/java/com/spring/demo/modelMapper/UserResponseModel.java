package com.spring.demo.modelMapper;

import javax.persistence.Column;

public class UserResponseModel {

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "AGE")
	private int age;

	@Column(name = "EMAIL")
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserResponseModel(String userName, int age, String email) {
		this.userName = userName;
		this.age = age;
		this.email = email;
	}

	public UserResponseModel() {
	}

}
