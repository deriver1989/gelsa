package com.gelsa.demo.controller;


import com.gelsa.demo.dto.OperadorDTO;
import com.gelsa.demo.dto.PersonaDTO;
import com.gelsa.demo.response.ResponseDTO;
import com.gelsa.demo.service.OperadorServiceImpl;
import com.gelsa.demo.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperadorController {

    @Autowired
    private OperadorServiceImpl operadorServiceImpl;



    //CREAR PERSONA
    @PostMapping("/operador/crear")
    public ResponseDTO guardarOperador(@RequestBody OperadorDTO request){
        try {
            ResponseDTO response = null;
            if(operadorServiceImpl.guardarOperador(request)) {
                response = new ResponseDTO(200, "Guardado OK", true);
            }else{
                response = new ResponseDTO(200, "Error guardando operador", false);
            }
            return response;

        } catch (Exception e) {
            // Respuesta estándar en caso de error
            ResponseDTO response = new ResponseDTO(404, "Error al guardar", null);
            return response;
        }
    }



}
