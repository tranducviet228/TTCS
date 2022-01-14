package com.KMA.BookingCare.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.KMA.BookingCare.Dto.User;
import com.KMA.BookingCare.Dto.UserInput;
import com.KMA.BookingCare.Service.UserService;

@RestController
public class UserApi {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> getByUsername(@RequestBody UserInput userInput){
		User user=userService.findByUsername(userInput.getUsername());
	
		return new ResponseEntity<User>(user, HttpStatus.OK);
	
//	@PostMapping("/rePass")
//	public ResponseEntity<User> getById(@RequestBody UserInput userInput){
//		user=userService.getById(userInput.getI)
//	}
	

}
}
