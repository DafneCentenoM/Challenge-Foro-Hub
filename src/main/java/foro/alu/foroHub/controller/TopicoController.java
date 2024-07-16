package foro.alu.foroHub.controller;

import foro.alu.foroHub.domain.topico.*;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
    @RequestMapping("/topicos")
    public class TopicoController {

        @Autowired
        private TopicoRepository topicoRepository;

       /* @Autowired
        private ServicioTopico servicioTopico;*/

        //REGISTRAR TOPICO
        @PostMapping
        @Transactional
        public ResponseEntity registartTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {

            Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
            DatosRespuestaTopico  datosRespuestaTopico = new DatosRespuestaTopico(
                    topico.getId(),
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaDeCreacion(),
                    topico.getCurso().name(),
                    topico.getAutor(),
                    topico.isStatus());
            URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
            return ResponseEntity.created(url).body(datosRespuestaTopico);
        }



        //LISTAR TOPICOS
        @GetMapping
        public ResponseEntity<Page<DatosListadoTopicos>> listadoTopico(@PageableDefault(size = 5) Pageable paginacion) {//page para hacer paginas en lugar de listas
            return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(DatosListadoTopicos::new));
        }



        //ACTUALIZAR TOPICOS
        @PutMapping
        @Transactional
        public ResponseEntity actualizarTopico(@RequestBody @Valid ActualizarTopico actualizarTopico) {
            Topico topico = topicoRepository.getReferenceById(actualizarTopico.id());
            topico.actualizarDatos(actualizarTopico);
            return ResponseEntity.ok(new DatosRespuestaTopico(
                    topico.getId(),
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaDeCreacion(),
                    topico.getCurso().name(),
                    topico.getAutor(),
                    topico.isStatus()

            ));
        }

        //DELETE TOPICO
       /* @DeleteMapping("/{id}")
        public void eliminarTopico(@PathVariable Long id){
            Topico topico = topicoRepository.getReferenceById(id);
            topicoRepository.delete(topico);
        }*/

        //DELETE LOGICO
       /* @DeleteMapping("/{id}")
        public void eliminarTopico(@PathVariable Long id) {
            Topico topico = topicoRepository.getReferenceById(id);
            topico.desactivarTopico();
        }*/

        @DeleteMapping("/{id}")
        public ResponseEntity eliminarTopico(@PathVariable Long id) {

            Optional<Topico> optionalTopico = topicoRepository.findById(id);

            if (optionalTopico.isPresent()) {
                Topico topico = optionalTopico.get();
                topico.desactivarTopico(); // Marcar como inactivo (borrado lógico)
                topicoRepository.deleteById(id); // Guardar los cambios en la base de datos
            } else {
                // Manejo de error si no se encuentra el tópico con ese ID
                throw new EntityNotFoundException("No se encontró el tópico con ID: " + id);
            }
            return  ResponseEntity.noContent().build();
        }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {

        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaDeCreacion(),
                topico.getCurso().name(),
                topico.getAutor(),
                topico.isStatus()

        );
    return ResponseEntity.ok(datosTopico);

    }
}
