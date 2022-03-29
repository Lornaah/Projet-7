package com.nnk.springboot.dto;

import java.util.Objects;

public class UserDTO {

	private String username;
	private String password;
	private String fullname;

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

	@Override
	public int hashCode() {
		return Objects.hash(fullname, password, username);
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
		return Objects.equals(fullname, other.fullname) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", fullname=" + fullname + "]";
	}

}
