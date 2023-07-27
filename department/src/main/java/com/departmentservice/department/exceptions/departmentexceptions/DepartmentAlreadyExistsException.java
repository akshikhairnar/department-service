package com.departmentservice.department.exceptions.departmentexceptions;

public class DepartmentAlreadyExistsException extends RuntimeException{


    private String message;

    public DepartmentAlreadyExistsException(){}

    public DepartmentAlreadyExistsException(String msg){
        super(msg);
        this.message=msg;
    }
}
