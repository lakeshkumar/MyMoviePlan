package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.MovieTicket;
import com.ecommerce.repository.MovieTicketRepository;

@RestController
@RequestMapping("/api/v1/movieTicket")
public class MovieTicketController {
	
	@Autowired
	MovieTicketRepository movieTicketRepository;
	
	@GetMapping("/movieTickets/all")
	public List<MovieTicket> getAllMovieTickets() {
		return movieTicketRepository.findAll();
	}
	
	@GetMapping("/movieTickets/getAParticularMovie/{movieName}")
	public Optional<MovieTicket> getMovieTicketByMovieName(@PathVariable String movieName) {
		return movieTicketRepository.getMovieTicketByMovieName(movieName);
	}
	
	@GetMapping("/movieTickets/getAParticularMovieById/{id}")
	public MovieTicket getMovieTicketById(@PathVariable Long id) {
		return movieTicketRepository.getById(id);
	}
	
	@PostMapping("/movieTickets/add")
	public MovieTicket addMovieTicket(@RequestBody(required = false) MovieTicket movieTicket) {
		return movieTicketRepository.save(movieTicket);
	}
	
	@PutMapping("/movieTickets/update")
	public MovieTicket updateMovieTicket(@RequestBody(required = false) MovieTicket movieTicket) {
		return movieTicketRepository.save(movieTicket);
	}
	
	@DeleteMapping("/movieTickets/delete/{id}")
	public void deleteMovieTicket(@PathVariable Long id) {
		movieTicketRepository.deleteById(id);
	}
}
