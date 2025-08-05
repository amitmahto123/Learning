package com.amit.UserService.Service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.UserService.DTO.UserDTO;
import com.amit.UserService.Entity.User;
import com.amit.UserService.Mapper.UserModelMapper;
import com.amit.UserService.UserRepo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserModelMapper userModelMapper;
	
	public List<UserDTO> getAllUser() {
		List<User> users = userRepository.findAll();
		List<UserDTO> userslist = users.stream().map(userModelMapper::maptoUserDTO).toList();
		return userslist;
	}

	public UserDTO getUserById(Integer id) {
		Optional<User> optionalUserById = userRepository.findById(id);
		if (optionalUserById.isPresent()) {
			return userModelMapper.maptoUserDTO(optionalUserById.get());
		}

		else {
			return null;
		}

	}
	
	public UserDTO saveUser(UserDTO userDTO)
	{
		User savedUser = userRepository.save(userModelMapper.maptoUser(userDTO));
		return userModelMapper.maptoUserDTO(savedUser);
	}
}
