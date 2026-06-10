package com.fyuxera.chatapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Message model class representing a chat message
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int messageId;
    private int senderId;
    private int receiverId;
    private String messageContent;
    private boolean isRead;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    private String senderUsername;
    private String receiverUsername;
    
    public Message() {
    }
    
    public Message(int senderId, int receiverId, String messageContent) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageContent = messageContent;
        this.isRead = false;
    }
    
    // getters and setters
    public int getMessageId() {
        return messageId;
    }
    
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
    
    public int getSenderId() {
        return senderId;
    }
    
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }
    
    public int getReceiverId() {
        return receiverId;
    }
    
    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }
    
    public String getMessageContent() {
        return messageContent;
    }
    
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
    
    public boolean isRead() {
        return isRead;
    }
    
    public void setRead(boolean read) {
        isRead = read;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public String getSenderUsername() {
        return senderUsername;
    }
    
    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }
    
    public String getReceiverUsername() {
        return receiverUsername;
    }
    
    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
    }
    
    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", messageContent='" + messageContent + '\'' +
                ", isRead=" + isRead +
                ", createdAt=" + createdAt +
                '}';
    }
}
