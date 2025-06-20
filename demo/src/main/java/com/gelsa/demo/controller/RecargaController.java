package com.gelsa.demo.controller;


import com.gelsa.demo.dto.PersonaDTO;
import com.gelsa.demo.dto.RecargaDTO;
import com.gelsa.demo.response.ResponseDTO;
import com.gelsa.demo.service.RecargaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecargaController {

    @Autowired
    private RecargaServiceImpl recargaServiceImpl;



    //CREAR PERSONA
    @PostMapping("/recarga/crear")
    public ResponseDTO guardarRecarga(@RequestBody RecargaDTO request){
        try {
            ResponseDTO response = null;
            if(recargaServiceImpl.guardarRecarga(request)) {
                response = new ResponseDTO(200, "Guardado OK", true);
            }else{
                response = new ResponseDTO(200, "Error guardando recarga", false);
            }
            return response;

        } catch (Exception e) {
            // Respuesta estándar en caso de error
            ResponseDTO response = new ResponseDTO(404, "Error al guardar", null);
            return response;
        }
    }



}
