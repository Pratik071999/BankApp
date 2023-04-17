package com.monocept.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.monocept.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User , Integer>{
	
	@Query(value = "SELECT u FROM User u WHERE u.userId=:id")
	User findUserWithId(@Param("id") Long id);
	
	Optional<User> findByEmail(String email);
	Optional<User> findByUserId(Long userId);
	
//	@Query("select u from User u where u.email=:email")
//	User findUserWithEmail(@Param("email") String email);

	@Query("select u.email from User u where u.userId=:id")
	String getEmailById(@Param("id") Long id);
}
