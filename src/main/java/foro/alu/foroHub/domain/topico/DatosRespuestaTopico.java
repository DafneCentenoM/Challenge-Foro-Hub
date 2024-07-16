package foro.alu.foroHub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(Long id,
                                   String titulo,
                                   String mensaje,
                                   LocalDateTime fechaDeCreacion,
                                   String status,
                                   String curso,
                                   boolean autor
) {


}
