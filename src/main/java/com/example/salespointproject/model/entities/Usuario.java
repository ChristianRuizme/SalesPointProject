package com.example.salespointproject.model.entities;

import com.example.salespointproject.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@Builder    //Para poder construir usuarios a base de otros objetos
@AllArgsConstructor     //builder() lo ocupa para poder funcionar
@NoArgsConstructor
public class Usuario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(
            name = "usuario_seq",
            sequenceName =  "secuencia_usuarios",
            allocationSize = 1
    )
    private Long id;

    @NotBlank (message = "El nombre es obligatorio")
    @Column (nullable = false)
    private String name;

    @NotBlank (message = "El correo electronico no puede estar vacio")
    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String password;

    @Enumerated (EnumType.STRING)
    private Role role;
}
