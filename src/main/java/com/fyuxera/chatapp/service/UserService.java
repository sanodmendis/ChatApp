package com.fyuxera.chatapp.service;

import com.fyuxera.chatapp.api.RestApiClient;
import com.fyuxera.chatapp.api.config.ApiConfig;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * User Service - REST API based
 * Handles user operations via REST API
 */
public class UserService {
    
    private final RestApiClient apiClient;
    
    public UserService() {
        this.apiClient = RestApiClient.getInstance();
    }
    
    /**
     * Search users by query
     */
    public JsonArray searchUsers(String query, int limit) throws Exception {
        String endpoint = ApiConfig.ENDPOINT_USERS_SEARCH + "?q=" + query;
        JsonObject response = apiClient.getAuth(endpoint);
        
        if (apiClient.isSuccess(response)) {
            return response.getAsJsonArray("users");
        }
        return new JsonArray();
    }
    
    // get all users
    public JsonArray getAllUsers() throws Exception {
        return searchUsers("", 100);
    }
    
    // get current user profile
    public JsonObject getCurrentUser() throws Exception {
        JsonObject response = apiClient.getAuth(ApiConfig.ENDPOINT_USERS_ME);
        
        if (apiClient.isSuccess(response)) {
            return response.getAsJsonObject("user");
        }
        return null;
    }
}
