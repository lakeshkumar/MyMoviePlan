package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Cart;
import com.ecommerce.repository.CartRepository;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
	
	@Autowired
	CartRepository cartRepository;
	
	@GetMapping("/movieTickets/all")
	public List<Cart> getAllMovieTickets() {
		return cartRepository.findAll();
	}
	
	@PostMapping("/movieTickets/add")
	public Cart addMovieTicketToCart(@RequestBody(required = false) Cart cart) {
		return cartRepository.save(cart);
	}
	
	@DeleteMapping("/movieTickets/delete/{id}")
	public void deleteMovieTicketFromCart(@PathVariable Long id) {
		cartRepository.deleteById(id);
	}
	
	@DeleteMapping("/movieTickets/delete/all")
	public void deleteAllMovieTickets() {
		cartRepository.deleteAll();
	}
}
