package com.usuario.reservas.cliente.logic.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.reservas.cliente.data.entities.db.UsuarioEntityDB;
import com.usuario.reservas.cliente.data.repository.UsuarioRepository;
import com.usuario.reservas.cliente.logic.validators.Result;

@Service
public class RegisterUsuarioUserCase {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Result<UsuarioEntityDB> registerUser(
            String nombre,
            String apellido,
            String email,
            String password,
            String passwordConfirmar) {

        Result<UsuarioEntityDB> result;

        // 1. Validaciones básicas de negocio
        if (!password.equals(passwordConfirmar)) {
            return Result.failure(new Exception("Las contraseñas no coinciden"));
        }

        try {
            var usuarioBuilder = UsuarioEntityDB.builder()
                    .nombreUsuario(nombre)
                    .apellidoUsuario(apellido)
                    .emailUsuario(email)
                    .passwordUsuario(password)                    
                    .passwordConfirmar(passwordConfirmar);

            var usuario = usuarioBuilder.build();

            var usuarioSaved = usuarioRepository.save(usuario);
            
            result = Result.success(usuarioSaved);

        } catch (Exception e) {
            result = Result.failure(e);
        }

        return result;
    }

}
