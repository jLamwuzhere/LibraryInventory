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

import com.joelambert.libraryinventory.models.Movie;
import com.joelambert.libraryinventory.services.MovieService;

@Controller
public class MovieController {
	@Autowired
	MovieService movieServ;
	
	
	
	//------------- CREATE -----------------//
	@GetMapping("/movies/new")
	public String newBook(
		@ModelAttribute("movieObj") Movie emptyMovie,
		HttpSession session
	) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "/movies/newMovie.jsp";
	}

	@PostMapping("/movies/new")
	public String processRecipe(
		@Valid @ModelAttribute("movieObj") Movie filledMovie,
		BindingResult results
	) {
		// logic for failed VALIDATIONS
		if(results.hasErrors()) {
			return "/movies/newMovie.jsp";
		}
		movieServ.create(filledMovie);
		return "redirect:/movies";
//		TO REDIRECT INSTEAD TO DETAILS USE THESE TWO LINES IN PLACE OF PREVIOUS 2
//		Movie newMovie = movieServ.create(filledMovie);
//		return "redirect:/movies/" + newMovie.getId();

	}
	//------------- CREATE -----------------//
	
	//-------------READ ONE-------------------------
	@GetMapping("/movies/{id}")
	public String oneMovie(
		@PathVariable("id") Long id,
		HttpSession session,
		Model model
	) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("oneMovie", movieServ.getOne(id ));
		return "/movies/showMovie.jsp";
	}
	
	//---------------- READ ALL --------------------
		@GetMapping("/movies")
		public String index(
			HttpSession session,
			Model model
		) {
			if(session.getAttribute("user_id") == null) {
				return "redirect:/";
			}
			model.addAttribute("allMovies", movieServ.getAll());
			return"/movies/index.jsp";
		}
	
	//----------------- UPDATE ----------------//
		@GetMapping("/movies/{id}/edit")
		public String editMovie(
			@PathVariable("id") Long id,
			Model model
		) {
			model.addAttribute("movieObj", movieServ.getOne(id));
			return "/movies/editMovie.jsp";
		}
		@PutMapping("/movies/{id}/edit")
		public String update(
			@Valid @ModelAttribute("movieObj") Movie filledMovie,
			BindingResult results
		) {
			// VALIDATIONS FAIL
			if(results.hasErrors()) {
				return "/movies/editMovie.jsp";
		}
			movieServ.create(filledMovie);
			return "redirect:/movies";
		}
	//----------------- UPDATE ----------------//
	
	//---------------DELETE--------------
	@GetMapping("/movies/{id}/delete")
	public String delete(
		@PathVariable("id") Long id
	) {
		movieServ.deleteOne(id);
		return"redirect:/movies";
	}

}