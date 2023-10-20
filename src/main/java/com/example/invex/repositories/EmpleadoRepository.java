package com.example.invex.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.invex.models.EmpleadoModel;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoModel, Long>{
    //public abstract ArrayList<EmpleadoModel> findByPrioridad(Integer prioridad);
}
