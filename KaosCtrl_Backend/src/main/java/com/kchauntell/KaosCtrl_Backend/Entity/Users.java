package com.kchauntell.KaosCtrl_Backend.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import com.kchauntell.KaosCtrl_Backend.Utils.BCrypt;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

@Entity
@Table(name="Users")
public class Users {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name="username")
    private String username;

    @Column (name="email")
    private String email;

    @Column (name="firstname")
    private String firstname;

    @Column (name="lastname")
    private String lastname;

    @Column (name="password_hash")
    private String passwordHash;

    @CreatedDate
    @Column (name="created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name="role")
    private String role = "client";

    @Column(name="is_logged_in")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean is_logged_in;

    //Construct
    public Users() {}

    public Users (
            long user_id,
            String username,
            String email,
            String firstname,
            String lastname,
            String passwordHash,
            String role
    ) {
        this.id = user_id;
        this.username = username;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.passwordHash = BCrypt.hash(passwordHash);
        this.role = role;
        this.is_logged_in= false;
    }

    public long getId() { return id;}
    public void setId(long id) { this.id = id;}
    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username;}
    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}
    public String getFirstname() { return firstname;}
    public void setFirstname(String firstname) { this.firstname = firstname;}
    public String getLastname() { return lastname;}
    public void setLastname(String lastname) { this.lastname = lastname;}
    public String getPasswordHash() { return passwordHash;}
    public void setPasswordHash(String passwordHash) { this.passwordHash = BCrypt.hash(passwordHash);}
    public LocalDateTime getCreatedAt() { return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt;}
    public boolean getIs_logged_in() { return is_logged_in;}
    public void setIs_logged_in(boolean is_logged_in) { this.is_logged_in = is_logged_in;}
    public String getRole() { return role;}
    public void setRole(String role) { this.role = role;}

    public String toString() {
        return "Users [id=" + id + ", username=" + username
                + ", firstname=" + firstname
                + ", lastname=" + lastname
                + ", email=" + email
                + ", passwordHash=" + passwordHash
                + ", createdAt=" + createdAt
                + ", role=" + role
                + "]";
    }
}