package com.example.salespointproject.services;

//Importo otras clases que uso
import com.example.salespointproject.entities.Producto;
import com.example.salespointproject.repositories.ProductoRepository;

//Imports de Spring Boot
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Imports de java
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired  //Inyecto el repository para controlarlo
    private ProductoRepository productoRepository;

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto producto) {
        // Aquí es donde configuramos REGLAS antes de guardar
        return productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
