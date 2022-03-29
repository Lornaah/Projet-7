package com.nnk.springboot.services.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nnk.springboot.dto.UserDTO;
import com.nnk.springboot.model.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.security.UserDetailsImpl;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(UserDTO userDTO) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userDTO.setPassword(encoder.encode(userDTO.getPassword()));

		User user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFullname());

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

		return user.map(UserDetailsImpl::new).get();

	}

}
