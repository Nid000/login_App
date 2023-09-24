package com.example.model;

public class UserInfo {
    public String username;
    public String password;
    public String name;
    public String role;
    public int roleInt;

    // Constructors, getters, and setters

    // Constructor
    public UserInfo(String username, String password, String name, String role, int roleInt) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.roleInt = roleInt;
    }

    // Getters and setters for all fields
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getRoleInt() {
        return roleInt;
    }

    public void setRoleInt(int roleInt) {
        this.roleInt = roleInt;
    }
}
