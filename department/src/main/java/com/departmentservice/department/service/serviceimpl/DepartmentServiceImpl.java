package com.departmentservice.department.service.serviceimpl;

import com.departmentservice.department.entity.Department;
import com.departmentservice.department.exceptions.departmentexceptions.DepartmentAlreadyExistsException;
import com.departmentservice.department.exceptions.departmentexceptions.NoSuchDepartmentExistsException;
import com.departmentservice.department.repository.DepartmentRepository;
import com.departmentservice.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByDepartmentName(name);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartment(Long id) {
        return departmentRepository.findById(id);
                //.orElseThrow(() -> new NoSuchDepartmentExistsException("No Department Exist With Id :" + id));
    }

    @Override
    public Department addDepartment(Department department) {
        Department existDepartment = getDepartmentByName(department.getDepartmentName());
        if (existDepartment == null) {
            return departmentRepository.save(department);

        } else {
            throw new DepartmentAlreadyExistsException("Department Already Exist  ID " + existDepartment.getDepartmentId());
        }
    }

    @Override
    public Department updateDepartment(Department department, Long id) {
        Optional<Department> departmentToUpdate = getDepartment(id);
        departmentToUpdate.get().setDepartmentName(department.getDepartmentName());
        return departmentRepository.save(departmentToUpdate.get());
    }

    @Override
    public void deleteDepartment(Long id) {
       Optional<Department> department = getDepartment(id);
        if (department.isEmpty()) {
            departmentRepository.deleteById(id);
        }
    }
}
