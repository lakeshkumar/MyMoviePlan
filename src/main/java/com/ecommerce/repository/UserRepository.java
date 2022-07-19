package com.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "SELECT * FROM users WHERE id = :id AND first_name = :firstName AND "
			+ "last_name = :lastName AND username = :username AND email = :email", nativeQuery = true)
	public Optional<User> getUserDetails(@Param("id") Long id,
			@Param("firstName") String firstName,
			@Param("lastName") String lastName,
			@Param("username") String username,
			@Param("email") String email);
}
