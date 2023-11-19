package responses;

import io.restassured.response.Response;

public class LoginResponse {
    private String token;

    // Constructors, getters, and setters

    // Default constructor
    public LoginResponse() {
    }

    // Parameterized constructor
    public LoginResponse(String token) {
        this.token = token;
    }

    // Getter and Setter methods for token
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
