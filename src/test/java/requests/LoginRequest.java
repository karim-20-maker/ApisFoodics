package requests;

public class LoginRequest {
    private String email;
    private String password;
    private String token;

    // Constructors, getters, and setters

    // Parameterized constructor
    public LoginRequest(String email, String password, String token) {
        this.email = email;
        this.password = password;
        this.token = token;
    }

    // Getter and Setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter methods for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter methods for token
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

