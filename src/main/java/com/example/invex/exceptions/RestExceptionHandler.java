package com.example.invex.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(value=EmployeeNotFoundException.class)
    public ResponseEntity<ApiError> handleEmployeesNotFoundException(){
        
        ApiError error = new ApiError(400, "Empleado no encontrado", new Date());
        return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value=SaveEmployeesException.class)
    public ResponseEntity<ApiError> handleSaveEmployeesException(){
        
        ApiError error = new ApiError(1001, "No se pudo guardar usuario(s)", new Date());
        return new ResponseEntity<ApiError>(error,HttpStatus.EXPECTATION_FAILED);
    }
}
