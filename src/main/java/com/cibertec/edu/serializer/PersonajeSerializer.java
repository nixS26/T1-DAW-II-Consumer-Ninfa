package com.cibertec.edu.serializer;


import com.cibertec.edu.dto.PersonajeDTO;
import com.cibertec.edu.model.PersonajeModel;

public class PersonajeSerializer {

    public static PersonajeModel toEntity(PersonajeDTO dto) {
        PersonajeModel model = new PersonajeModel();
        model.setNombre(dto.getName());
        model.setKi(dto.getKi());
        model.setMaxKi(dto.getMaxKi());
        model.setRaza(dto.getRace());
        model.setGenero(dto.getGender());
        model.setDescripcion(dto.getDescription());
        return model;
    }
}
