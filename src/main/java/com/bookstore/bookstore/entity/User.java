package com.bookstore.bookstore.entity;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;

@Entity
@Table(name = "user")
// @JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id")
    // Long id;

    @Id
    @Column(length = 32)
    String username;
    @Column(length = 64)
    String password;
    @Column(length = 64)
    String address;

    // public Long getId() {
    //     return id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }
    
    public User(){
        setUsername("");
    }
    public User(String username, String password){
        setUsername(username);
        setPassword(password);
    }
    public User(String username, String password, String address){
        setUsername(username);
        setPassword(password);
        setAddress(address);
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
