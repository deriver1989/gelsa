package com.gelsa.demo.service;


import com.gelsa.demo.entity.OperadorEntity;
import com.gelsa.demo.entity.PersonaEntity;
import com.gelsa.demo.entity.RecargaEntity;
import com.gelsa.demo.dto.RecargaDTO;
import com.gelsa.demo.repository.RecargaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecargaServiceImpl {

    @Autowired
    private RecargaRepository recargaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Boolean guardarRecarga(RecargaDTO request){
        RecargaEntity c = ((request.getId() == null)
                ? new RecargaEntity()
                : recargaRepository.findById(request.getId()).orElse(null));
        if(c != null){
            OperadorEntity o = new OperadorEntity();
            o.setId(request.getOperador());

            PersonaEntity p = new PersonaEntity();
            o.setId(request.getPersona());

            c.setValorRecarga(request.getValor());
            c.setId_operador(o);
            c.setId_persona(p);
            recargaRepository.save(c);
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }

    }





}
