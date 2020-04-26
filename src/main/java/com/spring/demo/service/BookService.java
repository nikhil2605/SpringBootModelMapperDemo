package com.spring.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.demo.entities.Book;
import com.spring.demo.entities.Book;
import com.spring.demo.modelMapper.BookResponseModel;
import com.spring.demo.modelMapper.BookRequestModel;
import com.spring.demo.modelMapper.BookResponseModel;
import com.spring.demo.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<BookResponseModel> getBooks() {
		List<BookResponseModel> bookResponseArray = new ArrayList<BookResponseModel>();
		ModelMapper modelMapper = new ModelMapper();

		for (Book book : bookRepository.findAll()) {
			bookResponseArray.add(modelMapper.map(book, BookResponseModel.class));
		}
		return bookResponseArray;
	}

	public BookResponseModel getBook(Long id) {
		if (bookRepository.existsById(id)) {
			Book book = bookRepository.getOne(id);
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(book, BookResponseModel.class);
		}
		return null;

	}

	public BookResponseModel saveBook(BookRequestModel bookRequestModel) {
		ModelMapper modelMapper = new ModelMapper();
		Book book = bookRepository.save(modelMapper.map(bookRequestModel, Book.class));
		return modelMapper.map(book, BookResponseModel.class);
	}

	public BookResponseModel updateBook(Long id, BookRequestModel bookRequestModel) {
		if (bookRepository.existsById(id)) {
			Book existingBook = bookRepository.getOne(id);
			ModelMapper modelMapper = new ModelMapper();
			Book book = bookRepository.save(modelMapper.map(bookRequestModel, Book.class));
			return modelMapper.map(book, BookResponseModel.class);
		}
		return null;
	}

	public BookResponseModel deleteBook(Long id) {
		if (bookRepository.existsById(id)) {
			Book book = bookRepository.getOne(id);
			bookRepository.deleteById(id);
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(book, BookResponseModel.class);
		}
		return null;
	}

}
