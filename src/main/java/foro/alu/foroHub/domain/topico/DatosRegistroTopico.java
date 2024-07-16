package foro.alu.foroHub.domain.topico;

import foro.alu.foroHub.domain.curso.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String autor,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @Valid
        @NotNull
        Curso curso



      /*  @NotBlank(message = "Utiliza el id del usuario")
        Long usuario_id,
        @NotBlank(message = "El titulo no puede estar vacio o repetido")
        String titulo,
        @NotBlank(message = "El mensaje no debe estar en blanco o rebasar el limite")
        String mensaje,
        @NotBlank(message = "El usuario esta activo o inactivo")
        Status status,
        @NotNull(message = "Utiliza el nombre de alguno de los cursos")
        Curso curso,
        LocalDateTime fechaDeCreacion*/
) {
}
