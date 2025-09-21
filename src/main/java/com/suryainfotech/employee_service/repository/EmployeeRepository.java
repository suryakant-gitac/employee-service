package com.suryainfotech.employee_service.repository;

import com.suryainfotech.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT e FROM Employee e JOIN FETCH e.department")
    List<Employee> findAllWithDepartment();
    List<Employee> findByAgeGreaterThan(Integer age);
    List<Employee> findByDepartment_Name(String departmentName);
}
