package com.KMA.BookingCare.ServiceImpl;

import java.nio.file.attribute.UserPrincipal;
import java.util.HashSet;
import java.util.List

;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.KMA.BookingCare.Dto.Role;
import com.KMA.BookingCare.Dto.User;
import com.KMA.BookingCare.Entity.RoleEntity;
import com.KMA.BookingCare.Entity.UserEntity;
import com.KMA.BookingCare.Repository.RoleRepository;
import com.KMA.BookingCare.Repository.UserRepository;
import com.KMA.BookingCare.Service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public void add(User user,String nameRole) {
		UserEntity userEntity= new UserEntity();
		userEntity.setId(user.getId());
		userEntity.setName(user.getName());
	    userEntity.setEmail(user.getEmail());
	    userEntity.setUsername(user.getUsername());
	    userEntity.setBirthYear(user.getBirthYear());
	    userEntity.setLocation(user.getLocation());
	    userEntity.setNameScheduler(user.getNameScheduler());
	    userEntity.setPhone(user.getPhone());
	    userEntity.setSex(user.getSex());
	    userEntity.setReason(user.getReason());
	    userEntity.setPhoneScheduler(user.getPhoneScheduler());
	    userEntity.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));

	    if(nameRole.equals("admin")) {
	    	Set<RoleEntity> role= new HashSet<RoleEntity>(roleRepository.findAll());
	    	userEntity.setRoles(role);
	    }
	    else if (nameRole.equals("member")) {
	    	Set<RoleEntity> role= new HashSet<RoleEntity>(roleRepository.findByName("ROLE_MEMBER"));
	    	userEntity.setRoles(role);
		}
	    else if (nameRole.equals("doctor")) {
	    	Set<RoleEntity> role= new HashSet<RoleEntity>(roleRepository.findByName("ROLE_DOCTOR"));
	    	userEntity.setRoles(role);
		}

		
	     
		userRepository.save(userEntity);
		
		
	}

	@Override
	public void update(User user) {
		UserEntity userEntity = new UserEntity();
		UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String password= userDetails.getPassword();
		userEntity.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(userEntity);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		User user = new User();
	
		UserEntity userEntity = userRepository.findByUsername(username);
		user.setId(userEntity.getId());
		user.setName(userEntity.getName());
		user.setUsername(userEntity.getUsername());
		user.setPassword((userEntity.getPassword()));
		user.setEmail(userEntity.getEmail());
		user.setRole(userEntity.getRole());
		Set<RoleEntity> set = userEntity.getRoles();
		Set<Role> roles = new HashSet<Role>();
		for (RoleEntity roleEn : userEntity.getRoles()) {
			Role role = new Role();
			role.setId(roleEn.getId());
			role.setName(roleEn.getName());
			roles.add(role);
		}
		user.setRoles(roles);
		return user;
	

		
	}

	


}
