package com.suryainfotech.employee_service.controller;

import com.suryainfotech.employee_service.entity.Department;
import com.suryainfotech.employee_service.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private  DepartmentRepository departmentRepository;
    @PostMapping
    public Department createDepartment(@RequestBody Department deparment){
        return departmentRepository.save(deparment);

    }
}
