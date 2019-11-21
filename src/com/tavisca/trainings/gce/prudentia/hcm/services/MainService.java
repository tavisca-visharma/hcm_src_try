package com.tavisca.trainings.gce.prudentia.hcm.services;

import com.tavisca.trainings.gce.prudentia.hcm.repositories.EmployeeRepository;

import java.sql.SQLException;
import java.text.ParseException;

public class MainService {
    public void serve() {
        try {
            HRService hrService = new HRService();
            EmployeeRepository employeeRepository = new EmployeeRepository();
            System.out.println(employeeRepository.findAll());
//            System.out.println(hrService.getEmployeesByName("vishal"));
        } catch (SQLException | ClassNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }
}
