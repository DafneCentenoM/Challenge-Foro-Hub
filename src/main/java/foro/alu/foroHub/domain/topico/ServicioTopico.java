package foro.alu.foroHub.domain.topico;

import foro.alu.foroHub.domain.usuario.UsuarioRespository;
import foro.alu.foroHub.infra.errores.IntegrityValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioTopico {

   /* @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRespository usuarioRespository;

    public DatosRespuestaTopico crearTopico(DatosRegistroTopico datosRegistroTopico){
        //verificar si el usuario esta registrado en la BD
        if (!usuarioRespository.findBy(datosRegistroTopico.usuario_id().isPresent())){
            throw new IntegrityValidation("El id del usuario no esta registrado en la BD");
        }



    }*/
}
