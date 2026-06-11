package com.fyuxera.chatapp.service;

import com.fyuxera.chatapp.api.RestApiClient;
import com.fyuxera.chatapp.api.config.ApiConfig;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Message Service - REST API based
 * Handles messaging operations via REST API
 */
public class MessageService {
    
    private final RestApiClient apiClient;
    
    public MessageService() {
        this.apiClient = RestApiClient.getInstance();
    }
    
    // send a message
    public boolean sendMessage(int recipientId, String messageText) throws Exception {
        if (messageText == null || messageText.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        
        JsonObject json = new JsonObject();
        json.addProperty("recipient_id", recipientId);
        json.addProperty("message_text", messageText);
        
        JsonObject response = apiClient.postAuth(
                ApiConfig.ENDPOINT_MESSAGES_SEND,
                json.toString()
        );
        
        return apiClient.isSuccess(response);
    }
    
    // send a message (with sender ID)
    public int sendMessage(int senderId, int recipientId, String messageText) throws Exception {
        if (messageText == null || messageText.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        
        JsonObject json = new JsonObject();
        json.addProperty("recipient_id", recipientId);
        json.addProperty("message_text", messageText);
        
        JsonObject response = apiClient.postAuth(
                ApiConfig.ENDPOINT_MESSAGES_SEND,
                json.toString()
        );
        
        if (apiClient.isSuccess(response) && response.has("message_id")) {
            return response.get("message_id").getAsInt();
        }
        return -1;
    }
    
    // get conversation with a user
    public JsonArray getConversation(int userId, int limit, int offset) throws Exception {
        String endpoint = ApiConfig.ENDPOINT_MESSAGES_CONVERSATION + userId + 
                         "?limit=" + limit + "&offset=" + offset;
        JsonObject response = apiClient.getAuth(endpoint);
        
        if (apiClient.isSuccess(response)) {
            return response.getAsJsonArray("messages");
        }
        return new JsonArray();
    }
    
    // get conversation with a user (with default pagination)
    public JsonArray getConversation(int currentUserId, int otherUserId) throws Exception {
        return getConversation(otherUserId, 50, 0);
    }
    
    // delete a message
    public boolean deleteMessage(int messageId) throws Exception {
        String endpoint = ApiConfig.ENDPOINT_MESSAGES_DELETE + messageId;
        JsonObject response = apiClient.deleteAuth(endpoint);
        return apiClient.isSuccess(response);
    }
    
    // update a message
    public boolean updateMessage(int messageId, String newText) throws Exception {
        if (newText == null || newText.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        
        JsonObject json = new JsonObject();
        json.addProperty("message_text", newText);
        
        String endpoint = ApiConfig.ENDPOINT_MESSAGES_UPDATE + messageId;
        JsonObject response = apiClient.putAuth(endpoint, json.toString());
        return apiClient.isSuccess(response);
    }
    
    // mark all messages from a sender as read
    public boolean markMessagesAsRead(int senderId) throws Exception {
        JsonObject json = new JsonObject();
        json.addProperty("sender_id", senderId);

        JsonObject response = apiClient.putAuth(
                ApiConfig.ENDPOINT_MESSAGES_READ,
                json.toString()
        );
        return apiClient.isSuccess(response);
    }

    // get all conversations
    public JsonArray getConversations() throws Exception {
        JsonObject response = apiClient.getAuth(ApiConfig.ENDPOINT_CONVERSATIONS);
        
        if (apiClient.isSuccess(response)) {
            return response.getAsJsonArray("conversations");
        }
        return new JsonArray();
    }
}

