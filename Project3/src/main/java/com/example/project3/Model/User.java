package com.example.project3.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotNull(message = "id should not be null")
    private Integer id;

    @NotEmpty(message = "user should not be empty")
    @Size(min = 6)
    private String username;
    //the size included in the pattren
    @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{7,}$")
    @NotEmpty(message = "password should not be empty")
    private String password;

    @Pattern(regexp ="^(.+)@(\\S+)$")
    @NotEmpty(message ="email should not be empty")
    private String email;

    @NotEmpty(message = "role should not be empty")
    @Pattern(regexp = "Admin|Customer")
    private String role;

    @Positive
    @NotNull(message = "balance should not be null")
    private int balance;



}
