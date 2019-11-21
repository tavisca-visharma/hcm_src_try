package com.tavisca.trainings.gce.prudentia.hcm.repositories;

import com.tavisca.trainings.gce.prudentia.hcm.dataAccess.DBManager;
import com.tavisca.trainings.gce.prudentia.hcm.infra.BusinessException;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.Skill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            skill = new Skill(skill_id, skill_name, description);
        }
        return skill;
    }
}
