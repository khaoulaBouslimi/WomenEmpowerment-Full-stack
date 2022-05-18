package com.example.demo.entities;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SearchCriteria {

    @NotBlank(message = "username can't be empty!")
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
