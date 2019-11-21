package com.tavisca.trainings.gce.prudentia.hcm.models.classes;

import com.tavisca.trainings.gce.prudentia.hcm.models.interfaces.EmployeeDuty;
import com.tavisca.trainings.gce.prudentia.hcm.services.EmployeeService;

import java.util.Set;


public class Employee implements EmployeeDuty {

    private int id;
    private String name;
    private String department;
    private Set<SkillMatrix> skillMatrix;
    transient private EmployeeService employeeService;

    public Employee() {
    }

    public Employee(int id, String name, String department, Set<SkillMatrix> skillMatrix) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.skillMatrix = skillMatrix;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public Set<SkillMatrix> getSkillsMatrix() {
        return skillMatrix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSkillMatrix(Set<SkillMatrix> skillMatrix) {
        this.skillMatrix = skillMatrix;
    }

    @Override
    public Employee update() {
        return employeeService.update(this.getId());
    }

    @Override
    public Employee viewProfileOfEmployee(int id) {
        return employeeService.viewProfileOfEmployee(this.getId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "\n\t\t"+"id=" + id +
                ","+"\n\t\t"+" name='" + name + '\'' +
                ","+"\n\t\t"+" department='" + department + '\'' +
                ","+"\n\t\t"+"skillMatrix=" + skillMatrix +
                '}';
    }
}
