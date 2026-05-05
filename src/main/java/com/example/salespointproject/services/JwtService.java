package com.example.salespointproject.services;

//Imports de otros archivos
import com.example.salespointproject.model.entities.Usuario;

//Imports de librerias
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//Imports de java

@Service
public class JwtService {

    //Saco los valores de mis variables de entorno
    @Value("${jwt.secret}")
    private String JWT_KEY;
    @Value("${jwt.expiration}")
    private long JWT_EXPIRATION;

    public String generateToken(Usuario usuario ) {

    }

 }