/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.projet.entities;

/**
 *
 * @author Rahmouni
 */
public class User {
	private int id;
	private String username;
	private String mdp;
	private String role;
	private String email;

	public User() {
	}

	public User(String username, String mdp, String role, String email) {
		this.username = username;
		this.mdp = mdp;
		this.role = role;
		this.email = email;
	}

	public User(int id, String username, String mdp, String role, String email) {
		this.id = id;
		this.username = username;
		this.mdp = mdp;
		this.role = role;
		this.email = email;
	}

	public User(int id, String username, String role, String email) {
		this.id = id;
		this.username = username;
		this.role = role;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}