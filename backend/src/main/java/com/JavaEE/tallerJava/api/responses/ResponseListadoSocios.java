package com.JavaEE.tallerJava.api.responses;

import com.JavaEE.tallerJava.business.entities.Socio;
import com.JavaEE.tallerJava.services.SocioService;
import lombok.Data;

import java.util.List;

// Par respuestas complejas
@Data
public class ResponseListadoSocios {


    private List<Socio> socios;
}
