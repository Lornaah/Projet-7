package com.nnk.springboot.services.user;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private static final Logger logger = LogManager.getLogger("UserService");

	@Override
	public User createUser(UserDTO userDTO) {

		logger.info("createUser called with the user : " + userDTO.toString());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userDTO.setPassword(encoder.encode(userDTO.getPassword()));

		User user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFullname());

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		logger.info("loadUserByUsername called with the userName : " + userName);
		Optional<User> user = userRepository.findByUsername(userName);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

		return user.map(UserDetailsImpl::new).get();

	}

	@Override
	public List<User> findAllUsers() {
		logger.info("findAllUsers called");
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		logger.info("updateUser called on " + user.toString());
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findById(Integer id) {
		logger.info("findById called with id : " + id);
		return userRepository.findById(id);
	}

	@Override
	public void deleteUser(User user) {
		logger.info("deleteUser called on " + user.toString());
		userRepository.delete(user);
	}

}
