package com.bookshelf.models;

import java.util.Objects;

public class User {
    private String id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;

    public User(String id, String firstname, String lastname, String username, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                 Objects.equals(firstname, user.firstname) &&
                 Objects.equals(lastname, user.lastname) &&
                 Objects.equals(username, user.username) &&
                 Objects.equals(email, user.email) &&
                 Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, username, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                 "id='" + id + '\'' +
                 ", firstname='" + firstname + '\'' +
                 ", lastname='" + lastname + '\'' +
                 ", username='" + username + '\'' +
                 ", email='" + email + '\'' +
                 ", password='" + password + '\'' +
                 '}';
    }
}
