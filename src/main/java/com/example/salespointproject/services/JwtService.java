package com.example.salespointproject.services;

//Imports de otros archivos
import com.example.salespointproject.model.entities.Usuario;

//Imports de librerias
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//Imports de java
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    //Saco los valores de mis variables de entorno
    @Value("${jwt.secret}")
    private String JWT_KEY;
    @Value("${jwt.expiration}")
    private long JWT_EXPIRATION;

    public String generateToken(Usuario usuario ) {
        return Jwts.builder()
                .setSubject(String.valueOf(usuario.getId()))
                //
                .claim("username", usuario.getName())
                .claim("role", usuario.getRole())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //Metodo para hacer mi llave a Key
    private Key getSignInKey() {
        //Convertimos nuestra llave a bytes
        byte [] keyBytes = Decoders.BASE64.decode(JWT_KEY);
        //Convertimos bytes a java.security.Key para el metodo signWith
        return Keys.hmacShaKeyFor(keyBytes);
    }

 }