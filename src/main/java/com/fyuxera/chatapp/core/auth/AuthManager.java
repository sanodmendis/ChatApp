package com.fyuxera.chatapp.core.auth;

import com.fyuxera.chatapp.api.RestApiClient;
import com.fyuxera.chatapp.api.config.ApiConfig;
import com.google.gson.JsonObject;
import com.fyuxera.chatapp.model.User;

/**
 * Authentication Manager - Handles REST API authentication
 * @author Sanod
 */
public class AuthManager {
    
    private static AuthManager instance;
    private final RestApiClient apiClient;
    
    private AuthManager() {
        this.apiClient = RestApiClient.getInstance();
    }
    
    public static synchronized AuthManager getInstance() {
        if (instance == null) {
            instance = new AuthManager();
        }
        return instance;
    }
    
    // register new user
    public boolean register(String username, String email, String password, String fullName) 
            throws Exception {
        
        if (!validate(username, email, password, fullName)) {
            return false;
        }
        
        JsonObject json = new JsonObject();
        json.addProperty("username", username);
        json.addProperty("email", email);
        json.addProperty("password", password);
        json.addProperty("full_name", fullName);
        
        JsonObject response = apiClient.post(
                ApiConfig.ENDPOINT_AUTH_REGISTER, 
                json.toString()
        );
        
        return apiClient.isSuccess(response);
    }
    
    // login user
    public User login(String username, String password) throws Exception {
        System.out.println("[AuthManager.login()] Starting login for: " + username);
        
        if (username == null || username.trim().isEmpty() || 
            password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password are required");
        }
        
        JsonObject json = new JsonObject();
        json.addProperty("username", username);
        json.addProperty("password", password);
        
        System.out.println("[AuthManager.login()] Sending login request to API");
        JsonObject response = apiClient.post(
                ApiConfig.ENDPOINT_AUTH_LOGIN, 
                json.toString()
        );
        
        System.out.println("[AuthManager.login()] Response received: " + (response != null ? "not null" : "NULL"));
        
        if (response == null) {
            throw new RuntimeException("No response from server");
        }
        
        System.out.println("[AuthManager.login()] Checking if success: " + apiClient.isSuccess(response));
        if (!apiClient.isSuccess(response)) {
            String errorMsg = response.has("message") ? 
                response.get("message").getAsString() : "Login failed";
            System.out.println("[AuthManager.login()] Login failed: " + errorMsg);
            throw new RuntimeException(errorMsg);
        }
        
        // extract token
        System.out.println("[AuthManager.login()] Extracting token...");
        if (!response.has("token")) {
            throw new RuntimeException("No token in response");
        }
        String token = response.get("token").getAsString();
        System.out.println("[AuthManager.login()] Token extracted, setting access token");
        apiClient.setAccessToken(token);
        
        // extract user data
        System.out.println("[AuthManager.login()] Extracting user data...");
        if (!response.has("user")) {
            throw new RuntimeException("No user data in response");
        }
        JsonObject userJson = response.getAsJsonObject("user");
        System.out.println("[AuthManager.login()] Parsing user JSON");
        User user = jsonToUser(userJson);
        
        System.out.println("[AuthManager.login()] Login successful for user: " + user.getUsername());
        return user;
    }
    
    // get current user profile
    public User getCurrentUserProfile() throws Exception {
        JsonObject response = apiClient.getAuth(ApiConfig.ENDPOINT_USERS_ME);
        
        if (!apiClient.isSuccess(response)) {
            return null;
        }
        
        JsonObject userJson = response.getAsJsonObject("user");
        return jsonToUser(userJson);
    }
    
    // logout - clear tokens
    public void logout() {
        apiClient.clearTokens();
    }
    
    // helpers
    
    private boolean validate(String username, String email, String password, String fullName) {
        if (username == null || username.trim().length() < 3) {
            throw new IllegalArgumentException("Username must be at least 3 characters");
        }
        
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }
        
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name is required");
        }
        
        return true;
    }
    
    private User jsonToUser(JsonObject json) {
        try {
            User user = new User();
            user.setUserId(json.get("user_id").getAsInt());
            user.setUsername(json.get("username").getAsString());
            user.setEmail(json.get("email").getAsString());
            
            String fullName = json.get("full_name").getAsString();
            String[] nameParts = fullName.split(" ", 2);
            user.setFirstName(nameParts[0]);
            user.setLastName(nameParts.length > 1 ? nameParts[1] : "");
            
            return user;
        } catch (Exception e) {
            System.err.println("Error parsing user JSON: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to parse user data: " + e.getMessage());
        }
    }
}
