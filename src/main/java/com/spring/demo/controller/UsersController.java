package com.spring.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.demo.modelMapper.UserRequestModel;
import com.spring.demo.modelMapper.UserResponseModel;
import com.spring.demo.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UsersController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserResponseModel> getUsers() {
		return userService.getUsers();
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public UserResponseModel getUser(@Valid @PathVariable("id") Long id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public UserResponseModel createUser(@Valid @RequestBody UserRequestModel user) {
		return userService.saveUser(user);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public UserResponseModel updateUser(@PathVariable("id") Long id, @Valid @RequestBody UserRequestModel user) {
		return userService.updateUser(id, user);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public UserResponseModel deleteUser(@PathVariable("id") Long id) {
		return userService.deleteUser(id);
	}

}
