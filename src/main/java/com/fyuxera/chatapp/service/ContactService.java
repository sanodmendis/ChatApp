package com.fyuxera.chatapp.service;

import com.fyuxera.chatapp.api.RestApiClient;
import com.fyuxera.chatapp.api.config.ApiConfig;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Contact Service - REST API based
 * Handles contact operations via REST API
 */
public class ContactService {
    
    private final RestApiClient apiClient;
    
    public ContactService() {
        this.apiClient = RestApiClient.getInstance();
    }
    
    /**
     * Add a contact by username
     * @param username the username to add as a contact
     * @return JsonObject with contact info, or null on failure
     */
    public JsonObject addContact(String username) throws Exception {
        JsonObject json = new JsonObject();
        json.addProperty("username", username);
        
        JsonObject response = apiClient.postAuth(
                ApiConfig.ENDPOINT_CONTACTS,
                json.toString()
        );
        
        if (apiClient.isSuccess(response) && response.has("contact")) {
            return response.getAsJsonObject("contact");
        }
        return null;
    }
    
    /**
     * Get all contacts for the current user
     * @return JsonArray of contacts
     */
    public JsonArray getContacts() throws Exception {
        JsonObject response = apiClient.getAuth(ApiConfig.ENDPOINT_CONTACTS);
        
        if (apiClient.isSuccess(response)) {
            return response.getAsJsonArray("contacts");
        }
        return new JsonArray();
    }
    
    /**
     * Search for users to add as contacts
     * @param query search query
     * @return JsonArray of users that can be added
     */
    public JsonArray searchUsers(String query) throws Exception {
        String endpoint = ApiConfig.ENDPOINT_CONTACTS_SEARCH + "?q=" + query;
        JsonObject response = apiClient.getAuth(endpoint);
        
        if (apiClient.isSuccess(response)) {
            return response.getAsJsonArray("users");
        }
        return new JsonArray();
    }
    
    /**
     * Remove a contact by contact ID
     * @param contactId the contact ID to remove
     * @return true if successful
     */
    public boolean removeContact(int contactId) throws Exception {
        String endpoint = ApiConfig.ENDPOINT_CONTACTS + "/" + contactId;
        JsonObject response = apiClient.deleteAuth(endpoint);
        return apiClient.isSuccess(response);
    }
    
    /**
     * Block a contact
     * @param contactId the contact ID to block
     * @return true if successful
     */
    public boolean blockContact(int contactId) throws Exception {
        String endpoint = ApiConfig.ENDPOINT_CONTACTS + "/" + contactId + "/block";
        JsonObject response = apiClient.putAuth(endpoint, "{}");
        return apiClient.isSuccess(response);
    }
    
    /**
     * Unblock a contact
     * @param contactId the contact ID to unblock
     * @return true if successful
     */
    public boolean unblockContact(int contactId) throws Exception {
        String endpoint = ApiConfig.ENDPOINT_CONTACTS + "/" + contactId + "/unblock";
        JsonObject response = apiClient.putAuth(endpoint, "{}");
        return apiClient.isSuccess(response);
    }
}
