package com.example.salespointproject.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    //Atributos
    @Id //Primary key para este atributo
    private Long id;
    private String descripcion;
    private String nombre;
    private Integer stock;
    private String codigoBarras;
    private Double precio;
}
