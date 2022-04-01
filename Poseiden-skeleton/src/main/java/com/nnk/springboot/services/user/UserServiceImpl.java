package com.nnk.springboot.services.user;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
	public UserDTO createUser(UserDTO userDTO) {
		logger.info("createUser called with the user : " + userDTO.toString());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userDTO.setPassword(encoder.encode(userDTO.getPassword()));

		User user = new User();
		user.update(userDTO);
		userRepository.save(user);
		userDTO.setId(user.getId());

		return userDTO;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		logger.info("loadUserByUsername called with the userName : " + userName);
		Optional<User> user = userRepository.findByUsername(userName);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

		return user.map(UserDetailsImpl::new).get();

	}

	@Override
	public List<UserDTO> findAllUsers() {
		logger.info("findAllUsers called");
		List<User> userList = userRepository.findAll();
		List<UserDTO> userListDTO = userList.stream().map(u -> new UserDTO(u)).toList();
		return userListDTO;
	}

	@Override
	@Transactional
	public UserDTO updateUser(UserDTO userDTO) {
		logger.info("updateUser called on " + userDTO.toString());
		User user = userRepository.getById(userDTO.getId());
		user.update(userDTO);
		userRepository.save(user);
		return userDTO;
	}

	@Override
	public Optional<UserDTO> findById(Integer id) {
		logger.info("findById called with id : " + id);
		Optional<User> user = userRepository.findById(id);
		return user.map(u -> new UserDTO(u));
	}

	@Override
	public void deleteUser(UserDTO user) {
		logger.info("deleteUser called on " + user.toString());
		userRepository.deleteById(user.getId());
	}

}
