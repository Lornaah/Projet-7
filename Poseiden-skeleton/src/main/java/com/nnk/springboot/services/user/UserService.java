package com.nnk.springboot.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nnk.springboot.dto.UserDTO;
import com.nnk.springboot.model.User;

public interface UserService extends UserDetailsService {

	public User createUser(UserDTO userDTO);

	public List<User> findAllUsers();

	public User updateUser(User user);

	public Optional<User> findById(Integer id);

	public void deleteUser(User user);

}
