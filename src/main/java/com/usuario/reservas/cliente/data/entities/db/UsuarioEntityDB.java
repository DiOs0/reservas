package com.usuario.reservas.cliente.data.entities.db;

import lombok.Builder;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class UsuarioEntityDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private String passwordConfirmar;
    
}
