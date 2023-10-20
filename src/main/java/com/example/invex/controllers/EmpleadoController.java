package com.example.invex.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.invex.models.EmpleadoModel;
import com.example.invex.services.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    Logger logger = LoggerFactory.getLogger(EmpleadoController.class);

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping(path = "/{id}")
    public Optional<EmpleadoModel> obtenerEmpleadoPorId(@PathVariable("id") Long id, @RequestHeader HttpHeaders headers){
        logger.info("Header values: {}", headers);
        return this.empleadoService.obtenerPorId(id);
    }

    @PostMapping()
    public ArrayList<EmpleadoModel> crearEmpleado(@RequestBody ArrayList<EmpleadoModel> empleados){
        return this.empleadoService.crearEmpleados(empleados);
    }

    @GetMapping()
    public ArrayList<EmpleadoModel> obtenerEmpleados(){
        return empleadoService.obtenerEmpleados();
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id, @RequestHeader HttpHeaders headers){
        boolean ok = this.empleadoService.eliminarEmpleado(id);
        logger.info("Header values: {}", headers);
        if (ok){
            return "Se eliminó el empleado: " + id;
        }else{
            return "No pudo eliminar el empleado" + id;
        }
    }

    @PostMapping(path = "/save")
    public EmpleadoModel actualizarEmpleado(@RequestBody EmpleadoModel empleado){
        return this.empleadoService.actualizarEmpleado(empleado);
    }

}
