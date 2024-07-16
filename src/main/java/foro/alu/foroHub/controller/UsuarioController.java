package foro.alu.foroHub.controller;



import foro.alu.foroHub.domain.usuario.DatosRegistroUsuario;

import foro.alu.foroHub.domain.usuario.Usuario;
import foro.alu.foroHub.domain.usuario.UsuarioRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRespository usuarioRespository;

    @PostMapping
    public void registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario){
        usuarioRespository.save(new Usuario(datosRegistroUsuario));
    }


    @GetMapping
    public List<Usuario> listadoTopico(){
        return usuarioRespository.findAll();
    }
}
