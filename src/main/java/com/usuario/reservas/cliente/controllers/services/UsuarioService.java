package com.usuario.reservas.cliente.controllers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.reservas.cliente.data.entities.db.UsuarioEntityDB;
import com.usuario.reservas.cliente.logic.usercases.RegisterUsuarioUserCase;

@RestController
@RequestMapping("/usuario")
public class UsuarioService {

    @Autowired
    private RegisterUsuarioUserCase registerUsuarioUserCase;

    @PostMapping("/registro")
    public ResponseEntity<?> registerUsuario(@ModelAttribute UsuarioEntityDB usuario) {
        var result = registerUsuarioUserCase.registerUser(usuario.getNombreUsuario(),
                usuario.getApellidoUsuario(),
                usuario.getEmailUsuario(),
                usuario.getPasswordUsuario(),
                usuario.getPasswordConfirmar());
        return result.fold(
                val -> ResponseEntity.ok(val),
                ex -> ResponseEntity.badRequest().body(ex.getMessage())
        );
    }

}
