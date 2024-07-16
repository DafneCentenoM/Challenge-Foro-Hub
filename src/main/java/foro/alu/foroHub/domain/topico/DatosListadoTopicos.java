package foro.alu.foroHub.domain.topico;

import java.time.LocalDateTime;

//para modificar lo que va a devolver(la salida)
public record DatosListadoTopicos(Long id,
                                  String titulo,
                                  String mensaje,
                                  LocalDateTime fecha_creacion) {

    public DatosListadoTopicos (Topico topico){
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion());
    }
}
