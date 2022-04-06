package com.nnk.springboot.model;

import java.util.Arrays;

public enum AuthenticationProvider {
	LOCAL("Local"), GITHUB("Github");

	private String name;

	private AuthenticationProvider(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public static AuthenticationProvider fromString(String nameToFind) {
		return Arrays.stream(values()).filter(provider -> provider.name.equals(nameToFind)).findFirst().orElse(LOCAL);
	}
}
