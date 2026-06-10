package com.fyuxera.chatapp.api.config;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * API Configuration
 * @author Sanod
 */
public class ApiConfig {

    private static final Dotenv dotenv = Dotenv.load();

    // API Base URL from .env
    public static final String BASE_URL = dotenv.get("BASE_URL");

    // Endpoints
    public static final String ENDPOINT_AUTH_REGISTER = "/auth/register";
    public static final String ENDPOINT_AUTH_LOGIN = "/auth/login";
    public static final String ENDPOINT_USERS_ME = "/users/me";
    public static final String ENDPOINT_USERS_SEARCH = "/users";
    public static final String ENDPOINT_MESSAGES_SEND = "/messages";
    public static final String ENDPOINT_MESSAGES_CONVERSATION = "/messages/";
    public static final String ENDPOINT_CONVERSATIONS = "/conversations";
    public static final String ENDPOINT_MESSAGES_DELETE = "/messages/";
    public static final String ENDPOINT_MESSAGES_UPDATE = "/messages/";

    // HTTP Timeouts (seconds)
    public static final int CONNECT_TIMEOUT = 5;
    public static final int READ_TIMEOUT = 15;

    // JWT
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
}
