package com.suryainfotech.employee_service.controller;

import com.suryainfotech.employee_service.entity.Department;
import com.suryainfotech.employee_service.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private  DepartmentRepository departmentRepository;
    @PostMapping
    public Department createDepartment(@RequestBody Department deparment){
        return departmentRepository.save(deparment);

    }
    @GetMapping
    public List<Department> getAllDepartments()
    {
        return departmentRepository.findAll();
    }
}
