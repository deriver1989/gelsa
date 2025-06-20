package com.gelsa.demo.service;

import com.gelsa.demo.entity.PersonaEntity;
import com.gelsa.demo.dto.PersonaDTO;
import com.gelsa.demo.repository.PersonaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl {

    @Autowired
    private PersonaRepository personaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Boolean guardarPersona(PersonaDTO request){
        PersonaEntity c = ((request.getId() == null)
                ? new PersonaEntity()
                : personaRepository.findById(request.getId()).orElse(null));
        if(c != null){
            c.setNombre(request.getNombre());
            return true;
        }else {
            return false;
        }

    }





}
