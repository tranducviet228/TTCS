package com.KMA.BookingCare.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.KMA.BookingCare.Dto.Role;
import com.KMA.BookingCare.Dto.User;
import com.KMA.BookingCare.Service.UserService;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= userService.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> grantedAuthorities= new ArrayList<GrantedAuthority>();
//		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		for(Role role: user.getRoles()) {
//			System.out.println(role.getName());
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		UserDetails userDetails= new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
		
		return userDetails;
	}

}
