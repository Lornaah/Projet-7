package com.nnk.springboot.dto;

import java.util.Objects;

import com.nnk.springboot.model.AuthenticationProvider;
import com.nnk.springboot.model.User;
import com.nnk.springboot.model.UserOAuth2;

public class UserDTO {

	private Integer id;
	private String username;
	private String password;
	private String fullname;
	private String role;
	private String authenticationProvider;

	public UserDTO() {
	}

	public UserDTO(UserOAuth2 user) {
		this.username = user.getId();
		this.fullname = user.getName();
		setAuthenticationProvider(AuthenticationProvider.GITHUB);
		this.password = "GithubProvider";
		this.role = "USER";
	}

	public UserDTO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.fullname = user.getFullname();
		this.role = user.getRole();
		this.authenticationProvider = user.getAuthenticationProvider().toString();
	}

	public UserDTO(String username, String password, String fullname, String role) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.role = role;
		authenticationProvider = AuthenticationProvider.LOCAL.toString();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getAuthenticationProvider() {
		return authenticationProvider;
	}

	public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(authenticationProvider, fullname, id, password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return authenticationProvider == other.authenticationProvider && Objects.equals(fullname, other.fullname)
				&& Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", role=" + role + ", authenticationProvider=" + authenticationProvider + "]";
	}

}
