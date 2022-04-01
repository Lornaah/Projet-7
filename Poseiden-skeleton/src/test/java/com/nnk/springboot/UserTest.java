package com.nnk.springboot;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.dto.UserDTO;
import com.nnk.springboot.services.user.UserService;

@SpringBootTest
public class UserTest {

	@Autowired
	private UserService userService;

	@Autowired
	ClearDB clearDB;

	private UserDTO userDTO;

	@BeforeEach
	public void beforeEach() {
		clearDB.clearDB();
		userDTO = new UserDTO("Test", "Test123!", "Test Test", "USER");
	}

	@Test
	public void userCreateTest() {
		// Arrange
		userService.createUser(userDTO);

		// Act
		Optional<UserDTO> user = userService.findById(userDTO.getId());

		// Assert
		assertTrue(user.isPresent());
		assertNotNull(userDTO);
	}

	@Test
	public void userUpdateTest() {
		// Arrange
		userService.createUser(userDTO);
		userDTO.setFullname("TestTest");

		// Act
		UserDTO newUserDTO = userService.updateUser(userDTO);

		// Assert
		assertTrue(newUserDTO.getFullname().equals("TestTest"));
	}

	@Test
	public void userGetTest() {
		// Arrange
		userService.createUser(userDTO);

		// Act
		List<UserDTO> userList = userService.findAllUsers();

		// Assert
		assertFalse(userList.isEmpty());
		assertTrue(userList.contains(userDTO));
	}

	@Test
	public void tradeDeleteTest() {
		// Arrange
		userService.createUser(userDTO);

		// Act
		List<UserDTO> oldList = userService.findAllUsers();
		userService.deleteUser(userDTO);
		List<UserDTO> newList = userService.findAllUsers();

		// Assert
		assertTrue(oldList.size() - 1 == newList.size());
		assertFalse(newList.contains(userDTO));
	}

}
