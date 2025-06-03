package com.cibertec.edu.controller;

import com.cibertec.edu.model.PersonajeModel;
import com.cibertec.edu.repository.PersonajeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    private final PersonajeRepository personajeRepository;

    private static final Logger logger = LoggerFactory.getLogger(PersonajeController.class);

    public PersonajeController(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @GetMapping
    public List<PersonajeModel> obtenerTodos() {
        logger.info("Solicitando todos los personajes desde la BD");
        return personajeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody PersonajeModel personaje) {
        try {
            logger.info("Registrando personaje: {}", personaje.getNombre());
            PersonajeModel saved = personajeRepository.save(personaje);
            logger.info("Personaje guardado con ID: {}", saved.getId());
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            logger.error(" Error al guardar el personaje: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar personaje");
        }
    }

}
