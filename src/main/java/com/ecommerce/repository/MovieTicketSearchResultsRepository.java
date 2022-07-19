package com.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.*;

@Repository
public interface MovieTicketSearchResultsRepository extends JpaRepository<MovieTicketSearchResults, Long> {
	@Query(value = "SELECT * FROM movie_ticket_search_results WHERE movieName = :movieName", nativeQuery = true)
	public Optional<MovieTicketSearchResults> getMovieTicketByMovieName(@Param("movieName") String movieName);
}
