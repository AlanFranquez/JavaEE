package com.JavaEE.tallerJava.api.controllers;

import com.JavaEE.tallerJava.api.responses.ResponseListadoSocios;
import com.JavaEE.tallerJava.business.entities.Socio;
import com.JavaEE.tallerJava.services.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "api/v1/socios")
public class SocioController {


    @Autowired
    private SocioService socioService;





    @GetMapping
    public ResponseEntity<ResponseListadoSocios> getSocios() {

        ResponseListadoSocios responses = socioService.listdoSocios();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> crearSocio(@RequestBody Socio s) {

        String response = socioService.addUser(s);

        if(response == null) {
            return new ResponseEntity<>("Error al crear un nuevo usuario", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarSocio(@PathVariable(name="id") Integer id) {
        socioService.borrarSocio(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarSocio(@PathVariable(name="id") Integer id, @RequestBody Socio s1) {
        String response = socioService.editarSocio(id, s1);

        if(response == null) {
            return new ResponseEntity<>("Error al modificar usuario", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
