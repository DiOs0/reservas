package com.usuario.reservas.cliente.logic.usercases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.reservas.cliente.data.entities.db.UsuarioEntityDB;
import com.usuario.reservas.cliente.data.repository.UsuarioRepository;
import com.usuario.reservas.cliente.logic.validators.Result;

@Service
public class EditUsuarioUserCase {

    @Autowired
    private UsuarioRepository usuarioRepository;
    

    public Result<UsuarioEntityDB> updateUser(Integer id, String nombre, String apellido, String email) {
        try {
            var usuarioOptional = usuarioRepository.findById(id);
            if (usuarioOptional.isEmpty()) {
                return Result.failure(new Exception("Usuario no encontrado con ID: " + id));
            }
            
            UsuarioEntityDB existingUser = usuarioOptional.get();
            
            var updatedUser = UsuarioEntityDB.builder()
                    .id(existingUser.getId()) 
                    .nombreUsuario(nombre)
                    .apellidoUsuario(apellido)
                    .emailUsuario(email)
                    .passwordUsuario(existingUser.getPasswordUsuario()) 
                    .passwordConfirmar(existingUser.getPasswordConfirmar())
                    .build();

            var saved = usuarioRepository.save(updatedUser);
            return Result.success(saved);
        } catch (Exception e) {
            return Result.failure(e);
        }
    }

}
