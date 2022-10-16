package com.youtube.jwt.entity;

public class JwtResponse {

    private User user;
    private String jwtToken;

    public JwtResponse(User user, String jwtToken) {
        this.user = user;
        String Password =this.user.getUserPassword();
        System.out.println("jkj");
        this.jwtToken = jwtToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
