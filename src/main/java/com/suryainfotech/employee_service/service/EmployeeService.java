package com.suryainfotech.employee_service.service;

import com.suryainfotech.employee_service.dto.EmployeeDTO;
import com.suryainfotech.employee_service.entity.Employee;
import com.suryainfotech.employee_service.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAllWithDepartment().stream()
                .map(e-> new EmployeeDTO(
                        e.getId(),
                        e.getName(),
                        e.getAge(),
                        e.getDepartment()!=null?e.getDepartment().getName():null
                )).collect(Collectors.toList());
    }
    public List<EmployeeDTO> getEmployeesByAge(Integer age) {
        return employeeRepository.findByAgeGreaterThan(age).stream()
                .map(e-> new EmployeeDTO(
                        e.getId(),
                        e.getName(),
                        e.getAge(),
                        e.getDepartment()!=null?e.getDepartment().getName():null
                )).collect(Collectors.toList());
    }

    public List<EmployeeDTO> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment_Name(department).stream()
                .map(e-> new EmployeeDTO(
                        e.getId(),
                        e.getName(),
                        e.getAge(),
                        e.getDepartment()!=null?e.getDepartment().getName():null
                )).collect(Collectors.toList());
    }
    public EmployeeDTO  getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(e -> new EmployeeDTO(
                        e.getId(),
                        e.getName(),
                        e.getAge(),
                        e.getDepartment() != null ? e.getDepartment().getName() : null
                ))
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
