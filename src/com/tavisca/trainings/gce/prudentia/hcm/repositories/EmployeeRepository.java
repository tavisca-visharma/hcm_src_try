package com.tavisca.trainings.gce.prudentia.hcm.repositories;

import com.tavisca.trainings.gce.prudentia.hcm.dataAccess.DBManager;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.Employee;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.SkillMatrix;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeRepository {

    private Connection connection;
    private SkillMatrixRepository skillMatrixRepository;

    public EmployeeRepository() throws SQLException, ClassNotFoundException {
        this.connection = DBManager.getConnection();
        skillMatrixRepository = new SkillMatrixRepository();
    }

    public Employee save(Employee employee) throws SQLException {
        String insertQuery = "insert into hcm_employee(emp_name,department) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,employee.getName());
        statement.setString(2,employee.getDepartment());
        int affectedRows = statement.executeUpdate(insertQuery);
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                employee.setId(generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("Creating Employee failed, No Employee Id obtained.");
            }
        }

        


        return employee;
    }

    public List<Employee> findAll() throws SQLException, ParseException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM hcm_employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int empId = resultSet.getInt("emp_id");
            String empName = resultSet.getString("emp_name");
            String department = resultSet.getString("department");
            Set<SkillMatrix> skill_matrices = new HashSet<>();

            query = "SELECT * from hcm_employee_skill_matrix where emp_id = " + empId;
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int skill_matrix_id = rs.getInt("skill_matrix_id");
                SkillMatrix skillMatrix = skillMatrixRepository.findById(skill_matrix_id);
                skill_matrices.add(skillMatrix);
            }
            rs.close();
            statement.close();

            employees.add(new Employee(empId, empName, department, skill_matrices));
        }
        return employees;
    }

    public List<Employee> findByDepartment(String department) {
        return null;
    }

    public List<Employee> findByName(String name) {
        return null;
    }
}
