package com.JavaEE.tallerJava.services;

import com.JavaEE.tallerJava.DTOS.EmbarcacionDTO;
import com.JavaEE.tallerJava.DTOS.SocioDTO;
import com.JavaEE.tallerJava.api.responses.ResponseListadoSocios;
import com.JavaEE.tallerJava.business.entities.Embarcacion;
import com.JavaEE.tallerJava.business.entities.Socio;
import com.JavaEE.tallerJava.business.repositories.socioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
public class SocioService {


    private socioRepository socioRepository;

    @Autowired
    SocioService(socioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public String addUser(Socio s1) {
        Optional<Socio> s = socioRepository.findById(s1.getDni());

        if(!s.isPresent()) {
            socioRepository.save(s1);


            return "Se ha creado un nuevo Socio";
        }

        return null;



    };

    public String editarSocio(Integer id, Socio s) {
        String response = null;
        Socio aux = socioRepository.findById(id).orElseThrow(() -> new RuntimeException("Socio no existe"));

        aux.setDir(s.getDir());
        aux.setTelefono(s.getTelefono());
        aux.setDni(s.getDni());
        aux.setFechaIngreso(null);
        aux.setNombre(s.getNombre());


        socioRepository.save(aux);

        return "Socio editado";
    }

    public void borrarSocio(Integer id) {
        socioRepository.deleteById(id);
    }

    public ResponseListadoSocios listdoSocios() {
        ResponseListadoSocios lista = new ResponseListadoSocios();


        lista.setSocios(socioRepository.findAll());

        return lista;
    }


    // mapeo para los DTOS

    public SocioDTO MapDTOSocios(Socio s) {
        SocioDTO socioDTO = new SocioDTO();
        socioDTO.setDir(s.getDir());
        socioDTO.setDni(s.getDni());
        socioDTO.setNombre(s.getNombre());
        socioDTO.setFechaIngreso(s.getFechaIngreso());
        socioDTO.setEmbarcaciones(s.getEmbarcaciones().stream().map((e) -> MapDTOEmbarcaciones(e)).toList());

        return socioDTO;
    }

    public EmbarcacionDTO MapDTOEmbarcaciones(Embarcacion e) {
        EmbarcacionDTO edto = new EmbarcacionDTO();

        edto.setNombre(e.getNombre());
        edto.setTipo(e.getTipo());
        edto.setNombre(e.getNombre());

        return edto;
    }

    public SocioDTO mapEntitySocios(SocioDTO s) {
        SocioDTO socio = new SocioDTO();
        socio.setDir(s.getDir());
        socio.setDni(s.getDni());
        socio.setNombre(s.getNombre());
        socio.setFechaIngreso(s.getFechaIngreso());
        return socio;
    }



}
