package foro.alu.foroHub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record ActualizarTopico(
                                @NotNull Long id,
                               String titulo,
                               String mensaje,
                               Boolean status,
                               String nombreCurso) {
}
