package com.departmentservice.department.service;


import com.departmentservice.department.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department getDepartmentByName(String name);

    List<Department> getAllDepartment();

    Department getDepartment(Long id);

    Department addDepartment(Department department);


    Department updateDepartment(Department department, Long id);

    void deleteDepartment(Long id);
}
