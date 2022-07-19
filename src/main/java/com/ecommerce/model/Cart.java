package com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "movie_name")
	private String movieName;
	
	@Column(name = "show_date")
	private String showDate;
	
	@Column(name = "show_time")
	private String showTime;
	
	@Column(name = "showing_location")
	private String showingLocation;
	
	@Column(name = "price")
	private Long price;
	
	public Cart() {}

	public Cart(String movieName, String showDate, String showTime, String showingLocation, Long price) {
		super();
		this.movieName = movieName;
		this.showDate = showDate;
		this.showTime = showTime;
		this.showingLocation = showingLocation;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getShowingLocation() {
		return showingLocation;
	}

	public void setShowingLocation(String showingLocation) {
		this.showingLocation = showingLocation;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
	
}
