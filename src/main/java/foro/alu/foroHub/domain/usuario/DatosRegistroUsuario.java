package foro.alu.foroHub.domain.usuario;


import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank
        String email,
        @NotBlank
        String clave
) {
}
