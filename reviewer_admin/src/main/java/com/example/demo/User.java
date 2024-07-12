package com.example.demo;

public class User {
    private String name;
    private String password;
    private Boolean role;
    private Boolean isBlocked;
    private Boolean isRequested;

    public User(String name, String password, Boolean role, Boolean isBlocked, Boolean isRequested) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.isBlocked = isBlocked;
        this.isRequested = isRequested;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public Boolean getIsRequested() {
        return isRequested;
    }

    public void setRequested(Boolean requested) {
        isRequested = requested;
    }

    public Boolean getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }
}
