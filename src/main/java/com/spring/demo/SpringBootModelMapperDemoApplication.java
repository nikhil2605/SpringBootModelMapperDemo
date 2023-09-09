package com.spring.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spring.demo.entities.Author;
import com.spring.demo.entities.Book;
import com.spring.demo.entities.Users;
import com.spring.demo.repository.AuthorRepository;
import com.spring.demo.repository.BookRepository;
import com.spring.demo.repository.UsersRepository;

@SpringBootApplication
public class SpringBootModelMapperDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootModelMapperDemoApplication.class, args);
	}

	@Autowired
	BookRepository bookRepositoty;

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	UsersRepository usersRepository;

	@PostConstruct
	public void insertData() {

		Author author1 = new Author("Nirali");
		Author author2 = new Author("TechMax");
		authorRepository.save(author1);
		authorRepository.save(author2);

		Book book1 = new Book("Math1", 250.22, author1);
		Book book2 = new Book("Chemistry", 210.00, author1);
		Book book3 = new Book("Botony", 150.00, author2);
		Book book4 = new Book("Zoology", 100.00, author2);
		bookRepositoty.save(book1);
		bookRepositoty.save(book2);
		bookRepositoty.save(book3);
		bookRepositoty.save(book4);

		Users user1 = new Users("Nikhil", "nikhil12@gmail.com", "Nikhil456", 25);
		Users user2 = new Users("Raj", "raj14@gmail.com", "raj4714", 15);
		Users user3 = new Users("Sonal", "sonal14@gmail.com", "saonali56", 21);
		usersRepository.save(user1);
		usersRepository.save(user2);
		usersRepository.save(user3);

	}

}
