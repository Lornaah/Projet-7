package com.nnk.springboot.services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.nnk.springboot.dto.UserDTO;

public interface UserService extends UserDetailsService {

	public UserDTO createUser(UserDTO userDTO);

	public List<UserDTO> findAllUsers();

	public UserDTO updateUser(UserDTO user);

	public Optional<UserDTO> findById(Integer id);

	public void deleteUser(UserDTO user);

	public Optional<? extends GrantedAuthority> getRole();

	public boolean userMatchesUserName(String userName);

}
