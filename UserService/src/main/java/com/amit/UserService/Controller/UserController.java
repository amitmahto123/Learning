package com.amit.UserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.UserService.DTO.UserDTO;
import com.amit.UserService.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/SaveUser")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
		UserDTO saveUser = userService.saveUser(userDTO);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<UserDTO>> getAllUsers()
	{
		List<UserDTO> allUsers = userService.getAllUser();
		return new ResponseEntity<List<UserDTO>>(allUsers, HttpStatus.OK);
	}
	
	@GetMapping("userById/{id}")
	public ResponseEntity<UserDTO> getUserBYId(@PathVariable Integer id)
	{
		UserDTO userById = userService.getUserById(id);
		return new ResponseEntity<UserDTO>(userById, HttpStatus.OK);
	}

}
