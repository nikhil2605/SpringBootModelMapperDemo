package com.spring.demo.modelMapper;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.demo.entities.Book;

public class AuthorResponseModel {

	private String authorName;

	@JsonBackReference
	private List<Book> bookList;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public AuthorResponseModel(String authorName, List<Book> bookList) {
		this.authorName = authorName;
		this.bookList = bookList;
	}

	public AuthorResponseModel() {
	}

}
