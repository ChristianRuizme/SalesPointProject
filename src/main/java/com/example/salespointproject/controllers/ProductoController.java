package com.example.salespointproject.controllers;

//Importo otros documentos
import com.example.salespointproject.entities.Producto;
import com.example.salespointproject.services.ProductoService;

//Imports de Spring Boot
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Imports de Java
import java.util.List;

@RestController
@RequestMapping(/api/productos)
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //Dar la lista de productos
    @GetMapping
    public List<Producto> listar() {
        return productoService.listarTodos();
    }

    //Guardar un producto
    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }
}
