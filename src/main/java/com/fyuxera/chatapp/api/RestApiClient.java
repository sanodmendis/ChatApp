package com.fyuxera.chatapp.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.fyuxera.chatapp.api.config.ApiConfig;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * REST API Client
 * Handles HTTP requests with JWT authentication
 * @author Sanod
 */
public class RestApiClient {
    
    private static RestApiClient instance;
    private final HttpClient httpClient;
    private String accessToken;
    
    private RestApiClient() {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(ApiConfig.CONNECT_TIMEOUT))
                .version(HttpClient.Version.HTTP_1_1)
                .build();
    }
    
    public static synchronized RestApiClient getInstance() {
        if (instance == null) {
            instance = new RestApiClient();
        }
        return instance;
    }
    
    // token management
    
    public void setAccessToken(String token) {
        this.accessToken = token;
    }
    
    public String getAccessToken() {
        return accessToken;
    }
    
    public void clearTokens() {
        this.accessToken = null;
    }
    
    // request builder
    
    private HttpRequest.Builder baseRequest(String endpoint) {
        return HttpRequest.newBuilder()
                .uri(URI.create(ApiConfig.BASE_URL + endpoint))
                .timeout(Duration.ofSeconds(ApiConfig.READ_TIMEOUT))
                .header("Content-Type", "application/json");
    }
    
    private HttpRequest.Builder authRequest(String endpoint) {
        return baseRequest(endpoint)
                .header(ApiConfig.HEADER_AUTHORIZATION, 
                        ApiConfig.TOKEN_PREFIX + accessToken);
    }
    
    // http methods
    
    public JsonObject post(String endpoint, String jsonBody) throws Exception {
        HttpRequest request = baseRequest(endpoint)
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        
        return executeRequest(request);
    }
    
    public JsonObject postAuth(String endpoint, String jsonBody) throws Exception {
        HttpRequest request = authRequest(endpoint)
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        
        return executeRequest(request);
    }
    
    public JsonObject get(String endpoint) throws Exception {
        HttpRequest request = baseRequest(endpoint)
                .GET()
                .build();
        
        return executeRequest(request);
    }
    
    public JsonObject getAuth(String endpoint) throws Exception {
        HttpRequest request = authRequest(endpoint)
                .GET()
                .build();
        
        return executeRequest(request);
    }
    
    public JsonObject putAuth(String endpoint, String jsonBody) throws Exception {
        HttpRequest request = authRequest(endpoint)
                .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        
        return executeRequest(request);
    }
    
    public JsonObject deleteAuth(String endpoint) throws Exception {
        HttpRequest request = authRequest(endpoint)
                .DELETE()
                .build();
        
        return executeRequest(request);
    }
    
    // core execution
    
    private JsonObject executeRequest(HttpRequest request) throws Exception {
        System.out.println("[RestApiClient.executeRequest()] Sending request to: " + request.uri());
        HttpResponse<String> response = httpClient.send(request,
                HttpResponse.BodyHandlers.ofString());
        
        System.out.println("[RestApiClient.executeRequest()] Status: " + response.statusCode());
        System.out.println("[RestApiClient.executeRequest()] Response body: " + response.body());
        
        return parseResponse(response.statusCode(), response.body());
    }
    
    private JsonObject parseResponse(int statusCode, String body) throws Exception {
        System.out.println("[RestApiClient.parseResponse()] Parsing response with status " + statusCode);
        JsonObject response = new JsonObject();
        
        try {
            JsonObject parsed = JsonParser.parseString(body).getAsJsonObject();
            response = parsed;
            System.out.println("[RestApiClient.parseResponse()] Successfully parsed JSON");
        } catch (Exception e) {
            System.out.println("[RestApiClient.parseResponse()] Failed to parse JSON: " + e.getMessage());
            response.addProperty("status", "error");
            response.addProperty("message", "Invalid response format");
        }
        
        response.addProperty("_statusCode", statusCode);
        return response;
    }
    
    // helpers
    
    public boolean isSuccess(JsonObject response) {
        try {
            return response != null && 
                   response.has("status") &&
                   "success".equals(response.get("status").getAsString());
        } catch (Exception e) {
            System.err.println("Error checking response status: " + e.getMessage());
            return false;
        }
    }
    
    public int getStatusCode(JsonObject response) {
        try {
            return response.get("_statusCode").getAsInt();
        } catch (Exception e) {
            return 0;
        }
    }
    
    public String getErrorMessage(JsonObject response) {
        try {
            if (response.has("message")) {
                return response.get("message").getAsString();
            }
        } catch (Exception e) {
            // ignore
        }
        return "Unknown error";
    }
}
