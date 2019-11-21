package com.tavisca.trainings.gce.prudentia.hcm.dataAccess;

import com.tavisca.trainings.gce.prudentia.hcm.infra.BusinessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static Connection connection;
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/vishaldb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private DBManager() {
    }

    public static Connection getConnection() throws BusinessException {
        if (connection == null) {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                throw new BusinessException(000, "driver class not loaded");
            }
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new BusinessException(001, "database may not be running");
            }
        }
        return connection;
    }
}
