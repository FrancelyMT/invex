package com.example.invex.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.invex.models.EmpleadoModel;

//@Service
public interface EmpleadoService {
    
    public ArrayList<EmpleadoModel> crearEmpleados(ArrayList<EmpleadoModel> empleados);

    public Optional<EmpleadoModel> obtenerPorId(Long id);

    public ArrayList<EmpleadoModel> obtenerEmpleados();
    
    public boolean eliminarEmpleado(Long id);

    public EmpleadoModel actualizarEmpleado(EmpleadoModel empleado);

}
