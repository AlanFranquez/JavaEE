package com.JavaEE.tallerJava.business.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Embarcacion {


    @Id
    private String matricula;

    private String nombre;
    private String tipo;
}
