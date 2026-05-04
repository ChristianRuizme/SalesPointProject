package com.example.salespointproject.dtos;

import com.example.salespointproject.model.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistrationDTO {
    private String name;
    private String email;
    private String password;
    private Role role;
}
