package com.spring.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.modelMapper.BookResponseModel;
import com.spring.demo.modelMapper.BookRequestModel;
import com.spring.demo.modelMapper.BookResponseModel;
import com.spring.demo.service.BookService;

@RestController
@RequestMapping(value = "/api")
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<BookResponseModel> getBooks() {
		return bookService.getBooks();
	}
		
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public BookResponseModel getBook(@Valid @PathVariable("id") Long id) {
		return bookService.getBook(id);
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public BookResponseModel createBook(@Valid @RequestBody BookRequestModel book) {		
		return bookService.saveBook(book);
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	public BookResponseModel updateBook(@PathVariable("id") Long id, @Valid @RequestBody BookRequestModel book) {
		return bookService.updateBook(id, book);
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public BookResponseModel deleteBook(@PathVariable("id") Long id) {
		return bookService.deleteBook(id);
	}
	
}
