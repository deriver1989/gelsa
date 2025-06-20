package com.gelsa.demo.service;

import com.gelsa.demo.entity.OperadorEntity;
import com.gelsa.demo.dto.OperadorDTO;
import com.gelsa.demo.repository.OperadorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperadorServiceImpl {

    @Autowired
    private OperadorRepository operadorRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Boolean guardarOperador(OperadorDTO request){
        OperadorEntity c = ((request.getId() == null)
                ? new OperadorEntity()
                : operadorRepository.findById(request.getId()).orElse(null));
        if(c != null){
            c.setNombre(request.getNombre());
            return true;
        }else {
            return false;
        }

    }





}
