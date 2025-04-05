package com.JavaEE.tallerJava.DTOS;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SocioDTO {
    private String nombre;
    private String dir;

    private Integer dni;

    private String telefono;

    private LocalDateTime fechaIngreso;

    private List<EmbarcacionDTO> embarcaciones;

}
