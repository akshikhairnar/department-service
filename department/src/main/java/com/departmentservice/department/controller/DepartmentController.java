package com.departmentservice.department.controller;

import com.departmentservice.department.dto.DepartmentDTO;
import com.departmentservice.department.entity.Department;
import com.departmentservice.department.mapper.DepartmentMapper;
import com.departmentservice.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartment();
        List<DepartmentDTO> departmentDTOS = departments.stream().map(DepartmentMapper::departmentDTOMapper).toList();
        return new ResponseEntity<>(departmentDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("id") Long id) {
        Department department = departmentService.getDepartment(id);
        DepartmentDTO departmentDTO = DepartmentMapper.departmentDTOMapper(department);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        Department departmentToAdd = DepartmentMapper.departmentMapper(departmentDTO);
        Department addedDepartment = departmentService.addDepartment(departmentToAdd);
        DepartmentDTO addedDepartmentDTO = DepartmentMapper.departmentDTOMapper(addedDepartment);
        return new ResponseEntity<>(addedDepartmentDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable("id") Long id) {
        Department departmentToUpdate = DepartmentMapper.departmentMapper(departmentDTO);
        Department updatedDepartment = departmentService.updateDepartment(departmentToUpdate, id);
        DepartmentDTO updatedDepartmentDTO = DepartmentMapper.departmentDTOMapper(updatedDepartment);
        return new ResponseEntity<>(updatedDepartmentDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
