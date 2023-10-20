package com.example.invex.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.invex.models.EmpleadoModel;
import com.example.invex.repositories.EmpleadoRepository;

public class EmpleadoServiceImplTest {
    
    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoServiceImpl empleadoService;

    private EmpleadoModel empleado;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        int year = 2020;
        int month = 9; 
        int day = 5;
        Date fechaPersonalizada = new Date(year - 1900, month - 1, day);

        empleado = new EmpleadoModel();
        empleado.setId(8L);
        empleado.setNombre("maria");
        empleado.setsNombre("francisca");
        empleado.setaPaterno("paterno");
        empleado.setEdad(23);
        empleado.setSexo(2);
        empleado.setFechaNac(fechaPersonalizada);
        empleado.setPuesto("Tester");
    }

    @Test
    void obtenerEmpleados(){
        ArrayList<EmpleadoModel> miArrayList = new ArrayList<>();
        miArrayList.add(empleado);
        when(empleadoRepository.findAll()).thenReturn(miArrayList);
        assertNotNull(empleadoService.obtenerEmpleados());
    }
}
