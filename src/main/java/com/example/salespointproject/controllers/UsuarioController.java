package com.example.salespointproject.controllers;

//Imports de otras clases que uso
import com.example.salespointproject.services.UsuarioService;
import com.example.salespointproject.model.entities.Usuario;

//Imports de librerias
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Imports de java
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }
}
