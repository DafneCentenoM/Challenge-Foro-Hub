package foro.alu.foroHub.domain.topico;

import foro.alu.foroHub.domain.curso.Curso;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name="topico")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaDeCreacion;


    private boolean status;



    private String autor;

    @Enumerated(EnumType.STRING) //clase enum
   @Column(name = "curso")
    private Curso curso;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaDeCreacion =LocalDateTime.now();
        this.curso = datosRegistroTopico.curso();
        this.status = true;
        this.autor = datosRegistroTopico.autor();

    }

    public void actualizarDatos(ActualizarTopico actualizarTopico) {
        if (actualizarTopico.titulo() != null) {
            this.titulo = actualizarTopico.titulo();
        }
        if (actualizarTopico.mensaje() != null) {
            this.mensaje = actualizarTopico.mensaje();
        }
        if (actualizarTopico.nombreCurso() != null) {
            this.curso = Curso.valueOf(actualizarTopico.nombreCurso());
        }

    }


    public void desactivarTopico() {
        this.status=false;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }


}
