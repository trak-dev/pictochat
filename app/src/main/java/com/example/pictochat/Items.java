package com.example.pictochat;

public class Items {
    private String message , sender, user;

    public Items(String message, String sender, String user) {
        this.message = message;
        this.sender = sender;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getUser() { return user; }

    public void setUser(String user) { this.user = user; }
}
