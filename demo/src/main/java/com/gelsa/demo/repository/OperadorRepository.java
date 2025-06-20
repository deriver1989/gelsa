package com.gelsa.demo.repository;

import com.gelsa.demo.entity.OperadorEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperadorRepository extends CrudRepository<OperadorEntity, Long> ,
        JpaSpecificationExecutor<OperadorEntity> {

}
