package com.spring.demo.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.spring.demo.modelMapper.AuthorRequestModel;
import com.spring.demo.modelMapper.AuthorResponseModel;
import com.spring.demo.service.AuthorService;

@RestController
@RequestMapping(value = "/api")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;	
	
	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public List<AuthorResponseModel> getAuthors() {
		return authorService.getAuthors();
	}
	
	@RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
	public AuthorResponseModel getAuthor(@Valid @PathVariable("id") Long id) {
		return authorService.getAuthor(id);
	}

	@RequestMapping(value = "/authors", method = RequestMethod.POST)
	public AuthorResponseModel saveAuthor(@Valid @RequestBody AuthorRequestModel author) {
		return authorService.saveAuthor(author);
	}

	@RequestMapping(value = "/authors/{id}", method = RequestMethod.PUT)
	public AuthorResponseModel updateAuthor(@PathVariable("id") Long id, @Valid @RequestBody AuthorRequestModel author) {
		return authorService.updateAuthor(id, author);
	}

	@RequestMapping(value = "/authors/{id}", method = RequestMethod.DELETE)
	public AuthorResponseModel deleteAuthor(@PathVariable("id") Long id) {
		return authorService.deleteAuthor(id);
	}

}
