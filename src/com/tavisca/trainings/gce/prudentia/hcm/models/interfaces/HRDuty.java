package com.tavisca.trainings.gce.prudentia.hcm.models.interfaces;

import com.tavisca.trainings.gce.prudentia.hcm.models.classes.Employee;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.Skill;

import java.util.List;
import java.util.Set;

public interface HRDuty {
    Employee createProfile(int id);        // HR representative has privilege to create new profile for the employees.

    Employee addRecord();

    Employee update(int id);

    List<Employee> getEmployeesByDepartment(String department);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesBySkills(Set<Skill> skills);

    Employee getEmployeeById(int id);

    Employee deleteEmployee(int id);
}
