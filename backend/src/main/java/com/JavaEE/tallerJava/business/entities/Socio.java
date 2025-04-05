package com.JavaEE.tallerJava.business.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Socio {
    private String nombre;
    private String dir;

    @Id
    private Integer dni;

    private String telefono;

    private LocalDateTime fechaIngreso;

    @OneToMany
    private List<Embarcacion> embarcaciones;

}
