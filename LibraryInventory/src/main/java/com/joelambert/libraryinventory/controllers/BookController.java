package com.joelambert.libraryinventory.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.joelambert.libraryinventory.models.Book;
import com.joelambert.libraryinventory.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookServ;
	
	
	
	//------------- CREATE -----------------//
	@GetMapping("/books/new")
	public String newBook(
		@ModelAttribute("bookObj") Book emptyBook,
		HttpSession session
	) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "/books/newBook.jsp";
	}

	@PostMapping("/books/new")
	public String processRecipe(
		@Valid @ModelAttribute("bookObj") Book filledBook,
		BindingResult results
	) {
		// logic for failed VALIDATIONS
		if(results.hasErrors()) {
			return "/books/newBook.jsp";
		}
		bookServ.create(filledBook);
		return "redirect:/books";
//		TO REDIRECT INSTEAD TO DETAILS USE THESE TWO LINES IN PLACE OF PREVIOUS 2
//		Book newBook = bookServ.create(filledBook);
//		return "redirect:/books/" + newBook.getId();

	}
	//------------- CREATE -----------------//
	
	//-------------READ ONE-------------------------
	@GetMapping("/books/{id}")
	public String oneBook(
		@PathVariable("id") Long id,
		HttpSession session,
		Model model
	) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("oneBook", bookServ.getOne(id ));
		return "/books/showBook.jsp";
	}
	
	//---------------- READ ALL --------------------
		@GetMapping("/books")
		public String index(
			HttpSession session,
			Model model
		) {
			if(session.getAttribute("user_id") == null) {
				return "redirect:/";
			}
			model.addAttribute("allBooks", bookServ.getAll());
			return"/books/index.jsp";
		}
	
	//----------------- UPDATE ----------------//
		@GetMapping("/books/{id}/edit")
		public String editBook(
			@PathVariable("id") Long id,
			Model model
		) {
			model.addAttribute("bookObj", bookServ.getOne(id));
			return "/books/editBook.jsp";
		}
		@PutMapping("/books/{id}/edit")
		public String update(
			@Valid @ModelAttribute("bookObj") Book filledBook,
			BindingResult results
		) {
			// VALIDATIONS FAIL
			if(results.hasErrors()) {
				return "/books/editBook.jsp";
		}
			bookServ.create(filledBook);
			return "redirect:/books";
		}
	//----------------- UPDATE ----------------//
	
	//---------------DELETE--------------
	@GetMapping("/books/{id}/delete")
	public String delete(
		@PathVariable("id") Long id
	) {
		bookServ.deleteOne(id);
		return"redirect:/books";
	}

}

