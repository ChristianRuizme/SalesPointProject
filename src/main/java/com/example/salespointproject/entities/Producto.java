package com.example.salespointproject.entities;

import jakarta.persistence.*;   //Jakarta Persistence API ayuda con el ORM, (@Entity, @Table, @Id, etc)
import jakarta.validation.constraints.*;    //Etiquetas de validacion
import lombok.*;    //Setters, getters y constructores
import java.time.LocalDateTime; //Tema de horas

@Entity
@Table(name = "productos")
@Data  //Genera setters, getters, etc con Lombok
@NoArgsConstructor // Genera el constructor vacío que necesita Spring
@AllArgsConstructor //Genera el constructor lleno
public class Producto {
    //Atributos
    @Id //Primary key para este atributo
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_seq") //strategy: como genera valor
    //generator: nombre interno en java, sequenceName: nombre en SQL, allocationSize: como incrementa
    @SequenceGenerator(
            name = "producto_seq",
            sequenceName = "secuencia_productos",
            allocationSize = 1 // Incrementa de 1 en 1
    )
    private Long id;

    @NotBlank(message = "El código de barras es obligatorio") //En caso de error muestra message
    @Column(nullable = false, unique = true)    //nullable: no puede estar vacio, unique: es unico
    //name: cambia el nombre de columna, length: maximo caracteres, precision: num de digitos
    //scale: num de decimales, updatable: es actualizable, columnDefinition: comando SQL
    private String codigoBarras;

    @NotBlank(message = "La descripcion del producto no puede estar vacía")
    @Column(nullable = false)
    private String descripcion;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Column(nullable = false)
    private String nombre;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser menor a cero")
    @Column(nullable = false)
    private Integer stock;

    @NotNull(message = "El precio de venta es obligatorio")
    @Min(value = 0, message = "El precio de venta no puede ser negativo")
    @Column(nullable = false)
    private Double precioVenta;

    @NotNull(message = "El precio de costo es obligatorio")
    @Min(value = 0, message = "El precio de costo no puede ser negativo")
    @Column(nullable = false)
    private Double precioCosto;

    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;

    private Boolean activo = true;

    //Metodos
    //PrePersist, se ejecuta antes de crear cada objeto
    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
        if(this.activo == null) {
            this.activo = true;
        }
    }
}