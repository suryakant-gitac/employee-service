package com.suryainfotech.employee_service.dto;

public class EmployeeDTO {
    private Long id;
    private String name;
    private Integer age;
    private String departmentName;

    public EmployeeDTO(Long id, String name, Integer age, String departmentName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.departmentName = departmentName;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public Integer getAge() { return age; }
    public String getDepartmentName() { return departmentName; }
}
