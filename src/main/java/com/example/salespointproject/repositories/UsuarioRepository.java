package com.example.salespointproject.repositories;

//Importo de otras clases que uso
import com.example.salespointproject.model.entities.Usuario;

//Imports de librerias
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Imports de java
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
