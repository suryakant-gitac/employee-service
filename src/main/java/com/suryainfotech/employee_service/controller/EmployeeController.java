package com.suryainfotech.employee_service.controller;

import com.suryainfotech.employee_service.dto.EmployeeDTO;
import com.suryainfotech.employee_service.entity.Employee;
import com.suryainfotech.employee_service.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("filter")
    public List<EmployeeDTO> filterEmployees(@RequestParam(required = false) Integer age,
                                          @RequestParam(required = false) String department){
        if(age !=null)
        {
            return employeeService.getEmployeesByAge(age);
        }else if(department !=null){
            return employeeService.getEmployeesByDepartment(department);
        }
        return employeeService.getAllEmployees();
    }


    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);

    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
