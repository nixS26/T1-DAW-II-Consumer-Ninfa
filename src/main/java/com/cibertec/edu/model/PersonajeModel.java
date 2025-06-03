package com.cibertec.edu.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DragonBall")
@Data
public class PersonajeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Ki")
    private String ki;
    @Column(name = "MaxKi")
    private String maxKi;
    @Column(name = "raza")
    private String raza;
    @Column(name = "genero")
    private String genero;
    @Column(name = "descripcion")
    private String descripcion;
}
