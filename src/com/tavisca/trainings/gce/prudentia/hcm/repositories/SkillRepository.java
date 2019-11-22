package com.tavisca.trainings.gce.prudentia.hcm.repositories;

import com.tavisca.trainings.gce.prudentia.hcm.dataAccess.DBManager;
import com.tavisca.trainings.gce.prudentia.hcm.infra.BusinessException;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.Skill;

import java.sql.*;

public class SkillRepository {

    private Connection connection;

    public SkillRepository() throws BusinessException {
        connection = DBManager.getConnection();
    }

    public Skill findById(int id) throws SQLException {
        Skill skill = null;
        String query = "SELECT * FROM hcm_skill where skill_id = " + id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            int skill_id = resultSet.getInt("skill_id");
            String skill_name = resultSet.getString("skill_name");
            String description = resultSet.getString("description");
            skill = new Skill(skill_name, description);
            skill.setId(skill_id);
        }
        return skill;
    }

    public Skill findByName(String name) throws SQLException {
        Skill skill = null;
        String query = "SELECT * FROM hcm_skill WHERE skill_name = " + "'" + name + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            int skill_id = resultSet.getInt("skill_id");
            String skill_name = resultSet.getString("skill_name");
            String description = resultSet.getString("description");
            skill = new Skill(skill_name, description);
            skill.setId(skill_id);
        }
        return skill;

    }

    public Skill save(Skill skill) throws SQLException {
        String insertQuery = "insert into hcm_skill(skill_name,description) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, skill.getName());
        preparedStatement.setString(2, skill.getDescription());
        int affectedRows = preparedStatement.executeUpdate();
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                skill.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating Skill failed, No Skill Id obtained.");
            }
        }
        return skill;
    }
}
