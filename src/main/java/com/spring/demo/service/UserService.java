package com.spring.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.demo.entities.Users;
import com.spring.demo.modelMapper.UserRequestModel;
import com.spring.demo.modelMapper.UserResponseModel;
import com.spring.demo.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	private UsersRepository usersRepository;

	public List<UserResponseModel> getUsers() {
		List<UserResponseModel> userResponseArray = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();

		for (Users user : usersRepository.findAll()) {
			userResponseArray.add(modelMapper.map(user, UserResponseModel.class));
		}
		return userResponseArray;
	}

	public UserResponseModel getUser(Long id) {
		if (usersRepository.existsById(id)) {
			Users user = usersRepository.getOne(id);
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(user, UserResponseModel.class);
		}
		return null;

	}

	public UserResponseModel saveUser(UserRequestModel userRequestModel) {
		ModelMapper modelMapper = new ModelMapper();
		Users user = usersRepository.save(modelMapper.map(userRequestModel, Users.class));
		return modelMapper.map(user, UserResponseModel.class);
	}

	public UserResponseModel updateUser(Long id, UserRequestModel userRequestModel) {
		if (usersRepository.existsById(id)) {
			Users existingUser = usersRepository.getOne(id);
			if (existingUser != null) {
				existingUser.setUserName(userRequestModel.getUserName());
				existingUser.setAge(userRequestModel.getAge());
				existingUser.setEmail(userRequestModel.getEmail());
				existingUser.setPassword(userRequestModel.getPassword());
			}
			ModelMapper modelMapper = new ModelMapper();
			Users user = usersRepository.save(modelMapper.map(existingUser, Users.class));
			return modelMapper.map(user, UserResponseModel.class);
		}
		return null;
	}

	public UserResponseModel deleteUser(Long id) {
		if (usersRepository.existsById(id)) {
			Users user = usersRepository.getOne(id);
			usersRepository.deleteById(id);
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(user, UserResponseModel.class);
		}
		return null;
	}

}
