package com.spring.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.entities.Author;
import com.spring.demo.modelMapper.AuthorRequestModel;
import com.spring.demo.modelMapper.AuthorResponseModel;
import com.spring.demo.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public List<AuthorResponseModel> getAuthors() {
		List<AuthorResponseModel> authorResponseArray = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();

		for (Author author : authorRepository.findAll()) {
			authorResponseArray.add(modelMapper.map(author, AuthorResponseModel.class));
		}
		return authorResponseArray;
	}

	public AuthorResponseModel getAuthor(Long id) {
		if (authorRepository.existsById(id)) {
			Author author = authorRepository.getOne(id);
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(author, AuthorResponseModel.class);
		}
		return null;

	}

	public AuthorResponseModel saveAuthor(AuthorRequestModel authorRequestModel) {
		ModelMapper modelMapper = new ModelMapper();
		Author author = authorRepository.save(modelMapper.map(authorRequestModel, Author.class));
		return modelMapper.map(author, AuthorResponseModel.class);
	}

	public AuthorResponseModel updateAuthor(Long id, AuthorRequestModel authorRequestModel) {
		if (authorRepository.existsById(id)) {
			Author existingAuthor = authorRepository.getOne(id);
			ModelMapper modelMapper = new ModelMapper();
			Author author = authorRepository.save(modelMapper.map(existingAuthor, Author.class));
			return modelMapper.map(author, AuthorResponseModel.class);
		}
		return null;
	}

	public AuthorResponseModel deleteAuthor(Long id) {
		if (authorRepository.existsById(id)) {
			Author author = authorRepository.getOne(id);
			authorRepository.deleteById(id);
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(author, AuthorResponseModel.class);
		}
		return null;
	}
}
