package com.spring.demo.modelMapper;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.demo.entities.Author;

public class BookRequestModel {
	
	private String bookName;

	private Double bookPrice;

	@JsonManagedReference
	private Author author;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public BookRequestModel(String bookName, Double bookPrice, Author author) {
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.author = author;
	}

	public BookRequestModel() {
	}
	
	
	

}
