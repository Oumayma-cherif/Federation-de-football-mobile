/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.projet.entities;

/**
 *
 * @author wassim
 */
public class User_2 {
    
    private int id;
    private String username;
    private String email;
    private String profilePictureUrl;
    
    private static User_2 connectedUser;
    
    public User_2(int id, String username, String email, String profilePictureUrl) {
        this.email = email;
        this.username = username;
        this.id = id;
        this.profilePictureUrl = profilePictureUrl;
        System.err.println(profilePictureUrl);
    }
    
    public static void setAuthenticatedUser(int id, String username, String email, String profilePictureUrl) {
        User_2.connectedUser = new User_2(id, username, email, profilePictureUrl);
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }
    
    public static User_2 getAuthenticatedUser() {
        return User_2.connectedUser;
    }
    
    public String getUsername() {
        return this.username;
    }
}
