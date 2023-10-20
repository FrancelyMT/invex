package com.example.invex.services;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.invex.controllers.EmpleadoController;
import com.example.invex.exceptions.EmployeeNotFoundException;
import com.example.invex.models.EmpleadoModel;
import com.example.invex.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
    
    @Override
    public Optional<EmpleadoModel> obtenerPorId(Long id){
        Optional<EmpleadoModel> empl = empleadoRepository.findById(id);
        if(empl.isEmpty()){
            logger.error("Empleado no encontrado: "+id);
            throw new EmployeeNotFoundException("No se encontró el empleado");
        }else{
            logger.info("Usuario encontrado: "+id);
            return empl;
        }
    }

    @Override
	public ArrayList<EmpleadoModel> crearEmpleados(ArrayList<EmpleadoModel> empleados) {
        logger.info("Creando empleados: "+empleados);
		return (ArrayList<EmpleadoModel>) empleadoRepository.saveAll(empleados);
	}

    @Override
    public ArrayList<EmpleadoModel> obtenerEmpleados(){
        return (ArrayList<EmpleadoModel>)empleadoRepository.findAll();
    }

	@Override
    public boolean eliminarEmpleado(Long id){
        try{
            empleadoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            System.out.println("ERROR ELIMINAR"+err);
            return false;
        }
    }

	@Override
	public EmpleadoModel actualizarEmpleado(EmpleadoModel empleado) {
		return empleadoRepository.save(empleado);
	}
    
}
