package com.nnk.springboot.services.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nnk.springboot.dto.UserDTO;
import com.nnk.springboot.model.User;

public interface UserService extends UserDetailsService {

	public User createUser(UserDTO userDTO);

}
