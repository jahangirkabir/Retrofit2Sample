package com.jahanbabu.retrofit2sample.Model;

/**
 * Created by JK on 12/8/16.
 */

public class User {
    private String message, status, accessToken;

    public User(String message, String status, String accessToken) {
        this.message = message;
        this.status = status;
        this.accessToken = accessToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "User{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
