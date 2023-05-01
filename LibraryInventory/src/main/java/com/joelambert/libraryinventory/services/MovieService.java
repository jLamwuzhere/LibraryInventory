package com.joelambert.libraryinventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joelambert.libraryinventory.models.Movie;
import com.joelambert.libraryinventory.repositories.MovieRepository;

@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepo;
	
	// CREATE & UPDATE ONE Movie
	public Movie create(Movie newMovie) {
		return  movieRepo.save(newMovie);
	}

	// FIND (READ)  ONE Movie
	public Movie getOne(Long id) {
		return movieRepo.findById(id).orElse(null);
	}

	// FIND (READ) ALL Movies
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}

		
	// DELETE ONE Movie
	public void deleteOne(Long id) {
		movieRepo.deleteById(id);
	}
	
}
