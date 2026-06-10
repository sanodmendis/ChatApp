package com.fyuxera.chatapp.core.session;

import com.fyuxera.chatapp.model.User;

/**
 * Session Manager - Manages current user session
 * Stores JWT token and user information
 * @author Sanod
 */
public class SessionManager {
    
    private static SessionManager instance;
    private User currentUser;
    private String accessToken;
    
    private SessionManager() {
    }
    
    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    
    // session management
    
    public void login(User user, String token) {
        this.currentUser = user;
        this.accessToken = token;
    }
    
    public void logout() {
        this.currentUser = null;
        this.accessToken = null;
    }
    
    public boolean isLoggedIn() {
        return currentUser != null && accessToken != null;
    }
    
    // getters
    
    public User getCurrentUser() {
        return currentUser;
    }
    
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
    
    public String getAccessToken() {
        return accessToken;
    }
    
    public void setAccessToken(String token) {
        this.accessToken = token;
    }
    
    public int getCurrentUserId() {
        return currentUser != null ? currentUser.getUserId() : -1;
    }
    
    public String getCurrentUsername() {
        return currentUser != null ? currentUser.getUsername() : null;
    }
}
