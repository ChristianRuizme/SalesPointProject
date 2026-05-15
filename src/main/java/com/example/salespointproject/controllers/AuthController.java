package com.example.salespointproject.controllers;

//Imports de otros documentos
import com.example.salespointproject.dtos.UserRegistrationDTO;
import com.example.salespointproject.exceptions.AuthExceptions;
import com.example.salespointproject.model.entities.Usuario;
import com.example.salespointproject.services.JwtService;
import com.example.salespointproject.services.UsuarioService;
import com.example.salespointproject.dtos.UserLoginDTO;

//Imports de librerias
import com.example.salespointproject.utils.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Imports de Java
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private CookieUtil cookieUtil;

    //Atributos
    private final JwtService jwtService;
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    //Constructor
    public AuthController(JwtService jwtService, UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    @Transactional  //Si algo falla no guarda datos
    public ResponseEntity<?> registrar(@RequestBody UserRegistrationDTO dtoRegistro, HttpServletResponse response) {
        //Reviso exceptions
        usuarioService.validarEmailUnico(dtoRegistro.getEmail());

        //Paso mi DTO a usuario
        Usuario usuario = Usuario.builder()
                .name(dtoRegistro.getName())
                .email(dtoRegistro.getEmail())
                .password(dtoRegistro.getPassword())
                .role(dtoRegistro.getRole())
                .build();

        Usuario nuevoUsuario = usuarioService.guardar(usuario);
        String token = jwtService.generateToken(nuevoUsuario);

        cookieUtil.crearCookieToken(response, token);

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Usuario creado con exito");
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO dtoLogin, HttpServletResponse response) {
        Usuario usuarioDB = usuarioService.buscarPorEmail(dtoLogin.getEmail());
        boolean esValida = passwordEncoder.matches(dtoLogin.getPassword(), usuarioDB.getPassword());

        if (!esValida) {
            throw new AuthExceptions.ContrasenaIncorrectaException();
        } else {
            String token = jwtService.generateToken(usuarioDB);
            cookieUtil.crearCookieToken(response, token);
        }

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Usuario creado con exito");
        return ResponseEntity.ok(respuesta);
    }
}
