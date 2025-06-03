package com.cibertec.edu.repository;

import com.cibertec.edu.model.PersonajeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<PersonajeModel, Long> {
}
