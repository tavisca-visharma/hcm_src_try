package com.tavisca.trainings.gce.prudentia.hcm.repositories;

import com.tavisca.trainings.gce.prudentia.hcm.dataAccess.DBManager;
import com.tavisca.trainings.gce.prudentia.hcm.infra.BusinessException;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.Skill;
import com.tavisca.trainings.gce.prudentia.hcm.models.classes.SkillMatrix;
import com.tavisca.trainings.gce.prudentia.hcm.models.enums.Level;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SkillMatrixRepository {
    private Connection connection;
    private SkillRepository skillRepository;

    public SkillMatrixRepository() throws BusinessException {
        connection = DBManager.getConnection();
        skillRepository = new SkillRepository();
    }

    public SkillMatrix findById(int id) throws SQLException, ParseException {
        SkillMatrix skillMatrix = null;
        String query = "SELECT * FROM hcm_skill_matrix where skill_matrix_id = " + id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            int skill_id = resultSet.getInt("skill_id");
            String proficiency = resultSet.getString("proficiency");
            String acquired = resultSet.getString("acquired");
            Skill skill = skillRepository.findById(skill_id);
            skillMatrix = new SkillMatrix(
                    skill,
                    Level.values()[Integer.parseInt(proficiency)],
                    new SimpleDateFormat("dd-MM-yyyy").parse(acquired).toInstant()
            );

        }
        return skillMatrix;
    }

    public SkillMatrix save(SkillMatrix skillMatrix) throws SQLException {

        String insertQuery = "insert into hcm_skill_matrix(skill_id,proficiency,acquired) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, skillMatrix.getSkill().getId());
        preparedStatement.setInt(2, skillMatrix.getProficiency().ordinal());
        preparedStatement.setString(3, skillMatrix.getAcquired().toString());
        int affectedRows = preparedStatement.executeUpdate();
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                skillMatrix.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating SkillMatrix failed, No Skill Matrix Id obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skillMatrix;
    }
}
