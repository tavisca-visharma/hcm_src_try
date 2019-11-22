package com.tavisca.trainings.gce.prudentia.hcm.services;

import com.tavisca.trainings.gce.prudentia.hcm.infra.BusinessException;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.Employee;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.Skill;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.SkillMatrix;
import com.tavisca.trainings.gce.prudentia.hcm.models.enums.Level;
import com.tavisca.trainings.gce.prudentia.hcm.repositories.EmployeeRepository;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.util.HashSet;

public class MainService {
    public void serve() {
        try {
            HRService hrService = new HRService();
            EmployeeRepository employeeRepository;
            employeeRepository = new EmployeeRepository();
            Employee testEmployee = new Employee(
                    "Test Employee 222",
                    "Test Department 222",
                    new HashSet<>() {{
                        add(new SkillMatrix(
                                new Skill("Java Language", "OOP Language"),
                                Level.BEGINNER,
                                Instant.now()
                        ));
                    }}
            );
            employeeRepository.save(testEmployee);
            System.out.println(employeeRepository.findAll());
//            System.out.println(hrService.getEmployeesByName("vishal"));
        } catch (SQLException | ParseException | BusinessException e) {
            e.printStackTrace();
        }
    }
}
