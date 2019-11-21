package com.tavisca.trainings.gce.prudentia.hcm.services;

import com.tavisca.trainings.gce.prudentia.hcm.models.classes.Employee;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.Skill;
import com.tavisca.trainings.gce.prudentia.hcm.repositories.EmployeeRepository;

import java.util.List;
import java.util.Set;

public class HRService {

    private EmployeeRepository employeeRepository;

    public Employee createProfile(int id) {
        return null;
    }

    public Employee addRecord() {
        return null;
    }

    public Employee update(int id) {
        return null;
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> getEmployeesBySkills(Set<Skill> skills) {
        return null;
    }

    public Employee getEmployeeById(int id) {
        return null;
    }

    public Employee deleteEmployee(int id) {
        return null;
    }
}
