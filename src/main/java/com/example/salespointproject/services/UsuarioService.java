package com.example.salespointproject.services;

//Imports de otras clases que uso
import com.example.salespointproject.repositories.UsuarioRepository;
import com.example.salespointproject.model.entities.Usuario;

//Imports de librerias
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Imports de java
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
