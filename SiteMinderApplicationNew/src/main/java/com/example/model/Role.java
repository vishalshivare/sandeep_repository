package com.example.model;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
public class Role implements GrantedAuthority{

	private String name;
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthority() {
		return this.name;
	}

	
}
