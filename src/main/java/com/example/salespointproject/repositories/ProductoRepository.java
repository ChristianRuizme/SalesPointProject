package com.example.salespointproject.repositories;

//Importo otras clases que use
import com.example.salespointproject.model.entities.Producto;

//Importo librerias
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;   //Comandos SQL precargados de ahi extiendo

//Imports de java
import java.util.Optional;  //Es para evitar el NullPointerException (si es null, regresa vacio)

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findByCodigoBarras(String codigoBarras);
}