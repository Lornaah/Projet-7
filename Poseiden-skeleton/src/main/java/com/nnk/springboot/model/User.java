package com.nnk.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.nnk.springboot.dto.UserDTO;

@Entity
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "username", "authenticationProvider" }) })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message = "Username is mandatory")
	@Column(unique = true)
	private String username;
	@NotBlank(message = "Password is mandatory")
	private String password;
	@NotBlank(message = "FullName is mandatory")
	private String fullname;
	@NotBlank(message = "Role is mandatory")
	private String role;
	@NotNull
	@Enumerated(EnumType.STRING)
	private AuthenticationProvider authenticationProvider;

	public void update(UserDTO userDTO) {
		this.username = userDTO.getUsername();
		this.password = userDTO.getPassword();
		this.fullname = userDTO.getFullname();
		this.role = userDTO.getRole();
		this.authenticationProvider = AuthenticationProvider.fromString(userDTO.getAuthenticationProvider());
	}

	public User(String username, String password, String fullname) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.role = "USER";
		this.authenticationProvider = AuthenticationProvider.LOCAL;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AuthenticationProvider getAuthenticationProvider() {
		return authenticationProvider;
	}

	public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", role=" + role + ", authenticationProvider=" + authenticationProvider + "]";
	}

}
