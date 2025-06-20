package com.gelsa.demo.controller;

import com.gelsa.demo.dto.PersonaDTO;
import com.gelsa.demo.response.ResponseDTO;
import com.gelsa.demo.service.PersonaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonaController {

    @Autowired
    private PersonaServiceImpl personaServiceImpl;



    //CREAR PERSONA
    @PostMapping("/persona/crear")
    public ResponseDTO guardarOperador( @RequestBody PersonaDTO request){
        try {
            ResponseDTO response = null;
            if(personaServiceImpl.guardarPersona(request)) {
                response = new ResponseDTO(200, "Guardado OK", true);
            }else{
                response = new ResponseDTO(200, "Error guardando persona", false);
            }
            return response;

        } catch (Exception e) {
            // Respuesta estándar en caso de error
            ResponseDTO response = new ResponseDTO(404, "Error al guardar", null);
            return response;
        }
    }



}
