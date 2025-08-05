package com.amit.UserService.Mapper;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.amit.UserService.DTO.UserDTO;
import com.amit.UserService.Entity.User;

@Component
public class UserModelMapper {
	
	private final ModelMapper modelMapper;
	
	public UserModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
	
	
	public UserDTO maptoUserDTO(User user)
	{
		 UserDTO mappedUserDto = this.modelMapper.map(user, UserDTO.class);
		 return mappedUserDto;
		 
	}
	
	public User maptoUser(UserDTO userDTO) {
		 User mappeduser=this.modelMapper.map(userDTO, User.class);
		 return mappeduser;
		
	}

}
