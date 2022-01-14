package com.KMA.BookingCare.Service;

import java.util.List;

import com.KMA.BookingCare.Dto.Role;
import com.KMA.BookingCare.Dto.User;

public interface UserService {
	public void add(User user, String roleName);
	public void update(User user);
	public void delete(Long id);
	public User getById(Long id);
	public User findByUsername(String username) ;
	public List<User> getAll();
	
}
