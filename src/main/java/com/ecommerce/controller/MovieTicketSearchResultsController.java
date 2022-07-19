package com.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.MovieTicketSearchResults;
import com.ecommerce.repository.MovieTicketSearchResultsRepository;

@RestController
@RequestMapping("/api/v1/movieTicketSearchResults")
public class MovieTicketSearchResultsController {
	
	@Autowired
	private MovieTicketSearchResultsRepository movieTicketSearchResultsRepository;
	
	@GetMapping("/movieTicket/search/results/all")
	public List<MovieTicketSearchResults> getMovieTicketByMovieName() {
		return movieTicketSearchResultsRepository.findAll();
	}
	
	@PostMapping("/movieTicket/search/results/add")
	public MovieTicketSearchResults createMovieTicketSearchResult(
			@RequestBody(required = false) String movieTicketSearchResults) {
		
		MovieTicketSearchResults movieTicketSearchResults1 = new MovieTicketSearchResults();
		movieTicketSearchResults1.setMovieName(movieTicketSearchResults);		
		return movieTicketSearchResultsRepository.save(movieTicketSearchResults1);
	}
	
	@DeleteMapping("/movieTicket/search/results/delete/")
	public void deleteAllMovieTicketSearchResults() {
		movieTicketSearchResultsRepository.deleteAll();
	}
}
