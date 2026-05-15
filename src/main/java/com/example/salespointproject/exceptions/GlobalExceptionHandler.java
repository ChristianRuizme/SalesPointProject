package com.example.salespointproject.exceptions;

//Imports de librerias
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Imports de java
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Tambien puedes usar @Slf4j como si fuera Lombok
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AuthExceptions.EmailYaRegistradoException.class)
    public ResponseEntity<Map<String, String>> handleEmailDuplicado(AuthExceptions.EmailYaRegistradoException ex) {
        log.warn("Email duplicado: {}", ex.getMessage());
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "Credenciales invalidas");
        respuesta.put("mensaje", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);  //409: Colision con la base de datos
    }

    @ExceptionHandler(AuthExceptions.UsuarioNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleUsuarioNoEncontrado(AuthExceptions.UsuarioNoEncontradoException ex) {
        log.warn("Usuario no encontrado: {}", ex.getMessage());
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "No encontrado");
        respuesta.put("mensaje", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta); //404: No encontrado
    }

    @ExceptionHandler(AuthExceptions.ContrasenaIncorrectaException.class)
    public ResponseEntity<Map<String, String>> handleContrasenaIncorrecta(AuthExceptions.ContrasenaIncorrectaException ex) {
        log.warn("Contrasena incorrecta: {}", ex.getMessage());
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "Credenciales invalidas");
        respuesta.put("mensaje", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(respuesta);  //401: No autorizado
    }
}
