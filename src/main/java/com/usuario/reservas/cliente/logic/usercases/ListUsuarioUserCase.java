package com.usuario.reservas.cliente.logic.usercases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.reservas.cliente.data.entities.db.UsuarioEntityDB;
import com.usuario.reservas.cliente.data.repository.UsuarioRepository;
import com.usuario.reservas.cliente.logic.validators.Result;


@Service
public class ListUsuarioUserCase {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Result<List<UsuarioEntityDB>> getAllUsers() {
        try {
            List<UsuarioEntityDB> usuarios = usuarioRepository.findAll();
            return Result.success(usuarios);
        } catch (Exception e) {
            return Result.failure(e);
        }
    }

    public Result<UsuarioEntityDB> getUserById(Integer id) {
        try {
            // findById devuelve un Optional
            var usuarioOptional = usuarioRepository.findById(id);

            if (usuarioOptional.isPresent()) {
                return Result.success(usuarioOptional.get());
            } else {
                return Result.failure(new Exception("Usuario con ID " + id + " no encontrado"));
            }
        } catch (Exception e) {
            return Result.failure(e);
        }
    }

}
