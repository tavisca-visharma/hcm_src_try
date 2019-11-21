package com.tavisca.trainings.gce.prudentia.hcm.models.classes;

import com.tavisca.trainings.gce.prudentia.hcm.models.interfaces.HRDuty;
import com.tavisca.trainings.gce.prudentia.hcm.services.HRService;

import java.util.List;
import java.util.Set;

public class HR extends Employee implements HRDuty {

    HRService hrService = new HRService();

    @Override
    public Employee createProfile(int id) {
        return hrService.createProfile(id);
    }

    @Override
    public Employee addRecord() {
        return hrService.addRecord();
    }

    @Override
    public Employee update(int id) {
        return hrService.update(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return hrService.getEmployeesByDepartment(department);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return hrService.getEmployeesByName(name);
    }

    @Override
    public List<Employee> getEmployeesBySkills(Set<Skill> skills) {
        return hrService.getEmployeesBySkills(skills);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return hrService.getEmployeeById(id);
    }

    @Override
    public Employee deleteEmployee(int id) {
        return hrService.deleteEmployee(id);
    }
}
