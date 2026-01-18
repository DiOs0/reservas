package com.usuario.reservas.cliente.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuario.reservas.cliente.data.entities.db.UsuarioEntityDB;

public interface UsuarioRepository
        extends JpaRepository<UsuarioEntityDB, Integer> {

}
