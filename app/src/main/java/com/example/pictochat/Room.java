package com.example.pictochat;

public class Room {
    private String name , password;
    private Long compte_messages;
    private Integer status;

    public Room(String name, Integer status, String password, Long compte_messages) {
        this.name = name;
        this.status = status;
        this.password = password;
        this.compte_messages = compte_messages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCompte_messages() {
        return compte_messages;
    }

    public void setCompte_messages(Long compte_messages) {
        this.compte_messages = compte_messages;
    }
}
