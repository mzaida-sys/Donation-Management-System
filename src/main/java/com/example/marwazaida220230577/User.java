package com.example.marwazaida220230577;

public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public abstract String getRole();

    public boolean login(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    public void logout() {
        System.out.println(username + " has logged out.");
    }
}