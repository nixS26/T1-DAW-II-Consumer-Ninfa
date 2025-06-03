package com.cibertec.edu.consumer;

import com.cibertec.edu.dto.PersonajeDTO;
import com.cibertec.edu.model.PersonajeModel;
import com.cibertec.edu.repository.PersonajeRepository;
import com.cibertec.edu.serializer.PersonajeSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PersonajeRepository personajeRepository;

    public KafkaConsumer(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @KafkaListener(topics = "DragonBall", groupId = "grupo-dragonball")
    public void escucharMensaje(String mensaje) {
        try {
            PersonajeDTO dto = objectMapper.readValue(mensaje, PersonajeDTO.class);
            PersonajeModel personaje = PersonajeSerializer.toEntity(dto);
            personajeRepository.save(personaje);
            System.out.println("Personaje guardado: " + dto.getName());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
