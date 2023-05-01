package com.joelambert.libraryinventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joelambert.libraryinventory.models.Book;
import com.joelambert.libraryinventory.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepo;
	
	// CREATE & UPDATE ONE BOOK
	public Book create(Book newBook) {
		return bookRepo.save(newBook);
	}

	// FIND (READ)  ONE BOOK
	public Book getOne(Long id) {
		return bookRepo.findById(id).orElse(null);
	}

	// FIND (READ) ALL BOOKS
	public List<Book> getAll() {
		return bookRepo.findAll();
	}

		
	// DELETE ONE BOOK
	public void deleteOne(Long id) {
		bookRepo.deleteById(id);
	}


}
