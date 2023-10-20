package com.example.invex.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    
    public EmployeeNotFoundException(String msg){
        super(msg);
    }
}
