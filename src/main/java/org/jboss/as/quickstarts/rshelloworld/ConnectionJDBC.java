package org.jboss.as.quickstarts.rshelloworld;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ConnectionJDBC {
    private static final String URL = "jdbc:mysql://192.168.0.100:3306/dbsum";
    private static final String USERNAME = "admin";
    private static final String USERPASSWORD = "00000000";
    private static String value;
    private final static Logger LOGGER = Logger.getLogger(ConnectionJDBC.class.getName());


    public String connect() {

        Connection connection;
        String error = "";
        List<Integer> listID = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
            Statement statement = connection.createStatement();
            value = "SELECT * FROM value";
            ResultSet resultSet = statement.executeQuery(value);
            LOGGER.warning("start///");


            while (resultSet.next()) {
                int e = resultSet.getInt(1);
                listID.add(e);
                LOGGER.warning("" + e);
            }

            if (!connection.isClosed()) {
                error = "Connected with db successfully";
            }
            connection.close();
            if (connection.isClosed()) {
                error = "Connected with db close";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            error = "Error don't connected to db";
        }
        return listID.toString() + error;
    }

}
