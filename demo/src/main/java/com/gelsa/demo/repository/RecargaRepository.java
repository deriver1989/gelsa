package com.gelsa.demo.repository;

import com.gelsa.demo.entity.RecargaEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecargaRepository extends CrudRepository<RecargaEntity, Long> ,
        JpaSpecificationExecutor<RecargaEntity> {

}
