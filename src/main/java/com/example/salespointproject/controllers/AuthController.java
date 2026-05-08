package com.example.salespointproject.controllers;

//Imports de otros documentos
import com.example.salespointproject.model.entities.Usuario;
import com.example.salespointproject.services.JwtService;
import com.example.salespointproject.services.UsuarioService;

//Imports de librerias
import com.example.salespointproject.services.UsuarioService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    //Atributos
    private final JwtService jwtService;
    private final UsuarioService usuarioService;

    //Constructor
    public AuthController(JwtService jwtService, UsuarioService usuarioService) {
        this.jwtService = jwtService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario, HttpServletResponse response) {
        Usuario nuevoUsuario = usuarioService.guardar(usuario);
        String token = jwtService.generateToken(nuevoUsuario);

        //Hacemos la cookie
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600); //1hr

        //Entregamos la cookie
        response.addCookie(cookie);
        return ResponseEntity.ok("Usuario creado con exito");
    }
}
