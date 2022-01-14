package com.KMA.BookingCare.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KMA.BookingCare.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	public UserEntity findByUsername(String username);
	
	public Optional<UserEntity> findById(Long id);
}
