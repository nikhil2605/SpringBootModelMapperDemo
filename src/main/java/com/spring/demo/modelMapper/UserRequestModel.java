package com.spring.demo.modelMapper;

import javax.persistence.Column;

public class UserRequestModel {

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "AGE")
	private int age;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRequestModel(String userName, int age, String email, String password) {
		this.userName = userName;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	public UserRequestModel() {
	}

}
