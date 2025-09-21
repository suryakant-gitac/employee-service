package com.suryainfotech.employee_service.repository;

import com.suryainfotech.employee_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
