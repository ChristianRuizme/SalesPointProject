package com.example.salespointproject.dtos;

//Imports de librerias
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginDTO {
    private String email;
    private String password;
}
